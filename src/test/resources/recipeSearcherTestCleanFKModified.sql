-- MySQL dump 10.13  Distrib 9.0.1, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recipe_searcher_for_testing
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredients` (
  `IngredientID` int NOT NULL AUTO_INCREMENT,
  `IngredientName` varchar(50) NOT NULL,
  PRIMARY KEY (`IngredientID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,'Milk'),(2,'Eggs'),(3,'All-Purpose Flour'),(4,'White Sugar'),(5,'Unsalted Butter'),(6,'Salt'),(7,'Black Pepper'),(8,'Honey'),(9,'Light Brown Sugar'),(10,'Soy Sauce'),(11,'Vinegar'),(12,'Cayenne Pepper'),(13,'Ground Beef'),(14,'Onion'),(15,'Bread Crumbs'),(16,'Ketchup'),(17,'Yellow Mustard');
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipenames`
--

DROP TABLE IF EXISTS `recipenames`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipenames` (
  `RecipeNameID` int NOT NULL AUTO_INCREMENT,
  `RecipeName` varchar(100) NOT NULL,
  PRIMARY KEY (`RecipeNameID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipenames`
--

LOCK TABLES `recipenames` WRITE;
/*!40000 ALTER TABLE `recipenames` DISABLE KEYS */;
INSERT INTO `recipenames` VALUES (1,'Crepes'),(2,'Honey Pepper Sauce'),(3,'Meatloaf');
/*!40000 ALTER TABLE `recipenames` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipenames_ingredients`
--

DROP TABLE IF EXISTS RecipeNames_Ingredients;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipenames_ingredients` (
  `RecipeNameID` int NOT NULL DEFAULT '0',
  `IngredientID` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`RecipeNameID`,`IngredientID`),
  KEY `RecipeNameID` (`RecipeNameID`),
  KEY `IngredientID` (`IngredientID`),
  CONSTRAINT `FK_Ingredients_RecipeName` FOREIGN KEY (`IngredientID`) REFERENCES `ingredients` (`IngredientID`) ON DELETE CASCADE,
  CONSTRAINT `FK_RecipeName_Ingredients` FOREIGN KEY (`RecipeNameID`) REFERENCES `recipenames` (`RecipeNameID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipenames_ingredients`
--

LOCK TABLES RecipeNames_Ingredients WRITE;
/*!40000 ALTER TABLE RecipeNames_Ingredients DISABLE KEYS */;
INSERT INTO RecipeNames_Ingredients VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12),(3,1),(3,2),(3,6),(3,7),(3,9),(3,13),(3,14),(3,15),(3,16),(3,17);
/*!40000 ALTER TABLE RecipeNames_Ingredients ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-23 15:49:19
