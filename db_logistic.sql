-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.16-MariaDB - mariadb.org binary distribution
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
  `kode` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `is_permanent` varchar(50) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.admin: ~1 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
REPLACE INTO `admin` (`id`, `kode`, `name`, `username`, `password`, `is_permanent`, `create_date`) VALUES
	(1, 'ADMINX', 'Admin X', 'adminx', 'qazwsxedc', '1', '2021-05-06 19:10:19');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table db_logistic.agent
CREATE TABLE IF NOT EXISTS `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) NOT NULL,
  `agent_name` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `kota_kode` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.agent: ~4 rows (approximately)
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
REPLACE INTO `agent` (`id`, `kode`, `agent_name`, `alamat`, `kota_kode`, `create_date`) VALUES
	(1, 'AGJKT', 'AGEN JAKARTA TIMUR', 'jakarta timur', 'JKT', '2021-06-11 14:44:40'),
	(2, 'AGPAL', 'AGEN PALEMBANG', 'Palembang', 'PLB', '2021-06-28 23:52:42'),
	(3, 'AGBAL', 'AGEN BALI', 'bali', 'BAL', '2021-07-01 17:36:33'),
	(4, 'AGBDG', 'AGEN BANDUNG', 'bandung', 'bdg', '2021-07-01 17:59:23');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;

-- Dumping structure for table db_logistic.cost_estimate
CREATE TABLE IF NOT EXISTS `cost_estimate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) NOT NULL DEFAULT '',
  `from_city_kode` varchar(50) NOT NULL DEFAULT '0',
  `to_city_kode` varchar(50) NOT NULL DEFAULT '0',
  `cost_perkg` decimal(20,0) NOT NULL DEFAULT 0,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.cost_estimate: ~3 rows (approximately)
/*!40000 ALTER TABLE `cost_estimate` DISABLE KEYS */;
REPLACE INTO `cost_estimate` (`id`, `kode`, `from_city_kode`, `to_city_kode`, `cost_perkg`, `create_date`) VALUES
	(1, 'JAKPAL', 'JKT', 'PLB', 20000, '2021-07-04 10:27:04'),
	(5, 'JAKXXX', 'JKT', 'YGK', 20000, '2021-07-04 10:29:58'),
	(9, 'JAKXqq', 'SBY', 'YGK', 20000, '2021-07-04 10:31:32');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table db_logistic.customer: ~3 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
REPLACE INTO `customer` (`id`, `kode`, `nama`, `jeniskelamin`, `notelp`, `alamat`, `create_date`) VALUES
	(14, '0021', 'Saami', 'Laki - laki', '081210675553', 'Jakarta Raya', '2021-05-11 22:33:13'),
	(15, '00125', 'Jack Sumanto', 'Laki - laki', '021646534', 'Jakarta', '2021-06-03 17:31:55'),
	(16, '0991', 'Nisa', 'Perempuan', '021865343', 'Jakarta', '2021-06-11 14:43:28');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table db_logistic.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `kode_agent` varchar(50) DEFAULT NULL,
  `create_date` varchar(50) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.employee: ~5 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
REPLACE INTO `employee` (`id`, `kode`, `name`, `gender`, `username`, `password`, `kode_agent`, `create_date`) VALUES
	(1, 'EMP0001', 'Saami Ganteng', 'Laki - laki', 'saami', '1234', 'AGJKT', '2021-06-10 14:38:32'),
	(2, 'EMP0002', 'RROy', 'Laki - laki', 'roy123', '1234', 'AGJKT', '2021-06-28 22:39:36'),
	(3, 'EMP0003', 'Yadi', 'Laki - laki', 'yadi123', '1234', 'AGPAL', '2021-06-29 00:00:04'),
	(4, 'EMP0004', 'Suminem', 'Laki - laki', 'sum123', '1234', 'AGPAL', '2021-06-30 03:37:17'),
	(5, 'EMP0005', 'Yati', 'Perempuan', 'yati123', '1234', 'AGJKT', '2021-06-30 03:40:04');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table db_logistic.kota
CREATE TABLE IF NOT EXISTS `kota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) NOT NULL,
  `nama_kota` varchar(50) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.kota: ~6 rows (approximately)
/*!40000 ALTER TABLE `kota` DISABLE KEYS */;
REPLACE INTO `kota` (`id`, `kode`, `nama_kota`, `create_date`) VALUES
	(1, 'JKT', 'DKI Jakarta', '2021-06-10 14:09:40'),
	(2, 'SBY', 'Surabaya', '2021-06-10 14:09:48'),
	(4, 'PLB', 'Palembang', '2021-06-11 14:34:36'),
	(5, 'YGK', 'Yogyakarta', '2021-06-28 21:08:02'),
	(7, 'BAL', 'Bali', '2021-07-01 17:34:23'),
	(8, 'bdg', 'Bandung', '2021-07-01 17:59:14');
/*!40000 ALTER TABLE `kota` ENABLE KEYS */;

-- Dumping structure for view db_logistic.lihat_admin
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `lihat_admin` 
) ENGINE=MyISAM;

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
  `transaction_no` varchar(50) NOT NULL DEFAULT '',
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

-- Dumping structure for table db_logistic.paket_tracker
CREATE TABLE IF NOT EXISTS `paket_tracker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_no` varchar(50) NOT NULL DEFAULT '',
  `id_paket_lines` varchar(50) NOT NULL DEFAULT '',
  `description` int(11) DEFAULT NULL,
  `status` varchar(50) NOT NULL COMMENT 'Dikirim/Diterima',
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.paket_tracker: ~0 rows (approximately)
/*!40000 ALTER TABLE `paket_tracker` DISABLE KEYS */;
/*!40000 ALTER TABLE `paket_tracker` ENABLE KEYS */;

-- Dumping structure for view db_logistic.lihat_admin
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `lihat_admin`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `lihat_admin` AS SELECT cost_estimate.id, cost_estimate.from_city_id, asal.nama_kota AS 'Asal', cost_estimate.to_city_id ,asal.nama_kota AS 'Tujuan' , cost_estimate.cost_perkg
FROM  cost_estimate
INNER JOIN kota as asal ON asal.id=cost_estimate.from_city_id 
INNER JOIN kota as tujuan On tujuan.id=cost_estimate.to_city_id ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
