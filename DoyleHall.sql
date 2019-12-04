-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: DoyleHall
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doyle_rooms`
--

DROP TABLE IF EXISTS `doyle_rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doyle_rooms` (
  `Room_Number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doyle_rooms`
--

LOCK TABLES `doyle_rooms` WRITE;
/*!40000 ALTER TABLE `doyle_rooms` DISABLE KEYS */;
INSERT INTO `doyle_rooms` VALUES (201),(205),(206),(207),(208),(209),(210),(211),(212),(213),(214),(216),(301),(305),(306),(307),(308),(309),(310),(311),(312),(313),(314),(316);
/*!40000 ALTER TABLE `doyle_rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `Name` varchar(25) NOT NULL,
  `Email_Address` varchar(30) DEFAULT 'null',
  `Room_Floor` int(11) DEFAULT '0',
  `Room_Num` int(11) DEFAULT '0',
  `Room_Status` varchar(5) DEFAULT 'out',
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES ('Andrew N. Harrington','anh@cs.luc.edu',0,0,'out'),('Catherine Putonti','cputonti@luc.edu',0,0,'out'),('Cecilia Murphy','cmurphy@luc.edu',0,0,'out'),('Chandra N. Sekharan','chandra@cs.luc.edu',0,0,'out'),('Channah Naiman','cnaiman@luc.edu',0,0,'out'),('David Gubala','dgubala727@gmail.com',0,0,'out'),('Dmitriy Dligach','ddligach@luc.edu',0,0,'out'),('Eric Chan-Tin','chantin@cs.luc.edu',0,0,'out'),('George K. Thiruvathukal','gkt@cs.luc.edu',0,0,'out'),('Heather E. Wheeler','hwheeler1@luc.edu',0,0,'out'),('Konstantin Läufer','laufer@cs.luc.edu',0,0,'out'),('Leo Irakliotis','info@irakliotis.com',0,0,'out'),('Marina Hart','mhart6@luc.edu',0,0,'out'),('Miao Ye','my@cs.luc.edu',0,0,'out'),('Neil Klingensmith','neil@cs.luc.edu',0,0,'out'),('Nicholas J. Hayward','nhayward@luc.edu',0,0,'out'),('Peter Lars Dordal','pld@cs.luc.edu',0,0,'out'),('Robert Yacobellis','ryacobellis@luc.edu',0,0,'out'),('Ronald I. Greenberg','rig@cs.luc.edu',0,0,'out'),('Stephen Doty','doty@math.luc.edu',0,0,'out'),('William L. Honig','whonig@luc.edu',0,0,'out');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-04 13:04:39
