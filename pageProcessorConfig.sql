/*
Navicat MySQL Data Transfer

Source Server         : Bill
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : silver_train

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-07-26 23:07:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pageprocessorconfig`
-- ----------------------------
DROP TABLE IF EXISTS `pageprocessorconfig`;
CREATE TABLE `pageprocessorconfig` (
`processorId`  varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`processorName`  varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`createTime`  date NOT NULL ,
`updateTime`  date NOT NULL ,
`description`  varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`beanClass`  varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`status`  varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`regex`  varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
PRIMARY KEY (`processorId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;
