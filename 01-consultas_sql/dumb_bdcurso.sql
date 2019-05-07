Lab BD - 2018-2
Lab 01: Exemplo de Consultas SQL - Parte 1
Joao Carlos Pinheiro 9 de out de 2018 Editado às 11 de out de 2018
Modelagem de um banco de dados de cursos on-line.
consultas-cursoonline-roterio-aula.sql
SQL
script-bd-cursoonline.sql
SQL
dump-bdcurso-aula.sql
SQL
modelo relacional - cursosonline.png
Imagem
Comentários da turma
Nenhum comentário da turma.
Por que você não inicia a conversa?

-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cursodb
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'João da Silva','joao@dasilva.com'),
                           (2,'Frederico José','fred@jose.com'),
                           (3,'Ribamar Santos','ribamar@santos.com'),
                           (4,'Renata Fonseca','renata@fonseca.com'),
						   (5,'Paulo da Silva','paulo@dasilva.com');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'SQL e banco de dados'),
                           (2,'Desenvolvimento web com Spring'),
                           (3,'Scrum e métodos Ágeis'),
                           (4,'PHP e MySql');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercicio`
--

DROP TABLE IF EXISTS `exercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercicio` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `secao_id` int(11) NOT NULL,
  `pergunta` text NOT NULL,
  `resposta_oficial` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercicio`
--

LOCK TABLES `exercicio` WRITE;
/*!40000 ALTER TABLE `exercicio` DISABLE KEYS */;
INSERT INTO `exercicio` VALUES (1,1,'O que é um select?','Uma consulta que devolve resultados'),
                               (2,1,'Como funciona um select?','select campos from tabela'),
                               (3,2,'O que é um update?','serve pra alterar dados'),
                               (4,2,'Perigos do update?','Nao pode esquecer de colocar where'),
                               (5,3,'O que é um delete?','deleta uma linha do banco de dados'),
                               (6,3,'Cuidados com ele?','nao pode esquecer do where'),
                               (7,4,'o que eh um insert?','serve para inserir um dado no banco'),
                               (8,4,'como funciona?','insert into (coluna1, coluna2) values (v1, v2)'),
                               (9,5,'Como funciona a web?','requisicao e resposta'),
                               (10,5,'Que linguagens posso ajudar?','varias, java, php, c#, etc'),
                               (11,6,'O que eh MVC?','model view controller'),
                               (12,6,'Frameworks que usam?','spring boot, spring mvc, Spring REST, etc'),
                               (13,7,'O que é a classe Result?','serve para lidar com o resultado'),
                               (14,8,'O que é um interceptor?','eh como se fosse um filtro que eh executado antes'),
                               (15,8,'quando usar?','tratamento de excecoes, conexao com o banco de dados'),
                               (16,9,'o que eh iteracao','tempo que vc tem pra agregar valor'),
                               (17,9,'qual tamanho bom?','de 2 a 4 semanas, segundo o scrum guide antigo'),
                               (18,10,'o que sao retrospectiva?','reunioes onde a ideia eh melhorar o processo'),
                               (19,10,'quando devemos fazer?','geralmente a cada iteracao'),
                               (20,11,'o que eh a reuniao diaria?','uma pequena reuniao para informar a equipe sobre o andamento da iteracao'),
                               (21,11,'quando fazemos?','uma vez por dia, em um horario fixo e pre definido'),
                               (22,12,'o que eh kanban?','um metodo agil tb'),(23,12,'o que eh xp?','outro metodo agil'),
                               (24,12,'tem outros?','lean, crystal, fdd'),(25,13,'o que eh a web?','eh a internet, ue'),
                               (26,13,'como funciona a web?','requisicao e resposta'),
                               (27,14,'o que eh o apache?','servidor que sabe trabalhar com HTTP'),
                               (28,14,'java funciona?','sim, quando colocamos o tomcat junto com ele'),
                               (29,15,'o que eh mysql','essa voce sabe, certo? :)'),
                               (30,16,'o que eh deploy?','É o processo de colocarmos a aplicacao no ar'),
                               (31,16,'como faz?','em php, basta copiar os arquivos php, em java, basta copiar o jar');
/*!40000 ALTER TABLE `exercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `aluno_id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `tipo` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,1,1,'2013-11-25 16:16:05','PAGA_PF'),
                               (2,2,1,'2013-05-25 16:16:25','PAGA_PJ'),
                               (3,3,3,'2013-07-21 16:16:30','PAGA_PF'),
                               (4,4,4,'2013-11-15 16:15:35','PAGA_PK'),
                               (5,2,2,'2012-01-04 00:00:00','PAGA_PJ');
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `media_curso`
--

DROP TABLE IF EXISTS `media_curso`;
/*!50001 DROP VIEW IF EXISTS `media_curso`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `media_curso` AS SELECT 
 1 AS `curso`,
 1 AS `media`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `resposta_id` int(11) DEFAULT NULL,
  `nota` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES (1,1,8),(2,2,0),(3,3,7),(4,4,6),(5,5,9),(6,6,10),(7,7,4),(8,8,4),(9,9,7),(10,10,8),
(11,11,6),(12,12,7),(13,13,4),(14,14,9),(15,15,3),(16,16,5),(17,17,5),(18,18,5),(19,19,6),(20,20,8),(21,21,8),
(22,22,9),(23,23,10),(24,24,2),(25,25,0),(26,26,1),(27,27,4);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notas` (
  `aluno` varchar(10) DEFAULT NULL,
  `nota1` int(11) DEFAULT NULL,
  `nota2` int(11) DEFAULT NULL,
  `nota3` int(11) DEFAULT NULL,
  `nota4` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES ('Maria',8,9,10,6),
                           ('Jose',7,8,5,9);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resposta` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `exercicio_id` int(11) DEFAULT NULL,
  `aluno_id` int(11) DEFAULT NULL,
  `resposta_dada` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resposta`
--

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
INSERT INTO `resposta` VALUES (1,1,1,'uma selecao'),(2,2,1,'ixi, nao sei'),
						      (3,3,1,'alterar dados'),(4,4,1,'esquecer o where e alterar tudo'),
                              (5,5,1,'apagar coisas'),(6,6,1,'tb nao pode esquecer o where'),
                              (7,7,1,'inserir dados'),(8,1,2,'buscar dados'),
                              (9,2,2,'select campos from tabela'),(10,3,2,'alterar coisas'),
                              (11,4,2,'ixi, nao sei'),(12,16,3,'tempo pra fazer algo'),
                              (13,17,3,'1 a 4 semanas'),(14,18,3,'melhoria do processo'),
                              (15,19,3,'todo dia'),(16,20,3,'reuniao de status'),
                              (17,21,3,'todo dia'),(18,22,3,'o quadro branco'),
                              (19,23,3,'um metodo agil'),(20,24,3,'tem varios outros'),
                              (21,25,4,'eh a internet'),(22,26,4,'browser faz requisicao, servidor manda resposta'),
                              (23,27,4,'eh o servidor que lida com http'),(24,28,4,'nao sei'),
                              (25,29,4,'banco de dados!'),(26,30,4,'eh colocar a app na internet'),
                              (27,31,4,'depende da tecnologia, mas geralmente eh levar pra um servidor que ta na internet');
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secao`
--

DROP TABLE IF EXISTS `secao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secao` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `curso_id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL DEFAULT '',
  `explicacao` text NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secao`
--

LOCK TABLES `secao` WRITE;
/*!40000 ALTER TABLE `secao` DISABLE KEYS */;
INSERT INTO `secao` VALUES (1,1,'Aprendendo o SELECT','explicacao do capitulo Aprendendo o SELECT',1),
                           (2,1,'Aprendendo o UPDATE','explicacao do capitulo Aprendendo o UPDATE',2),
                           (3,1,'Aprendendo o DELETE','explicacao do capitulo Aprendendo o DELETE',3),
                           (4,1,'Aprendendo o INSERT','explicacao do capitulo Aprendendo o INSERT',4),
                           (5,2,'O que é a Web?','explicacao do capitulo O que é a Web?',1),
                           (6,2,'Entendendo o MVC','explicacao do capitulo Entendendo o MVC',2),
                           (7,2,'O objeto Result','explicacao do capitulo O objeto Result',3),
                           (8,2,'Interceptor','explicacao do capitulo Interceptor',4),
                           (9,3,'Planejando a iteração','explicacao do capitulo Planejando a iteração',1),
                           (10,3,'Retrospectivas','explicacao do capitulo Retrospectivas',2),
                           (11,3,'Reunião Diária','explicacao do capitulo Reunião Diária',3),
                           (12,3,'Kanban e XP','explicacao do capitulo Kanban e XP',4),
                           (13,4,'Introdução a Web','explicacao do capitulo Introdução a Web',1),
                           (14,4,'O servidor Apache','explicacao do capitulo O servidor Apache',2),
                           (15,4,'MySql','explicacao do capitulo Lidando com o MySql',3),
                           (16,4,'Instalação da aplicação','explicacao do capitulo Instalando a aplicação',4);
/*!40000 ALTER TABLE `secao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_media_curso`
--

DROP TABLE IF EXISTS `tmp_media_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_media_curso` (
  `curso` varchar(255) NOT NULL DEFAULT '',
  `media` decimal(14,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_media_curso`
--

LOCK TABLES `tmp_media_curso` WRITE;
/*!40000 ALTER TABLE `tmp_media_curso` DISABLE KEYS */;
INSERT INTO `tmp_media_curso` VALUES ('PHP e MySql',4.8571),
									 ('Scrum e métodos ágeis',5.7778),
                                     ('SQL e banco de dados',6.2727);
/*!40000 ALTER TABLE `tmp_media_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `media_curso`
--

/*!50001 DROP VIEW IF EXISTS `media_curso`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `media_curso` AS select `c`.`nome` AS `curso`,avg(`n`.`nota`) AS `media` from ((((`nota` `n` join `resposta` `r` on((`r`.`id` = `n`.`resposta_id`))) join `exercicio` `e` on((`e`.`id` = `r`.`exercicio_id`))) join `secao` `s` on((`s`.`id` = `e`.`secao_id`))) join `curso` `c` on((`c`.`id` = `s`.`curso_id`))) group by `c`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-25 11:29:13


# Chaves estrangeiras
#alter table secao add foreign key (curso_id) references curso(id);

dump-bdcurso-aula.sql
Exibindo dump-bdcurso-aula.sql.