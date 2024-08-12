-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2024 at 10:52 AM
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
-- Database: `medicationdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(45) NOT NULL,
  `contact` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `patient_weight` double NOT NULL,
  `patient_height` double NOT NULL,
  `body_mass_index(kg/m^2)` double NOT NULL,
  `BMI_Category` varchar(45) NOT NULL,
  `body_surface_area(m^2)` double NOT NULL,
  `cardiac_output` double NOT NULL,
  `cardiac_index(liters/minute/m^2)` double NOT NULL,
  `drug_name` varchar(45) NOT NULL,
  `drug_dosage(mg)` int(11) NOT NULL,
  `medication_dosage(mg)` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`patient_id`, `patient_name`, `contact`, `email`, `patient_weight`, `patient_height`, `body_mass_index(kg/m^2)`, `BMI_Category`, `body_surface_area(m^2)`, `cardiac_output`, `cardiac_index(liters/minute/m^2)`, `drug_name`, `drug_dosage(mg)`, `medication_dosage(mg)`) VALUES
(1, 'mitra', '9390083317', 'sai@gmail.com', 18.14, 0.81, 27.648224356043283, 'Over-Weight', 0.6388661831714056, 4, 6.261092080572394, 'crocin', 500, 184.64340554086868),
(2, 'luffy', '0123456789', 'luffy@gmail.com', 20.25, 1.02, 19.463667820069205, 'Healthy', 0.7574628703771559, 5, 6.600983619844495, 'Dolo', 650, 284.59587615326666),
(3, 'zoro', '2345678901', 'zoro@gmail.com', 25.24, 1.25, 16.153599999999997, 'Under-Weight', 0.9361564446655746, 6, 6.409185167916453, 'paracetamol', 300, 162.33926786108228),
(4, 'sanji', '1234765809', 'sanji@gmail.com', 30.4, 1.35, 16.68038408779149, 'Under-Weight', 1.0677078252031311, 4, 3.746343246326776, 'Dolo', 325, 200.58094982139747),
(5, 'chopper', '4567890123', 'chopper@gmail.com', 45.6, 0.81, 69.50160036579788, 'Obesity', 1.012916580968048, 5, 4.9362406479924354, 'L DoFor', 2, 1.171001827708726);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`patient_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `patient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
