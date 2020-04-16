drop table ciudad if exists
drop table estacion if exists
drop table estacion_xrefs if exists;
drop table linea if exists;
drop sequence if exists seq_estacion;

create sequence seq_estacion start with 1 increment by 1;

create table ciudad (id integer not null, latitud double, longitud double, nombre varchar(255) not null, primary key (id));
create table estacion (id integer not null, nombre varchar(255) not null, linea_id varchar(8) not null, primary key (id));
create table estacion_xrefs (estacion1id integer not null, estacion2id integer not null, primary key (estacion1id, estacion2id));
create table linea (id varchar(8) not null, longitud_total double, estacion_cabecera_id integer not null, ciudad_id integer not null, estacion_fin_id integer not null, primary key (id));

alter table estacion add constraint FK_ESTACION_LINEA foreign key (linea_id) references linea;
alter table estacion_xrefs add constraint FK_ESTACIONXREF_2 foreign key (estacion2id) references estacion;
alter table estacion_xrefs add constraint FK_ESTACIONXREF_1 foreign key (estacion1id) references estacion;
alter table linea add constraint FK_LINEA_EST_CAB foreign key (estacion_cabecera_id) references estacion;
alter table linea add constraint FK_LINEA_CIUDAD foreign key (ciudad_id) references ciudad;
alter table linea add constraint FK_LINEA_EST_FIN foreign key (estacion_fin_id) references estacion;
