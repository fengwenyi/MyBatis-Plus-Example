# MyBatis-Plus-Example

Spring Boot 整合 MyBatis Plus 实例，持续更新！！！

## 代码生成器

[请点击此处的传送门](https://github.com/fengwenyi/mybatis-plus-code-generator)

## 三方框架版本总览

| 名称 | 版本 | 更新时间 |
| --- | --- | --- |
| Spring Boot | 2.4.2 |  2021.02.02 |
| MyBatis-Plus | 3.4.2 |  2021.02.02 |
| JavaLib | 2.1.1 |  2021.07.06 |
| api-result | 2.3.1 |  2021.02.02 |
| swagger | 2.9.2 |  2019.08.27 |

## 项目版本标识说明

BUILD
开发版本：用于标识该版本正在构建或者开发中。

SNAPSHOT
预览版本：开发已经完成，开始进入测试阶段。

RELEASE
稳定版本：已发布到中央仓库。

## 数据库设计

### 商品类别表-category
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| id | bigint(20) | 主键ID |
| name | varchar(50) | 类别名称 |

### 商品表-goods
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| id | bigint(20) | 主键ID |
| name | varchar(255) | 商品名称 |
| category_id | bigint(20) | 类别ID |
| stock_num | bigint(20) | 库存数量 |
| price | decimal(9, 4) | 单价 |
| flag | tinyint(1) | 上下架。0：下架；1：上架。默认0。 |
| delete_status | tinyint(1) | 逻辑删除状态。0：正常；1：删除。默认0。 |
| create_time | datetime | 创建时间 |
| update_time | datetime | 更新时间 |
| create_by | varchar(64) | 创建人 |
| update_by | varchar(64) | 修改人 |
| version | int(11) | 版本。默认：0。 |

## 常见问题

### 1、LocalDateTime无法使用的问题

#### 描述

用代码生成器生成的时间类型默认为 `LocalDateTime`, 但是在项目中使用报错。今天在项目上遇到了这个问题，什么原因呢？

#### 分析

首先要明确，如果你的项目都和示例项目配置、依赖、版本都一样，那说明本身是没有问题的。肯定是其他问题导致的。

经过排查，项目引入了 `druid`, 版本比较老，所以无法转换导致的。

#### 解决

升级 `druid` 版本
