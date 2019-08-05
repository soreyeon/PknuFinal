create or replace PACKAGE BODY PKG_PDS AS

--------------------------------------------------------------------------------

  PROCEDURE PROC_PDS_LIST(
      IN_MENU_ID     IN  VARCHAR2  -- 보여줄 메뉴 아이디(MENU01)
      
    , IN_NOW_PAGE    IN  NUMBER -- 현재 페이지 정보(보여줄)
    , IN_PAGECOUNT   IN  NUMBER -- 한 페이지에 보여줄 자료수
    
    , OUT_TOTALCOUNT OUT NUMBER -- 전체자료수(돌려받을) 해당 MENU
    
    , O_CUR          OUT  SYS_REFCURSOR -- 조회된 결과
  ) AS
        V_STARTNUM NUMBER(5,0); -- 보여줄 자료의 시작번호
        V_ENDNUM   NUMBER(5,0); -- 보여줄 자료의 끝번호
  BEGIN
    -- 전체 자료수를 반환
    SELECT COUNT(IDX)
    INTO   OUT_TOTALCOUNT
    FROM   BOARD
    WHERE  MENU_ID = IN_MENU_ID;
    
    V_STARTNUM := (IN_NOW_PAGE -1) * IN_PAGECOUNT + 1;
    V_ENDNUM := IN_NOW_PAGE * IN_PAGECOUNT;
    
    IF(V_ENDNUM >= OUT_TOTALCOUNT) THEN
       V_ENDNUM := OUT_TOTALCOUNT;
    END IF;
    
    --자료실 자료출력(페이징기술) 1~10페이지 자료
    OPEN O_CUR FOR
    SELECT * FROM (
        SELECT ROW_NUMBER() OVER (ORDER BY NREF DESC, STEP ASC) AS RN,
               IDX, MENU_ID, 
               LPAD(' ', 2*LVL) || DECODE(LVL, 0, '', '[RE]') || TITLE AS TITLE,  --새글/답글
               WRITER, REGDATE, READCOUNT, 
               ( SELECT NVL(COUNT(FILENAME), 0)
                 FROM FILES
                 WHERE IDX = B.IDX
               ) AS FILESCOUNT,                     --파일자료수
               BNUM, LVL, STEP, NREF, DELNUM
        FROM   BOARD B
        WHERE  MENU_ID = IN_MENU_ID
    ) T
        WHERE T.RN BETWEEN V_STARTNUM AND V_ENDNUM
        ORDER BY NREF DESC, STEP ASC;
  END PROC_PDS_LIST;
  
--------------------------------------------------------------------------------

  PROCEDURE PROC_PDS_INSERT(
      IN_MENU_ID IN VARCHAR2
    , IN_TITLE   IN VARCHAR2
    , IN_CONT    IN VARCHAR2
    , IN_WRITER  IN VARCHAR2
    , IN_BNUM    IN NUMBER
    , IN_LVL     IN NUMBER
    , IN_STEP    IN NUMBER
    , IN_NREF    IN NUMBER
    
    -- File Upload 부분 처리
    , IN_FILENAME  IN FILE_ARRAY
    , IN_FILEEXT   IN FILE_ARRAY
    , IN_SFILENAME IN FILE_ARRAY
  ) AS
      V_BNUM NUMBER(5,0);
      V_LVL  NUMBER(5,0);
      V_STEP NUMBER(5,0);
      V_NREF NUMBER(5,0);
      
      V_MAXIDX NUMBER(5,0); -- BOARD에 추가된 글번호
  BEGIN
     IF IN_BNUM = 0 THEN  -- BNUM = 0 새글
        SELECT NVL(MAX(BNUM), 0) + 1 
        INTO   V_BNUM
        FROM   BOARD
        WHERE  MENU_ID = IN_MENU_ID;
        
        V_LVL  := 0;
        V_STEP := 0;
        
        SELECT NVL(MAX(NREF), 0) + 1 
        INTO   V_NREF
        FROM   BOARD
        WHERE  MENU_ID = IN_MENU_ID;
     ELSE -- 답글
        V_BNUM := IN_BNUM;
        V_LVL  := IN_LVL + 1;
        V_STEP := IN_STEP + 1;
        V_NREF := IN_NREF;
        
        --기존글의 STEP변경(순서)
        UPDATE BOARD
        SET    STEP = STEP + 1 
        WHERE  NREF = IN_NREF
        AND    STEP > IN_STEP
        AND    MENU_ID = IN_MENU_ID;
        
     END IF;
     
      --글 추가
     INSERT INTO BOARD (
        IDX, MENU_ID, TITLE, CONT, WRITER, REGDATE, 
        READCOUNT, BNUM, LVL, STEP, NREF, DELNUM
     ) VALUES (
        BRDSEQ.NEXTVAL,
        IN_MENU_ID,
        IN_TITLE,
        IN_CONT,
        IN_WRITER,
        TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
        0,
        V_BNUM,
        V_LVL,
        V_STEP,
        V_NREF,
        0
     );

     
     --추가된 파일정보를 DB에 저장
     ----추가된 글번호 알아내기: BOARD
     SELECT MAX(IDX)
     INTO V_MAXIDX
     FROM BOARD
     WHERE MENU_ID = IN_MENU_ID;
     
     --FILES 테이블에 저장된 파일 정보를 담는다
     IF IN_FILENAME(1) IS NOT NULL THEN
        FOR I IN IN_FILENAME.FIRST .. IN_FILENAME.LAST
        LOOP 
            INSERT INTO FILES 
            VALUES (
               (SELECT NVL(MAX(FILE_NUM), 0) + 1 FROM FILES),  --FILE_IDX
               V_MAXIDX,  -- IDX: V_MAXIDX
               IN_FILENAME(I),
               IN_FILEEXT(I),
               IN_SFILENAME(I)
            );
        END LOOP;
     END IF;
     
  END PROC_PDS_INSERT;
  
--------------------------------------------------------------------------------

  PROCEDURE PROC_PDS_CONTENT (
      IN_IDX   IN   NUMBER
    , O_CUR    OUT  SYS_REFCURSOR
  ) AS
  BEGIN
   UPDATE BOARD
    SET READCOUNT = READCOUNT + 1
    WHERE IDX = IN_IDX;
    
    OPEN O_CUR FOR
    SELECT IDX, MENU_ID, TITLE, CONT, WRITER, REGDATE, 
           READCOUNT, BNUM, LVL, STEP, NREF, DELNUM
    FROM   BOARD
    WHERE  IDX = IN_IDX;
  END PROC_PDS_CONTENT;
  
--------------------------------------------------------------------------------

  PROCEDURE PROC_PDS_FILELIST (
      IN_IDX   IN   NUMBER
    , O_CUR    OUT  SYS_REFCURSOR
  ) AS
  BEGIN
    OPEN O_CUR FOR
    SELECT FILE_NUM, IDX, FILENAME, FILEEXT, SFILENAME
    FROM FILES
    WHERE IDX = IN_IDX;
  END PROC_PDS_FILELIST;

--------------------------------------------------------------------------------

  PROCEDURE PROC_PDS_DELETE (
      IN_IDX   IN   NUMBER
  ) AS
  BEGIN
    
    --전체 작업을 하나의 단위로 처리
    SAVEPOINT SP_DELETE_PTR;
    
    DELETE FROM FILES
    WHERE IDX = IN_IDX;
    
    DELETE FROM BOARD
    WHERE IDX = IN_IDX;
    
    COMMIT;
    
  EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO SP_DELETE_PTR;
        RAISE;
        
  END PROC_PDS_DELETE;

--------------------------------------------------------------------------------

  PROCEDURE PROC_PDS_UPDATE (
      IN_IDX   IN NUMBER
    , IN_TITLE IN VARCHAR2
    , IN_CONT  IN VARCHAR2
  ) AS
  BEGIN
  
    UPDATE BOARD
    SET    TITLE = IN_TITLE, 
           CONT = IN_CONT
    WHERE  IDX = IN_IDX;
    
  END PROC_PDS_UPDATE;

--------------------------------------------------------------------------------

END PKG_PDS;