-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2019 at 02:00 AM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tictactoegame`
--

-- --------------------------------------------------------

--
-- Table structure for table `board`
--

CREATE TABLE `board` (
  `id` int(11) NOT NULL,
  `val1` varchar(11) NOT NULL,
  `val2` varchar(11) NOT NULL,
  `val3` varchar(11) NOT NULL,
  `val4` varchar(11) NOT NULL,
  `val5` varchar(11) NOT NULL,
  `val6` varchar(11) NOT NULL,
  `val7` varchar(11) NOT NULL,
  `val8` varchar(11) NOT NULL,
  `val9` varchar(11) NOT NULL,
  `gamename` varchar(255) NOT NULL,
  `creator` varchar(255) NOT NULL,
  `oponent` varchar(255) NOT NULL,
  `winner` varchar(255) NOT NULL,
  `playerid_1` int(255) NOT NULL,
  `playerid_2` int(255) NOT NULL,
  `cell1` varchar(255) NOT NULL,
  `cell2` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `board`
--

INSERT INTO `board` (`id`, `val1`, `val2`, `val3`, `val4`, `val5`, `val6`, `val7`, `val8`, `val9`, `gamename`, `creator`, `oponent`, `winner`, `playerid_1`, `playerid_2`, `cell1`, `cell2`) VALUES
(1, 'X', 'O', 'O', '-', 'X', '-', '-', '-', 'X', 'Test Room', 'darwin1234', 'justin', 'darwin1234', 1, 2, 'X', 'O'),
(2, 'O', 'O', 'O', '-', 'X', '-', '-', '-', 'X', 'tictactoe2', 'justin', 'darwin1234', 'justin', 2, 1, 'O', 'X'),
(3, 'X', 'X', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'draw', 'darwin1234', 'justin', 'darwin1234', 1, 2, 'X', 'O'),
(4, 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'draw2', 'darwin1234', 'justin', 'Not Yet Started!', 1, 2, 'X', 'O');

-- --------------------------------------------------------

--
-- Table structure for table `tictactoe_table`
--

CREATE TABLE `tictactoe_table` (
  `id` int(11) NOT NULL,
  `string` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tictactoe_table`
--

INSERT INTO `tictactoe_table` (`id`, `string`) VALUES
(1, 'adaadadsasd');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `playername` varchar(255) NOT NULL,
  `win` int(11) NOT NULL,
  `lost` int(11) NOT NULL,
  `draw` int(11) NOT NULL,
  `cell` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `firstname`, `lastname`, `playername`, `win`, `lost`, `draw`, `cell`) VALUES
(1, 'darwin1234', 'donmock123', 'Darwin', 'Sese', 'darwin1234', 11, 0, 0, 'X'),
(2, 'justin1234', 'donmock123', 'Justin', 'Domingo', 'justin', 12, 0, 0, 'O');

-- --------------------------------------------------------

--
-- Table structure for table `winner`
--

CREATE TABLE `winner` (
  `id` int(11) NOT NULL,
  `playername` varchar(255) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tictactoe_table`
--
ALTER TABLE `tictactoe_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `board`
--
ALTER TABLE `board`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tictactoe_table`
--
ALTER TABLE `tictactoe_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
