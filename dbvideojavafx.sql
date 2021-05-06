create database dbvideojavafx
go 
use dbvideojavafx

create table professor(

codigo		int				not null,
nome		varchar(100)	not null,
titulacao	varchar(50)		not null

primary key(codigo)

)

go

create table disciplina (

codigo				int				not null,
nome				varchar(100)	not null,
codigoProfessor		int				not null

primary key(codigo)
foreign key(codigoProfessor) references professor (codigo)

)
