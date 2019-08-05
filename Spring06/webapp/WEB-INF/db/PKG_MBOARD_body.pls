create or replace PACKAGE BODY PKG_MBOARD AS

--------------------------------------------------------------------------------

  PROCEDURE PROC_MBOARD_LIST(
      IN_MENU_ID IN VARCHAR2
    , O_CUR OUT SYS_REFCURSOR
  ) AS
  BEGIN
   OPEN O_CUR FOR
   SELECT IDX, MENU_ID, TITLE, WRITER, REGDATE,
          READCOUNT, BNUM, LVL, STEP, NREF, DELNUM
   FROM BOARD
   WHERE MENU_ID = IN_MENU_ID
   ORDER BY NREF DESC, STEP ASC;
  END PROC_MBOARD_LIST;

--------------------------------------------------------------------------------

  PROCEDURE PROC_MBOARD_INSERT(
        IN_MENU_ID IN VARCHAR2
      , IN_TITLE IN VARCHAR2
      , IN_CONT IN VARCHAR2
      , IN_WRITER IN VARCHAR2
      , IN_BNUM IN VARCHAR2
      , IN_LVL  IN NUMBER
      , IN_STEP IN NUMBER
      , IN_NREF IN NUMBER
  ) AS
    V_BNUM  NUMBER(5,0);
    V_LVL   NUMBER(5,0);
    V_STEP  NUMBER(5,0);
    V_NREF  NUMBER(5,0);
    
    V_IDX NUMBER(5,0);
  BEGIN
    IF IN_BNUM = 0 THEN --새글이면
        SELECT NVL(MAX(IDX), 0)+1 INTO V_BNUM FROM BOARD
        WHERE MENU_ID = IN_MENU_ID;
        
        V_LVL := 0;
        V_STEP := 0;
        
        SELECT NVL(MAX(NREF), 0)+1 INTO V_NREF FROM BOARD
        WHERE MENU_ID = IN_MENU_ID;
    ELSE --답글이면
        V_BNUM := IN_BNUM;
        V_LVL  := V_LVL + 1;
        V_NREF := IN_NREF;
        V_STEP := IN_STEP + 1;
        
        UPDATE BOARD 
        SET STEP = STEP + 1
        WHERE MENU_ID = IN_MENU_ID
        AND   NREF = IN_NREF
        AND   STEP > IN_STEP;
    END IF;
  
  
    INSERT INTO BOARD (
        IDX, MENU_ID, TITLE, CONT, WRITER, REGDATE,
        READCOUNT, BNUM, LVL, STEP, NREF, DELNUM 
    ) VALUES (
        BRDSEQ.NEXTVAL,
        IN_MENU_ID,
        IN_TITLE,
        IN_CONT,
        IN_WRITER,
        TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),
        0,
        V_BNUM,
        V_LVL,
        V_STEP,
        V_NREF,
        0
    );
  END PROC_MBOARD_INSERT;

--------------------------------------------------------------------------------

  PROCEDURE PROC_MBOARD_VIEW (
      IN_IDX IN NUMBER
    , O_CUR OUT SYS_REFCURSOR
  ) AS
  BEGIN
    UPDATE BOARD
    SET READCOUNT = READCOUNT + 1
    WHERE IDX = IN_IDX;
  
    OPEN O_CUR FOR
    SELECT IDX, TITLE, CONT, WRITER, MENU_ID, REGDATE, READCOUNT, BNUM, 
           LVL, STEP, NREF, DELNUM
    FROM BOARD
    WHERE IDX = IN_IDX;
  END PROC_MBOARD_VIEW;

--------------------------------------------------------------------------------

  PROCEDURE PROC_MBOARD_DELETE (
      IN_IDX IN NUMBER
  ) AS
    V_NREF NUMBER(5,0);
    V_LVL  NUMBER(5,0);
    V_STEP NUMBER(5,0);
  
  BEGIN
    --답글이 있을때 DELNUM = 1
    --답글이 없을때 DELETE
    
    UPDATE BOARD
    SET DELNUM = 1
    WHERE IDX = IN_IDX;
    
    --현재글의 답글 정보를 확인
    SELECT NREF, LVL, STEP
    INTO V_NREF, V_LVL, V_STEP
    FROM BOARD
    WHERE IDX = IN_IDX;
    
    DELETE BOARD
    WHERE IDX = IN_IDX
    AND NOT EXISTS (
        SELECT 1
        FROM BOARD
        WHERE NREF = V_NREF
        AND LVL = V_LVL + 1
        AND STEP = V_STEP + 1
    );
  END PROC_MBOARD_DELETE;

--------------------------------------------------------------------------------

  PROCEDURE PROC_MBOARD_UPDATE (
        IN_IDX IN NUMBER
      , IN_TITLE IN VARCHAR2
      , IN_CONT IN VARCHAR2
  ) AS
  BEGIN
    UPDATE BOARD
    SET  TITLE = IN_TITLE,
         CONT = IN_CONT
    WHERE IDX = IN_IDX;
    
  END PROC_MBOARD_UPDATE;

--------------------------------------------------------------------------------

END PKG_MBOARD;