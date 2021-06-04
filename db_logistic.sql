-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_logistic
CREATE DATABASE IF NOT EXISTS `db_logistic` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_logistic`;

-- Dumping structure for table db_logistic.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `is_permanent` varchar(50) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `create_by` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.admin: ~1 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
REPLACE INTO `admin` (`id`, `code`, `name`, `username`, `password`, `is_permanent`, `create_date`, `create_by`) VALUES
	(1, 'ADMINX', 'Admin X', 'adminx', 'qazwsxedc', '1', '2021-05-06 19:10:19', 'Anonymous');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table db_logistic.cost_estimate
CREATE TABLE IF NOT EXISTS `cost_estimate` (
  `id` int(11) NOT NULL,
  `from_city_id` int(11) NOT NULL DEFAULT 0,
  `to_city_id` int(11) NOT NULL DEFAULT 0,
  `cost_perkg` decimal(20,6) NOT NULL DEFAULT 0.000000,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  `create_by` varchar(50) NOT NULL COMMENT 'kode admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.cost_estimate: ~0 rows (approximately)
/*!40000 ALTER TABLE `cost_estimate` DISABLE KEYS */;
/*!40000 ALTER TABLE `cost_estimate` ENABLE KEYS */;

-- Dumping structure for table db_logistic.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `jeniskelamin` varchar(50) DEFAULT NULL,
  `notelp` varchar(50) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dumping data for table db_logistic.customer: ~2 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
REPLACE INTO `customer` (`id`, `kode`, `nama`, `jeniskelamin`, `notelp`, `alamat`, `create_date`) VALUES
	(14, '0021', 'Saami', 'Laki - laki', '081210675553', 'Jakarta Raya', '2021-05-11 22:33:13'),
	(15, '00125', 'Jack Sumanto', 'Laki - laki', '021646534', 'Jakarta', '2021-06-03 17:31:55');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table db_logistic.drop_off_agent
CREATE TABLE IF NOT EXISTS `drop_off_agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agent_name` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `kota_id` int(11) NOT NULL DEFAULT 0,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  `create_by` varchar(50) NOT NULL COMMENT 'kode admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.drop_off_agent: ~0 rows (approximately)
/*!40000 ALTER TABLE `drop_off_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `drop_off_agent` ENABLE KEYS */;

-- Dumping structure for table db_logistic.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` int(11) NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `id_drop_off_agent` int(11) DEFAULT NULL,
  `create_date` varchar(50) NOT NULL DEFAULT current_timestamp(),
  `create_by` varchar(50) NOT NULL COMMENT 'kode_admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.employee: ~0 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table db_logistic.kota
CREATE TABLE IF NOT EXISTS `kota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kota` varchar(50) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.kota: ~0 rows (approximately)
/*!40000 ALTER TABLE `kota` DISABLE KEYS */;
/*!40000 ALTER TABLE `kota` ENABLE KEYS */;

-- Dumping structure for table db_logistic.paket_header
CREATE TABLE IF NOT EXISTS `paket_header` (
  `id` int(11) NOT NULL,
  `transaction_no` varchar(50) NOT NULL DEFAULT '',
  `from_city_id` int(11) NOT NULL DEFAULT 0,
  `to_city_id` int(11) NOT NULL DEFAULT 0,
  `cost_estimate_id` int(11) NOT NULL DEFAULT 0,
  `cost` decimal(20,6) NOT NULL DEFAULT 0.000000,
  `sender_customer_id` decimal(20,6) NOT NULL DEFAULT 0.000000,
  `receiver_customer_id` decimal(20,6) NOT NULL DEFAULT 0.000000,
  `note` text NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.paket_header: ~0 rows (approximately)
/*!40000 ALTER TABLE `paket_header` DISABLE KEYS */;
/*!40000 ALTER TABLE `paket_header` ENABLE KEYS */;

-- Dumping structure for table db_logistic.paket_lines
CREATE TABLE IF NOT EXISTS `paket_lines` (
  `id` int(11) NOT NULL,
  `nama_paket` int(11) NOT NULL,
  `berat` decimal(20,6) DEFAULT NULL,
  `cost_weight` decimal(20,6) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT current_timestamp(),
  `update_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.paket_lines: ~0 rows (approximately)
/*!40000 ALTER TABLE `paket_lines` DISABLE KEYS */;
/*!40000 ALTER TABLE `paket_lines` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
