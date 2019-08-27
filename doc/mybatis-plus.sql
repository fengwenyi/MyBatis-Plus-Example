/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : mybatis-plus-example

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 08/27/2018 11:05:34
 @author Erwin Feng
*/

CREATE DATABASE if not exists `mybatis-plus-example` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE `mybatis-plus-example`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES (1035761969176342529, '北京');
INSERT INTO `t_city` VALUES (1035762001753501698, '成都');
INSERT INTO `t_city` VALUES (1035765839768121346, '上海');
INSERT INTO `t_city` VALUES (1035765875767832578, '深圳');
INSERT INTO `t_city` VALUES (1035788325201117185, '1');

-- ----------------------------
-- Table structure for t_idcard
-- ----------------------------
DROP TABLE IF EXISTS `t_idcard`;
CREATE TABLE `t_idcard`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_idcard
-- ----------------------------
INSERT INTO `t_idcard` VALUES (1035788325276614657, '1');
INSERT INTO `t_idcard` VALUES (1035789714388168706, '123456789012345678');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` bigint(20) NOT NULL COMMENT '唯一标识，主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  `info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '介绍',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否逻辑删除（true：删除；false：正常（默认））',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `gender` int(1) NULL DEFAULT 0 COMMENT '性别（0：保密（默认）；1：男；2：女）',
  `idcard_id` bigint(20) NULL DEFAULT NULL COMMENT '身份证号码表编号（id）',
  `city_id` bigint(20) NULL DEFAULT NULL COMMENT '城市表编号（id）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1035788325322752001, '张三', 20, '千里之行，始于足下', 0, '2018-09-01 15:15:55', '2019-08-27 11:08:55', 1, 1035788325276614657, 1035788325201117185);
INSERT INTO `t_student` VALUES (1035789714459471874, '李四', 18, '不积跬步，无以至千里', 0, '2018-09-01 15:21:26', '2019-08-27 11:08:55', 1, 1035789714388168706, 1035762001753501698);

SET FOREIGN_KEY_CHECKS = 1;
