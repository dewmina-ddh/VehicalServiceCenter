-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2026 at 03:20 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vehicle_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `appo_id` varchar(20) NOT NULL,
  `vehical_no` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Pending',
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `uName` varchar(20) DEFAULT 'Admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bay_table`
--

CREATE TABLE `bay_table` (
  `bay_id` varchar(20) NOT NULL,
  `bay_name` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'Available',
  `vehicle_no` varchar(30) DEFAULT NULL,
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bay_table`
--

INSERT INTO `bay_table` (`bay_id`, `bay_name`, `status`, `vehicle_no`, `recorded_at`) VALUES
('BAY-01', 'Service Bay 01', 'Available', NULL, '2026-06-19 13:14:49'),
('BAY-02', 'Service Bay 02', 'Available', NULL, '2026-05-28 01:26:19'),
('BAY-03', 'Service Bay 03', 'Available', NULL, '2026-06-19 13:05:35'),
('BAY-04', 'Service Bay 04', 'Available', NULL, '2026-05-28 01:26:19'),
('BAY-05', 'Service Bay 05', 'Available', NULL, '2026-06-19 08:46:57'),
('BAY-06', 'Service Bay 06', 'Available', NULL, '2026-06-19 12:35:36');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `phone` int(10) NOT NULL,
  `city` varchar(100) DEFAULT NULL,
  `town` varchar(100) DEFAULT NULL,
  `recorded_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `name`, `nic`, `phone`, `city`, `town`, `recorded_time`) VALUES
('CUS-80477', 'dsdasd', 'dsadad', 123456, 'dasdsa', 'dsadas', '2026-06-06 01:56:20'),
('CUS-84353', 'damaith', '200524402775', 701052405, 'Galle', 'Baddegama', '2026-06-19 12:59:44'),
('CUS-97650', 'dasdas', '2313', 2315, 'dasdas', 'sdasd', '2026-05-28 01:26:19');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `item_id` int(11) NOT NULL,
  `catagory` varchar(100) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `details` varchar(20) DEFAULT 'no',
  `qty` int(3) NOT NULL,
  `unit_price` int(10) NOT NULL,
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`item_id`, `catagory`, `brand`, `details`, `qty`, `unit_price`, `recorded_at`) VALUES
(1, 'Car Care', '3M', 'Microfiber Cloth', 150, 800, '2026-06-07 03:19:05'),
(2, 'Car Care', 'Generic', 'Cotton Wash Cloth', 200, 300, '2026-06-07 03:19:05'),
(3, 'Car Care', 'Wurth', 'Wash Sponge Large', 80, 600, '2026-06-07 03:19:05'),
(4, 'Car Care', '3M', 'Car Shampoo 1L', 60, 1500, '2026-06-07 03:19:05'),
(5, 'Car Care', 'Meguiars', 'Liquid Wax 500ml', 30, 4500, '2026-06-07 03:19:05'),
(6, 'Car Care', 'Turtle Wax', 'Dash Polish 300ml', 45, 2000, '2026-06-07 03:19:05'),
(7, 'Car Care', '3M', 'Tyre Polish 500ml', 50, 1800, '2026-06-07 03:19:05'),
(8, 'Car Care', 'Generic', 'Glass Cleaner 500ml', 60, 900, '2026-06-07 03:19:05'),
(9, 'Car Care', 'Wurth', 'Engine Degreaser', 40, 2500, '2026-06-07 03:19:05'),
(10, 'Car Care', '3M', 'Rubbing Compound', 25, 3500, '2026-06-07 03:19:05'),
(11, 'Car Care', 'Soft99', 'Fusso Coat Wax', 15, 8500, '2026-06-07 03:19:05'),
(12, 'Car Care', 'Generic', 'Chamois Leather', 70, 1200, '2026-06-07 03:19:05'),
(13, 'Car Care', 'Wurth', 'AC Cleaner Spray', 35, 3000, '2026-06-07 03:19:05'),
(14, 'Car Care', 'Glade', 'Air Freshener Gel', 100, 800, '2026-06-07 03:19:05'),
(15, 'Car Care', 'Ambi Pur', 'Vent Clip Perfume', 85, 1200, '2026-06-07 03:19:05'),
(16, 'Engine Oil', 'Mobil', '10W-30 (4L)', 20, 15000, '2026-06-07 03:19:05'),
(17, 'Engine Oil', 'Mobil', '10W-30 (1L)', 35, 4000, '2026-06-07 03:19:05'),
(18, 'Engine Oil', 'Castrol', '20W-50 (4L)', 30, 12000, '2026-06-07 03:19:05'),
(19, 'Engine Oil', 'Castrol', '20W-50 (1L)', 45, 3200, '2026-06-07 03:19:05'),
(20, 'Engine Oil', 'Toyota', '0W-20 (4L)', 20, 18000, '2026-06-07 03:19:05'),
(21, 'Engine Oil', 'Toyota', '5W-30 (4L)', 25, 17500, '2026-06-07 03:19:05'),
(22, 'Engine Oil', 'Caltex', '15W-40 (4L)', 30, 11000, '2026-06-07 03:19:05'),
(23, 'Gear Oil', 'Toyota', '75W-90 (1L)', 40, 4500, '2026-06-07 03:19:05'),
(24, 'Gear Oil', 'Mobil', '80W-90 (1L)', 35, 3800, '2026-06-07 03:19:05'),
(25, 'Transmission', 'Toyota', 'ATF WS (4L)', 15, 16000, '2026-06-07 03:19:05'),
(26, 'Transmission', 'Toyota', 'ATF T-IV (4L)', 12, 14000, '2026-06-07 03:19:05'),
(27, 'Transmission', 'Toyota', 'CVT FE (4L)', 18, 16500, '2026-06-07 03:19:05'),
(28, 'Brake Fluid', 'Wurth', 'DOT 4 (500ml)', 50, 2500, '2026-06-07 03:19:05'),
(29, 'Brake Fluid', 'Toyota', 'DOT 3 (500ml)', 60, 2000, '2026-06-07 03:19:05'),
(30, 'Coolant', 'Wurth', 'Premix (4L)', 25, 5000, '2026-06-07 03:19:05'),
(31, 'Coolant', 'Toyota', 'Long Life (2L)', 40, 4000, '2026-06-07 03:19:05'),
(32, 'Filters', 'Toyota', 'Oil Filter (Prem)', 100, 3500, '2026-06-07 03:19:05'),
(33, 'Filters', 'VIC', 'Oil Filter (Std)', 150, 2000, '2026-06-07 03:19:05'),
(34, 'Filters', 'Bosch', 'Oil Filter', 80, 2200, '2026-06-07 03:19:05'),
(35, 'Filters', 'Sakura', 'Oil Filter', 110, 1800, '2026-06-07 03:19:05'),
(36, 'Filters', 'Toyota', 'Air Filter (Prem)', 60, 6000, '2026-06-07 03:19:05'),
(37, 'Filters', 'VIC', 'Air Filter', 80, 3500, '2026-06-07 03:19:05'),
(38, 'Filters', 'Sakura', 'Air Filter', 90, 2800, '2026-06-07 03:19:05'),
(39, 'Filters', 'Toyota', 'Cabin AC Filter', 70, 4500, '2026-06-07 03:19:05'),
(40, 'Filters', 'Sakura', 'Cabin AC Filter', 120, 1500, '2026-06-07 03:19:05'),
(41, 'Filters', 'Wix', 'Fuel Filter', 40, 4000, '2026-06-07 03:19:05'),
(42, 'Filters', 'Toyota', 'Fuel Filter (Prem)', 25, 8500, '2026-06-07 03:19:05'),
(43, 'Filters', 'Honda', 'Oil Filter', 75, 3200, '2026-06-07 03:19:05'),
(44, 'Filters', 'Honda', 'Air Filter', 50, 4000, '2026-06-07 03:19:05'),
(45, 'Filters', 'Nissan', 'Oil Filter', 65, 3000, '2026-06-07 03:19:05'),
(46, 'Filters', 'Nissan', 'Air Filter', 45, 3800, '2026-06-07 03:19:05'),
(47, 'Brake Parts', 'Nisshinbo', 'Front Brake Pads', 30, 9500, '2026-06-07 03:19:05'),
(48, 'Brake Parts', 'Akebono', 'Front Brake Pads', 25, 12000, '2026-06-07 03:19:05'),
(49, 'Brake Parts', 'Bosch', 'Front Brake Pads', 40, 8000, '2026-06-07 03:19:05'),
(50, 'Brake Parts', 'Brembo', 'Front Brake Pads', 15, 18000, '2026-06-07 03:19:05'),
(51, 'Brake Parts', 'Nisshinbo', 'Rear Brake Pads', 35, 8500, '2026-06-07 03:19:05'),
(52, 'Brake Parts', 'Akebono', 'Rear Brake Pads', 25, 11000, '2026-06-07 03:19:05'),
(53, 'Brake Parts', 'Toyota', 'Brake Shoes (Rear)', 20, 14000, '2026-06-07 03:19:05'),
(54, 'Brake Parts', 'MK Kashiyama', 'Brake Shoes (Rear)', 40, 6500, '2026-06-07 03:19:05'),
(55, 'Brake Parts', 'Generic', 'Brake Caliper Pin', 80, 1200, '2026-06-07 03:19:05'),
(56, 'Electrical', 'NGK', 'Iridium Spark Plug', 100, 4500, '2026-06-07 03:19:05'),
(57, 'Electrical', 'Denso', 'Iridium Spark Plug', 80, 4800, '2026-06-07 03:19:05'),
(58, 'Electrical', 'NGK', 'Copper Spark Plug', 150, 1200, '2026-06-07 03:19:05'),
(59, 'Electrical', 'Bosch', 'Spark Plug', 120, 1500, '2026-06-07 03:19:05'),
(60, 'Electrical', 'Osram', 'H4 Headlight Bulb', 60, 2500, '2026-06-07 03:19:05'),
(61, 'Electrical', 'Philips', 'H4 Headlight Bulb', 55, 2800, '2026-06-07 03:19:05'),
(62, 'Electrical', 'Osram', 'H11 Fog Light Bulb', 45, 3000, '2026-06-07 03:19:05'),
(63, 'Electrical', 'Generic', 'T10 Park Bulb (LED)', 200, 500, '2026-06-07 03:19:05'),
(64, 'Electrical', 'Generic', 'Brake Light Bulb', 180, 300, '2026-06-07 03:19:05'),
(65, 'Electrical', 'Generic', 'Fuses (Box of 50)', 40, 1500, '2026-06-07 03:19:05'),
(66, 'Electrical', 'Bosch', 'Relay 12V 4Pin', 60, 800, '2026-06-07 03:19:05'),
(67, 'Electrical', 'Generic', 'Battery Terminal', 100, 450, '2026-06-07 03:19:05'),
(68, 'Electrical', 'Amaron', 'Battery 45AH', 15, 24000, '2026-06-07 03:19:05'),
(69, 'Wipers', 'Bosch', 'Wiper Blade 14\"', 50, 1500, '2026-06-07 03:19:05'),
(70, 'Wipers', 'Bosch', 'Wiper Blade 16\"', 60, 1600, '2026-06-07 03:19:05'),
(71, 'Wipers', 'Bosch', 'Wiper Blade 18\"', 60, 1800, '2026-06-07 03:19:05'),
(72, 'Wipers', 'Bosch', 'Wiper Blade 20\"', 70, 2000, '2026-06-07 03:19:05'),
(73, 'Wipers', 'Bosch', 'Wiper Blade 22\"', 50, 2200, '2026-06-07 03:19:05'),
(74, 'Wipers', 'Bosch', 'Wiper Blade 24\"', 45, 2400, '2026-06-07 03:19:05'),
(75, 'Wipers', 'NWB', 'Wiper Blade 16\"', 40, 2500, '2026-06-07 03:19:05'),
(76, 'Wipers', 'NWB', 'Wiper Blade 20\"', 40, 3000, '2026-06-07 03:19:05'),
(77, 'Wipers', 'Wurth', 'Wiper Fluid Add', 80, 600, '2026-06-07 03:19:05'),
(78, 'Belts', 'Bando', 'Fan Belt (4PK)', 40, 2500, '2026-06-07 03:19:05'),
(79, 'Belts', 'Mitsuboshi', 'Fan Belt (6PK)', 35, 3800, '2026-06-07 03:19:05'),
(80, 'Belts', 'Toyota', 'Timing Belt', 20, 12500, '2026-06-07 03:19:05'),
(81, 'Suspension', 'KYB', 'Front Shock Abs', 15, 25000, '2026-06-07 03:19:05'),
(82, 'Suspension', 'KYB', 'Rear Shock Abs', 20, 18000, '2026-06-07 03:19:05'),
(83, 'Suspension', '555', 'Tie Rod End', 30, 4500, '2026-06-07 03:19:05'),
(84, 'Suspension', '555', 'Rack End', 25, 5500, '2026-06-07 03:19:05'),
(85, 'Suspension', 'RBI', 'Lower Arm Bush', 50, 2200, '2026-06-07 03:19:05'),
(86, 'Accessories', 'Generic', 'Floor Mat Set', 25, 4500, '2026-06-07 03:19:05'),
(87, 'Accessories', 'Generic', 'Steering Cover', 40, 1800, '2026-06-07 03:19:05'),
(88, 'Accessories', '3M', 'Double Sided Tape', 100, 800, '2026-06-07 03:19:05'),
(89, 'Accessories', 'Generic', 'Hose Clamps Set', 60, 1500, '2026-06-07 03:19:05');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `inv_id` varchar(20) NOT NULL,
  `job_id` varchar(20) DEFAULT NULL,
  `date` time NOT NULL,
  `total_amount` int(10) NOT NULL,
  `discount` int(10) DEFAULT 0,
  `net_amount` int(10) DEFAULT 0,
  `pay_amount` int(10) DEFAULT 0,
  `payment_method` varchar(20) NOT NULL DEFAULT 'Cash',
  `balance` int(10) DEFAULT 0,
  `payment_status` varchar(20) NOT NULL DEFAULT 'Pending',
  `cust_name` varchar(50) DEFAULT NULL,
  `bill_type` varchar(20) DEFAULT NULL,
  `recoded_user` varchar(20) DEFAULT 'User',
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`inv_id`, `job_id`, `date`, `total_amount`, `discount`, `net_amount`, `pay_amount`, `payment_method`, `balance`, `payment_status`, `cust_name`, `bill_type`, `recoded_user`, `recorded_at`) VALUES
('INV-1502', 'JOB-2713', '18:30:02', 9600, 0, 9600, 10000, 'Cash', 400, 'Paid', 'damaith', 'Service Bill', 'frame0', '2026-06-19 13:00:30'),
('INV-3721', 'JOB-9326', '18:44:27', 9600, 0, 9600, 10000, 'Cash', 400, 'Paid', 'damaith', 'Service Bill', 'frame0', '2026-06-19 13:14:49'),
('INV-6901', 'JOB-4643', '18:35:18', 9600, 0, 9600, 10000, 'Cash', 400, 'Paid', 'damaith', 'Service Bill', 'frame0', '2026-06-19 13:05:35'),
('INV-9427', 'JOB-2479', '07:34:47', 75700, 0, 75700, 76000, 'Cash', 300, 'Paid', 'dasdas', 'Service Bill', NULL, '2026-06-19 08:46:57');

-- --------------------------------------------------------

--
-- Table structure for table `invoice_items`
--

CREATE TABLE `invoice_items` (
  `id` int(4) NOT NULL,
  `inv_id` varchar(20) NOT NULL,
  `item_id` int(11) NOT NULL,
  `qty` int(10) NOT NULL,
  `unit_price` int(10) NOT NULL,
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `job_services`
--

CREATE TABLE `job_services` (
  `job_id` varchar(20) NOT NULL,
  `service_id` varchar(20) NOT NULL,
  `price` int(10) NOT NULL,
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `job_services`
--

INSERT INTO `job_services` (`job_id`, `service_id`, `price`, `recorded_at`) VALUES
('JOB-1485', 'SRV002', 1000, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV003', 5000, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV004', 1200, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV005', 500, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV006', 400, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV010', 15000, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV012', 8000, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV013', 2500, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV014', 3500, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV015', 1800, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV016', 2000, '2026-06-14 16:15:07'),
('JOB-1485', 'SRV017', 1500, '2026-06-14 16:15:07'),
('JOB-2479', 'SRV002', 1000, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV003', 5000, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV004', 1200, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV005', 500, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV006', 400, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV010', 15000, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV012', 8000, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV013', 2500, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV014', 3500, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV015', 1800, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV016', 2000, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV017', 1500, '2026-06-12 02:04:48'),
('JOB-2479', 'SRV020', 4500, '2026-06-12 02:04:48'),
('JOB-2713', 'SRV001', 1500, '2026-06-19 13:00:02'),
('JOB-2713', 'SRV002', 1000, '2026-06-19 13:00:02'),
('JOB-2713', 'SRV003', 5000, '2026-06-19 13:00:02'),
('JOB-2713', 'SRV004', 1200, '2026-06-19 13:00:02'),
('JOB-2713', 'SRV005', 500, '2026-06-19 13:00:02'),
('JOB-2713', 'SRV006', 400, '2026-06-19 13:00:02'),
('JOB-4643', 'SRV001', 1500, '2026-06-19 13:05:18'),
('JOB-4643', 'SRV002', 1000, '2026-06-19 13:05:18'),
('JOB-4643', 'SRV003', 5000, '2026-06-19 13:05:18'),
('JOB-4643', 'SRV004', 1200, '2026-06-19 13:05:18'),
('JOB-4643', 'SRV005', 500, '2026-06-19 13:05:18'),
('JOB-4643', 'SRV006', 400, '2026-06-19 13:05:18'),
('JOB-4878', 'SRV001', 1500, '2026-06-06 14:51:09'),
('JOB-4878', 'SRV002', 1000, '2026-06-06 14:51:09'),
('JOB-4878', 'SRV003', 5000, '2026-06-06 14:51:09'),
('JOB-4878', 'SRV004', 1200, '2026-06-06 14:51:09'),
('JOB-4878', 'SRV005', 500, '2026-06-06 14:51:09'),
('JOB-4878', 'SRV006', 400, '2026-06-06 14:51:09'),
('JOB-5418', 'SRV001', 1500, '2026-06-06 01:34:08'),
('JOB-5418', 'SRV002', 1000, '2026-06-06 01:34:08'),
('JOB-5418', 'SRV003', 5000, '2026-06-06 01:34:08'),
('JOB-5418', 'SRV004', 1200, '2026-06-06 01:34:08'),
('JOB-5418', 'SRV005', 500, '2026-06-06 01:34:08'),
('JOB-5418', 'SRV006', 400, '2026-06-06 01:34:08'),
('JOB-6178', 'SRV001', 1500, '2026-06-06 01:56:36'),
('JOB-6178', 'SRV002', 1000, '2026-06-06 01:56:36'),
('JOB-6178', 'SRV003', 5000, '2026-06-06 01:56:36'),
('JOB-6178', 'SRV004', 1200, '2026-06-06 01:56:36'),
('JOB-6178', 'SRV005', 500, '2026-06-06 01:56:36'),
('JOB-6178', 'SRV006', 400, '2026-06-06 01:56:36'),
('JOB-8718', 'SRV001', 1500, '2026-06-09 13:52:34'),
('JOB-8718', 'SRV002', 1000, '2026-06-09 13:52:34'),
('JOB-8718', 'SRV003', 5000, '2026-06-09 13:52:34'),
('JOB-8718', 'SRV004', 1200, '2026-06-09 13:52:34'),
('JOB-8718', 'SRV005', 500, '2026-06-09 13:52:34'),
('JOB-8718', 'SRV006', 400, '2026-06-09 13:52:34'),
('JOB-9326', 'SRV001', 1500, '2026-06-19 13:14:27'),
('JOB-9326', 'SRV002', 1000, '2026-06-19 13:14:27'),
('JOB-9326', 'SRV003', 5000, '2026-06-19 13:14:27'),
('JOB-9326', 'SRV004', 1200, '2026-06-19 13:14:27'),
('JOB-9326', 'SRV005', 500, '2026-06-19 13:14:27'),
('JOB-9326', 'SRV006', 400, '2026-06-19 13:14:27');

-- --------------------------------------------------------

--
-- Table structure for table `job_table`
--

CREATE TABLE `job_table` (
  `job_id` varchar(20) NOT NULL,
  `vehicle_no` varchar(30) NOT NULL,
  `service_type` varchar(100) DEFAULT NULL,
  `additional_services` varchar(100) DEFAULT NULL,
  `bay_id` varchar(20) DEFAULT NULL,
  `tech_id` varchar(20) DEFAULT NULL,
  `odometer_reading` varchar(10) NOT NULL,
  `start_time` time NOT NULL,
  `total_amount` decimal(10,2) DEFAULT 0.00,
  `status` varchar(20) DEFAULT 'Ongoing',
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `job_table`
--

INSERT INTO `job_table` (`job_id`, `vehicle_no`, `service_type`, `additional_services`, `bay_id`, `tech_id`, `odometer_reading`, `start_time`, `total_amount`, `status`, `recorded_at`) VALUES
('JOB-1485', 'BEO-8269', 'Full Service', '', 'BAY-03', 'TECH-05', '123', '21:45:07', 15000.00, 'Completed', '2026-06-19 05:52:54'),
('JOB-2479', 'BEO-8269', 'Full Service', 'Brake Pad Replacement', 'BAY-05', 'TECH-04', '123', '07:34:47', 19500.00, 'Completed', '2026-06-19 08:46:57'),
('JOB-2713', 'ABC-1234', 'Normal Service', '', 'BAY-01', 'TECH-01', '23000', '18:30:02', 1500.00, 'Completed', '2026-06-19 13:00:30'),
('JOB-4643', 'ABC-1234', 'Normal Service', '', 'BAY-03', 'TECH-02', '23000', '18:35:18', 1500.00, 'Completed', '2026-06-19 13:05:35'),
('JOB-4878', 'BEO-8269', 'Normal Service', '', 'BAY-04', 'TECH-02', '123', '20:21:09', 1500.00, 'Completed', '2026-06-19 09:15:46'),
('JOB-5418', 'BEO-8269', 'Normal Service', '', 'BAY-01', 'TECH-01', '123', '07:04:08', 1500.00, 'Completed', '2026-06-19 09:18:25'),
('JOB-6178', 'BDZ-6960', 'Normal Service', '', 'BAY-02', 'TECH-03', '123', '07:26:36', 1500.00, 'Completed', '2026-06-19 12:31:52'),
('JOB-8718', 'BEO-8269', 'Normal Service', '', 'BAY-06', 'TECH-03', '123', '19:22:34', 1500.00, 'Completed', '2026-06-19 12:35:36'),
('JOB-9326', 'ABC-1234', 'Normal Service', '', 'BAY-01', 'TECH-01', '23000', '18:44:27', 1500.00, 'Completed', '2026-06-19 13:14:49');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `service_id` varchar(20) NOT NULL,
  `service_name` varchar(100) NOT NULL,
  `price` int(10) NOT NULL,
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`service_id`, `service_name`, `price`, `recorded_at`) VALUES
('SRV001', 'Normal Service', 1500, '2026-05-28 01:26:19'),
('SRV002', 'Body Wash & Vacuum', 1000, '2026-06-05 01:43:58'),
('SRV003', 'Engine Oil Change', 5000, '2026-06-05 01:43:58'),
('SRV004', 'Oil Filter Replacement', 1200, '2026-06-05 01:43:58'),
('SRV005', 'Fluid Level Check', 500, '2026-06-05 01:43:58'),
('SRV006', 'Air Filter Cleaning', 400, '2026-06-05 01:43:58'),
('SRV010', 'Full Service', 15000, '2026-05-28 01:26:19'),
('SRV011', 'Normal Service (Full)', 1500, '2026-06-05 01:43:58'),
('SRV012', 'Full Lubrication Service', 8000, '2026-06-05 01:43:58'),
('SRV013', 'Wheel Alignment & Balancing', 2500, '2026-06-05 01:43:58'),
('SRV014', 'Engine Tune-up & Scanning', 3500, '2026-06-05 01:43:58'),
('SRV015', 'Brake System Servicing', 1800, '2026-06-05 01:43:58'),
('SRV016', 'Under-carriage Degreasing & Washing', 2000, '2026-06-05 01:43:58'),
('SRV017', 'AC System Inspection & Top-up', 1500, '2026-06-05 01:43:58'),
('SRV020', 'Brake Pad Replacement', 4500, '2026-05-28 01:26:19'),
('SRV021', 'Battery Charging & Replacement', 12000, '2026-05-28 01:26:19'),
('SRV022', 'Spark Plug Replacement', 950, '2026-05-28 01:26:19'),
('SRV023', 'Wiper Blade Replacement', 1750, '2026-05-28 01:26:19'),
('SRV024', 'Headlight/Tail-light Bulb Replacement', 650, '2026-05-28 01:26:19');

-- --------------------------------------------------------

--
-- Table structure for table `technician`
--

CREATE TABLE `technician` (
  `tech_id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `phone` int(10) NOT NULL,
  `specialty` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'Available',
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `technician`
--

INSERT INTO `technician` (`tech_id`, `name`, `nic`, `phone`, `specialty`, `status`, `recorded_at`) VALUES
('TECH-01', 'Sunil Perera', '198512345678', 771234567, 'Hybrid & Engine Tuning', 'Available', '2026-06-19 13:14:49'),
('TECH-02', 'Kamal Silva', '199087654321', 719876543, 'Wheel Alignment & Suspension', 'Available', '2026-06-19 13:05:35'),
('TECH-03', 'Nimal Fernando', '199345678912', 754567890, 'Auto Electrical & Air Conditioning', 'Available', '2026-06-19 12:31:52'),
('TECH-04', 'Ruwan Kumara', '198854321987', 723456789, 'General Service & Lube', 'Available', '2026-06-19 08:46:57'),
('TECH-05', 'Ajith Kumara', '199511223344', 781122334, 'Body Wash & Interior Cleaning', 'Available', '2026-06-19 05:52:54');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(3) NOT NULL,
  `name` varchar(100) NOT NULL,
  `uName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `password` varchar(255) NOT NULL,
  `confirm` varchar(255) NOT NULL,
  `role` varchar(10) NOT NULL,
  `change_pass` tinyint(4) NOT NULL DEFAULT 0,
  `recorded_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `uName`, `email`, `nic`, `password`, `confirm`, `role`, `change_pass`, `recorded_time`) VALUES
(2, 'Dama', 'dama', 'dama@gmail.com', '123456789', 'admin123', 'admin123', 'admin', 0, '2026-05-28 01:26:20'),
(3, 'Dewmina', 'dew', 'dewmina@gmail.com', '111111111111', 'dew@123', 'dew@123', 'user', 0, '2026-05-28 01:26:20');

-- --------------------------------------------------------

--
-- Table structure for table `vehical_table`
--

CREATE TABLE `vehical_table` (
  `vehical_no` varchar(30) NOT NULL,
  `make` varchar(50) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `model` varchar(50) NOT NULL,
  `fuel` varchar(50) NOT NULL,
  `reading` int(10) DEFAULT 0,
  `color` varchar(50) NOT NULL,
  `make_year` year(4) NOT NULL,
  `cus_id` varchar(20) NOT NULL,
  `recodede_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehical_table`
--

INSERT INTO `vehical_table` (`vehical_no`, `make`, `brand`, `model`, `fuel`, `reading`, `color`, `make_year`, `cus_id`, `recodede_time`) VALUES
('ABC-1234', 'Item 2', 'Honda', 'civic', 'Item 2', 23000, 'red', '2015', 'CUS-84353', '2026-06-19 12:59:44'),
('BDZ-6960', 'Item 2', 'dsadas', 'dsadsa', 'Item 2', 123, 'dsdasd', '2013', 'CUS-80477', '2026-06-06 01:56:20'),
('BEO-8269', 'Item 2', 'dsadasd', 'dasdasd', 'Item 2', 123, 'dsadasd', '2026', 'CUS-97650', '2026-05-28 01:26:19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`appo_id`),
  ADD KEY `vehical_no` (`vehical_no`);

--
-- Indexes for table `bay_table`
--
ALTER TABLE `bay_table`
  ADD PRIMARY KEY (`bay_id`),
  ADD KEY `vehicle_no` (`vehicle_no`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`inv_id`),
  ADD KEY `job_id` (`job_id`);

--
-- Indexes for table `invoice_items`
--
ALTER TABLE `invoice_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `inv_id` (`inv_id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `job_services`
--
ALTER TABLE `job_services`
  ADD PRIMARY KEY (`job_id`,`service_id`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `job_table`
--
ALTER TABLE `job_table`
  ADD PRIMARY KEY (`job_id`),
  ADD KEY `vehicle_no` (`vehicle_no`),
  ADD KEY `bay_id` (`bay_id`),
  ADD KEY `tech_id` (`tech_id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`service_id`);

--
-- Indexes for table `technician`
--
ALTER TABLE `technician`
  ADD PRIMARY KEY (`tech_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vehical_table`
--
ALTER TABLE `vehical_table`
  ADD PRIMARY KEY (`vehical_no`),
  ADD KEY `cus_id` (`cus_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT for table `invoice_items`
--
ALTER TABLE `invoice_items`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `fk_appointment_vehicle` FOREIGN KEY (`vehical_no`) REFERENCES `vehical_table` (`vehical_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bay_table`
--
ALTER TABLE `bay_table`
  ADD CONSTRAINT `fk_bay_vehicle` FOREIGN KEY (`vehicle_no`) REFERENCES `vehical_table` (`vehical_no`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `fk_invoice_job` FOREIGN KEY (`job_id`) REFERENCES `job_table` (`job_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `invoice_items`
--
ALTER TABLE `invoice_items`
  ADD CONSTRAINT `fk_items_inventory` FOREIGN KEY (`item_id`) REFERENCES `inventory` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_items_invoice` FOREIGN KEY (`inv_id`) REFERENCES `invoice` (`inv_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `job_services`
--
ALTER TABLE `job_services`
  ADD CONSTRAINT `fk_js_job` FOREIGN KEY (`job_id`) REFERENCES `job_table` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_js_service` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `job_table`
--
ALTER TABLE `job_table`
  ADD CONSTRAINT `fk_job_bay` FOREIGN KEY (`bay_id`) REFERENCES `bay_table` (`bay_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_job_technician` FOREIGN KEY (`tech_id`) REFERENCES `technician` (`tech_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_job_vehicle` FOREIGN KEY (`vehicle_no`) REFERENCES `vehical_table` (`vehical_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vehical_table`
--
ALTER TABLE `vehical_table`
  ADD CONSTRAINT `fk_vehicle_customer` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
