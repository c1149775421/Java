-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2021-05-02 23:35:21
-- 服务器版本： 8.0.12
-- PHP 版本： 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `book`
--

-- --------------------------------------------------------

--
-- 表的结构 `t_book`
--

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` decimal(11,2) NOT NULL,
  `author` varchar(100) NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_path` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_book`
--

INSERT INTO `t_book` (`id`, `name`, `price`, `author`, `sales`, `stock`, `img_path`) VALUES
(1, 'java从入门到放弃', '80.00', '国哥', 9999, 9, 'static/img/default.jpg'),
(2, '数据结构与算法', '78.50', '严敏君', 6, 13, 'static/img/default.jpg'),
(3, '怎样拐跑别人的媳妇', '68.00', '龙伍', 100055, 49, 'static/img/default.jpg'),
(4, '台式卤肉饭', '16.00', '小胖', 1054, 46, 'static/img/default.jpg'),
(5, 'C++编程思想', '45.50', '刚哥', 14, 95, 'static/img/default.jpg'),
(6, '蛋炒饭', '9.90', '周星星', 12, 53, 'static/img/default.jpg'),
(7, '赌神', '66.50', '龙伍', 125, 535, 'static/img/default.jpg'),
(8, 'Java编程思想', '99.50', '阳哥', 47, 36, 'static/img/default.jpg'),
(9, 'JavaScript从入门到精通', '9.90', '婷姐', 85, 95, 'static/img/default.jpg'),
(10, 'cocos2d-x游戏编程入门', '49.00', '国哥', 52, 62, 'static/img/default.jpg'),
(11, 'C语言程序设计', '28.00', '谭浩强', 53, 73, 'static/img/default.jpg'),
(12, 'Lua语言程序设计', '51.50', '雷丰阳', 48, 82, 'static/img/default.jpg'),
(13, '西游记', '12.00', '罗贯中', 20, 9998, 'static/img/default.jpg'),
(14, '水浒传', '33.05', '华仔', 23, 87, 'static/img/default.jpg'),
(15, '操作系统原理', '133.05', '刘优', 122, 188, 'static/img/default.jpg'),
(16, '数据结构 java版', '173.15', '封大神', 21, 81, 'static/img/default.jpg'),
(17, 'UNIX高级环境编程', '99.15', '乐天', 210, 810, 'static/img/default.jpg'),
(18, 'javaScript高级编程', '69.15', '国哥', 210, 810, 'static/img/default.jpg'),
(19, '大话设计模式', '89.15', '国哥', 20, 10, 'static/img/default.jpg'),
(20, '人月神话', '88.15', '刚哥', 20, 80, 'static/img/default.jpg'),
(33, '怎样拐跑别人的媳妇', '111.00', '吴伟涛', 17, 45, 'static/img/default.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `t_order`
--

CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_order`
--

INSERT INTO `t_order` (`order_id`, `create_time`, `price`, `status`, `user_id`) VALUES
('16192657818267', '2021-04-24 20:03:01', '555.00', 0, 7),
('16192656589707', '2021-04-24 20:00:58', '111.00', 0, 7),
('161926551508314', '2021-04-24 19:58:35', '89.05', 0, 14);

-- --------------------------------------------------------

--
-- 表的结构 `t_order_item`
--

CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_order_item`
--

INSERT INTO `t_order_item` (`id`, `name`, `count`, `price`, `total_price`, `order_id`) VALUES
(23, '怎样拐跑别人的媳妇', 5, '111.00', '555.00', '16192657818267'),
(22, '怎样拐跑别人的媳妇', 1, '111.00', '111.00', '16192656589707'),
(21, '水浒传', 1, '33.05', '33.05', '161926551508314'),
(20, 'C语言程序设计', 1, '28.00', '28.00', '161926551508314'),
(18, '西游记', 1, '12.00', '12.00', '161926551508314'),
(19, '台式卤肉饭', 1, '16.00', '16.00', '161926551508314');

-- --------------------------------------------------------

--
-- 表的结构 `t_user`
--

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_user`
--

INSERT INTO `t_user` (`id`, `username`, `password`, `email`) VALUES
(1, 'admin', 'admin', 'admin@atguigu.com'),
(4, 'wzg123', 'wzg123', 'wzg123@qq.com'),
(7, 'oushaojie', 'oushaojie', 'oushaojie@qq.com'),
(8, 'admin2', 'admin2', 'admin@qq.com'),
(14, '123www', '123www', '123@qq.com');

--
-- 转储表的索引
--

--
-- 表的索引 `t_book`
--
ALTER TABLE `t_book`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `t_order`
--
ALTER TABLE `t_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `user_id` (`user_id`);

--
-- 表的索引 `t_order_item`
--
ALTER TABLE `t_order_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`);

--
-- 表的索引 `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `t_book`
--
ALTER TABLE `t_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- 使用表AUTO_INCREMENT `t_order_item`
--
ALTER TABLE `t_order_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- 使用表AUTO_INCREMENT `t_user`
--
ALTER TABLE `t_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
