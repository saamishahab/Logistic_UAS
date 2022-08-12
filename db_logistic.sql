-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.21-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
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
REPLACE INTO `admin` (`id`, `kode`, `name`, `username`, `password`, `is_permanent`, `create_date`) VALUES
	(1, 'ADMINX', 'Admin X', 'adminx', 'qazwsxedc', '1', '2021-05-06 12:10:19');

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
REPLACE INTO `agent` (`id`, `kode`, `agent_name`, `alamat`, `kota_kode`, `create_date`) VALUES
	(1, 'AGJKT', 'AGEN JAKARTA TIMUR', 'jakarta timur', 'JKT', '2021-06-11 14:44:40'),
	(2, 'AGPAL', 'AGEN PALEMBANG', 'Palembang', 'PLB', '2021-06-28 23:52:42'),
	(3, 'AGBAL', 'AGEN BALI', 'bali', 'BAL', '2021-07-01 17:36:33'),
	(4, 'AGBDG', 'AGEN BANDUNG', 'jl Bandung Selatan', 'PLB', '2021-07-01 17:59:23'),
	(5, 'AGPAP', 'AGEN PAPUA', 'Papua', 'PAP', '2021-07-06 05:31:08');

-- Dumping structure for table db_logistic.cost_estimate
CREATE TABLE IF NOT EXISTS `cost_estimate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) NOT NULL DEFAULT '',
  `from_city_kode` varchar(50) NOT NULL DEFAULT '0',
  `to_city_kode` varchar(50) NOT NULL DEFAULT '0',
  `cost_perkg` decimal(20,0) NOT NULL DEFAULT 0,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.cost_estimate: ~7 rows (approximately)
REPLACE INTO `cost_estimate` (`id`, `kode`, `from_city_kode`, `to_city_kode`, `cost_perkg`, `create_date`) VALUES
	(1, 'JAKPAL', 'JKT', 'PLB', 22000, '2021-07-04 10:27:04'),
	(9, 'JAKXqq', 'JKT', 'YGK', 21000, '2021-07-04 10:31:32'),
	(11, 'SURYOG', 'SBY', 'YGK', 18000, '2021-07-05 18:46:43'),
	(12, 'JKTPAP', 'JKT', 'PAP', 42000, '2021-07-06 05:30:15'),
	(13, 'JKTJKTS', 'JKT', 'JKT', 8000, '2022-06-25 14:31:04'),
	(14, 'JKTSBY', 'JKT', 'SBY', 27000, '2022-06-25 14:31:39'),
	(15, 'JAKBAL', 'JKT', 'BAL', 31000, '2022-06-25 14:32:43');

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
REPLACE INTO `customer` (`id`, `kode`, `nama`, `jeniskelamin`, `notelp`, `alamat`, `create_date`) VALUES
	(14, '0021', 'Saami Shahab', 'Laki - laki', '081210675553', 'Jakarta Raya', '2021-05-11 22:33:13'),
	(15, '00125', 'Aprilia', 'Perempuan', '02163', 'Jakarta', '2021-06-03 17:31:55'),
	(16, '0991', 'Nisa An', 'Perempuan', '021865343', 'Jakarta', '2021-06-11 14:43:28'),
	(18, '9012', 'Joni Andra', 'Laki - laki', '02186443', 'Jakarta Raya', '2021-07-06 05:28:30');

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

-- Dumping data for table db_logistic.employee: ~5 rows (approximately)
REPLACE INTO `employee` (`id`, `kode`, `name`, `gender`, `username`, `password`, `kode_agent`, `create_date`) VALUES
	(1, 'EMP0001', 'Saami Ganteng', 'Laki - laki', 'saami', '1234', 'AGJKT', '2021-06-10 14:38:32'),
	(3, 'EMP0003', 'Yadi', 'Laki - laki', 'yadi123', '1234', 'AGPAL', '2021-06-29 00:00:04'),
	(4, 'EMP0004', 'Sutiamin', 'Perempuan', 'suti123', '12345', 'AGPAL', '2021-06-30 03:37:17'),
	(5, 'EMP0005', 'Yati', 'Perempuan', 'yati123', '1234', 'AGJKT', '2021-06-30 03:40:04'),
	(6, 'EMP101001', 'Maryani', 'Perempuan', 'mar123', '1234', 'AGBAL', '2021-07-06 05:32:14');

-- Dumping structure for table db_logistic.kota
CREATE TABLE IF NOT EXISTS `kota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(50) NOT NULL,
  `nama_kota` varchar(50) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.kota: ~6 rows (approximately)
REPLACE INTO `kota` (`id`, `kode`, `nama_kota`, `create_date`) VALUES
	(1, 'JKT', 'DKI Jakarta', '2021-06-10 14:09:40'),
	(2, 'SBY', 'Surabaya', '2021-06-10 14:09:48'),
	(4, 'PLB', 'Palembang', '2021-06-11 14:34:36'),
	(5, 'YGK', 'Yogyakarta', '2021-06-28 21:08:02'),
	(7, 'BAL', 'Bali', '2021-07-01 17:34:23'),
	(9, 'PAP', 'Papua Timur', '2021-07-06 05:29:29');

-- Dumping structure for table db_logistic.paket_tracker
CREATE TABLE IF NOT EXISTS `paket_tracker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_no` varchar(50) NOT NULL DEFAULT '',
  `description` text DEFAULT NULL,
  `status` varchar(50) NOT NULL COMMENT 'Dikirim/Diterima',
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `created_by` varchar(50) DEFAULT NULL COMMENT 'kode employee',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.paket_tracker: ~17 rows (approximately)
REPLACE INTO `paket_tracker` (`id`, `transaction_no`, `description`, `status`, `created_date`, `created_by`) VALUES
	(1, 'PAKET23042735', '', 'Paket Diterima di Agen AGJKT', NULL, NULL),
	(2, 'PAKET23042735', NULL, 'Paket Berangkat dari Agen AGJKT ', NULL, NULL),
	(3, 'PAKET23042735', NULL, 'Paket Diterima di Agen PAL', '2021-07-05 13:39:19', NULL),
	(4, 'PAKET23042735', 'sudah dikirim', 'Dikirim', '2021-07-05 21:00:48', 'EMP0001'),
	(5, 'PAKET06072021053359', 'paket telah dikirim', 'Dikirim Agen', '2021-07-05 22:42:57', 'EMP0001'),
	(6, 'PAKET23042735', 'Paket terjadi kendala', 'Terkendala', '2021-07-05 22:43:35', 'EMP0001'),
	(7, 'PAKET25062022014630', 'Diterima', 'Diterima Agen', '2022-06-25 06:54:55', 'EMP0001'),
	(8, 'PAKET25062022014630', 'diterima di agen banten', 'Diterima Agen', '2022-06-25 07:12:51', 'EMP0001'),
	(9, 'PAKET25062022014630', 'perjalanan menuju agen banten', 'Perjalanan', '2022-06-25 07:21:08', 'EMP0001'),
	(10, 'PAKET25062022014630', 'sudah di terima customer', 'DiAmbil Customer', '2022-06-25 07:21:47', 'EMP0001'),
	(11, 'PAKET25062022014630', 'pengiriman selesai', 'Pengiriman Selesai', '2022-06-25 07:22:03', 'EMP0001'),
	(12, 'PAKET23042735', 'telah selesai', 'Pengiriman Selesai', '2022-07-01 14:53:14', 'EMP0001'),
	(13, 'PAKET23042735', 'diterima customer', 'Pengiriman Selesai', '2022-07-01 14:54:08', 'EMP0001'),
	(14, 'PAKET23042735', 'diterima lagi', 'Pengiriman Selesai', '2022-07-01 14:56:32', 'EMP0001'),
	(15, 'PAKET06072021053359', 'diter', 'Pengiriman Selesai', '2022-07-01 14:57:25', 'EMP0001'),
	(16, 'PAKET23042735', 'tes', 'Pengiriman Selesai', '2022-07-01 14:59:46', 'EMP0001'),
	(17, 'PAKET23042735', 's', 'Pengiriman Selesai', '2022-07-01 15:00:16', 'EMP0001'),
	(18, 'PAKET06072021053359', 'tes', 'Pengiriman Selesai', '2022-07-01 16:19:21', 'EMP0001'),
	(19, 'PAKET09082022105641', 'Sudah diterima agen', 'Diterima Agen', '2022-08-09 15:59:45', 'EMP0001');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_logistic.paket_transaction: ~8 rows (approximately)
REPLACE INTO `paket_transaction` (`id`, `transaction_no`, `cost_estimate_kode`, `cost`, `sender_customer_kode`, `receiver_customer_kode`, `alamat`, `nama_paket`, `berat`, `create_date`, `create_by`) VALUES
	(1, 'PAKET23042735', 'JAKPAL', 22000.000000, '0021', '0991', 'Paket', 'Elektronik', 2.00, '2021-07-05 13:35:04', ''),
	(2, 'PAKET06072021020734', 'JAKPAL', 264000.000000, '0021', '0277741', 'Palembang Raya', 'Mesin Cuci', 12.00, '2021-07-05 19:07:34', 'EMP0001'),
	(3, 'PAKET06072021050411', 'JAKXqq', 105000.000000, '0021', '0277741', 'Yogyakarta pokoknya', 'Komputer', 5.00, '2021-07-05 22:04:11', 'EMP0001'),
	(4, 'PAKET06072021053359', 'JKTPAP', 272000.000000, '0991', '9012', 'Jl Papua Timur', 'Komputer', 8.00, '2021-07-05 22:33:59', 'EMP0001'),
	(5, 'PAKET25062022014630', 'JAKPAL', 44000.000000, '0021', '0991', 'Palembang raya', 'baju', 2.00, '2022-06-25 06:46:30', 'EMP0001'),
	(6, 'PAKET26062022073556', 'JAKBAL', 155000.000000, '0021', '9012', 'jl bali', 'daging', 5.00, '2022-06-26 12:35:56', 'EMP0001'),
	(7, 'PAKET01072022100055', 'JKTJKTS', 72000.000000, '0021', '00125', 'jl jakarta', 'komputer i7', 9.00, '2022-07-01 15:00:55', 'EMP0001'),
	(8, 'PAKET01072022102209', 'JKTJKTS', 24000.000000, '0021', '00125', 'tes', 'jeruk', 3.00, '2022-07-01 15:22:09', 'EMP0001'),
	(9, 'PAKET09082022105641', 'JAKXqq', 420000.000000, '0021', '00125', 'yogyakarta', 'beras', 20.00, '2022-08-09 15:56:41', 'EMP0001');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
