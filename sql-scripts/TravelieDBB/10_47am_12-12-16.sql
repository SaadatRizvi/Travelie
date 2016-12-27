-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: traveliedbb
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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `van_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `registered_seats` int(11) NOT NULL DEFAULT '1',
  `departure_time` varchar(11) NOT NULL,
  `arival_time` varchar(11) NOT NULL,
  `departure_date` varchar(11) NOT NULL,
  `expected_price` int(11) NOT NULL DEFAULT '500',
  PRIMARY KEY (`id`),
  KEY `fk_vanId` (`van_id`),
  KEY `fk_driverId` (`driver_id`),
  KEY `fk_routeId` (`route_id`),
  CONSTRAINT `fk_driverId` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_routeId` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vanId` FOREIGN KEY (`van_id`) REFERENCES `van` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (4,2,2,3,4,'00:59','unknown','2016-12-11',5000),(5,5,4,6,1,'00:59','unknown','2016-12-11',5000),(6,3,3,6,2,'01:59','unknown','2016-12-11',5000),(7,5,3,4,4,'15:00','unknown','2016-12-11',5000),(9,4,3,8,4,'01:57','unknown','2016-12-29',5000),(10,6,1,8,6,'18:34','unknown','2016-12-11',5000),(11,2,2,5,2,'14:58','unknown','2016-12-11',5000),(12,1,1,4,1,'01:59','unknown','2016-12-11',5000),(13,4,1,7,8,'00:00','unknown','2016-12-22',5000);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `regnumber` int(11) NOT NULL,
  `phonenumber` int(11) NOT NULL,
  `flagged` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `regnumber` (`regnumber`),
  UNIQUE KEY `phonenumber` (`phonenumber`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'David','Adams','David','Adams','david@luv2code.com',2014123,332343233,0),(2,'John','Adams','John','Doe','john@luv2code.com',2014124,332323235,0),(3,'Ajay','Adams','Ajay','Rao','ajay@luv2code.com',2014143,332323231,0),(4,'Mary','Adams','Mary','Public','mary@luv2code.com',2014523,332325233,0),(5,'Maxwell','Adams','Maxwell','Dixon','max@luv2code.com',2014723,332363233,0),(6,'umer','123abc','Umer','Farooq','hotmail@gmail.com',2014158,213,0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination`
--

DROP TABLE IF EXISTS `destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `location` (`location`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination`
--

LOCK TABLES `destination` WRITE;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` VALUES (9,'Abbotabad'),(1,'Destination'),(5,'Faisalabad'),(10,'Hyderabad'),(2,'Islamabad'),(8,'Karachi'),(4,'Lahore'),(7,'Multan'),(6,'Peshawar'),(3,'Rawalpindi');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `cnic` varchar(45) NOT NULL,
  `license_number` varchar(11) NOT NULL,
  `phonenumber` int(11) NOT NULL,
  `picture` varchar(15) NOT NULL,
  `flagged` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnic` (`cnic`),
  UNIQUE KEY `license_number` (`license_number`),
  UNIQUE KEY `phonenumber` (`phonenumber`),
  UNIQUE KEY `picture` (`picture`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'David','Adams','100','101',332343233,'?1',0),(2,'John','Doe','200','102',332323235,'?2',0),(3,'Ajay','Rao','300','303',332323231,'?3',0),(4,'Mary','Private','400','305',332325233,'?4',0),(6,'Saif','Khan','123345','092021',323143452,'?9',1);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source` varchar(45) NOT NULL,
  `destination_id` int(11) NOT NULL,
  `exp_t_time` varchar(45) NOT NULL,
  `eco_fare` int(11) NOT NULL,
  `ac_fare` int(11) NOT NULL,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_destinationId` (`destination_id`),
  CONSTRAINT `fk_destinationId` FOREIGN KEY (`destination_id`) REFERENCES `destination` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'GIKI',1,'1 hr 25 min',2500,3500,'Available'),(2,'GIKI',2,'5 hr',12500,13500,'Available'),(3,'GIKI',3,'2 hr',5000,7500,'Available'),(4,'GIKI',4,'2 hr',5000,6000,'Avaialbe'),(5,'GIKI',5,'2 hr ',6000,8000,'Avaiable'),(6,'GIKI',6,'3 hr',4300,5000,'Avaiable'),(7,'GIKI',7,'3 hr',4300,5000,'Avaiable'),(8,'GIKI',8,'3 hr',4300,5000,'Avaiable'),(9,'GIKI',9,'3 hr',4300,5000,'Avaiable'),(10,'GIKI',10,'3 hr',4300,5000,'Avaiable');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookings_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `seat_no` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_customerId` (`customer_id`),
  KEY `fk_bookingsId` (`bookings_id`),
  CONSTRAINT `fk_bookingsId` FOREIGN KEY (`bookings_id`) REFERENCES `bookings` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_customerId` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (4,11,6,2),(5,13,6,1),(6,7,6,4),(7,4,6,4),(8,13,6,2),(9,13,6,3),(10,13,6,4),(11,13,6,5),(12,13,6,6),(13,13,6,7),(14,13,6,8),(15,10,6,6);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_ticketId` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userticket`
--

LOCK TABLES `userticket` WRITE;
/*!40000 ALTER TABLE `userticket` DISABLE KEYS */;
INSERT INTO `userticket` VALUES (1,1,1,1,1,1,'ahmed','giki','lahore','2/5/16','19:00',52),(2,2,2,2,2,2,'usman','giki','khi','2/5/16','19:00',532),(3,3,3,3,3,3,'osama','giki','fsd','22/5/16','15:00',562);
/*!40000 ALTER TABLE `userticket` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `van`
--

LOCK TABLES `van` WRITE;
/*!40000 ALTER TABLE `van` DISABLE KEYS */;
INSERT INTO `van` VALUES (1,'ABC123','Van',15,2,0),(2,'XCV123','Coaster',15,3,0),(3,'EGE123','Bus',15,2,0),(4,'EGS123','Hiace',15,2,0),(5,'LOE123','Van',15,3,0),(6,'rty566','Van',15,3,0),(11,'2014370','Coaster',15,3,1),(16,'2014148','Car',15,2,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
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
-- Table structure for table `webdata`
--

DROP TABLE IF EXISTS `webdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `departure_time` varchar(45) NOT NULL,
  `departure_date` varchar(45) NOT NULL,
  `destination` varchar(45) NOT NULL,
  `available_seats` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bookingID_idx` (`booking_id`),
  CONSTRAINT `fk_bookingID` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webdata`
--

LOCK TABLES `webdata` WRITE;
/*!40000 ALTER TABLE `webdata` DISABLE KEYS */;
INSERT INTO `webdata` VALUES (6,'Economy','00:59','2016-12-11','Peshawar',11,4),(7,'AC','01:59','2016-12-11','Peshawar',14,5),(8,'AC','15:00','2016-12-11','Lahore',13,6),(9,'AC','01:59','2016-12-11','Lahore',11,7),(16,'AC','18:34','2016-12-11','Karachi',9,10),(17,'AC','14:58','2016-12-11','Faisalabad',13,11),(18,'AC','01:59','2016-12-11','Lahore',14,12),(19,'Economy','00:00','2016-12-22','Multan',7,13);
/*!40000 ALTER TABLE `webdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'traveliedbb'
--

--
-- Dumping routines for database 'traveliedbb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-12 10:48:01
