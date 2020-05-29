-- ----------------------------
-- 创建数据库
-- ----------------------------
DROP DATABASE IF EXISTS `mybatis-plus-example`; -- 删除数据库
CREATE DATABASE `mybatis-plus-example` CHARACTER SET utf8mb4 COLLATE utf8mb4_bin; -- 创建数据库并指定编码

USE `mybatis-plus-example`;

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
    `id` BIGINT (20) NOT NULL COMMENT 'ID',
    `username` VARCHAR (255) NOT NULL COMMENT '用户名',
    `password` VARCHAR (255) NOT NULL COMMENT '密码',
    `nickname` VARCHAR (255) COMMENT '昵称',
    `sex` INT (1) DEFAULT 0 COMMENT '性别。0：未知；1：男；2：女',
    `release_status` INT (1) DEFAULT 0 COMMENT '生效状态。0：不生效；1：生效',
	`delete_status` INT (1) DEFAULT 0 COMMENT '删除状态。0：正常；-1：删除',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_username` (`username`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_bin COMMENT '用户表';

INSERT INTO `t_user` (id, username, password, nickname, sex, release_status) VALUE (1, 'root', '123456', 'Root', 1, 1);
