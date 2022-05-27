  alter session set "_oracle_script"=true;  
  create user cateringBoda identified by cateringBoda;
  GRANT CONNECT, RESOURCE, DBA TO cateringBoda;
  
  CREATE TABLE GRUPOALIMENTICIO
 (
  codigoGrupo number(1),
  nombre varchar2(50),
  
  CONSTRAINT pk_grupoAlim PRIMARY KEY (codigoGrupo)
 );
  
  CREATE TABLE PLATO
  (
  	codigoPlato number(3),
  	nombre varchar2(200),
  	descripcion varchar2(300),
  	orden number(1),
  	cantidadLactosa number(4,2),
  	
  	CONSTRAINT pk_plato PRIMARY KEY (codigoPlato)
  );
  
 
CREATE TABLE PLATOGRUPO
(
 codigoGrupo number(1),
 codigoPlato number(3),
 
 CONSTRAINT pk_grupoplato PRIMARY KEY (codigoGrupo,codigoPlato),
 CONSTRAINT fk1_grupoplato FOREIGN KEY (codigoGrupo) REFERENCES GRUPOALIMENTICIO(codigoGrupo),
 CONSTRAINT fk2_grupoplato FOREIGN KEY (codigoPlato) REFERENCES PLATO(codigoPlato)
);

INSERT INTO GRUPOALIMENTICIO values(1,'CARNE');
INSERT INTO GRUPOALIMENTICIO values(2,'PESCADO');
INSERT INTO GRUPOALIMENTICIO values(3,'VERDURA');
INSERT INTO GRUPOALIMENTICIO values(4,'CEREALES');


CREATE SEQUENCE CODPLATO
 start with 1
 increment by 1
 maxvalue 999
 minvalue 1;


select CODPLATO.nextval from dual;

select CODPLATO.currval from dual;





