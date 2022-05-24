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
  
 
 
 CREATE TABLE PLATO
 (
 maxGruposAlimenticios number(1),
 codigo number(3),
 nombre varchar2(100),
 descripcion varchar2(250),
 orden number(1),
 numGrupoAlimenticios number(1),
 cantidadLactosa  number(2);
 );
 
