/*
 Navicat Premium Data Transfer

 Source Server         : localhost.01-192.168.16.128
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.16.128:3306
 Source Schema         : mybatis-plus-example

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 07/03/2021 18:15:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shop_category
-- ----------------------------
DROP TABLE IF EXISTS `shop_category`;
CREATE TABLE `shop_category`  (
  `id` bigint(0) NOT NULL COMMENT '主键ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods`  (
  `id` bigint(0) NOT NULL COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品名称',
  `category_id` bigint(0) DEFAULT NULL COMMENT '商品类别ID',
  `stock_num` bigint(0) DEFAULT NULL COMMENT '库存数量',
  `price` decimal(9, 4) DEFAULT NULL COMMENT '商品单价',
  `flag` tinyint(1) DEFAULT NULL COMMENT '上下架。0：下架；1：上架。默认0。',
  `delete_status` tinyint(1) DEFAULT NULL COMMENT '逻辑删除状态。0：正常；1：删除。默认0。',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `version` int(0) DEFAULT NULL COMMENT '版本。默认：0。',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
