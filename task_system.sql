-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2022 at 05:14 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `announcements`
--

CREATE TABLE `announcements` (
  `announcement_id` int(11) NOT NULL,
  `educatorID` int(11) NOT NULL,
  `announcement` varchar(500) NOT NULL,
  `datePosted` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `announcements`
--

INSERT INTO `announcements` (`announcement_id`, `educatorID`, `announcement`, `datePosted`) VALUES
(8, 4, 'Good evening, everyone. Meeting at courtyard', '2022-12-17');

-- --------------------------------------------------------

--
-- Table structure for table `educators_info`
--

CREATE TABLE `educators_info` (
  `educator_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` varchar(255) NOT NULL,
  `age` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `educators_info`
--

INSERT INTO `educators_info` (`educator_id`, `first_name`, `last_name`, `birthdate`, `age`, `sex`, `address`, `email`, `password`) VALUES
(4, 'Michelle', 'Maglapus', '2001-10-05', '21', 'Female', 'Medellin, Cebu', 'mgmaglapus@gmail.com', 'mich123'),
(7, 'Soseit', 'Bedoria', '10-07-2001', '21', 'Female', 'Dalaguete, Cebu', 'soseit.bedoria@passerellesnumeriques.org', 'soseit123'),
(9, 'Junnalyn ', 'Bedoria', '15-12-2000', '23', 'Female', 'Mindanao', 'junnalyn.doning@passerellesnumeriques.org', 'doning123'),
(10, 'Alyssa', 'Cazarte', '04-12-2001', '20', 'Female', 'Manlapay', 'cazarte@gmail.com', 'cazarte123');

-- --------------------------------------------------------

--
-- Table structure for table `scholars_info`
--

CREATE TABLE `scholars_info` (
  `scholar_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` varchar(255) NOT NULL,
  `age` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `batch_year` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scholars_info`
--

INSERT INTO `scholars_info` (`scholar_id`, `first_name`, `last_name`, `birthdate`, `age`, `sex`, `batch_year`, `address`, `email`, `password`) VALUES
(3, 'Soseit', 'Bedoria', '03-04-2001', '21', 'Female', '2001', 'Manlapay', 'soseit@', '123'),
(5, 'Michelle', 'Maglapus', '05-10-2001', '21', 'Female', '2023', 'Medillin, Cebu', 'michelle.maglapus@student.passerellesnumeriques.org', 'michyy'),
(6, 'Jan Nino', 'Baoc', '13-12-2002', '21', 'Male', 'Bantayan', '2023', 'baoc@gmail.com', 'baoc123'),
(7, 'Hannah', 'Cagaanan', '07-07-2001', '21', 'Female', 'Cebu', '2023', 'hannahcagaanan@gmail.com', 'baddnana12898');

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `taskID` int(11) NOT NULL,
  `educatorID` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `completed` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `dateStarted` date NOT NULL DEFAULT current_timestamp(),
  `dueDate` varchar(250) NOT NULL,
  `scholar_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`taskID`, `educatorID`, `title`, `status`, `completed`, `description`, `dateStarted`, `dueDate`, `scholar_id`) VALUES
(15, 7, 'edit1', 'Minor Task', 'yes', 'edit1 hehe', '2022-12-16', '17-12-2022', NULL),
(17, 7, 'new task 3', 'Major Task', 'Not Yet', 'edited ehe', '2022-12-16', '18-12-2022', NULL),
(19, 4, 'new task for all from mich2', 'Minor Task', 'yes', 'new desc for all from mich1', '2022-12-16', '17-12-2022', 5),
(22, 4, 'new task for only one', 'Minor Task', 'yes', 'akshdmjsehvdhje', '2022-12-17', '18-12-2022', 5),
(23, 4, 'task for all ni', 'Minor Task', 'Not Yet', 'this a description', '2022-12-17', '19-12-2022', NULL),
(24, 4, 'new task para kang michelle', 'Major Task', 'yes', 'akjbdjhg hdbjh', '2022-12-17', '18-12-2022', 5),
(25, 4, 'task 1', 'Major Task', 'yes', 'task for tomorrow', '2022-12-17', '19-12-2022', 5),
(26, 4, 'task no. 1', 'Minor Task', 'Not Yet', 'etc  skjdkjbfe', '2022-12-17', '18-12-2022', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`announcement_id`),
  ADD KEY `educatorID` (`educatorID`);

--
-- Indexes for table `educators_info`
--
ALTER TABLE `educators_info`
  ADD PRIMARY KEY (`educator_id`);

--
-- Indexes for table `scholars_info`
--
ALTER TABLE `scholars_info`
  ADD PRIMARY KEY (`scholar_id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`taskID`),
  ADD KEY `educatorID` (`educatorID`,`scholar_id`),
  ADD KEY `scholar_id` (`scholar_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `announcements`
--
ALTER TABLE `announcements`
  MODIFY `announcement_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `educators_info`
--
ALTER TABLE `educators_info`
  MODIFY `educator_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `scholars_info`
--
ALTER TABLE `scholars_info`
  MODIFY `scholar_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `taskID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `announcements`
--
ALTER TABLE `announcements`
  ADD CONSTRAINT `announcements_ibfk_1` FOREIGN KEY (`educatorID`) REFERENCES `educators_info` (`educator_id`);

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`educatorID`) REFERENCES `educators_info` (`educator_id`),
  ADD CONSTRAINT `tasks_ibfk_2` FOREIGN KEY (`scholar_id`) REFERENCES `scholars_info` (`scholar_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
