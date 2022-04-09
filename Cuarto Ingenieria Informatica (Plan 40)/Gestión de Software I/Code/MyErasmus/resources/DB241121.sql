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


-- Volcando estructura de base de datos para directus
CREATE DATABASE IF NOT EXISTS `directus` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `directus`;

-- Volcando estructura para tabla directus.accommodation
CREATE TABLE IF NOT EXISTS `accommodation` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.accommodation: ~0 rows (aproximadamente)
DELETE FROM `accommodation`;
/*!40000 ALTER TABLE `accommodation` DISABLE KEYS */;
/*!40000 ALTER TABLE `accommodation` ENABLE KEYS */;

-- Volcando estructura para tabla directus.alumn
CREATE TABLE IF NOT EXISTS `alumn` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `passport` varchar(255) NOT NULL,
  `alumn_id` int unsigned DEFAULT NULL,
  `mobility_start` date DEFAULT NULL,
  `mobility_finish` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alumn_alumn_id_foreign` (`alumn_id`),
  CONSTRAINT `alumn_alumn_id_foreign` FOREIGN KEY (`alumn_id`) REFERENCES `user` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.alumn: ~2 rows (aproximadamente)
DELETE FROM `alumn`;
/*!40000 ALTER TABLE `alumn` DISABLE KEYS */;
INSERT INTO `alumn` (`id`, `passport`, `alumn_id`, `mobility_start`, `mobility_finish`) VALUES
	(5, '123456789', 1, '2021-01-04', '2021-05-31');
/*!40000 ALTER TABLE `alumn` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_activity
CREATE TABLE IF NOT EXISTS `directus_activity` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `action` varchar(45) NOT NULL,
  `user` char(36) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ip` varchar(50) NOT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  `collection` varchar(64) NOT NULL,
  `item` varchar(255) NOT NULL,
  `comment` text,
  PRIMARY KEY (`id`),
  KEY `directus_activity_collection_foreign` (`collection`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_activity: ~45 rows (aproximadamente)
DELETE FROM `directus_activity`;
/*!40000 ALTER TABLE `directus_activity` DISABLE KEYS */;
INSERT INTO `directus_activity` (`id`, `action`, `user`, `timestamp`, `ip`, `user_agent`, `collection`, `item`, `comment`) VALUES
	(1, 'login', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:28', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_users', '43e8cc75-49ad-409a-930a-15234abee921', NULL),
	(2, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:40', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'prueba', NULL),
	(3, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:40', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '1', NULL),
	(4, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:57', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '2', NULL),
	(5, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:34:05', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '3', NULL),
	(8, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:44:31', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'user', NULL),
	(9, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:44:31', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '4', NULL),
	(10, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:45:24', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '5', NULL),
	(11, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:46:07', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '6', NULL),
	(12, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:46:37', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '7', NULL),
	(13, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:46:57', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '1', NULL),
	(14, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 09:55:52', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'events', NULL),
	(15, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 09:55:52', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '8', NULL),
	(16, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 09:56:32', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '9', NULL),
	(17, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 09:59:06', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '10', NULL),
	(18, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:05:19', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '11', NULL),
	(19, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:00', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '12', NULL),
	(20, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:03', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '8', NULL),
	(21, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:03', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '11', NULL),
	(22, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:03', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '9', NULL),
	(23, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:03', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '10', NULL),
	(24, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:03', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '12', NULL),
	(25, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:06', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '8', NULL),
	(26, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:06', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '11', NULL),
	(27, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:06', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '12', NULL),
	(28, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:06', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '9', NULL),
	(29, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:06', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '10', NULL),
	(30, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:07:30', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '10', NULL),
	(31, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:08:43', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '13', NULL),
	(32, 'login', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-22 20:58:51', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_users', '43e8cc75-49ad-409a-930a-15234abee921', NULL),
	(33, 'login', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:35:14', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_users', '43e8cc75-49ad-409a-930a-15234abee921', NULL),
	(34, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:38:27', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'alumn', NULL),
	(35, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:38:27', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '14', NULL),
	(36, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:39:22', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '15', NULL),
	(37, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:42:00', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '16', NULL),
	(38, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:42:33', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '1', NULL),
	(39, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:44:33', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '1', NULL),
	(40, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:45:08', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '16', NULL),
	(41, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:45:49', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '2', NULL),
	(42, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:46:12', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '1', NULL),
	(43, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:46:18', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '2', NULL),
	(44, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:46:43', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '3', NULL),
	(45, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 09:46:48', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '3', NULL),
	(46, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:21:14', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '17', NULL),
	(47, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:22:05', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '18', NULL),
	(48, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:22:40', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '1', NULL),
	(49, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:23:21', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '2', NULL),
	(50, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:24:56', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '18', NULL),
	(51, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:25:01', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '17', NULL),
	(52, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:36:30', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '1', NULL),
	(53, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:36:30', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '2', NULL),
	(54, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:36:52', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '19', NULL),
	(55, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:40:16', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '20', NULL),
	(56, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:41:12', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '4', NULL),
	(57, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:41:25', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '4', NULL),
	(58, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:47:44', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'prueba', NULL),
	(59, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:04', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '21', NULL),
	(60, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:04', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'user_alumn', NULL),
	(61, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:04', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '22', NULL),
	(62, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:04', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '23', NULL),
	(63, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:04', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '24', NULL),
	(64, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:25', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '5', NULL),
	(65, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:46', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '6', NULL),
	(67, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:50:46', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '1', NULL),
	(68, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:52:17', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '6', NULL),
	(71, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:52:39', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '1', NULL),
	(72, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:53:25', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_permissions', '1', NULL),
	(73, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:53:27', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_permissions', '2', NULL),
	(74, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:53:29', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_permissions', '3', NULL),
	(75, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:53:31', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_permissions', '4', NULL),
	(76, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:54:13', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '7', NULL),
	(78, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:54:36', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '2', NULL),
	(79, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:57:04', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'accommodation', NULL),
	(80, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:57:04', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '25', NULL),
	(81, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:57:17', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '26', NULL),
	(82, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:57:38', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '27', NULL),
	(83, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 18:57:48', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '26', NULL),
	(84, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 20:00:14', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'landlord', NULL),
	(85, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 20:00:14', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '28', NULL),
	(86, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 20:00:31', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '29', NULL),
	(87, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:35:53', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'user_alumn', NULL),
	(88, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:36:17', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '30', NULL),
	(89, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:37:01', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '5', NULL),
	(90, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:37:08', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '7', NULL),
	(91, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:42:11', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '31', NULL),
	(92, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:42:23', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '1', NULL),
	(93, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:42:28', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '2', NULL),
	(94, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:46:27', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '32', NULL),
	(95, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:46:50', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'landlord', '1', NULL),
	(96, 'delete', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:47:00', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '7', NULL),
	(97, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:47:22', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'user', '2', NULL),
	(98, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:50:06', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '33', NULL),
	(99, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:51:01', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '34', NULL),
	(100, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:51:26', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '5', NULL),
	(101, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:52:53', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '5', NULL),
	(102, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:54:07', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '35', NULL),
	(103, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:54:20', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '5', NULL),
	(104, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:56:01', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '5', NULL),
	(105, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:58:24', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '36', NULL),
	(106, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:58:44', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '37', NULL),
	(107, 'update', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:59:21', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'alumn', '5', NULL),
	(108, 'login', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-24 21:59:56', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_users', '43e8cc75-49ad-409a-930a-15234abee921', NULL);
/*!40000 ALTER TABLE `directus_activity` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_collections
CREATE TABLE IF NOT EXISTS `directus_collections` (
  `collection` varchar(64) NOT NULL,
  `icon` varchar(30) DEFAULT NULL,
  `note` text,
  `display_template` varchar(255) DEFAULT NULL,
  `hidden` tinyint(1) NOT NULL DEFAULT '0',
  `singleton` tinyint(1) NOT NULL DEFAULT '0',
  `translations` json DEFAULT NULL,
  `archive_field` varchar(64) DEFAULT NULL,
  `archive_app_filter` tinyint(1) NOT NULL DEFAULT '1',
  `archive_value` varchar(255) DEFAULT NULL,
  `unarchive_value` varchar(255) DEFAULT NULL,
  `sort_field` varchar(64) DEFAULT NULL,
  `accountability` varchar(255) DEFAULT 'all',
  `color` varchar(255) DEFAULT NULL,
  `item_duplication_fields` json DEFAULT NULL,
  PRIMARY KEY (`collection`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_collections: ~3 rows (aproximadamente)
DELETE FROM `directus_collections`;
/*!40000 ALTER TABLE `directus_collections` DISABLE KEYS */;
INSERT INTO `directus_collections` (`collection`, `icon`, `note`, `display_template`, `hidden`, `singleton`, `translations`, `archive_field`, `archive_app_filter`, `archive_value`, `unarchive_value`, `sort_field`, `accountability`, `color`, `item_duplication_fields`) VALUES
	('accommodation', NULL, NULL, NULL, 0, 0, NULL, NULL, 1, NULL, NULL, NULL, 'all', NULL, NULL),
	('alumn', NULL, NULL, NULL, 0, 0, NULL, NULL, 1, NULL, NULL, NULL, 'all', NULL, NULL),
	('events', NULL, NULL, NULL, 0, 0, NULL, NULL, 1, NULL, NULL, NULL, 'all', NULL, NULL),
	('landlord', NULL, NULL, NULL, 0, 0, NULL, NULL, 1, NULL, NULL, NULL, 'all', NULL, NULL),
	('user', NULL, NULL, NULL, 0, 0, NULL, NULL, 1, NULL, NULL, NULL, 'all', NULL, NULL);
/*!40000 ALTER TABLE `directus_collections` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_dashboards
CREATE TABLE IF NOT EXISTS `directus_dashboards` (
  `id` char(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `icon` varchar(30) NOT NULL DEFAULT 'dashboard',
  `note` text,
  `date_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_created` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_dashboards_user_created_foreign` (`user_created`),
  CONSTRAINT `directus_dashboards_user_created_foreign` FOREIGN KEY (`user_created`) REFERENCES `directus_users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_dashboards: ~0 rows (aproximadamente)
DELETE FROM `directus_dashboards`;
/*!40000 ALTER TABLE `directus_dashboards` DISABLE KEYS */;
/*!40000 ALTER TABLE `directus_dashboards` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_fields
CREATE TABLE IF NOT EXISTS `directus_fields` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `collection` varchar(64) NOT NULL,
  `field` varchar(64) NOT NULL,
  `special` varchar(64) DEFAULT NULL,
  `interface` varchar(64) DEFAULT NULL,
  `options` json DEFAULT NULL,
  `display` varchar(64) DEFAULT NULL,
  `display_options` json DEFAULT NULL,
  `readonly` tinyint(1) NOT NULL DEFAULT '0',
  `hidden` tinyint(1) NOT NULL DEFAULT '0',
  `sort` int unsigned DEFAULT NULL,
  `width` varchar(30) DEFAULT 'full',
  `translations` json DEFAULT NULL,
  `note` text,
  `conditions` json DEFAULT NULL,
  `required` tinyint(1) DEFAULT '0',
  `group` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_fields_collection_foreign` (`collection`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_fields: ~15 rows (aproximadamente)
DELETE FROM `directus_fields`;
/*!40000 ALTER TABLE `directus_fields` DISABLE KEYS */;
INSERT INTO `directus_fields` (`id`, `collection`, `field`, `special`, `interface`, `options`, `display`, `display_options`, `readonly`, `hidden`, `sort`, `width`, `translations`, `note`, `conditions`, `required`, `group`) VALUES
	(4, 'user', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(5, 'user', 'name', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(6, 'user', 'mail', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(7, 'user', 'password', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(8, 'events', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, 1, 'full', NULL, NULL, NULL, 0, NULL),
	(9, 'events', 'discount', NULL, 'input', NULL, 'raw', NULL, 0, 0, 4, 'full', NULL, NULL, NULL, 0, NULL),
	(10, 'events', 'eventtype', NULL, 'select-dropdown', '{"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}', 'raw', NULL, 0, 0, 5, 'full', NULL, NULL, NULL, 1, NULL),
	(11, 'events', 'name', NULL, 'input', NULL, 'raw', NULL, 0, 0, 2, 'full', NULL, NULL, NULL, 1, NULL),
	(12, 'events', 'description', NULL, 'input-rich-text-html', '{"toolbar": ["bold", "italic", "underline", "removeformat", "customLink", "bullist", "numlist", "blockquote", "h1", "h2", "h3", "customImage", "customMedia", "hr", "code", "fullscreen", "aligncenter", "alignjustify"]}', 'formatted-value', NULL, 0, 0, 3, 'full', NULL, NULL, NULL, 1, NULL),
	(13, 'events', 'location', NULL, 'map', '{"defaultView": {"zoom": 0, "pitch": 0, "center": {"lat": 0, "lng": 0}, "bearing": 0}, "geometryType": "Point", "geometryFormat": "wkt"}', 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(14, 'alumn', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(17, 'user', 'city', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(19, 'alumn', 'passport', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(25, 'accommodation', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(26, 'accommodation', 'street', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(27, 'accommodation', 'city', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(28, 'landlord', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(29, 'landlord', 'nif', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(30, 'alumn', 'alumn_id', NULL, 'select-dropdown-m2o', NULL, NULL, NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(31, 'user', 'type', NULL, 'select-dropdown', '{"choices": [{"text": "student", "value": "student"}, {"text": "landlord", "value": "landlord"}]}', 'formatted-value', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(32, 'landlord', 'user_id', NULL, 'select-dropdown-m2o', NULL, 'related-values', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(36, 'alumn', 'mobility_start', NULL, 'datetime', NULL, 'datetime', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(37, 'alumn', 'mobility_finish', NULL, 'datetime', NULL, 'datetime', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL);
/*!40000 ALTER TABLE `directus_fields` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_files
CREATE TABLE IF NOT EXISTS `directus_files` (
  `id` char(36) NOT NULL,
  `storage` varchar(255) NOT NULL,
  `filename_disk` varchar(255) DEFAULT NULL,
  `filename_download` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `folder` char(36) DEFAULT NULL,
  `uploaded_by` char(36) DEFAULT NULL,
  `uploaded_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` char(36) DEFAULT NULL,
  `modified_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `charset` varchar(50) DEFAULT NULL,
  `filesize` bigint DEFAULT NULL,
  `width` int unsigned DEFAULT NULL,
  `height` int unsigned DEFAULT NULL,
  `duration` int unsigned DEFAULT NULL,
  `embed` varchar(200) DEFAULT NULL,
  `description` text,
  `location` text,
  `tags` text,
  `metadata` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_files_uploaded_by_foreign` (`uploaded_by`),
  KEY `directus_files_modified_by_foreign` (`modified_by`),
  KEY `directus_files_folder_foreign` (`folder`),
  CONSTRAINT `directus_files_folder_foreign` FOREIGN KEY (`folder`) REFERENCES `directus_folders` (`id`) ON DELETE SET NULL,
  CONSTRAINT `directus_files_modified_by_foreign` FOREIGN KEY (`modified_by`) REFERENCES `directus_users` (`id`),
  CONSTRAINT `directus_files_uploaded_by_foreign` FOREIGN KEY (`uploaded_by`) REFERENCES `directus_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_files: ~0 rows (aproximadamente)
DELETE FROM `directus_files`;
/*!40000 ALTER TABLE `directus_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `directus_files` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_folders
CREATE TABLE IF NOT EXISTS `directus_folders` (
  `id` char(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_folders_parent_foreign` (`parent`),
  CONSTRAINT `directus_folders_parent_foreign` FOREIGN KEY (`parent`) REFERENCES `directus_folders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_folders: ~0 rows (aproximadamente)
DELETE FROM `directus_folders`;
/*!40000 ALTER TABLE `directus_folders` DISABLE KEYS */;
/*!40000 ALTER TABLE `directus_folders` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_migrations
CREATE TABLE IF NOT EXISTS `directus_migrations` (
  `version` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_migrations: ~37 rows (aproximadamente)
DELETE FROM `directus_migrations`;
/*!40000 ALTER TABLE `directus_migrations` DISABLE KEYS */;
INSERT INTO `directus_migrations` (`version`, `name`, `timestamp`) VALUES
	('20201028A', 'Remove Collection Foreign Keys', '2021-11-19 10:32:24'),
	('20201029A', 'Remove System Relations', '2021-11-19 10:32:24'),
	('20201029B', 'Remove System Collections', '2021-11-19 10:32:24'),
	('20201029C', 'Remove System Fields', '2021-11-19 10:32:24'),
	('20201105A', 'Add Cascade System Relations', '2021-11-19 10:32:27'),
	('20201105B', 'Change Webhook URL Type', '2021-11-19 10:32:27'),
	('20210225A', 'Add Relations Sort Field', '2021-11-19 10:32:27'),
	('20210304A', 'Remove Locked Fields', '2021-11-19 10:32:27'),
	('20210312A', 'Webhooks Collections Text', '2021-11-19 10:32:27'),
	('20210331A', 'Add Refresh Interval', '2021-11-19 10:32:27'),
	('20210415A', 'Make Filesize Nullable', '2021-11-19 10:32:27'),
	('20210416A', 'Add Collections Accountability', '2021-11-19 10:32:27'),
	('20210422A', 'Remove Files Interface', '2021-11-19 10:32:27'),
	('20210506A', 'Rename Interfaces', '2021-11-19 10:32:27'),
	('20210510A', 'Restructure Relations', '2021-11-19 10:32:28'),
	('20210518A', 'Add Foreign Key Constraints', '2021-11-19 10:32:28'),
	('20210519A', 'Add System Fk Triggers', '2021-11-19 10:32:29'),
	('20210521A', 'Add Collections Icon Color', '2021-11-19 10:32:29'),
	('20210525A', 'Add Insights', '2021-11-19 10:32:30'),
	('20210608A', 'Add Deep Clone Config', '2021-11-19 10:32:30'),
	('20210626A', 'Change Filesize Bigint', '2021-11-19 10:32:30'),
	('20210716A', 'Add Conditions to Fields', '2021-11-19 10:32:30'),
	('20210721A', 'Add Default Folder', '2021-11-19 10:32:30'),
	('20210802A', 'Replace Groups', '2021-11-19 10:32:30'),
	('20210803A', 'Add Required to Fields', '2021-11-19 10:32:30'),
	('20210805A', 'Update Groups', '2021-11-19 10:32:30'),
	('20210805B', 'Change Image Metadata Structure', '2021-11-19 10:32:30'),
	('20210811A', 'Add Geometry Config', '2021-11-19 10:32:30'),
	('20210831A', 'Remove Limit Column', '2021-11-19 10:32:31'),
	('20210903A', 'Add Auth Provider', '2021-11-19 10:32:31'),
	('20210907A', 'Webhooks Collections Not Null', '2021-11-19 10:32:31'),
	('20210910A', 'Move Module Setup', '2021-11-19 10:32:31'),
	('20210920A', 'Webhooks URL Not Null', '2021-11-19 10:32:31'),
	('20210927A', 'Replace Fields Group', '2021-11-19 10:32:31'),
	('20210927B', 'Replace M2M Interface', '2021-11-19 10:32:31'),
	('20210929A', 'Rename Login Action', '2021-11-19 10:32:31'),
	('20211007A', 'Update Presets', '2021-11-19 10:32:32');
/*!40000 ALTER TABLE `directus_migrations` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_panels
CREATE TABLE IF NOT EXISTS `directus_panels` (
  `id` char(36) NOT NULL,
  `dashboard` char(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `icon` varchar(30) DEFAULT 'insert_chart',
  `color` varchar(10) DEFAULT NULL,
  `show_header` tinyint(1) NOT NULL DEFAULT '0',
  `note` text,
  `type` varchar(255) NOT NULL,
  `position_x` int NOT NULL,
  `position_y` int NOT NULL,
  `width` int NOT NULL,
  `height` int NOT NULL,
  `options` json DEFAULT NULL,
  `date_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_created` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_panels_dashboard_foreign` (`dashboard`),
  KEY `directus_panels_user_created_foreign` (`user_created`),
  CONSTRAINT `directus_panels_dashboard_foreign` FOREIGN KEY (`dashboard`) REFERENCES `directus_dashboards` (`id`) ON DELETE CASCADE,
  CONSTRAINT `directus_panels_user_created_foreign` FOREIGN KEY (`user_created`) REFERENCES `directus_users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_panels: ~0 rows (aproximadamente)
DELETE FROM `directus_panels`;
/*!40000 ALTER TABLE `directus_panels` DISABLE KEYS */;
/*!40000 ALTER TABLE `directus_panels` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_permissions
CREATE TABLE IF NOT EXISTS `directus_permissions` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `role` char(36) DEFAULT NULL,
  `collection` varchar(64) NOT NULL,
  `action` varchar(10) NOT NULL,
  `permissions` json DEFAULT NULL,
  `validation` json DEFAULT NULL,
  `presets` json DEFAULT NULL,
  `fields` text,
  PRIMARY KEY (`id`),
  KEY `directus_permissions_collection_foreign` (`collection`),
  KEY `directus_permissions_role_foreign` (`role`),
  CONSTRAINT `directus_permissions_role_foreign` FOREIGN KEY (`role`) REFERENCES `directus_roles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_permissions: ~0 rows (aproximadamente)
DELETE FROM `directus_permissions`;
/*!40000 ALTER TABLE `directus_permissions` DISABLE KEYS */;
INSERT INTO `directus_permissions` (`id`, `role`, `collection`, `action`, `permissions`, `validation`, `presets`, `fields`) VALUES
	(2, NULL, 'user', 'read', '{}', '{}', NULL, '*'),
	(3, NULL, 'events', 'read', '{}', '{}', NULL, '*'),
	(4, NULL, 'alumn', 'read', '{}', '{}', NULL, '*');
/*!40000 ALTER TABLE `directus_permissions` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_presets
CREATE TABLE IF NOT EXISTS `directus_presets` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `bookmark` varchar(255) DEFAULT NULL,
  `user` char(36) DEFAULT NULL,
  `role` char(36) DEFAULT NULL,
  `collection` varchar(64) DEFAULT NULL,
  `search` varchar(100) DEFAULT NULL,
  `layout` varchar(100) DEFAULT 'tabular',
  `layout_query` json DEFAULT NULL,
  `layout_options` json DEFAULT NULL,
  `refresh_interval` int DEFAULT NULL,
  `filter` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_presets_collection_foreign` (`collection`),
  KEY `directus_presets_user_foreign` (`user`),
  KEY `directus_presets_role_foreign` (`role`),
  CONSTRAINT `directus_presets_role_foreign` FOREIGN KEY (`role`) REFERENCES `directus_roles` (`id`) ON DELETE CASCADE,
  CONSTRAINT `directus_presets_user_foreign` FOREIGN KEY (`user`) REFERENCES `directus_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_presets: ~3 rows (aproximadamente)
DELETE FROM `directus_presets`;
/*!40000 ALTER TABLE `directus_presets` DISABLE KEYS */;
INSERT INTO `directus_presets` (`id`, `bookmark`, `user`, `role`, `collection`, `search`, `layout`, `layout_query`, `layout_options`, `refresh_interval`, `filter`) VALUES
	(2, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'user', NULL, 'cards', '{"cards": {"page": 1}, "tabular": {"page": 1, "fields": ["name", "mail", "type", "city"]}}', '{"cards": {"title": "{{name}}", "subtitle": "{{mail}}{{type}}"}}', 60, NULL),
	(3, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'events', NULL, 'tabular', '{"tabular": {"page": 1}}', NULL, NULL, NULL),
	(4, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'alumn', NULL, 'tabular', '{"tabular": {"page": 1, "fields": ["alumn_id", "passport", "mobility_start", "mobility_finish"]}}', '{"tabular": {"widths": {"test": 128.14813232421875}}}', 10, NULL),
	(5, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'directus_users', NULL, 'cards', '{"cards": {"page": 1, "sort": ["email"]}}', '{"cards": {"icon": "account_circle", "size": 4, "title": "{{ first_name }} {{ last_name }}", "subtitle": "{{ email }}"}}', NULL, NULL),
	(6, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'landlord', NULL, 'tabular', '{"tabular": {"page": 1}}', NULL, NULL, NULL);
/*!40000 ALTER TABLE `directus_presets` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_relations
CREATE TABLE IF NOT EXISTS `directus_relations` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `many_collection` varchar(64) NOT NULL,
  `many_field` varchar(64) NOT NULL,
  `one_collection` varchar(64) DEFAULT NULL,
  `one_field` varchar(64) DEFAULT NULL,
  `one_collection_field` varchar(64) DEFAULT NULL,
  `one_allowed_collections` text,
  `junction_field` varchar(64) DEFAULT NULL,
  `sort_field` varchar(64) DEFAULT NULL,
  `one_deselect_action` varchar(255) NOT NULL DEFAULT 'nullify',
  PRIMARY KEY (`id`),
  KEY `directus_relations_many_collection_foreign` (`many_collection`),
  KEY `directus_relations_one_collection_foreign` (`one_collection`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_relations: ~1 rows (aproximadamente)
DELETE FROM `directus_relations`;
/*!40000 ALTER TABLE `directus_relations` DISABLE KEYS */;
INSERT INTO `directus_relations` (`id`, `many_collection`, `many_field`, `one_collection`, `one_field`, `one_collection_field`, `one_allowed_collections`, `junction_field`, `sort_field`, `one_deselect_action`) VALUES
	(5, 'alumn', 'alumn_id', 'user', NULL, NULL, NULL, NULL, NULL, 'nullify'),
	(6, 'landlord', 'user_id', 'user', NULL, NULL, NULL, NULL, NULL, 'nullify');
/*!40000 ALTER TABLE `directus_relations` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_revisions
CREATE TABLE IF NOT EXISTS `directus_revisions` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `activity` int unsigned NOT NULL,
  `collection` varchar(64) NOT NULL,
  `item` varchar(255) NOT NULL,
  `data` json DEFAULT NULL,
  `delta` json DEFAULT NULL,
  `parent` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_revisions_collection_foreign` (`collection`),
  KEY `directus_revisions_parent_foreign` (`parent`),
  KEY `directus_revisions_activity_foreign` (`activity`),
  CONSTRAINT `directus_revisions_activity_foreign` FOREIGN KEY (`activity`) REFERENCES `directus_activity` (`id`) ON DELETE CASCADE,
  CONSTRAINT `directus_revisions_parent_foreign` FOREIGN KEY (`parent`) REFERENCES `directus_revisions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_revisions: ~41 rows (aproximadamente)
DELETE FROM `directus_revisions`;
/*!40000 ALTER TABLE `directus_revisions` DISABLE KEYS */;
INSERT INTO `directus_revisions` (`id`, `activity`, `collection`, `item`, `data`, `delta`, `parent`) VALUES
	(1, 2, 'directus_collections', 'prueba', '{"singleton": false, "collection": "prueba"}', '{"singleton": false, "collection": "prueba"}', NULL),
	(2, 3, 'directus_fields', '1', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "prueba"}', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "prueba"}', NULL),
	(3, 4, 'directus_fields', '2', '{"field": "campo1", "hidden": false, "display": null, "options": null, "special": null, "readonly": false, "interface": null, "collection": "prueba", "display_options": null}', '{"field": "campo1", "hidden": false, "display": null, "options": null, "special": null, "readonly": false, "interface": null, "collection": "prueba", "display_options": null}', NULL),
	(4, 5, 'directus_fields', '3', '{"field": "campo2", "hidden": false, "readonly": false, "collection": "prueba"}', '{"field": "campo2", "hidden": false, "readonly": false, "collection": "prueba"}', NULL),
	(7, 8, 'directus_collections', 'user', '{"singleton": false, "collection": "user"}', '{"singleton": false, "collection": "user"}', NULL),
	(8, 9, 'directus_fields', '4', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "user"}', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "user"}', NULL),
	(9, 10, 'directus_fields', '5', '{"field": "name", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "user"}', '{"field": "name", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "user"}', NULL),
	(10, 11, 'directus_fields', '6', '{"field": "mail", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "user"}', '{"field": "mail", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "user"}', NULL),
	(11, 12, 'directus_fields', '7', '{"field": "password", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "user"}', '{"field": "password", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "user"}', NULL),
	(12, 13, 'user', '1', '{"mail": "Aaron@Guapo.com", "name": "Aaron", "password": "aaron"}', '{"mail": "Aaron@Guapo.com", "name": "Aaron", "password": "aaron"}', NULL),
	(13, 14, 'directus_collections', 'events', '{"singleton": false, "collection": "events"}', '{"singleton": false, "collection": "events"}', NULL),
	(14, 15, 'directus_fields', '8', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "events"}', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "events"}', NULL),
	(15, 16, 'directus_fields', '9', '{"field": "discount", "hidden": false, "display": "raw", "readonly": false, "interface": "input", "collection": "events"}', '{"field": "discount", "hidden": false, "display": "raw", "readonly": false, "interface": "input", "collection": "events"}', NULL),
	(16, 17, 'directus_fields', '10', '{"field": "eventtype", "hidden": false, "display": "raw", "options": {"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}, "readonly": false, "required": true, "interface": "select-dropdown", "collection": "events"}', '{"field": "eventtype", "hidden": false, "display": "raw", "options": {"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}, "readonly": false, "required": true, "interface": "select-dropdown", "collection": "events"}', NULL),
	(17, 18, 'directus_fields', '11', '{"field": "name", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "events"}', '{"field": "name", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "events"}', NULL),
	(18, 19, 'directus_fields', '12', '{"field": "description", "hidden": false, "display": "formatted-value", "options": {"toolbar": ["bold", "italic", "underline", "removeformat", "customLink", "bullist", "numlist", "blockquote", "h1", "h2", "h3", "customImage", "customMedia", "hr", "code", "fullscreen", "aligncenter", "alignjustify"]}, "special": null, "readonly": false, "required": true, "interface": "input-rich-text-html", "collection": "events", "display_options": null}', '{"field": "description", "hidden": false, "display": "formatted-value", "options": {"toolbar": ["bold", "italic", "underline", "removeformat", "customLink", "bullist", "numlist", "blockquote", "h1", "h2", "h3", "customImage", "customMedia", "hr", "code", "fullscreen", "aligncenter", "alignjustify"]}, "special": null, "readonly": false, "required": true, "interface": "input-rich-text-html", "collection": "events", "display_options": null}', NULL),
	(19, 20, 'directus_fields', '8', '{"id": 8, "note": null, "sort": 1, "field": "id", "group": null, "width": "full", "hidden": true, "display": null, "options": null, "special": null, "readonly": true, "required": false, "interface": "input", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 1, "field": "id", "group": null, "collection": "events"}', NULL),
	(20, 21, 'directus_fields', '11', '{"id": 11, "note": null, "sort": 2, "field": "name", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": true, "interface": "input", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 2, "field": "name", "group": null, "collection": "events"}', NULL),
	(21, 22, 'directus_fields', '9', '{"id": 9, "note": null, "sort": 3, "field": "discount", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": false, "interface": "input", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 3, "field": "discount", "group": null, "collection": "events"}', NULL),
	(22, 23, 'directus_fields', '10', '{"id": 10, "note": null, "sort": 4, "field": "eventtype", "group": null, "width": "full", "hidden": false, "display": "raw", "options": {"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}, "special": null, "readonly": false, "required": true, "interface": "select-dropdown", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 4, "field": "eventtype", "group": null, "collection": "events"}', NULL),
	(23, 24, 'directus_fields', '12', '{"id": 12, "note": null, "sort": 5, "field": "description", "group": null, "width": "full", "hidden": false, "display": "formatted-value", "options": {"toolbar": ["bold", "italic", "underline", "removeformat", "customLink", "bullist", "numlist", "blockquote", "h1", "h2", "h3", "customImage", "customMedia", "hr", "code", "fullscreen", "aligncenter", "alignjustify"]}, "special": null, "readonly": false, "required": true, "interface": "input-rich-text-html", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 5, "field": "description", "group": null, "collection": "events"}', NULL),
	(24, 25, 'directus_fields', '8', '{"id": 8, "note": null, "sort": 1, "field": "id", "group": null, "width": "full", "hidden": true, "display": null, "options": null, "special": null, "readonly": true, "required": false, "interface": "input", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 1, "field": "id", "group": null, "collection": "events"}', NULL),
	(25, 26, 'directus_fields', '11', '{"id": 11, "note": null, "sort": 2, "field": "name", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": true, "interface": "input", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 2, "field": "name", "group": null, "collection": "events"}', NULL),
	(26, 27, 'directus_fields', '12', '{"id": 12, "note": null, "sort": 3, "field": "description", "group": null, "width": "full", "hidden": false, "display": "formatted-value", "options": {"toolbar": ["bold", "italic", "underline", "removeformat", "customLink", "bullist", "numlist", "blockquote", "h1", "h2", "h3", "customImage", "customMedia", "hr", "code", "fullscreen", "aligncenter", "alignjustify"]}, "special": null, "readonly": false, "required": true, "interface": "input-rich-text-html", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 3, "field": "description", "group": null, "collection": "events"}', NULL),
	(27, 28, 'directus_fields', '9', '{"id": 9, "note": null, "sort": 4, "field": "discount", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": false, "interface": "input", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 4, "field": "discount", "group": null, "collection": "events"}', NULL),
	(28, 29, 'directus_fields', '10', '{"id": 10, "note": null, "sort": 5, "field": "eventtype", "group": null, "width": "full", "hidden": false, "display": "raw", "options": {"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}, "special": null, "readonly": false, "required": true, "interface": "select-dropdown", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"sort": 5, "field": "eventtype", "group": null, "collection": "events"}', NULL),
	(29, 30, 'directus_fields', '10', '{"id": 10, "note": null, "sort": 5, "field": "eventtype", "group": null, "width": "full", "hidden": false, "display": "raw", "options": {"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}, "special": null, "readonly": false, "required": true, "interface": "select-dropdown", "collection": "events", "conditions": null, "translations": null, "display_options": null}', '{"note": null, "sort": 5, "field": "eventtype", "group": null, "width": "full", "hidden": false, "display": "raw", "options": {"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}, "special": null, "readonly": false, "required": true, "interface": "select-dropdown", "collection": "events", "conditions": null, "translations": null, "display_options": null}', NULL),
	(30, 31, 'directus_fields', '13', '{"field": "location", "hidden": false, "display": "raw", "options": {"defaultView": {"zoom": 0, "pitch": 0, "center": {"lat": 0, "lng": 0}, "bearing": 0}, "geometryType": "Point", "geometryFormat": "wkt"}, "readonly": false, "interface": "map", "collection": "events"}', '{"field": "location", "hidden": false, "display": "raw", "options": {"defaultView": {"zoom": 0, "pitch": 0, "center": {"lat": 0, "lng": 0}, "bearing": 0}, "geometryType": "Point", "geometryFormat": "wkt"}, "readonly": false, "interface": "map", "collection": "events"}', NULL),
	(31, 34, 'directus_collections', 'alumn', '{"singleton": false, "collection": "alumn"}', '{"singleton": false, "collection": "alumn"}', NULL),
	(32, 35, 'directus_fields', '14', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "alumn"}', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "alumn"}', NULL),
	(33, 36, 'directus_fields', '15', '{"field": "passport", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "alumn", "conditions": null}', '{"field": "passport", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "alumn", "conditions": null}', NULL),
	(34, 37, 'directus_fields', '16', '{"field": "passport", "hidden": false, "display": "related-values", "readonly": false, "interface": "select-dropdown-m2o", "collection": "alumn"}', '{"field": "passport", "hidden": false, "display": "related-values", "readonly": false, "interface": "select-dropdown-m2o", "collection": "alumn"}', NULL),
	(35, 38, 'alumn', '1', '{"passport": 1}', '{"passport": 1}', NULL),
	(36, 39, 'alumn', '1', '{"id": 1, "passport": null}', '{"passport": null}', NULL),
	(37, 40, 'directus_fields', '16', '{"id": 16, "note": null, "sort": null, "field": "passport", "group": null, "width": "full", "hidden": false, "display": "related-values", "options": null, "special": null, "readonly": false, "required": false, "interface": "select-dropdown-m2o", "collection": "alumn", "conditions": null, "translations": null, "display_options": null}', '{"note": null, "sort": null, "field": "passport", "group": null, "width": "full", "hidden": false, "display": "related-values", "options": null, "special": null, "readonly": false, "required": false, "interface": "select-dropdown-m2o", "collection": "alumn", "conditions": null, "translations": null, "display_options": null}', NULL),
	(38, 41, 'user', '2', '{"mail": "pruba@mail.com", "name": "prueba", "password": "prueba"}', '{"mail": "pruba@mail.com", "name": "prueba", "password": "prueba"}', NULL),
	(39, 42, 'alumn', '1', '{"id": 1, "passport": 1}', '{"passport": 1}', NULL),
	(40, 43, 'alumn', '2', '{"passport": 2}', '{"passport": 2}', NULL),
	(41, 44, 'alumn', '3', '{"passport": 1}', '{"passport": 1}', NULL),
	(42, 46, 'directus_fields', '17', '{"field": "city", "hidden": false, "display": "raw", "readonly": false, "interface": "input", "collection": "user"}', '{"field": "city", "hidden": false, "display": "raw", "readonly": false, "interface": "input", "collection": "user"}', NULL),
	(43, 47, 'directus_fields', '18', '{"field": "type", "hidden": false, "display": "related-values", "options": {"choices": [{"text": "student", "value": "student"}, {"text": "lessar", "value": "lessar"}]}, "readonly": false, "interface": "select-dropdown", "collection": "user"}', '{"field": "type", "hidden": false, "display": "related-values", "options": {"choices": [{"text": "student", "value": "student"}, {"text": "lessar", "value": "lessar"}]}, "readonly": false, "interface": "select-dropdown", "collection": "user"}', NULL),
	(44, 48, 'user', '1', '{"id": 1, "city": "Las Palmas de Gran Canaria", "mail": "Aaron@Guapo.com", "name": "Aaron", "type": "student", "password": "aaron"}', '{"city": "Las Palmas de Gran Canaria", "type": "student"}', NULL),
	(45, 49, 'user', '2', '{"id": 2, "city": "Barcelona", "mail": "pruba@mail.com", "name": "prueba", "type": "lessar", "password": "prueba"}', '{"city": "Barcelona", "type": "lessar"}', NULL),
	(46, 50, 'directus_fields', '18', '{"id": 18, "note": null, "sort": null, "field": "type", "group": null, "width": "full", "hidden": false, "display": "related-values", "options": {"choices": [{"text": "student", "value": "student"}, {"text": "lessar", "value": "lessar"}]}, "special": null, "readonly": false, "required": false, "interface": "select-dropdown", "collection": "user", "conditions": null, "translations": null, "display_options": null}', '{"note": null, "sort": null, "field": "type", "group": null, "width": "full", "hidden": false, "display": "related-values", "options": {"choices": [{"text": "student", "value": "student"}, {"text": "lessar", "value": "lessar"}]}, "special": null, "readonly": false, "required": false, "interface": "select-dropdown", "collection": "user", "conditions": null, "translations": null, "display_options": null}', NULL),
	(47, 51, 'directus_fields', '17', '{"id": 17, "note": null, "sort": null, "field": "city", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": false, "interface": "input", "collection": "user", "conditions": null, "translations": null, "display_options": null}', '{"note": null, "sort": null, "field": "city", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": false, "interface": "input", "collection": "user", "conditions": null, "translations": null, "display_options": null}', NULL),
	(48, 54, 'directus_fields', '19', '{"field": "passport", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "alumn"}', '{"field": "passport", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "alumn"}', NULL),
	(49, 55, 'directus_fields', '20', '{"field": "type", "hidden": false, "display": "related-values", "readonly": false, "interface": "select-dropdown-m2o", "collection": "alumn"}', '{"field": "type", "hidden": false, "display": "related-values", "readonly": false, "interface": "select-dropdown-m2o", "collection": "alumn"}', NULL),
	(50, 56, 'alumn', '4', '{"type": 1, "passport": "123456789"}', '{"type": 1, "passport": "123456789"}', NULL),
	(51, 59, 'directus_fields', '21', '{"field": "type", "hidden": false, "special": "m2m", "readonly": false, "interface": "list-m2m", "collection": "user"}', '{"field": "type", "hidden": false, "special": "m2m", "readonly": false, "interface": "list-m2m", "collection": "user"}', NULL),
	(52, 60, 'directus_collections', 'user_alumn', '{"icon": "import_export", "hidden": true, "collection": "user_alumn"}', '{"icon": "import_export", "hidden": true, "collection": "user_alumn"}', NULL),
	(53, 61, 'directus_fields', '22', '{"field": "id", "hidden": true, "collection": "user_alumn"}', '{"field": "id", "hidden": true, "collection": "user_alumn"}', NULL),
	(54, 62, 'directus_fields', '23', '{"field": "user_id", "hidden": true, "collection": "user_alumn"}', '{"field": "user_id", "hidden": true, "collection": "user_alumn"}', NULL),
	(55, 63, 'directus_fields', '24', '{"field": "alumn_id", "hidden": true, "collection": "user_alumn"}', '{"field": "alumn_id", "hidden": true, "collection": "user_alumn"}', NULL),
	(56, 64, 'alumn', '5', '{"passport": "123456789"}', '{"passport": "123456789"}', NULL),
	(57, 65, 'alumn', '6', '{"passport": "1234567899"}', '{"passport": "1234567899"}', NULL),
	(59, 67, 'user', '1', '{"id": 1, "city": "Las Palmas de Gran Canaria", "mail": "Aaron@Guapo.com", "name": "Aaron", "type": [1], "password": "aaron"}', '{}', NULL),
	(62, 71, 'user', '1', '{"id": 1, "city": "Las Palmas de Gran Canaria", "mail": "Aaron@Guapo.com", "name": "Aaron", "type": [2], "password": "aaron"}', '{}', NULL),
	(63, 72, 'directus_permissions', '1', '{"role": null, "action": "read", "fields": ["*"], "collection": "user_alumn", "validation": {}, "permissions": {}}', '{"role": null, "action": "read", "fields": ["*"], "collection": "user_alumn", "validation": {}, "permissions": {}}', NULL),
	(64, 73, 'directus_permissions', '2', '{"role": null, "action": "read", "fields": ["*"], "collection": "user", "validation": {}, "permissions": {}}', '{"role": null, "action": "read", "fields": ["*"], "collection": "user", "validation": {}, "permissions": {}}', NULL),
	(65, 74, 'directus_permissions', '3', '{"role": null, "action": "read", "fields": ["*"], "collection": "events", "validation": {}, "permissions": {}}', '{"role": null, "action": "read", "fields": ["*"], "collection": "events", "validation": {}, "permissions": {}}', NULL),
	(66, 75, 'directus_permissions', '4', '{"role": null, "action": "read", "fields": ["*"], "collection": "alumn", "validation": {}, "permissions": {}}', '{"role": null, "action": "read", "fields": ["*"], "collection": "alumn", "validation": {}, "permissions": {}}', NULL),
	(67, 76, 'alumn', '7', '{"passport": "987654321"}', '{"passport": "987654321"}', NULL),
	(69, 78, 'user', '2', '{"id": 2, "city": "Barcelona", "mail": "pruba@mail.com", "name": "prueba", "type": [3], "password": "prueba"}', '{}', NULL),
	(70, 79, 'directus_collections', 'accommodation', '{"singleton": false, "collection": "accommodation"}', '{"singleton": false, "collection": "accommodation"}', NULL),
	(71, 80, 'directus_fields', '25', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "accommodation"}', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "accommodation"}', NULL),
	(72, 81, 'directus_fields', '26', '{"field": "street", "hidden": false, "display": "raw", "readonly": false, "interface": "input", "collection": "accommodation"}', '{"field": "street", "hidden": false, "display": "raw", "readonly": false, "interface": "input", "collection": "accommodation"}', NULL),
	(73, 82, 'directus_fields', '27', '{"field": "city", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "accommodation"}', '{"field": "city", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "accommodation"}', NULL),
	(74, 83, 'directus_fields', '26', '{"id": 26, "note": null, "sort": null, "field": "street", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": true, "interface": "input", "collection": "accommodation", "conditions": null, "translations": null, "display_options": null}', '{"note": null, "sort": null, "field": "street", "group": null, "width": "full", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "required": true, "interface": "input", "collection": "accommodation", "conditions": null, "translations": null, "display_options": null}', NULL),
	(75, 84, 'directus_collections', 'landlord', '{"singleton": false, "collection": "landlord"}', '{"singleton": false, "collection": "landlord"}', NULL),
	(76, 85, 'directus_fields', '28', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "landlord"}', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "landlord"}', NULL),
	(77, 86, 'directus_fields', '29', '{"field": "nif", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "landlord"}', '{"field": "nif", "hidden": false, "display": "raw", "readonly": false, "required": true, "interface": "input", "collection": "landlord"}', NULL),
	(78, 88, 'directus_fields', '30', '{"field": "alumn_id", "hidden": false, "readonly": false, "interface": "select-dropdown-m2o", "collection": "alumn"}', '{"field": "alumn_id", "hidden": false, "readonly": false, "interface": "select-dropdown-m2o", "collection": "alumn"}', NULL),
	(79, 89, 'alumn', '5', '{"id": 5, "alumn_id": 1, "passport": "123456789"}', '{"alumn_id": 1}', NULL),
	(80, 90, 'alumn', '7', '{"id": 7, "alumn_id": 2, "passport": "987654321"}', '{"alumn_id": 2}', NULL),
	(81, 91, 'directus_fields', '31', '{"field": "type", "hidden": false, "display": "formatted-value", "options": {"choices": [{"text": "student", "value": "student"}, {"text": "landlord", "value": "landlord"}]}, "readonly": false, "interface": "select-dropdown", "collection": "user"}', '{"field": "type", "hidden": false, "display": "formatted-value", "options": {"choices": [{"text": "student", "value": "student"}, {"text": "landlord", "value": "landlord"}]}, "readonly": false, "interface": "select-dropdown", "collection": "user"}', NULL),
	(82, 92, 'user', '1', '{"id": 1, "city": "Las Palmas de Gran Canaria", "mail": "Aaron@Guapo.com", "name": "Aaron", "type": "student", "password": "aaron"}', '{"type": "student"}', NULL),
	(83, 93, 'user', '2', '{"id": 2, "city": "Barcelona", "mail": "pruba@mail.com", "name": "prueba", "type": "landlord", "password": "prueba"}', '{"type": "landlord"}', NULL),
	(84, 94, 'directus_fields', '32', '{"field": "user_id", "hidden": false, "display": "related-values", "readonly": false, "interface": "select-dropdown-m2o", "collection": "landlord"}', '{"field": "user_id", "hidden": false, "display": "related-values", "readonly": false, "interface": "select-dropdown-m2o", "collection": "landlord"}', NULL),
	(85, 95, 'landlord', '1', '{"nif": "45776078E", "user_id": 2}', '{"nif": "45776078E", "user_id": 2}', NULL),
	(86, 97, 'user', '2', '{"id": 2, "city": "Barcelona", "mail": "manololandlord@mail.com", "name": "manolo", "type": "landlord", "password": "manolo"}', '{"mail": "manololandlord@mail.com", "name": "manolo", "password": "manolo"}', NULL),
	(87, 98, 'directus_fields', '33', '{"field": "mobility", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "interface": "input", "collection": "alumn", "display_options": null}', '{"field": "mobility", "hidden": false, "display": "raw", "options": null, "special": null, "readonly": false, "interface": "input", "collection": "alumn", "display_options": null}', NULL),
	(88, 99, 'directus_fields', '34', '{"field": "test", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', '{"field": "test", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', NULL),
	(89, 100, 'alumn', '5', '{"id": 5, "test": "2021-11-24T21:51:00", "alumn_id": 1, "mobility": null, "passport": "123456789"}', '{"test": "2021-11-24T21:51:00"}', NULL),
	(90, 101, 'alumn', '5', '{"id": 5, "test": null, "alumn_id": 1, "mobility": null, "passport": "123456789"}', '{"test": null}', NULL),
	(91, 102, 'directus_fields', '35', '{"field": "test2", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', '{"field": "test2", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', NULL),
	(92, 103, 'alumn', '5', '{"id": 5, "test": null, "test2": "2021-11-24", "alumn_id": 1, "mobility": null, "passport": "123456789"}', '{"test2": "2021-11-24"}', NULL),
	(93, 104, 'alumn', '5', '{"id": 5, "test": null, "test2": "2021-11-24", "alumn_id": 1, "mobility": "bdrbbd", "passport": "123456789"}', '{"mobility": "bdrbbd"}', NULL),
	(94, 105, 'directus_fields', '36', '{"field": "mobility_start", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', '{"field": "mobility_start", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', NULL),
	(95, 106, 'directus_fields', '37', '{"field": "mobility_finish", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', '{"field": "mobility_finish", "hidden": false, "display": "datetime", "options": null, "special": null, "readonly": false, "interface": "datetime", "collection": "alumn", "display_options": null}', NULL),
	(96, 107, 'alumn', '5', '{"id": 5, "alumn_id": 1, "passport": "123456789", "mobility_start": "2021-01-04", "mobility_finish": "2021-05-31"}', '{"mobility_start": "2021-01-04", "mobility_finish": "2021-05-31"}', NULL);
/*!40000 ALTER TABLE `directus_revisions` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_roles
CREATE TABLE IF NOT EXISTS `directus_roles` (
  `id` char(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `icon` varchar(30) NOT NULL DEFAULT 'supervised_user_circle',
  `description` text,
  `ip_access` text,
  `enforce_tfa` tinyint(1) NOT NULL DEFAULT '0',
  `collection_list` json DEFAULT NULL,
  `admin_access` tinyint(1) NOT NULL DEFAULT '0',
  `app_access` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_roles: ~0 rows (aproximadamente)
DELETE FROM `directus_roles`;
/*!40000 ALTER TABLE `directus_roles` DISABLE KEYS */;
INSERT INTO `directus_roles` (`id`, `name`, `icon`, `description`, `ip_access`, `enforce_tfa`, `collection_list`, `admin_access`, `app_access`) VALUES
	('734382b9-fb3e-4021-b87f-b8ae086f40c5', 'Admin', 'supervised_user_circle', NULL, NULL, 0, NULL, 1, 1);
/*!40000 ALTER TABLE `directus_roles` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_sessions
CREATE TABLE IF NOT EXISTS `directus_sessions` (
  `token` varchar(64) NOT NULL,
  `user` char(36) NOT NULL,
  `expires` timestamp NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  `data` json DEFAULT NULL,
  PRIMARY KEY (`token`),
  KEY `directus_sessions_user_foreign` (`user`),
  CONSTRAINT `directus_sessions_user_foreign` FOREIGN KEY (`user`) REFERENCES `directus_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_sessions: ~3 rows (aproximadamente)
DELETE FROM `directus_sessions`;
/*!40000 ALTER TABLE `directus_sessions` DISABLE KEYS */;
INSERT INTO `directus_sessions` (`token`, `user`, `expires`, `ip`, `user_agent`, `data`) VALUES
	('8qQYG4OYIVQgrVEKqIfLR5zfL09-porJe0jcxDf1AlbRL1RJTStUbE7goiDrV-sT', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-29 21:04:45', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', NULL),
	('ml1aT02vxkqCCWeSo2ZIcXVYkmBdh8HurLzm4U5z_kqLDceND3uc6omV94e8Z3gg', '43e8cc75-49ad-409a-930a-15234abee921', '2021-12-01 21:59:55', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', NULL),
	('rSFBsxoz25Sr61HUERtFhxYN9xrn_wU80g_PqS-Xq1pJ4S_U0y-hi9RwqOAsPa9T', '43e8cc75-49ad-409a-930a-15234abee921', '2021-12-01 22:01:38', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', NULL),
	('XbykfuDiSZqlz06Hgk5d7UkSHg7nN0j_lc5M8ehZUyphqE9TFsi6gVrdmblHAlDQ', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-28 10:14:54', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', NULL);
/*!40000 ALTER TABLE `directus_sessions` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_settings
CREATE TABLE IF NOT EXISTS `directus_settings` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL DEFAULT 'Directus',
  `project_url` varchar(255) DEFAULT NULL,
  `project_color` varchar(10) DEFAULT '#00C897',
  `project_logo` char(36) DEFAULT NULL,
  `public_foreground` char(36) DEFAULT NULL,
  `public_background` char(36) DEFAULT NULL,
  `public_note` text,
  `auth_login_attempts` int unsigned DEFAULT '25',
  `auth_password_policy` varchar(100) DEFAULT NULL,
  `storage_asset_transform` varchar(7) DEFAULT 'all',
  `storage_asset_presets` json DEFAULT NULL,
  `custom_css` text,
  `storage_default_folder` char(36) DEFAULT NULL,
  `basemaps` json DEFAULT NULL,
  `mapbox_key` varchar(255) DEFAULT NULL,
  `module_bar` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `directus_settings_project_logo_foreign` (`project_logo`),
  KEY `directus_settings_public_foreground_foreign` (`public_foreground`),
  KEY `directus_settings_public_background_foreign` (`public_background`),
  KEY `directus_settings_storage_default_folder_foreign` (`storage_default_folder`),
  CONSTRAINT `directus_settings_project_logo_foreign` FOREIGN KEY (`project_logo`) REFERENCES `directus_files` (`id`),
  CONSTRAINT `directus_settings_public_background_foreign` FOREIGN KEY (`public_background`) REFERENCES `directus_files` (`id`),
  CONSTRAINT `directus_settings_public_foreground_foreign` FOREIGN KEY (`public_foreground`) REFERENCES `directus_files` (`id`),
  CONSTRAINT `directus_settings_storage_default_folder_foreign` FOREIGN KEY (`storage_default_folder`) REFERENCES `directus_folders` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_settings: ~0 rows (aproximadamente)
DELETE FROM `directus_settings`;
/*!40000 ALTER TABLE `directus_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `directus_settings` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_users
CREATE TABLE IF NOT EXISTS `directus_users` (
  `id` char(36) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `description` text,
  `tags` json DEFAULT NULL,
  `avatar` char(36) DEFAULT NULL,
  `language` varchar(8) DEFAULT 'en-US',
  `theme` varchar(20) DEFAULT 'auto',
  `tfa_secret` varchar(255) DEFAULT NULL,
  `status` varchar(16) NOT NULL DEFAULT 'active',
  `role` char(36) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `last_access` timestamp NULL DEFAULT NULL,
  `last_page` varchar(255) DEFAULT NULL,
  `provider` varchar(128) NOT NULL DEFAULT 'default',
  `external_identifier` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `directus_users_external_identifier_unique` (`external_identifier`),
  UNIQUE KEY `directus_users_email_unique` (`email`),
  KEY `directus_users_role_foreign` (`role`),
  CONSTRAINT `directus_users_role_foreign` FOREIGN KEY (`role`) REFERENCES `directus_roles` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_users: ~0 rows (aproximadamente)
DELETE FROM `directus_users`;
/*!40000 ALTER TABLE `directus_users` DISABLE KEYS */;
INSERT INTO `directus_users` (`id`, `first_name`, `last_name`, `email`, `password`, `location`, `title`, `description`, `tags`, `avatar`, `language`, `theme`, `tfa_secret`, `status`, `role`, `token`, `last_access`, `last_page`, `provider`, `external_identifier`) VALUES
	('43e8cc75-49ad-409a-930a-15234abee921', NULL, NULL, 'admin@example.com', '$argon2i$v=19$m=4096,t=3,p=1$z8l2+iUgMH2sFs8HkLWTsQ$rccg8oI1707hEIgG0hvV7I/mgZKnJwnJfEuoTh05Has', NULL, NULL, NULL, NULL, NULL, 'en-US', 'auto', NULL, 'active', '734382b9-fb3e-4021-b87f-b8ae086f40c5', NULL, '2021-11-24 22:01:38', '/collections/alumn', 'default', NULL);
/*!40000 ALTER TABLE `directus_users` ENABLE KEYS */;

-- Volcando estructura para tabla directus.directus_webhooks
CREATE TABLE IF NOT EXISTS `directus_webhooks` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `method` varchar(10) NOT NULL DEFAULT 'POST',
  `url` text NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'active',
  `data` tinyint(1) NOT NULL DEFAULT '1',
  `actions` varchar(100) NOT NULL,
  `collections` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_webhooks: ~0 rows (aproximadamente)
DELETE FROM `directus_webhooks`;
/*!40000 ALTER TABLE `directus_webhooks` DISABLE KEYS */;
/*!40000 ALTER TABLE `directus_webhooks` ENABLE KEYS */;

-- Volcando estructura para tabla directus.events
CREATE TABLE IF NOT EXISTS `events` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `discount` varchar(255) DEFAULT NULL,
  `eventtype` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.events: ~0 rows (aproximadamente)
DELETE FROM `events`;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
/*!40000 ALTER TABLE `events` ENABLE KEYS */;

-- Volcando estructura para tabla directus.landlord
CREATE TABLE IF NOT EXISTS `landlord` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nif` varchar(255) NOT NULL,
  `user_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `landlord_user_id_foreign` (`user_id`),
  CONSTRAINT `landlord_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.landlord: ~1 rows (aproximadamente)
DELETE FROM `landlord`;
/*!40000 ALTER TABLE `landlord` DISABLE KEYS */;
INSERT INTO `landlord` (`id`, `nif`, `user_id`) VALUES
	(1, '45776078E', 2);
/*!40000 ALTER TABLE `landlord` ENABLE KEYS */;

-- Volcando estructura para tabla directus.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.user: ~1 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `mail`, `password`, `city`, `type`) VALUES
	(1, 'Aaron', 'Aaron@Guapo.com', 'aaron', 'Las Palmas de Gran Canaria', 'student'),
	(2, 'manolo', 'manololandlord@mail.com', 'manolo', 'Barcelona', 'landlord');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
