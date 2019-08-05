create table board (
      idx         number(5,0)           not null primary key
    , menu_id     char(6)               not null
    , title       varchar2(100 byte)    not null
    , cont        varchar2(4000 byte)   not null
    , writer      varchar2(50 byte)     not null
    , readcount   number(5,0)           not null
    , bnum        number(5,0)           not null
    , lvl         number(5,0)           not null
    , step        number(5,0)           not null
    , nref        number(5,0)           not null
    , delnum      number(2,0) default 0 not null
);

create table "menus" (
      menu_id     char(6 byte)        not null
    , menu_name   varchar2(100 byte)  not null
    , menu_seq    number(5,0)         not null
    , primary key("menu_id")
);

create table "files" (
      file_num   number(5,0)        not null
    , idx        number(5,0)        not null
    , filename   varchar2(300 byte) not null
    , fileext    varchar2(10 byte)  not null
    , sfilename  varchar2(300 byte) not null
    , constraint "files_pk" primary key("file_num", "idx")
);

create table usertable (
      userid     varchar2(20)   not null primary key
    , userpwd    varchar2(20)   not null  
    , username   varchar2(100)  not null  
    , userpoint  number(6)      default 0  
);

insert into usertable (userid, userpwd, username) 
values ('admin', '1234', '관리자');
insert into usertable (userid, userpwd, username) 
values ('sky1', '1234', '한세계');
insert into usertable (userid, userpwd, username) 
values ('sky2', '1234', '서도재');
insert into usertable (userid, userpwd, username) 
values ('sky3', '1234', '강권주');

commit;

select * from usertable;

create sequence BRDSEQ;
CREATE SEQUENCE MENUSEQ;

