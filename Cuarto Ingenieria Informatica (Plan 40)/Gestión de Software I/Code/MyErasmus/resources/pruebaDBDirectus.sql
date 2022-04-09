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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_activity: ~7 rows (aproximadamente)
DELETE FROM `directus_activity`;
/*!40000 ALTER TABLE `directus_activity` DISABLE KEYS */;
INSERT INTO `directus_activity` (`id`, `action`, `user`, `timestamp`, `ip`, `user_agent`, `collection`, `item`, `comment`) VALUES
	(1, 'login', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:28', '::ffff:192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_users', '43e8cc75-49ad-409a-930a-15234abee921', NULL),
	(2, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:40', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_collections', 'prueba', NULL),
	(3, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:40', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '1', NULL),
	(4, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:33:57', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '2', NULL),
	(5, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:34:05', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '3', NULL),
	(6, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:34:17', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'prueba', '1', NULL),
	(7, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-19 10:42:40', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'prueba', '2', NULL),
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
	(31, 'create', '43e8cc75-49ad-409a-930a-15234abee921', '2021-11-21 10:08:43', '192.168.192.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36', 'directus_fields', '13', NULL);
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
	('events', NULL, NULL, NULL, 0, 0, NULL, NULL, 1, NULL, NULL, NULL, 'all', NULL, NULL),
	('prueba', NULL, NULL, NULL, 0, 0, NULL, NULL, 1, NULL, NULL, NULL, 'all', NULL, NULL),
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_fields: ~13 rows (aproximadamente)
DELETE FROM `directus_fields`;
/*!40000 ALTER TABLE `directus_fields` DISABLE KEYS */;
INSERT INTO `directus_fields` (`id`, `collection`, `field`, `special`, `interface`, `options`, `display`, `display_options`, `readonly`, `hidden`, `sort`, `width`, `translations`, `note`, `conditions`, `required`, `group`) VALUES
	(1, 'prueba', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(2, 'prueba', 'campo1', NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(3, 'prueba', 'campo2', NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(4, 'user', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, NULL, 'full', NULL, NULL, NULL, 0, NULL),
	(5, 'user', 'name', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(6, 'user', 'mail', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(7, 'user', 'password', NULL, 'input', NULL, 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 1, NULL),
	(8, 'events', 'id', NULL, 'input', NULL, NULL, NULL, 1, 1, 1, 'full', NULL, NULL, NULL, 0, NULL),
	(9, 'events', 'discount', NULL, 'input', NULL, 'raw', NULL, 0, 0, 4, 'full', NULL, NULL, NULL, 0, NULL),
	(10, 'events', 'eventtype', NULL, 'select-dropdown', '{"choices": [{"text": "party", "value": "party"}, {"text": "meetup", "value": "meetup"}, {"text": "tabletop", "value": "tabletop"}, {"text": "faire", "value": "faire"}, {"text": "sports", "value": "sports"}, {"text": "games", "value": "games"}, {"text": "concert", "value": "concert"}, {"text": "other", "value": "other"}]}', 'raw', NULL, 0, 0, 5, 'full', NULL, NULL, NULL, 1, NULL),
	(11, 'events', 'name', NULL, 'input', NULL, 'raw', NULL, 0, 0, 2, 'full', NULL, NULL, NULL, 1, NULL),
	(12, 'events', 'description', NULL, 'input-rich-text-html', '{"toolbar": ["bold", "italic", "underline", "removeformat", "customLink", "bullist", "numlist", "blockquote", "h1", "h2", "h3", "customImage", "customMedia", "hr", "code", "fullscreen", "aligncenter", "alignjustify"]}', 'formatted-value', NULL, 0, 0, 3, 'full', NULL, NULL, NULL, 1, NULL),
	(13, 'events', 'location', NULL, 'map', '{"defaultView": {"zoom": 0, "pitch": 0, "center": {"lat": 0, "lng": 0}, "bearing": 0}, "geometryType": "Point", "geometryFormat": "wkt"}', 'raw', NULL, 0, 0, NULL, 'full', NULL, NULL, NULL, 0, NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_permissions: ~0 rows (aproximadamente)
DELETE FROM `directus_permissions`;
/*!40000 ALTER TABLE `directus_permissions` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_presets: ~0 rows (aproximadamente)
DELETE FROM `directus_presets`;
/*!40000 ALTER TABLE `directus_presets` DISABLE KEYS */;
INSERT INTO `directus_presets` (`id`, `bookmark`, `user`, `role`, `collection`, `search`, `layout`, `layout_query`, `layout_options`, `refresh_interval`, `filter`) VALUES
	(1, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'prueba', NULL, 'tabular', '{"tabular": {"page": 1}}', NULL, NULL, NULL),
	(2, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'user', NULL, 'tabular', '{"tabular": {"page": 1}}', NULL, NULL, NULL),
	(3, NULL, '43e8cc75-49ad-409a-930a-15234abee921', NULL, 'events', NULL, 'tabular', '{"tabular": {"page": 1}}', NULL, NULL, NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_relations: ~0 rows (aproximadamente)
DELETE FROM `directus_relations`;
/*!40000 ALTER TABLE `directus_relations` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.directus_revisions: ~0 rows (aproximadamente)
DELETE FROM `directus_revisions`;
/*!40000 ALTER TABLE `directus_revisions` DISABLE KEYS */;
INSERT INTO `directus_revisions` (`id`, `activity`, `collection`, `item`, `data`, `delta`, `parent`) VALUES
	(1, 2, 'directus_collections', 'prueba', '{"singleton": false, "collection": "prueba"}', '{"singleton": false, "collection": "prueba"}', NULL),
	(2, 3, 'directus_fields', '1', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "prueba"}', '{"field": "id", "hidden": true, "readonly": true, "interface": "input", "collection": "prueba"}', NULL),
	(3, 4, 'directus_fields', '2', '{"field": "campo1", "hidden": false, "display": null, "options": null, "special": null, "readonly": false, "interface": null, "collection": "prueba", "display_options": null}', '{"field": "campo1", "hidden": false, "display": null, "options": null, "special": null, "readonly": false, "interface": null, "collection": "prueba", "display_options": null}', NULL),
	(4, 5, 'directus_fields', '3', '{"field": "campo2", "hidden": false, "readonly": false, "collection": "prueba"}', '{"field": "campo2", "hidden": false, "readonly": false, "collection": "prueba"}', NULL),
	(5, 6, 'prueba', '1', '{"campo1": "Funciona pls", "campo2": "1"}', '{"campo1": "Funciona pls", "campo2": "1"}', NULL),
	(6, 7, 'prueba', '2', '{"campo1": "GUAPO COÑO", "campo2": "2"}', '{"campo1": "GUAPO COÑO", "campo2": "2"}', NULL),
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
	(30, 31, 'directus_fields', '13', '{"field": "location", "hidden": false, "display": "raw", "options": {"defaultView": {"zoom": 0, "pitch": 0, "center": {"lat": 0, "lng": 0}, "bearing": 0}, "geometryType": "Point", "geometryFormat": "wkt"}, "readonly": false, "interface": "map", "collection": "events"}', '{"field": "location", "hidden": false, "display": "raw", "options": {"defaultView": {"zoom": 0, "pitch": 0, "center": {"lat": 0, "lng": 0}, "bearing": 0}, "geometryType": "Point", "geometryFormat": "wkt"}, "readonly": false, "interface": "map", "collection": "events"}', NULL);
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

-- Volcando datos para la tabla directus.directus_sessions: ~0 rows (aproximadamente)
DELETE FROM `directus_sessions`;
/*!40000 ALTER TABLE `directus_sessions` DISABLE KEYS */;
INSERT INTO `directus_sessions` (`token`, `user`, `expires`, `ip`, `user_agent`, `data`) VALUES
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
	('43e8cc75-49ad-409a-930a-15234abee921', NULL, NULL, 'admin@example.com', '$argon2i$v=19$m=4096,t=3,p=1$z8l2+iUgMH2sFs8HkLWTsQ$rccg8oI1707hEIgG0hvV7I/mgZKnJwnJfEuoTh05Has', NULL, NULL, NULL, NULL, NULL, 'en-US', 'auto', NULL, 'active', '734382b9-fb3e-4021-b87f-b8ae086f40c5', NULL, '2021-11-21 10:14:54', '/settings/data-model/events', 'default', NULL);
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

-- Volcando estructura para tabla directus.prueba
CREATE TABLE IF NOT EXISTS `prueba` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `campo1` text,
  `campo2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.prueba: ~0 rows (aproximadamente)
DELETE FROM `prueba`;
/*!40000 ALTER TABLE `prueba` DISABLE KEYS */;
INSERT INTO `prueba` (`id`, `campo1`, `campo2`) VALUES
	(1, 'Funciona pls', '1'),
	(2, 'GUAPO COÑO', '2');
/*!40000 ALTER TABLE `prueba` ENABLE KEYS */;

-- Volcando estructura para tabla directus.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `mail` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `type` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla directus.user: ~0 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `mail`, `password`, `type`) VALUES
	(1, 'pepe', 'pepe@gmail.com', 'aeiou12345', 'student');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
