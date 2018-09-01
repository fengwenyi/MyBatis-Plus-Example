/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : mybatis-plus

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 08/31/2018 03:14:59 AM

 @author Wenyi Feng
*/

CREATE DATABASE `mybatis-plus` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE `mybatis-plus`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '城市名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `t_idcard`
-- ----------------------------
DROP TABLE IF EXISTS `t_idcard`;
CREATE TABLE `t_idcard` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `code` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` bigint(20) NOT NULL COMMENT '唯一标识，主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `info` text COMMENT '介绍',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除（ture：删除；false：正常（默认））',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `gender` int(1) DEFAULT '0' COMMENT '性别（0：保密（默认）；1：男；2：女）',
  `idcard_id` bigint(20) DEFAULT NULL COMMENT '身份证号码表编号（id）',
  `city_id` bigint(20) DEFAULT NULL COMMENT '城市表编号（id）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
