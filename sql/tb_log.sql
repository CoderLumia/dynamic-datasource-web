/*
Navicat MySQL Data Transfer

Source Server         : local_datanode
Source Server Version : 50626
Source Host           : 192.168.0.215:3306
Source Database       : sndo

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2020-07-14 18:43:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `module` varchar(255) DEFAULT NULL COMMENT '模块',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_log
-- ----------------------------
