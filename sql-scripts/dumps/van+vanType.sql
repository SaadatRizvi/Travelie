-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: learnb
-- ------------------------------------------------------
-- Server version	5.6.34-log

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
-- Table structure for table `van`
--

DROP TABLE IF EXISTS `van`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `van` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_registration` varchar(45) NOT NULL,
  `vehicle_type` varchar(45) NOT NULL,
  `total_seats` int(11) NOT NULL,
  `vancategory_id` int(11) NOT NULL,
  `flagged` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vehicle_registration` (`vehicle_registration`),
  KEY `fk_vanTypeId` (`vancategory_id`),
  CONSTRAINT `fk_vanTypeId` FOREIGN KEY (`vancategory_id`) REFERENCES `vantype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `van`
--

LOCK TABLES `van` WRITE;
/*!40000 ALTER TABLE `van` DISABLE KEYS */;
INSERT INTO `van` VALUES (1,'ABC123','Van',23,2,0),(2,'XCV123','Coaster',10,3,0),(3,'EGE123','Bus',15,2,0),(4,'EGS123','Hiace',12,2,0),(5,'LOE123','Van',35,3,0),(6,'rty566','Van',32,3,0),(9,'ABC1234','sad',0,3,0),(11,'2014370','Coaster',23,3,1);
/*!40000 ALTER TABLE `van` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vantype`
--

DROP TABLE IF EXISTS `vantype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vantype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vantype`
--

LOCK TABLES `vantype` WRITE;
/*!40000 ALTER TABLE `vantype` DISABLE KEYS */;
INSERT INTO `vantype` VALUES (2,'AC'),(3,'Economy'),(1,'Type');
/*!40000 ALTER TABLE `vantype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'learnb'
--

--
-- Dumping routines for database 'learnb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-10  7:32:32
