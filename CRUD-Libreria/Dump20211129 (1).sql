CREATE DATABASE  IF NOT EXISTS `libreria` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `libreria`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: libreria
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros` (
  `isbn` char(13) NOT NULL,
  `titulo` char(100) DEFAULT NULL,
  `autor` char(50) DEFAULT NULL,
  `editorial` char(50) DEFAULT NULL,
  `imagen` char(50) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES ('9780072226843','Sun Certified Programmer and Developer for Java 2 Study Guide','Sierra, Kathy','McGraw-Hill','0002.jpg',700),('9780130092298','Servlets and JavaServer Pages','Hall, Marty','Sun Microsystems','0009.jpg',800),('9780130341518','Java How to Program (4th Edition)','Deitel, Harvey','McGraw-Hill','0008.jpg',700),('9780130471772','Core Java 2, Volume I: Fundamentals (6th Edition)','Horstmann, Kay','Sun Microsystems','0005.jpg',200),('9780131482111','Just Java 2 (5th Edition)','Van Der Linden, Peter','Sun Microsystems','0004.jpg',300),('9780131872486','Thinking in Java','Eckel, Bruce','Prentice Hall','0001.jpg',500),('9780201433289','JDBC(TM) API Tutorial and Reference','White, Set','Sun Microsystems','0010.jpg',250),('9780672316319','Java 2 Platform Unleashed','Jaworsky, Jamie','Sams','0007.jpg',600),('9781861003669','Beginning Java 2','Horton, Ivor','Wroxl','0003.jpg',400),('9781930110885','Swing, Second Edition','Robinson, Matthew','Manning','0006.jpg',350);
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-29 19:08:08
