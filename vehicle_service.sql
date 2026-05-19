-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2026 at 04:13 AM
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
-- Database: `vehical_service`
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
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
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
('BAY-01', 'Service Bay 01', 'Available', NULL, '2026-05-19 01:38:23'),
('BAY-02', 'Service Bay 02', 'Available', NULL, '2026-05-19 01:38:23'),
('BAY-03', 'Service Bay 03', 'Available', NULL, '2026-05-19 01:38:23'),
('BAY-04', 'Service Bay 04', 'Available', NULL, '2026-05-19 01:38:23'),
('BAY-05', 'Service Bay 05', 'Available', NULL, '2026-05-19 01:38:23'),
('BAY-06', 'Service Bay 06', 'Available', NULL, '2026-05-19 01:38:23');

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

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `item_id` int(11) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `qty` int(3) NOT NULL,
  `unit_price` int(10) NOT NULL,
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `inv_id` int(3) NOT NULL,
  `job_id` varchar(20) DEFAULT NULL,
  `date` date NOT NULL,
  `total_amount` int(10) NOT NULL,
  `discount` int(10) NOT NULL DEFAULT 0,
  `net_amount` int(10) NOT NULL,
  `payment_status` varchar(20) NOT NULL DEFAULT 'Pending',
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoice_items`
--

CREATE TABLE `invoice_items` (
  `id` int(4) NOT NULL,
  `inv_id` int(3) NOT NULL,
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
  `id` int(11) NOT NULL,
  `job_id` varchar(20) NOT NULL,
  `service_id` varchar(20) NOT NULL,
  `price` int(10) NOT NULL,
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `job_table`
--

CREATE TABLE `job_table` (
  `job_id` varchar(20) NOT NULL,
  `vehicle_no` varchar(30) NOT NULL,
  `bay_id` varchar(20) NOT NULL,
  `tech_id` varchar(20) NOT NULL,
  `odometer_reading` varchar(10) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `total_amount` decimal(10,2) NOT NULL DEFAULT 0.00,
  `status` varchar(20) NOT NULL DEFAULT 'Ongoing',
  `recorded_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
('TECH-01', 'Sunil Perera', '198512345678', 771234567, 'Hybrid & Engine Tuning', 'Available', '2026-05-19 01:40:46'),
('TECH-02', 'Kamal Silva', '199087654321', 719876543, 'Wheel Alignment & Suspension', 'Available', '2026-05-19 01:40:46'),
('TECH-03', 'Nimal Fernando', '199345678912', 754567890, 'Auto Electrical & Air Conditioning', 'Available', '2026-05-19 01:40:46');

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
(2, 'Dama', 'dama', 'dama@gmail.com', '123456789', 'admin123', 'admin123', 'admin', 0, '2026-05-16 16:13:18'),
(3, 'Dewmina', 'dew', 'dewmina@gmail.com', '111111111111', 'dew@123', 'dew@123', 'user', 0, '2026-05-16 16:14:19');

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
  `color` varchar(50) NOT NULL,
  `make_year` year(4) NOT NULL,
  `cus_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `job_id` (`job_id`),
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
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `inv_id` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoice_items`
--
ALTER TABLE `invoice_items`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `job_services`
--
ALTER TABLE `job_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
