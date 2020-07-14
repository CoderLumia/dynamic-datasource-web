/*
 Navicat Premium Data Transfer

 Source Server         : node2
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 192.168.184.102:3306
 Source Schema         : sndo

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 14/07/2020 08:44:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'lumia', 'admin', 'zl@snqu.com');
INSERT INTO `tb_user` VALUES (2, 'lin', 'admin', 'zl@snqu.com');
INSERT INTO `tb_user` VALUES (3, 'zenglin', 'admin', 'zl@snqu.com');
INSERT INTO `tb_user` VALUES (4, 'zenglin', 'admin', 'zl@snqu.com');

SET FOREIGN_KEY_CHECKS = 1;
