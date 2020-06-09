-- --------------------------------------------------------
-- Host:                         common-server
-- Server version:               5.6.48 - MySQL Community Server (GPL)
-- Server OS:                    Linux
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for weather
DROP DATABASE IF EXISTS `weather`;
CREATE DATABASE IF NOT EXISTS `weather` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `weather`;

-- Dumping structure for table weather.weather_log
DROP TABLE IF EXISTS `weather_log`;
CREATE TABLE IF NOT EXISTS `weather_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) NOT NULL DEFAULT '0',
  `country` varchar(50) NOT NULL DEFAULT '0',
  `weather_id` int(11) NOT NULL DEFAULT '0',
  `timetamps` bigint(20) NOT NULL DEFAULT '0',
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `city` (`city`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
