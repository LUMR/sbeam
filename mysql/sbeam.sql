CREATE DATABASE  IF NOT EXISTS `sbeam` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sbeam`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: sbeam
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'动作'),(2,'竞速'),(3,'冒险'),(4,'模拟经营');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `platform_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pubdate` datetime NOT NULL DEFAULT '2017-01-01 08:08:08',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'尼尔:机械纪元',1,1,400,'尼尔2','2017-03-17 00:00:00'),(2,'上古卷轴5',3,1,200,'老滚5','1970-01-01 00:00:00'),(3,'使命召唤：黑色行动',1,1,200,'使命召唤系列','1970-01-01 00:00:00'),(4,'鬼泣3',1,2,200,'鬼泣系列','2017-01-01 08:08:08'),(5,'鬼泣4',1,1,300,'鬼泣系列','2017-01-01 08:08:08'),(6,'刺客信条12',1,1,360,'潜行（无双）','2017-01-01 08:08:08');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `header`
--

DROP TABLE IF EXISTS `header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `header` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(30) NOT NULL,
  `src` varchar(50) NOT NULL DEFAULT '/header/',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `header`
--

LOCK TABLES `header` WRITE;
/*!40000 ALTER TABLE `header` DISABLE KEYS */;
INSERT INTO `header` VALUES (1,'c1.jpg','/header/LUMR.jpg');
/*!40000 ALTER TABLE `header` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `library`
--

DROP TABLE IF EXISTS `library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `library` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT 'userId',
  `game_id` int(11) NOT NULL COMMENT 'gameId',
  PRIMARY KEY (`user_id`,`game_id`),
  KEY `library_id_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `library`
--

LOCK TABLES `library` WRITE;
/*!40000 ALTER TABLE `library` DISABLE KEYS */;
INSERT INTO `library` VALUES (1,2,1),(2,2,3),(3,2,4),(4,2,2),(5,2,6);
/*!40000 ALTER TABLE `library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `game_id` int(11) NOT NULL DEFAULT '-1' COMMENT 'gameId',
  `file_name` varchar(50) NOT NULL DEFAULT '' COMMENT 'fileName',
  `src` varchar(50) NOT NULL DEFAULT '' COMMENT 'src',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (1,2,'2_0.jpeg','/pictures/2_0.jpeg'),(2,2,'2_1.jpg','/pictures/2_1.jpg'),(3,2,'2_2.jpg','/pictures/2_2.jpg'),(4,1,'1_0.png','/pictures/1_0.png'),(5,1,'1_1.jpg','/pictures/1_1.jpg'),(6,1,'1_2.jpg','/pictures/1_2.jpg');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform`
--

DROP TABLE IF EXISTS `platform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform`
--

LOCK TABLES `platform` WRITE;
/*!40000 ALTER TABLE `platform` DISABLE KEYS */;
INSERT INTO `platform` VALUES (1,'Pc'),(2,'Ps4'),(3,'XBOX ONE'),(4,'XBOX 360'),(5,'PSV');
/*!40000 ALTER TABLE `platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `game_id` int(11) NOT NULL DEFAULT '-1' COMMENT 'gameId',
  `user_id` int(11) NOT NULL DEFAULT '-1' COMMENT 'userId',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT 'title',
  `content` varchar(50) NOT NULL DEFAULT '' COMMENT 'content',
  `pub_date` datetime NOT NULL DEFAULT '2017-01-01 12:00:00' COMMENT 'pubDate',
  `up_date` datetime NOT NULL DEFAULT '2017-01-01 13:00:00' COMMENT 'upDate',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `header_id` int(11) NOT NULL DEFAULT '1',
  `money` double NOT NULL DEFAULT '0',
  `register_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'registerDate',
  `is_admin` int(11) NOT NULL DEFAULT '0' COMMENT 'isAdmin',
  PRIMARY KEY (`id`),
  KEY `user_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'LUMR','3f4bb586f04a0c1d93eadab9363a8a3183b4860c',1,0,'2017-05-14 23:06:26',1),(2,'尼尔','3f4bb586f04a0c1d93eadab9363a8a3183b4860c',1,9640,'2017-05-15 21:49:43',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_games`
--

DROP TABLE IF EXISTS `view_games`;
/*!50001 DROP VIEW IF EXISTS `view_games`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_games` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `category`,
 1 AS `platform`,
 1 AS `price`,
 1 AS `description`,
 1 AS `pubdate`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_games`
--

/*!50001 DROP VIEW IF EXISTS `view_games`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`lumr`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_games` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t2`.`name` AS `category`,`t3`.`name` AS `platform`,`t1`.`price` AS `price`,`t1`.`description` AS `description`,`t1`.`pubdate` AS `pubdate` from (`game` `t1` left join (`category` `t2` join `platform` `t3`) on(((`t1`.`category_id` = `t2`.`id`) and (`t1`.`platform_id` = `t3`.`id`)))) */;
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

-- Dump completed on 2017-05-17 11:50:09

CREATE TABLE sys_role (
  id          INT AUTO_INCREMENT,
  role        VARCHAR(10) NOT NULL COMMENT '角色名称',
  description VARCHAR(24) NULL COMMENT '角色描述',
  available   TINYINT     NULL COMMENT '是否可用:1可用 0不可用',
  CONSTRAINT sys_role_id_pk
    PRIMARY KEY (id)
)
  COMMENT '用户角色';

CREATE UNIQUE INDEX sys_role_role_uindex
  ON sys_role(role);


CREATE TABLE sys_permission (
  id           INT AUTO_INCREMENT PRIMARY KEY,
  name         VARCHAR(10) COMMENT '',
  permission   VARCHAR(24) COMMENT '',
  resource_type VARCHAR(12) COMMENT '',
  available    TINYINT NULL COMMENT '是否可用:1可用 0不可用'
)
  COMMENT '权限表';

CREATE TABLE sys_role_permission (
  role_id       INT COMMENT '角色id',
  permission_id INT COMMENT '权限id'
) COMMENT '角色权限关联表';

CREATE UNIQUE INDEX sys_role_permission_uindex ON sys_role_permission(role_id, permission_id);

CREATE TABLE user_role(
  user_id INT,
  role_id INT
) COMMENT '用户角色关联表';

CREATE UNIQUE INDEX user_role_uindex ON user_role(user_id,role_id);