-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2017 at 09:39 AM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resiowl`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('riyamittal', 'riyamittal');

-- --------------------------------------------------------

--
-- Table structure for table `flat`
--

CREATE TABLE `flat` (
  `id` int(11) NOT NULL,
  `category` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `plot` varchar(255) NOT NULL,
  `colony` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `landmark` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `amenities` varchar(255) NOT NULL,
  `rent` varchar(255) NOT NULL,
  `security_deposit` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `hospital` varchar(255) NOT NULL,
  `mall` varchar(255) NOT NULL,
  `grocery_store` varchar(255) NOT NULL,
  `tranport` varchar(255) NOT NULL,
  `restaurant` varchar(255) NOT NULL,
  `created` datetime(6) NOT NULL,
  `modified` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat`
--

INSERT INTO `flat` (`id`, `category`, `name`, `plot`, `colony`, `street`, `landmark`, `city`, `state`, `zipcode`, `type`, `gender`, `amenities`, `rent`, `security_deposit`, `description`, `hospital`, `mall`, `grocery_store`, `tranport`, `restaurant`, `created`, `modified`) VALUES
(1, '0', 'rukfhkjdfhkj', '22', 'jagatpura', 'hfjdsfhrggtd', 'jdfshefgh', 'jaipur', 'rajasthan', '302017', '0', '0', 'asdf', '5000', '23455', 'djskfljsl kldksfjlk jkfj kldjkl jklj kdj kljk jk jklfj ljf lj l jkd jkdj lj ldsj ljkd jkld jklj kljkdlj skjhdsui sdh jksdh kjh h dh jdsh akhf hjjk hjkh djskfljsl kldksfjlk jkfj kldjk', '2', '3', '4', '5', '6', '2017-08-15 00:00:00.000000', '2017-08-04 00:00:00.000000'),
(2, '0', 'rukfhkjdfhkj', '23', 'jagatpura', 'hfjdsfhrggtd', 'jdfshefgh', 'jaipur', 'rajasthan', '302017', '1', '1', 'asdf ddfj', '1234', '1345', 'djskfljsl kldksfjlk jkfj kldjkl jklj kdj kljk jk jklfj ljf lj l jkd jkdj lj ldsj ljkd jkld jklj kljkdlj skjhdsui sdh jksdh kjh h dh jdsh akhf hjjk hjkh djskfljsl kldksfjlk jkfj kldjk', '2', '3', '4', '5', '6', '2017-08-15 00:00:00.000000', '2017-08-04 00:00:00.000000'),
(3, '0', 'rukfhkjdfhkj', '12', 'jagatpura', 'hfjdsfhrggtd', 'jdfshefgh', 'jaipur', 'rajasthan', '302017', '0', '0', 'asdf', '7000', '2345', 'djskfljsl kldksfjlk jkfj kldjkl jklj kdj kljk jk jklfj ljf lj l jkd jkdj lj ldsj ljkd jkld jklj kljkdlj skjhdsui sdh jksdh kjh h dh jdsh akhf hjjk hjkh djskfljsl kldksfjlk jkfj kldjk', '2', '3', '4', '5', '6', '2017-08-15 00:00:00.000000', '2017-08-04 00:00:00.000000');

-- --------------------------------------------------------

--
-- Table structure for table `home_form`
--

CREATE TABLE `home_form` (
  `contact_info` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `about` varchar(255) NOT NULL,
  `timing` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `home_form`
--

INSERT INTO `home_form` (`contact_info`, `email`, `about`, `timing`, `address`) VALUES
('+91 9782154684', 'support@resiowl.com', 'Our company aims at providing the best place to live or rent for our customers.', 'Monday-Sunday 9AM-9PM', 'Fiends colony jaipur, INDIA');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `usertype` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `email`, `password`, `usertype`) VALUES
(1, 'riyamittal34@gmail.com', 'riya', '0');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `oid` int(11) NOT NULL,
  `hostels` varchar(255) NOT NULL,
  `created` datetime(6) NOT NULL,
  `modified` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone1` varchar(255) NOT NULL,
  `phone2` varchar(255) NOT NULL,
  `usertype` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `created` datetime(6) NOT NULL,
  `modified` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `email`, `password`, `phone1`, `phone2`, `usertype`, `gender`, `created`, `modified`) VALUES
(1, 'riya', 'riyamittal', 'riyamittal34', '2354', '12345667', '23456789', 'owner', 'female', '2017-08-16 00:00:00.000000', '2017-08-18 00:00:00.000000'),
(2, 'riya mittal', 'riyamittal34', 'riyamittal@gmail.com', 'asdf', '8946900955', '8769321211', '1', 'f', '2017-08-23 12:42:28.000000', '2017-08-23 12:42:28.000000'),
(3, ' ', '', '', '', '', '', '', '', '2017-08-23 13:22:01.000000', '2017-08-23 13:22:01.000000'),
(4, ' ', '', '', '', '', '', '', '', '2017-08-25 15:00:27.000000', '2017-08-25 15:00:27.000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flat`
--
ALTER TABLE `flat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`oid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `flat`
--
ALTER TABLE `flat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `profile`
--
ALTER TABLE `profile`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
