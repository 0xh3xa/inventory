-- phpMyAdmin SQL Dump
-- version 4.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 19, 2015 at 05:13 AM
-- Server version: 5.5.41-MariaDB
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `store`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE IF NOT EXISTS `branch` (
  `id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`id`, `supplier_id`, `city_id`, `name`, `address`) VALUES
(76, 62, 3, 'pts', 'pts'),
(78, 62, 3, 'tst', 'tst'),
(87, 62, 3, 'yala', 'yala'),
(88, 63, 3, 'bbc', 'bbc');

-- --------------------------------------------------------

--
-- Table structure for table `catogery`
--

CREATE TABLE IF NOT EXISTS `catogery` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catogery`
--

INSERT INTO `catogery` (`id`, `name`) VALUES
(2, 'apple'),
(3, 'sumsung'),
(4, 'sony');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `name`) VALUES
(3, 'alex'),
(4, 'man');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `total_price` decimal(10,0) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `name`, `total_price`, `date`) VALUES
(1, 'abu raya', 250, '2015-02-17');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE IF NOT EXISTS `log` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `user_id`, `start_time`, `end_time`, `date`) VALUES
(1, 1, '02:28:20', NULL, '2015-01-16'),
(2, 1, '02:29:31', NULL, '2015-01-16'),
(3, 1, '02:35:16', NULL, '2015-01-16'),
(4, 8, '02:42:37', '03:10:31', '2015-01-16'),
(5, 8, '03:10:15', '03:10:31', '2015-01-16'),
(6, 8, '04:02:30', '05:32:15', '2015-01-16'),
(7, 8, '04:03:30', '05:32:15', '2015-01-16'),
(8, 8, '04:04:31', '05:32:15', '2015-01-16'),
(9, 8, '04:05:08', '05:32:15', '2015-01-16'),
(10, 8, '04:06:23', '05:32:15', '2015-01-16'),
(11, 8, '04:07:38', '05:32:15', '2015-01-16'),
(12, 8, '04:08:28', '05:32:15', '2015-01-16'),
(13, 8, '04:10:48', '05:32:15', '2015-01-16'),
(14, 8, '04:11:59', '05:32:15', '2015-01-16'),
(15, 8, '04:28:03', '05:32:15', '2015-01-16'),
(16, 9, '04:29:26', NULL, '2015-01-16'),
(17, 8, '05:01:44', '05:32:15', '2015-01-16'),
(18, 8, '05:03:33', '05:32:15', '2015-01-16'),
(19, 8, '05:04:53', '05:32:15', '2015-01-16'),
(20, 8, '05:06:21', '05:32:15', '2015-01-16'),
(21, 8, '05:06:49', '05:32:15', '2015-01-16'),
(22, 8, '05:11:56', '05:32:15', '2015-01-16'),
(23, 8, '05:12:26', '05:32:15', '2015-01-16'),
(24, 8, '05:21:24', '05:32:15', '2015-01-16'),
(25, 8, '05:22:54', '05:32:15', '2015-01-16'),
(26, 8, '05:23:25', '05:32:15', '2015-01-16'),
(27, 8, '05:24:35', '05:32:15', '2015-01-16'),
(28, 8, '05:28:21', '05:32:15', '2015-01-16'),
(29, 8, '05:28:48', '05:32:15', '2015-01-16'),
(30, 8, '05:29:19', '05:32:15', '2015-01-16'),
(31, 8, '05:29:44', '05:32:15', '2015-01-16'),
(32, 8, '05:30:58', '05:32:15', '2015-01-16'),
(33, 8, '05:31:52', '05:32:15', '2015-01-16'),
(34, 8, '05:35:12', '05:35:23', '2015-01-16'),
(35, 8, '05:36:26', '05:38:38', '2015-01-16'),
(36, 8, '05:37:12', '05:38:38', '2015-01-16'),
(37, 8, '05:37:33', '05:38:38', '2015-01-16'),
(38, 8, '05:38:12', '05:38:38', '2015-01-16'),
(39, 8, '05:38:55', '05:39:13', '2015-01-16'),
(40, 8, '05:39:11', '05:39:13', '2015-01-16'),
(41, 8, '05:39:40', '05:39:43', '2015-01-16'),
(42, 8, '05:40:09', '05:40:13', '2015-01-16'),
(43, 8, '05:40:36', '12:11:26', '2015-01-16'),
(44, 8, '05:41:26', '12:11:26', '2015-01-16'),
(45, 8, '05:43:08', '12:11:26', '2015-01-16'),
(46, 8, '07:44:53', '12:11:26', '2015-01-16'),
(47, 8, '12:51:02', '12:11:26', '2015-01-17'),
(48, 8, '01:20:26', '12:11:26', '2015-01-17'),
(49, 8, '01:23:39', '12:11:26', '2015-01-17'),
(50, 8, '01:24:30', '12:11:26', '2015-01-17'),
(51, 8, '01:25:13', '12:11:26', '2015-01-17'),
(52, 8, '01:26:13', '12:11:26', '2015-01-17'),
(53, 8, '01:26:47', '12:11:26', '2015-01-17'),
(54, 8, '01:30:03', '12:11:26', '2015-01-17'),
(55, 8, '01:30:50', '12:11:26', '2015-01-17'),
(56, 8, '01:36:08', '12:11:26', '2015-01-17'),
(57, 8, '01:36:50', '12:11:26', '2015-01-17'),
(58, 8, '01:37:37', '12:11:26', '2015-01-17'),
(59, 8, '01:37:48', '12:11:26', '2015-01-17'),
(60, 8, '01:38:14', '12:11:26', '2015-01-17'),
(61, 8, '01:39:14', '12:11:26', '2015-01-17'),
(62, 8, '01:39:52', '12:11:26', '2015-01-17'),
(63, 8, '02:11:40', '12:11:26', '2015-01-17'),
(64, 8, '02:11:49', '12:11:26', '2015-01-17'),
(65, 8, '02:19:33', '12:11:26', '2015-01-17'),
(66, 8, '02:20:52', '12:11:26', '2015-01-17'),
(67, 8, '02:21:26', '12:11:26', '2015-01-17'),
(68, 8, '02:22:29', '12:11:26', '2015-01-17'),
(69, 8, '02:24:09', '12:11:26', '2015-01-17'),
(70, 8, '02:25:42', '12:11:26', '2015-01-17'),
(71, 8, '02:27:10', '12:11:26', '2015-01-17'),
(72, 8, '02:28:16', '12:11:26', '2015-01-17'),
(73, 8, '02:29:46', '12:11:26', '2015-01-17'),
(74, 8, '02:32:17', '12:11:26', '2015-01-17'),
(75, 8, '02:32:52', '12:11:26', '2015-01-17'),
(76, 8, '02:34:01', '12:11:26', '2015-01-17'),
(77, 8, '02:35:11', '12:11:26', '2015-01-17'),
(78, 8, '02:37:28', '12:11:26', '2015-01-17'),
(79, 8, '02:38:05', '12:11:26', '2015-01-17'),
(80, 8, '11:01:27', '12:11:26', '2015-01-17'),
(81, 8, '11:14:41', '12:11:26', '2015-01-17'),
(82, 8, '11:19:05', '12:11:26', '2015-01-17'),
(83, 8, '11:20:24', '12:11:26', '2015-01-17'),
(84, 8, '11:21:00', '12:11:26', '2015-01-17'),
(85, 8, '11:22:33', '12:11:26', '2015-01-17'),
(86, 8, '11:25:14', '12:11:26', '2015-01-17'),
(87, 8, '11:26:20', '12:11:26', '2015-01-17'),
(88, 8, '11:27:43', '12:11:26', '2015-01-17'),
(89, 8, '11:28:16', '12:11:26', '2015-01-17'),
(90, 8, '11:34:08', '12:11:26', '2015-01-17'),
(91, 8, '11:34:56', '12:11:26', '2015-01-17'),
(92, 8, '11:37:06', '12:11:26', '2015-01-17'),
(93, 8, '11:39:19', '12:11:26', '2015-01-17'),
(94, 8, '11:40:03', '12:11:26', '2015-01-17'),
(95, 8, '12:04:11', '12:11:26', '2015-01-17'),
(96, 8, '12:05:05', '12:11:26', '2015-01-17'),
(97, 8, '12:06:59', '12:11:26', '2015-01-17'),
(98, 8, '12:08:00', '12:11:26', '2015-01-17'),
(99, 8, '12:08:48', '12:11:26', '2015-01-17'),
(100, 8, '12:09:47', '12:11:26', '2015-01-17'),
(101, 8, '12:10:39', '12:11:26', '2015-01-17'),
(102, 8, '12:22:52', '02:11:09', '2015-01-17'),
(103, 8, '12:26:22', '02:11:09', '2015-01-17'),
(104, 8, '12:26:47', '02:11:09', '2015-01-17'),
(105, 8, '01:37:28', '02:11:09', '2015-01-17'),
(106, 8, '01:38:17', '02:11:09', '2015-01-17'),
(107, 8, '01:40:17', '02:11:09', '2015-01-17'),
(108, 8, '01:41:18', '02:11:09', '2015-01-17'),
(109, 8, '01:41:58', '02:11:09', '2015-01-17'),
(110, 8, '01:43:16', '02:11:09', '2015-01-17'),
(111, 8, '01:44:42', '02:11:09', '2015-01-17'),
(112, 8, '01:45:33', '02:11:09', '2015-01-17'),
(113, 8, '01:46:16', '02:11:09', '2015-01-17'),
(114, 8, '01:47:13', '02:11:09', '2015-01-17'),
(115, 8, '01:47:25', '02:11:09', '2015-01-17'),
(116, 8, '01:48:58', '02:11:09', '2015-01-17'),
(117, 8, '01:50:10', '02:11:09', '2015-01-17'),
(118, 8, '01:51:07', '02:11:09', '2015-01-17'),
(119, 8, '01:51:30', '02:11:09', '2015-01-17'),
(120, 8, '01:53:45', '02:11:09', '2015-01-17'),
(121, 8, '01:55:11', '02:11:09', '2015-01-17'),
(122, 8, '01:56:34', '02:11:09', '2015-01-17'),
(123, 8, '01:59:43', '02:11:09', '2015-01-17'),
(124, 8, '02:00:57', '02:11:09', '2015-01-17'),
(125, 8, '02:02:43', '02:11:09', '2015-01-17'),
(126, 8, '02:03:16', '02:11:09', '2015-01-17'),
(127, 8, '02:04:26', '02:11:09', '2015-01-17'),
(128, 8, '02:04:58', '02:11:09', '2015-01-17'),
(129, 8, '02:06:29', '02:11:09', '2015-01-17'),
(130, 8, '02:07:06', '02:11:09', '2015-01-17'),
(131, 8, '02:08:07', '02:11:09', '2015-01-17'),
(132, 8, '02:10:10', '02:11:09', '2015-01-17'),
(133, 8, '02:12:18', '02:11:09', '2015-01-17'),
(134, 8, '02:12:55', '02:11:09', '2015-01-17'),
(135, 8, '02:13:25', '02:11:09', '2015-01-17'),
(136, 8, '02:13:55', '02:11:09', '2015-01-17'),
(137, 8, '02:14:36', '02:11:09', '2015-01-17'),
(138, 8, '02:15:24', '02:11:09', '2015-01-17'),
(139, 8, '02:16:11', '02:11:09', '2015-01-17'),
(140, 8, '02:16:54', '02:11:09', '2015-01-17'),
(141, 8, '02:18:49', '02:11:09', '2015-01-17'),
(142, 8, '02:19:10', '02:11:09', '2015-01-17'),
(143, 8, '02:21:33', '02:11:09', '2015-01-17'),
(144, 8, '02:22:17', '02:11:09', '2015-01-17'),
(145, 8, '02:22:55', '02:11:09', '2015-01-17'),
(146, 8, '02:23:45', '02:11:09', '2015-01-17'),
(147, 8, '02:24:51', '02:11:09', '2015-01-17'),
(148, 8, '02:26:08', '02:11:09', '2015-01-17'),
(149, 8, '02:26:36', '02:11:09', '2015-01-17'),
(150, 8, '03:02:14', '02:11:09', '2015-01-17'),
(151, 8, '11:58:35', '02:11:09', '2015-01-17'),
(152, 8, '11:59:17', '02:11:09', '2015-01-17'),
(153, 8, '12:00:35', '02:11:09', '2015-01-18'),
(154, 8, '12:04:55', '02:11:09', '2015-01-18'),
(155, 8, '12:05:09', '02:11:09', '2015-01-18'),
(156, 8, '12:05:43', '02:11:09', '2015-01-18'),
(157, 8, '12:06:05', '02:11:09', '2015-01-18'),
(158, 8, '12:06:22', '02:11:09', '2015-01-18'),
(159, 8, '12:07:33', '02:11:09', '2015-01-18'),
(160, 8, '12:09:14', '02:11:09', '2015-01-18');

-- --------------------------------------------------------

--
-- Table structure for table `orderT`
--

CREATE TABLE IF NOT EXISTS `orderT` (
  `id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `total_price` decimal(10,0) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderT`
--

INSERT INTO `orderT` (`id`, `supplier_id`, `name`, `total_price`, `date`) VALUES
(2, 62, 'testing', 4500, '2015-02-18'),
(6, 62, 'testing3', 450, '2015-02-18'),
(7, 62, 'testing4', 0, '2015-02-18'),
(8, 62, 'testing4', 0, '2015-02-18'),
(9, 62, 'testing5', 0, '2015-02-18'),
(10, 62, 'testing5', 225, '2015-02-18'),
(11, 62, 'testing6', 0, '2015-02-18'),
(12, 62, 'testing6', 225, '2015-02-18'),
(13, 62, 'testing', 0, '2015-02-18'),
(14, 62, 'testing', 225, '2015-02-18'),
(15, 62, 'testing7', 0, '2015-02-18'),
(16, 62, 'testing7', 675, '2015-02-18'),
(17, 62, 'testing88', 0, '2015-02-18'),
(18, 62, 'testing88', 450, '2015-02-18'),
(19, 62, 'testing10', 0, '2015-02-18'),
(20, 62, 'testing10', 450, '2015-06-18'),
(21, 62, 'tetsing11', 0, '2015-02-18'),
(22, 62, 'tetsing11', 675, '2015-02-18'),
(23, 62, 'ttet', 0, '2015-02-18'),
(24, 62, 'ttet', 225, '2015-09-18'),
(25, 62, 'et', 0, '2015-02-18'),
(26, 62, 'et', 450, '2015-02-18'),
(27, 62, 'qw', 0, '2015-02-18'),
(28, 62, 'qw', 450, '2015-02-18'),
(29, 62, 'ete', 0, '2015-02-18'),
(30, 62, 'ete', 450, '2015-12-18'),
(31, 62, 'tetstg', 0, '2015-02-18'),
(32, 62, 'tetstg', 450, '2015-02-18'),
(33, 62, 'sere', 0, '2015-02-18'),
(34, 62, 'sere', 450, '2015-02-18'),
(35, 62, 'erwe', 0, '2015-02-18'),
(36, 62, 'erwe', 450, '2015-02-18'),
(37, 62, 'testing22', 0, '2015-02-18'),
(38, 62, 'testing22', 450, '2015-02-18'),
(39, 62, 'testing22', 0, '2015-02-18'),
(40, 62, 'testing22', 450, '2015-02-18'),
(41, 62, 'dafads', 0, '2015-02-18'),
(43, 62, 'dsf', 0, '2015-02-18'),
(45, 62, 'qwqw', 0, '2015-02-18'),
(46, 62, 'qwqw', 2700, '2015-02-18'),
(47, 62, 'we', 0, '2015-02-18');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL,
  `catogery_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `dis_price` decimal(10,0) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `catogery_id`, `supplier_id`, `name`, `quantity`, `price`, `dis_price`) VALUES
(14, 4, 62, 'xperia z1', 627, 225, 225);

-- --------------------------------------------------------

--
-- Table structure for table `sub_invoice`
--

CREATE TABLE IF NOT EXISTS `sub_invoice` (
  `id` int(11) NOT NULL,
  `invoice_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price_item` decimal(10,0) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_invoice`
--

INSERT INTO `sub_invoice` (`id`, `invoice_id`, `product_id`, `quantity`, `price_item`) VALUES
(1, 1, 14, 20, 20);

-- --------------------------------------------------------

--
-- Table structure for table `sub_order`
--

CREATE TABLE IF NOT EXISTS `sub_order` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price_item` decimal(10,0) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_order`
--

INSERT INTO `sub_order` (`id`, `order_id`, `product_id`, `branch_id`, `quantity`, `price_item`) VALUES
(1, 2, 14, 76, 10, 225),
(2, 4, 14, 76, 5, 225);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `phone`, `email`) VALUES
(62, 'tty', '01069507018', 'a@gmail.com'),
(63, 'aa', 'aa', 'aa');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `usertype_id` int(3) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `usertype_id`, `username`, `password`, `email`, `phone`) VALUES
(8, 24, 'root', 'c{PykdHE', 'root', 'root@gmail.com'),
(9, 25, 'toor', '{$?HlN!q', 'toor', 'toor'),
(10, 25, 'mr_null', '7%?d', 'null', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `usertype`
--

CREATE TABLE IF NOT EXISTS `usertype` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `frames` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertype`
--

INSERT INTO `usertype` (`id`, `name`, `frames`) VALUES
(24, 'root', 'supplier,persmission,product,catogary,order,user,invoice'),
(25, 'toor', 'catogary,user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `catogery`
--
ALTER TABLE `catogery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderT`
--
ALTER TABLE `orderT`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_invoice`
--
ALTER TABLE `sub_invoice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_order`
--
ALTER TABLE `sub_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usertype`
--
ALTER TABLE `usertype`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=89;
--
-- AUTO_INCREMENT for table `catogery`
--
ALTER TABLE `catogery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=161;
--
-- AUTO_INCREMENT for table `orderT`
--
ALTER TABLE `orderT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `sub_invoice`
--
ALTER TABLE `sub_invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `sub_order`
--
ALTER TABLE `sub_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=64;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `usertype`
--
ALTER TABLE `usertype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
