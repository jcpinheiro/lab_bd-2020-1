create database loja;

use loja;

CREATE TABLE Produto (
   id int primary key auto_increment, 
   nome VARCHAR(100), 
   descricao VARCHAR(255) 
);

insert into Produto (nome, descricao)
     values ('Computador All-In-One', 'Computador de excelente qualidade'), 
            ('Tablet', 'Tablet 10 pol com 4G');
            
select * from Produto;

rename table Produto to produtos;

select * from produtos;

create table categoria (
  id int primary key auto_increment,
  nome varchar(100)
);

insert into categoria (nome) values ('Informática'), ('Eletrônicos'), ('Papelaria');

select * from categoria;

alter table produtos add column categoria_id int;

update produtos set categoria_id=1 where id in (1,2);

