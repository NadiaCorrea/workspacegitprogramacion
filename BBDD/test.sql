   alter session set "_oracle_script"=true;  
   create user programacion identified by programacion;
   GRANT CONNECT, RESOURCE, DBA TO programacion;
   
  
  CREATE TABLE personas 
  (
  nif varchar2(9) PRIMARY KEY,
  nombre varchar2(50),
  apellidos varchar2(50),
  edad NUMBER(3)
  );