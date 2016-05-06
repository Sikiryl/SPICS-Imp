-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2016 at 12:05 PM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spics`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `cartID` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `userID` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `latestUpdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `line_item`
--

CREATE TABLE IF NOT EXISTS `line_item` (
  `lineItemNo` int(11) NOT NULL,
  `productID` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `cartID` varchar(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `productID` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `productName` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `productType` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `price` double NOT NULL,
  `detail` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `picture` varchar(1000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `productName`, `productType`, `price`, `detail`, `picture`) VALUES
('P0001', 'Sevenlight O.T.S women wristwatch WP8139 (Black/White)', 'Watch', 149, 'Property\r\nWatch Sevenlight O.T.S chic, beautiful materials, good quality waterproof to 100% can be immersed in water.\r\n1. Waterproof 100% (very water resistance).\r\n2. Housing stainless Steel. Leather PU.\r\n3. Dial width 4.0 cm\r\n4. Excellent quality', '<a href="http://www.zabzaa.com/uppic/is/20160504_212205.png" target="_blank"><img border="0" src="http://www.zabzaa.com/uppic/ts/20160504_212205.png"></a>'),
('P0002', 'YAMAHA Acoustic Guitar F310 TBS', 'Music', 5490, 'Property\r\n- Made of high quality material\r\n- Confidence in the brand product brands.\r\n- Sound quality', '<a href="http://www.zabzaa.com/uppic/il/20160504_214807.png" target="_blank"><img border="0" src="http://www.zabzaa.com/uppic/tl/20160504_214807.png"></a>'),
('P0003', 'Hakone 6 layers shoe rack', 'Home', 459, NULL, '<a href="http://www.zabzaa.com/uppic/in/20160504_215659.png" target="_blank"><img border="0" src="http://www.zabzaa.com/uppic/tn/20160504_215659.png"></a>');

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE IF NOT EXISTS `promotion` (
  `promotionID` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `productID` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `promotionDetail` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `percentageDiscount` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`promotionID`, `productID`, `promotionDetail`, `percentageDiscount`, `startDate`, `endDate`) VALUES
('PM001', 'P0002', NULL, 10, '2016-05-04', '2016-07-04');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userID` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `firstName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `userType` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DOB` date NOT NULL,
  `address` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `IDcard` varchar(17) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bankAccount` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `firstName`, `lastName`, `userType`, `username`, `password`, `email`, `phone`, `gender`, `DOB`, `address`, `IDcard`, `bankAccount`) VALUES
('U0001', 'Hello', 'World', 'Purchaser', 'admin', 'test1234', 'cpe@kmutt.ac.th', '081-234-5678', 'Male', '1994-05-04', 'CPE KMUTT, Bangkok, Thailand, 10140', '1 2345 67890 12 3', '123-4-5678-90');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `line_item`
--
ALTER TABLE `line_item`
  ADD PRIMARY KEY (`lineItemNo`),
  ADD KEY `productID` (`productID`),
  ADD KEY `cartID` (`cartID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`promotionID`),
  ADD KEY `productID` (`productID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `line_item`
--
ALTER TABLE `line_item`
  MODIFY `lineItemNo` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `line_item`
--
ALTER TABLE `line_item`
  ADD CONSTRAINT `line_item_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`),
  ADD CONSTRAINT `line_item_ibfk_2` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`);

--
-- Constraints for table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `promotion_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
