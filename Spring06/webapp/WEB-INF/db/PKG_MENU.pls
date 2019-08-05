create or replace PACKAGE BODY PKG_MENU AS

--------------------------------------------------------------------------------

  PROCEDURE PROC_MENU_LIST(
        O_CUR OUT SYS_REFCURSOR
    ) AS
  BEGIN
    OPEN O_CUR FOR
    SELECT MENU_ID, MENU_NAME, MENU_SEQ
    FROM MENUS
    ORDER BY MENU_SEQ ASC;
  END PROC_MENU_LIST;

--------------------------------------------------------------------------------

  PROCEDURE PROC_MENU_CONTENT(
          IN_MENU_ID  IN   VARCHAR2
        , O_CUR       OUT  SYS_REFCURSOR
    ) AS
  BEGIN
    OPEN O_CUR FOR
    SELECT MENU_ID, MENU_NAME, MENU_SEQ
    FROM MENUS
    WHERE MENU_ID = IN_MENU_ID;
  END PROC_MENU_CONTENT;
  
--------------------------------------------------------------------------------

  PROCEDURE PROC_MENU_INSERT(
        IN_MENU_NAME  IN  VARCHAR2
        
    ) AS
    V_MENU_ID   VARCHAR2(6);
    V_MENU_SEQ  NUMBER(5,0);
  BEGIN
    SELECT 'MENU' || TRIM(TO_CHAR(MENUSEQ.NEXTVAL, '00'))
    INTO V_MENU_ID
    FROM DUAL;
    
    SELECT NVL(MAX(MENU_SEQ),0)+1
    INTO V_MENU_SEQ
    FROM MENUS;
    
  
    INSERT INTO MENUS( MENU_ID, MENU_NAME, MENU_SEQ)
    VALUES (
        V_MENU_ID, IN_MENU_NAME, V_MENU_SEQ
    );
  END PROC_MENU_INSERT;

--------------------------------------------------------------------------------

  PROCEDURE PROC_MENU_DELETE(
        IN_MENU_ID  IN  VARCHAR2
    ) AS
  BEGIN
    DELETE FROM MENUS
    WHERE MENU_ID = IN_MENU_ID;
  END PROC_MENU_DELETE;
  
--------------------------------------------------------------------------------

  PROCEDURE PROC_MENU_UPDATE(
          IN_MENU_ID    IN  VARCHAR2
        , IN_MENU_NAME  IN  VARCHAR2
        , IN_MENU_SEQ   IN  NUMBER
    ) AS
  BEGIN
   UPDATE MENUS
   SET MENU_NAME = IN_MENU_NAME,
       MENU_SEQ = IN_MENU_SEQ
    WHERE MENU_ID = IN_MENU_ID;
  END PROC_MENU_UPDATE;
  
--------------------------------------------------------------------------------

END PKG_MENU;