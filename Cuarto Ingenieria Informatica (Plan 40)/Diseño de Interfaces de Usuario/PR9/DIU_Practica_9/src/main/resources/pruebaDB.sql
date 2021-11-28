-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         8.0.27 - MySQL Community Server - GPL
-- SO del servidor:              Linux
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para PRUEBA
CREATE DATABASE IF NOT EXISTS `PRUEBA` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `PRUEBA`;

-- Volcando estructura para tabla PRUEBA.tabla1
CREATE TABLE IF NOT EXISTS `tabla1` (
  `Campo1` int DEFAULT NULL,
  `Campo2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla1: ~1 rows (aproximadamente)
DELETE FROM `tabla1`;
/*!40000 ALTER TABLE `tabla1` DISABLE KEYS */;
INSERT INTO `tabla1` (`Campo1`, `Campo2`) VALUES
	(1, 'hey funca puta');
/*!40000 ALTER TABLE `tabla1` ENABLE KEYS */;

-- Volcando estructura para tabla PRUEBA.tabla2
CREATE TABLE IF NOT EXISTS `tabla2` (
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla2: ~0 rows (aproximadamente)
DELETE FROM `tabla2`;
/*!40000 ALTER TABLE `tabla2` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla2` ENABLE KEYS */;

-- Volcando estructura para tabla PRUEBA.tabla3
CREATE TABLE IF NOT EXISTS `tabla3` (
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla3: ~0 rows (aproximadamente)
DELETE FROM `tabla3`;
/*!40000 ALTER TABLE `tabla3` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla3` ENABLE KEYS */;

-- Volcando estructura para tabla PRUEBA.tabla4
CREATE TABLE IF NOT EXISTS `tabla4` (
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla4: ~0 rows (aproximadamente)
DELETE FROM `tabla4`;
/*!40000 ALTER TABLE `tabla4` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla4` ENABLE KEYS */;

-- Volcando estructura para tabla PRUEBA.tabla5
CREATE TABLE IF NOT EXISTS `tabla5` (
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla5: ~0 rows (aproximadamente)
DELETE FROM `tabla5`;
/*!40000 ALTER TABLE `tabla5` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla5` ENABLE KEYS */;

-- Volcando estructura para tabla PRUEBA.tabla6
CREATE TABLE IF NOT EXISTS `tabla6` (
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla6: ~0 rows (aproximadamente)
DELETE FROM `tabla6`;
/*!40000 ALTER TABLE `tabla6` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla6` ENABLE KEYS */;

-- Volcando estructura para tabla PRUEBA.tabla7
CREATE TABLE IF NOT EXISTS `tabla7` (
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla7: ~0 rows (aproximadamente)
DELETE FROM `tabla7`;
/*!40000 ALTER TABLE `tabla7` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla7` ENABLE KEYS */;

-- Volcando estructura para tabla PRUEBA.tabla8
CREATE TABLE IF NOT EXISTS `tabla8` (
  `campo1` varchar(25) DEFAULT NULL,
  `campo2` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla PRUEBA.tabla8: ~0 rows (aproximadamente)
DELETE FROM `tabla8`;
/*!40000 ALTER TABLE `tabla8` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla8` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
