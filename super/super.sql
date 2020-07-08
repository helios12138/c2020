/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : super

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-07-08 10:51:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员信息表';

-- ----------------------------
-- Records of admin_info
-- ----------------------------

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `useamount` double NOT NULL COMMENT '适用金额',
  `creditamount` double NOT NULL COMMENT '减免金额',
  `begindate` timestamp NOT NULL,
  `enddate` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券';

-- ----------------------------
-- Records of coupon
-- ----------------------------

-- ----------------------------
-- Table structure for discount_goods
-- ----------------------------
DROP TABLE IF EXISTS `discount_goods`;
CREATE TABLE `discount_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discountid` int(11) NOT NULL,
  `goodsid` int(11) NOT NULL,
  `begindate` timestamp NOT NULL,
  `enddate` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='满折商品关联表';

-- ----------------------------
-- Records of discount_goods
-- ----------------------------

-- ----------------------------
-- Table structure for discount_info
-- ----------------------------
DROP TABLE IF EXISTS `discount_info`;
CREATE TABLE `discount_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `goodsnum` int(11) NOT NULL COMMENT '适用商品数量',
  `discount` int(11) NOT NULL COMMENT '折扣',
  `begindate` timestamp NOT NULL,
  `enddate` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='满折信息表';

-- ----------------------------
-- Records of discount_info
-- ----------------------------

-- ----------------------------
-- Table structure for fresh_class_info
-- ----------------------------
DROP TABLE IF EXISTS `fresh_class_info`;
CREATE TABLE `fresh_class_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生鲜类别信息';

-- ----------------------------
-- Records of fresh_class_info
-- ----------------------------

-- ----------------------------
-- Table structure for goods_appraise
-- ----------------------------
DROP TABLE IF EXISTS `goods_appraise`;
CREATE TABLE `goods_appraise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `content` varchar(255) NOT NULL COMMENT '评价内容',
  `contentdata` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评价表';

-- ----------------------------
-- Records of goods_appraise
-- ----------------------------

-- ----------------------------
-- Table structure for goods_buy
-- ----------------------------
DROP TABLE IF EXISTS `goods_buy`;
CREATE TABLE `goods_buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `state` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品采购表';

-- ----------------------------
-- Records of goods_buy
-- ----------------------------

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `menberprice` double NOT NULL COMMENT '会员价',
  `number` int(11) NOT NULL,
  `spec` varchar(50) NOT NULL COMMENT '规格',
  `details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of goods_info
-- ----------------------------

-- ----------------------------
-- Table structure for goods_menu_rec
-- ----------------------------
DROP TABLE IF EXISTS `goods_menu_rec`;
CREATE TABLE `goods_menu_rec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `menuid` int(11) NOT NULL,
  `des` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品菜谱推荐表';

-- ----------------------------
-- Records of goods_menu_rec
-- ----------------------------

-- ----------------------------
-- Table structure for goods_order
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `orgprice` double NOT NULL COMMENT '原始金额',
  `payprice` double NOT NULL COMMENT '结算金额',
  `couponid` int(11) NOT NULL COMMENT '优惠券编号',
  `ordertime` timestamp NOT NULL COMMENT '要求送达的时间',
  `addressid` int(11) NOT NULL COMMENT '配送地址编号',
  `orderstate` varchar(20) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单表';

-- ----------------------------
-- Records of goods_order
-- ----------------------------

-- ----------------------------
-- Table structure for limit_promotions_info
-- ----------------------------
DROP TABLE IF EXISTS `limit_promotions_info`;
CREATE TABLE `limit_promotions_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `proprice` double NOT NULL COMMENT '促销价格',
  `pronumber` int(11) NOT NULL COMMENT '促销数量',
  `begindate` timestamp NOT NULL,
  `enddate` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='限时促销信息';

-- ----------------------------
-- Records of limit_promotions_info
-- ----------------------------

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `materials` varchar(255) NOT NULL COMMENT '菜谱用料',
  `step` varchar(255) NOT NULL COMMENT '步骤',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜谱信息';

-- ----------------------------
-- Records of menu_info
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `goodsid` int(11) NOT NULL,
  `ordernum` int(11) NOT NULL,
  `price` double NOT NULL,
  `discount` double NOT NULL,
  `discountid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for shipping_address
-- ----------------------------
DROP TABLE IF EXISTS `shipping_address`;
CREATE TABLE `shipping_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `province` varchar(50) NOT NULL COMMENT '省份',
  `city` varchar(50) NOT NULL COMMENT '市',
  `area` varchar(50) NOT NULL COMMENT '区',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `username` varchar(50) NOT NULL COMMENT '联系人',
  `phone` varchar(50) NOT NULL COMMENT '电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配送地址表';

-- ----------------------------
-- Records of shipping_address
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `city` varchar(50) NOT NULL,
  `signtime` timestamp NOT NULL,
  `ismember` varchar(10) NOT NULL COMMENT '是否会员',
  `membertime` timestamp NOT NULL COMMENT '会员截至时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
