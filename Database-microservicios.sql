create database db_microservicios;
use db_microservicios;

create table usuario(
id int auto_increment primary key,
nombres varchar(100),
apellidos varchar(100),
correo varchar(100),
clave varchar(100),
create_at timestamp
);

#SELECT *  FROM usuario where correo='retamozodeveloper@gmail.com' and clave='123456';

delete FROM usuario where id=null;
create table informacion_personal(
id int auto_increment primary key,
id_usuario int references usuario(id),
descripcion varchar(1000),
fecha_nacimiento timestamp,
telefono varchar(15),
ruta_imagen varchar(1000),
direccion varchar(1000)
);

create table experiencia_laboral(
id int auto_increment primary key,
id_usuario int references usuario(id),
nombre_empresa varchar(100),
cargo varchar(100),
descripcion varchar(1000),
desde timestamp,
hasta timestamp,
trabaja_actualmente char(1)
);

create table estudios(
id int auto_increment primary key,
id_usuario int references usuario(id),
nombre_centro_estudio varchar(100),
nombre_carrera_curso varchar(100),
desde timestamp,
hasta timestamp,
estudia_actualmente char(1)
);

create table conocimiento_habilidad(
id int auto_increment primary key,
id_usuario int references usuario(id),
nombre_conocimiento varchar(100),
nivel_porcentaje varchar(3)
);


