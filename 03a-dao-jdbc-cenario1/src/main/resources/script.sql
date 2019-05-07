create table produtos
(
    id        int primary key auto_increment,
    nome      varchar(100),
    descricao varchar(255)
);

INSERT INTO produtos (nome, descricao)
VALUES ('Notebook Dell Insirion', 'Notebook Dell core 17 com 8 gb de RAM');
INSERT INTO produtos (nome, descricao)
VALUES ('Smartphone Galaxy S8', 'Display Infinito e resistência à água e à poeira ');
INSERT INTO produtos (nome, descricao)
VALUES ('iPad Mini 4', 'iPad Mini ultra fino e leve');