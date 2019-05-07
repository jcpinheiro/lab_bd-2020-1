/* CRIANDO UM BANCO */

CREATE DATABASE PROJETO;

/* CONECTANDO */

USE PROJETO;

/* CRIANDO A TABELA */


CREATE TABLE CLIENTE(
	NOME VARCHAR(30),
	SEXO CHAR(1),
	EMAIL VARCHAR(30),
	CPF INT(11),
	TELEFONE VARCHAR(30),
	ENDERECO VARCHAR(100)
);

/*VERIFICANDO AS TABELAS */

SHOW TABLES;

/* DESCREVENDO TABELAS */

DESC CLIENTE;

/* A 06 */

/*Tipos de dados */

Todos os bancos de dados possuem tipos que devem ser atribuidos aos dados de uma tabela.
Para caracteres literais, temos char e varchar, para números temos int e float, para
objetos como fotos e documentos, temos o blob, para textos extensos, temos o text. 
A disciplina de banco de dados é tão fantástica que ao entendermos o porque das coisas,
podemos iniciar já em modo avançado e um bom exemplo disso são os tipos. Há uma profissão
dentro da área que é a do analista de performance ou tuning, esse profissional é responsável
por analisar o banco de dados e deixá-lo mais rápido. Com algumas atitudes simples, 
podemos deixar o banco sem a necessidade de atuação desse profissional.

Cada caracter no banco de dados, vale 1 byte. Sendo assim, se eu entro com o dado JOÃO,
estou entrando com 4 bytes no meu banco. E o que isso tem a ver com a tipagem de tabelas?

Ao tiparmos uma tabela de modo errado ou displicente, vamos aumentar a quantidade de dados que 
será baixada do banco de dados, prolongando assim o tempo de resposta.

Uma comparacao bem didatica é o tipo char e varchar

A palavra var, vem de variant, em ingles, ou seja, que é dinâmica. Vejamos então a tipagem

varchar(10)
char(10)

entrando a palavra joao

total de bytes varchar(10) = 4 bytes
toal de bytes char(10) = 10 bytes

isso ocorre pois o char não varia. Os caracteres restantes serao preenchidos com espaço. 
eles nao ficam vazios. Enquanto que no varchar, o tipo varia conforme o dado.
Entao utilizo sempre o varchar? Não. O charé ligeiramente mais performatico, por nao
ter que gastar tempo variando de tamanho. Entao a regra é utilizar sempre o char quando
sabemos que o numero de caracteres naquela coluna nao vai variar nunca. Por exemplo,
unidade federativa, com dois digitos, sexo com um digito e assim por diante. Vista a diferença
que podemos fazer com uma tipagem correta de tabelas, na próxima aula detalharemos os tipos do mysql
e nos modulos específicos de cada banco, você entenderá os tipos correspondentes no sql server
e no oracle, que mudam muito pouco.

/* A 08 - Inserindo dados e valores nulos */

use projeto;

/* Mostrando as tabelas */
show tables

/* exibindo a estrutura de uma tabela */
desc cliente;

/* FORMA 01 - EXCLUINDO AS COLUNAS */

INSERT INTO CLIENTE VALUES('JOAO','M','JOAO@GMAIL.COM',988638273,'22923110','MAIA LACERDA - ESTACIO - RIO DE JANEIRO - RJ');

INSERT INTO CLIENTE VALUES('CELIA','F','CELIA@GMAIL.COM',541521456,'25078869','RIACHUELO - CENTRO - RIO DE JANEIRO - RJ');

INSERT INTO CLIENTE VALUES('JORGE','M',NULL,885755896,'58748895','OSCAR CURY - BOM RETIRO - PATOS DE MINAS - MG');

/* FORMA 02 - COLOCANDO AS COLUNAS */

INSERT INTO CLIENTE(NOME,SEXO,ENDERECO,TELEFONE,CPF) VALUES('LILIAN','F','SENADOR SOARES - TIJUCA - RIO DE JANEIRO - RJ','947785696',887774856);

/* FORMA 03 - INSERT COMPACTO - SOMENTE MYSQL */

INSERT INTO CLIENTE VALUES('ANA','F','ANA@GLOBO.COM',85548962,'548556985','PRES ANTONIO CARLOS - CENTRO - SAO PAULO - SP'),
                          ('CARLA','F','CARLA@TERATI.COM.BR',7745828,'66587458','SAMUEL SILVA - CENTRO - BELO HORIZONTE - MG');
						  

/* O COMANDO SELECT */

SELECT NOW();

SELECT 'FELIPE MAFRA';

SELECT 'BANCO DE DADOS';

/* ALIAS DE COLUNAS */

SELECT 'FELIPE MAFRA' AS PROFESSOR;

SELECT NOME, SEXO, EMAIL FROM CLIENTE;

SELECT NOME, SEXO, EMAIL, ENDERECO FROM CLIENTE;

SELECT ENDERECO, SEXO, EMAIL  FROM CLIENTE;

/* APENAS PARA FINS ACADEMICOS */

SELECT * FROM CLIENTE;

/* FILTRANDO DADOS COM WHERE E LIKE */

SELECT NOME, TELEFONE FROM CLIENTE;

/* FILTRANDO */

SELECT NOME, ENDERECO FROM CLIENTE
WHERE SEXO = 'M';

SELECT NOME, ENDERECO FROM CLIENTE
WHERE SEXO = 'F';

SELECT NOME, SEXO FROM CLIENTE
WHERE ENDERECO = 'RJ';

/* A CLAUSULA LIKE */

SELECT NOME, SEXO FROM CLIENTE
WHERE ENDERECO LIKE 'RJ';

/* CARACTER CORINGA % */

SELECT NOME, SEXO FROM CLIENTE
WHERE ENDERECO LIKE '%RJ';

SELECT NOME, SEXO, ENDERECO FROM CLIENTE
WHERE ENDERECO LIKE '%RJ';

SELECT NOME, SEXO, ENDERECO FROM CLIENTE
WHERE ENDERECO LIKE '%CENTRO%';

/* OPERADORES LOGICOS */

/* OR - OU */

SELECT NOME, SEXO, ENDERECO FROM CLIENTE
WHERE 
SEXO = 'M' OR ENDERECO LIKE '%RJ';

SELECT NOME, SEXO, ENDERECO  
FROM CLIENTE
WHERE SEXO = 'F' OR ENDERECO LIKE '%ESTACIO';

/* AND - E */

SELECT NOME, SEXO, ENDERECO  FROM CLIENTE
WHERE 
SEXO = 'M' AND ENDERECO LIKE '%RJ';

SELECT NOME, SEXO, ENDERECO FROM CLIENTE
WHERE SEXO = 'F' AND 
      ENDERECO LIKE '%ESTACIO';


/* PERFORMANCE EM OPERADORES LOGICOS */

/* 1 MILHAO DE REGISTROS PARA CONTAR */
SELECT COUNT(*) FROM CLIENTE;

SELECT SEXO, COUNT(*) 
FROM CLIENTE
GROUP BY SEXO;

SELECT CIDADE, COUNT(*) FROM CLIENTE
GROUP BY CIDADE;

/* CONDICAO - 
  SEXO = F
  CIDADE = RIO DE JANEIRO
*/

/* SITUACAO - TRATANDO COM OU / OR */
70% MULHERES = SEXO = F
30% MORA NO RIO DE JANEIRO

SELECT NOME, SEXO, ENDERECO
FROM CLIENTE
WHERE SEXO = 'F'
OR CIDADE = 'RIO DE JANEIRO';

/* SITUACAO - TRATANDO COM E / AND 
70% MULHERES = SEXO = F
30% MORA NO RIO DE JANEIRO */

SELECT NOME, SEXO, ENDERECO
FROM CLIENTE
WHERE CIDADE = 'RIO DE JANEIRO'
AND SEXO = 'F';

/* FILTRANDO VALORES NULOS */

SELECT NOME, SEXO, ENDERECO
FROM CLIENTE
WHERE EMAIL = NULL;

SELECT NOME, SEXO, ENDERECO
FROM CLIENTE
WHERE EMAIL IS NULL;

SELECT NOME, SEXO, ENDERECO
FROM CLIENTE
WHERE EMAIL IS NOT NULL;

/* A14 - UTILIZANDO O UPDATE PARA ATUALIZAR VALORES */

SELECT NOME, EMAIL
FROM CLIENTE;

UPDATE CLIENTE
SET EMAIL = 'LILIAN@HOTMAIL.COM';

/* UTILIZAR O UPDATE SEMPRE ACOMPANHADO
DA CLAUSULA WHERE */


UPDATE CLIENTE
SET EMAIL = 'JOAO@HOTMAIL.COM'
WHERE NOME = 'JOAO';

UPDATE CLIENTE
SET EMAIL = 'JORGE@GMAIL.COM'
WHERE NOME = 'JORGE';

UPDATE CLIENTE
SET EMAIL = 'ANA@GMAIL.COM'
WHERE NOME = 'ANA';

UPDATE CLIENTE
SET EMAIL = 'CARLA@TERRA.COM.BR'
WHERE NOME = 'CARLA';

/* DELETANDO REGISTROS COM A CLAUSULA DELETE */

DELETE FROM CLIENTE; -- NUNCA FAÇAM

SELECT COUNT(*) FROM CLIENTE;

DELETE FROM CLIENTE
WHERE NOME = 'ANA';

SELECT COUNT(*) FROM CLIENTE;

/* ENTRANDO COM MAIS TELEFONES */

UPDATE CLIENTE 
SET TELEFONE = '97865434'
WHERE NOME = 'JOAO';

UPDATE CLIENTE 
SET TELEFONE = '22923110 - 97865434'
WHERE NOME = 'JOAO';

SELECT ENDERECO, COUNT(*) AS "QUANTIDADE"
FROM CLIENTE
GROUP BY ENDERECO;
