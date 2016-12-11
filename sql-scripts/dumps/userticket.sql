CREATE DATABASE  IF NOT EXISTS `TravelieDBB` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `TravelieDBB`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: TravelieDB2
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `userticket`
--

DROP TABLE IF EXISTS `userticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) NOT NULL,
  `van_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `source` varchar(11) NOT NULL,
  `destination` varchar(11) NOT NULL,
  `dept_date` varchar(11) NOT NULL,
  `dept_time` varchar(11) NOT NULL,
  `seat_no` int(11) NOT NULL,
  
  PRIMARY KEY (`id`),

   KEY `fk_ticketId` (`ticket_id`),
CONSTRAINT `fk_ticketId` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON Update CASCADE
)

 ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Dumping data for table `userticket`
--

LOCK TABLES `userticket` WRITE;
/*!40000 ALTER TABLE `userticket` DISABLE KEYS */;


INSERT INTO `userticket` VALUES 
	(1, 1, 1, 1, 1, 1, "ahmed", "giki", "lahore","2/5/16", "19:00", 52),
	(2, 2, 2, 2, 2, 2, "usman", "giki", "khi","2/5/16", "19:00", 532),
	(3, 3, 3, 3, 3, 3, "osama", "giki", "fsd","22/5/16", "15:00", 562);

/*!40000 ALTER TABLE `userticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-24 21:50:59

