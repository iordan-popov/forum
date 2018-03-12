CREATE DATABASE  IF NOT EXISTS `forum` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `forum`;
-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: forum
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `forums`
--

DROP TABLE IF EXISTS `forums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forums` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forums`
--

LOCK TABLES `forums` WRITE;
/*!40000 ALTER TABLE `forums` DISABLE KEYS */;
INSERT INTO `forums` VALUES (1,'AutoParts','Main',1),(2,'Car Parts','car parts',2),(3,'Truck parts','truck parts',3),(4,'Motorcycle parts','Motorcycle parts',4);
/*!40000 ALTER TABLE `forums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `replies`
--

DROP TABLE IF EXISTS `replies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `replies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `users_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`users_id`,`topic_id`),
  KEY `fk_replies_users_idx` (`users_id`),
  KEY `fk_replies_topics1_idx` (`topic_id`),
  CONSTRAINT `fk_replies_topics1` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_replies_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `replies`
--

LOCK TABLES `replies` WRITE;
/*!40000 ALTER TABLE `replies` DISABLE KEYS */;
INSERT INTO `replies` VALUES (40,'Please advise for a good model of springs for mercedes C200 , 2001 ','2018-03-01','2018-03-01',10,1),(41,'Please advise?','2018-03-01','2018-03-01',10,27),(42,'MONROE  are good producer of springs','2018-03-01','2018-03-01',7,1),(43,'I prefer TRW , much cheaper and again high quality...','2018-03-01','2018-03-01',9,1),(44,'I have one from my old Audi, it has small defect but a new paint and it will be like new, call if interested 089323464','2018-03-01','2018-03-01',9,28),(45,'Are you willing to put down the price to 13,000 ?','2018-03-01','2018-03-01',8,29),(46,'Max for what i can go down is 14,000....','2018-03-01','2018-03-01',9,29),(47,'Ok, we have a deal, I will call you this afternoon to make the deal','2018-03-01','2018-03-01',8,29);
/*!40000 ALTER TABLE `replies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topics`
--

DROP TABLE IF EXISTS `topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(65) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `users_id` int(11) NOT NULL,
  `forums_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`users_id`,`forums_id`),
  KEY `fk_topics_users1_idx` (`users_id`),
  KEY `fk_topics_forums1_idx` (`forums_id`),
  CONSTRAINT `fk_topics_forums1` FOREIGN KEY (`forums_id`) REFERENCES `forums` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_topics_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topics`
--

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` VALUES (1,'Default',NULL,'2018-03-01','2018-03-01',6,1),(27,'Mechanic','I am having problem finding a good mechanic for my Suzuki','2018-03-01','2018-03-01',10,4),(28,'Second hand trunk Audi A3 1999','I am looking for a second hand-trunk door for Audi A3 1999, ','2018-03-01','2018-03-01',7,2),(29,'Selling Truck Reno','I am selling Reno T truck 2015 for 15,000 EURO for more information : 0883462433','2018-03-01','2018-03-01',9,3),(30,'For Sale ','Audi A4 1989 Diesel 2.0   3,500lv tel: 0873499512','2018-03-01','2018-03-01',8,2),(31,'searching for a good Truck','searching for a good Truck , DAF model up to 25k lv','2018-03-01','2018-03-01',8,3);
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(65) DEFAULT NULL,
  `password` varchar(65) DEFAULT NULL,
  `name` varchar(65) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `date_registered` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `current_status` varchar(45) DEFAULT NULL,
  `registered_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (6,'silvana@abv.bg','555','Silvana Petrova','Female',28,'2018-02-23',NULL,'Invisible','New'),(7,'misho@gmail.com','1234','Misho','Male',12,'2018-02-23',NULL,'Invisible','New'),(8,'iordan@gmail.com','123','Iordan','Male',28,'2018-02-24',NULL,'Invisible','New'),(9,'petar.petrov@abv.bg','12','Petar','Male',28,'2018-02-25',NULL,'Invisible','New'),(10,'ivan@abv.bg','123','Ivan Todorov','Male',29,'2018-03-01',NULL,'Invisible','New');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'forum'
--

--
-- Dumping routines for database 'forum'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-02 10:41:33
