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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.agent: ~3 rows (approximately)
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
REPLACE INTO `agent` (`id`, `kode`, `agent_name`, `alamat`, `kota_kode`, `create_date`) VALUES
	(1, 'AGJKT', 'AGEN JAKARTA TIMUR', 'jakarta timur', 'JKT', '2021-06-11 14:44:40'),
	(2, 'AGPAL', 'AGEN PALEMBANG', 'Palembang', 'PLB', '2021-06-28 23:52:42'),
	(3, 'AGBAL', 'AGEN BALI', 'bali', 'BAL', '2021-07-01 17:36:33'),
	(4, 'AGBDG', 'AGEN BANDUNG', 'jl Bandung Selatan', 'PLB', '2021-07-01 17:59:23'),
	(5, 'AGPAP', 'AGEN PAPUA', 'Papua', 'PAP', '2021-07-06 05:31:08');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.cost_estimate: ~4 rows (approximately)
/*!40000 ALTER TABLE `cost_estimate` DISABLE KEYS */;
REPLACE INTO `cost_estimate` (`id`, `kode`, `from_city_kode`, `to_city_kode`, `cost_perkg`, `create_date`) VALUES
	(1, 'JAKPAL', 'JKT', 'PLB', 22000, '2021-07-04 10:27:04'),
	(9, 'JAKXqq', 'JKT', 'YGK', 21000, '2021-07-04 10:31:32'),
	(11, 'SURYOG', 'SBY', 'YGK', 18000, '2021-07-05 18:46:43'),
	(12, 'JKTPAP', 'JKT', 'PAP', 34000, '2021-07-06 05:30:15');
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Dumping data for table db_logistic.customer: ~4 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
REPLACE INTO `customer` (`id`, `kode`, `nama`, `jeniskelamin`, `notelp`, `alamat`, `create_date`) VALUES
	(14, '0021', 'Saami Shahab', 'Laki - laki', '081210675553', 'Jakarta Raya', '2021-05-11 22:33:13'),
	(15, '00125', 'Aprilia', 'Perempuan', '02163', 'Jakarta', '2021-06-03 17:31:55'),
	(16, '0991', 'Nisa An', 'Perempuan', '021865343', 'Jakarta', '2021-06-11 14:43:28'),
	(18, '9012', 'Joni Andra', 'Laki - laki', '02186443', 'Jakarta Raya', '2021-07-06 05:28:30');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.employee: ~4 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
REPLACE INTO `employee` (`id`, `kode`, `name`, `gender`, `username`, `password`, `kode_agent`, `create_date`) VALUES
	(1, 'EMP0001', 'Saami Ganteng', 'Laki - laki', 'saami', '1234', 'AGJKT', '2021-06-10 14:38:32'),
	(3, 'EMP0003', 'Yadi', 'Laki - laki', 'yadi123', '1234', 'AGPAL', '2021-06-29 00:00:04'),
	(4, 'EMP0004', 'Sutiamin', 'Perempuan', 'suti123', '12345', 'AGPAL', '2021-06-30 03:37:17'),
	(5, 'EMP0005', 'Yati', 'Perempuan', 'yati123', '1234', 'AGJKT', '2021-06-30 03:40:04'),
	(6, 'EMP101001', 'Maryani', 'Perempuan', 'mar123', '1234', 'AGBAL', '2021-07-06 05:32:14');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table db_logistic.kota
CREATE TABLE IF NOT EXISTS `kota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) NOT NULL,
  `nama_kota` varchar(50) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.kota: ~6 rows (approximately)
/*!40000 ALTER TABLE `kota` DISABLE KEYS */;
REPLACE INTO `kota` (`id`, `kode`, `nama_kota`, `create_date`) VALUES
	(1, 'JKT', 'DKI Jakarta', '2021-06-10 14:09:40'),
	(2, 'SBY', 'Surabaya', '2021-06-10 14:09:48'),
	(4, 'PLB', 'Palembang', '2021-06-11 14:34:36'),
	(5, 'YGK', 'Yogyakarta', '2021-06-28 21:08:02'),
	(7, 'BAL', 'Bali', '2021-07-01 17:34:23'),
	(9, 'PAP', 'Papua Timur', '2021-07-06 05:29:29');
/*!40000 ALTER TABLE `kota` ENABLE KEYS */;

-- Dumping structure for view db_logistic.lihat_admin
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `lihat_admin` 
) ENGINE=MyISAM;

-- Dumping structure for table db_logistic.paket_tracker
CREATE TABLE IF NOT EXISTS `paket_tracker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_no` varchar(50) NOT NULL DEFAULT '',
  `description` text DEFAULT NULL,
  `status` varchar(50) NOT NULL COMMENT 'Dikirim/Diterima',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `created_by` varchar(50) DEFAULT NULL COMMENT 'kode employee',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.paket_tracker: ~3 rows (approximately)
/*!40000 ALTER TABLE `paket_tracker` DISABLE KEYS */;
REPLACE INTO `paket_tracker` (`id`, `transaction_no`, `description`, `status`, `created_date`, `created_by`) VALUES
	(1, 'PAKET23042735', '', 'Paket Diterima di Agen AGJKT', NULL, NULL),
	(2, 'PAKET23042735', NULL, 'Paket Berangkat dari Agen AGJKT ', NULL, NULL),
	(3, 'PAKET23042735', NULL, 'Paket Diterima di Agen PAL', '2021-07-05 20:39:19', NULL),
	(4, 'PAKET23042735', 'sudah dikirim', 'Dikirim', '2021-07-06 04:00:48', 'EMP0001'),
	(5, 'PAKET06072021053359', 'paket telah dikirim', 'Dikirim Agen', '2021-07-06 05:42:57', 'EMP0001'),
	(6, 'PAKET23042735', 'Paket terjadi kendala', 'Terkendala', '2021-07-06 05:43:35', 'EMP0001');
/*!40000 ALTER TABLE `paket_tracker` ENABLE KEYS */;

-- Dumping structure for table db_logistic.paket_transaction
CREATE TABLE IF NOT EXISTS `paket_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_no` varchar(50) NOT NULL DEFAULT '',
  `cost_estimate_kode` varchar(50) NOT NULL,
  `cost` decimal(20,6) NOT NULL DEFAULT 0.000000,
  `sender_customer_kode` varchar(50) NOT NULL,
  `receiver_customer_kode` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `nama_paket` text NOT NULL,
  `berat` decimal(20,2) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `create_by` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.paket_transaction: ~1 rows (approximately)
/*!40000 ALTER TABLE `paket_transaction` DISABLE KEYS */;
REPLACE INTO `paket_transaction` (`id`, `transaction_no`, `cost_estimate_kode`, `cost`, `sender_customer_kode`, `receiver_customer_kode`, `alamat`, `nama_paket`, `berat`, `create_date`, `create_by`) VALUES
	(1, 'PAKET23042735', 'JAKPAL', 22000.000000, '0021', '0991', 'Paket', 'Elektronik', 2.00, '2021-07-05 20:35:04', ''),
	(2, 'PAKET06072021020734', 'JAKPAL', 264000.000000, '0021', '0277741', 'Palembang Raya', 'Mesin Cuci', 12.00, '2021-07-06 02:07:34', 'EMP0001'),
	(3, 'PAKET06072021050411', 'JAKXqq', 105000.000000, '0021', '0277741', 'Yogyakarta pokoknya', 'Komputer', 5.00, '2021-07-06 05:04:11', 'EMP0001'),
	(4, 'PAKET06072021053359', 'JKTPAP', 272000.000000, '0991', '9012', 'Jl Papua Timur', 'Komputer', 8.00, '2021-07-06 05:33:59', 'EMP0001');
/*!40000 ALTER TABLE `paket_transaction` ENABLE KEYS */;

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
