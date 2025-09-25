/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `book_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `book_isbn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书标准ISBN编号',
  `book_press` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书出版社',
  `book_author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书作者',
  `book_pagination` int(11) NULL DEFAULT NULL COMMENT '图书页数',
  `book_price` double(10, 0) NULL DEFAULT NULL COMMENT '图书价格',
  `book_uploadtime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书上架时间',
  `book_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '图书状态（0：可借阅，1:已借阅，2：归还中，3：已下架）',
  `book_borrower` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书借阅人',
  `book_borrowtime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书借阅时间',
  `book_returntime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书预计归还时间',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Java基础案例教程（第2版）', '9787115547477', '人民邮电出版社', '传智播客', 291, 59, '2020-12-11', '0', NULL, NULL, NULL);
INSERT INTO `book` VALUES (2, '挪威的森林', '9787546205618', '上海译文出版社', '村上春树', 380, 34, '2020-12-12', '0', NULL, NULL, NULL);
INSERT INTO `book` VALUES (4, 'JavaWeb程序设计任务教程', '9787115439369', '人民邮电出版社', '传智播客', 419, 57, '2020-12-14', '0', '', '', '');
INSERT INTO `book` VALUES (5, 'Java基础入门（第2版）', '9787302511410', '清华大学出版社', '胡楠', 413, 59, '2020-12-15', '0', '', '', '');
INSERT INTO `book` VALUES (6, 'SpringCloud微服务架构开发', '9787115529046', '人民邮电出版社', '传智播客', 196, 43, '2020-12-16', '2', '林煜乔', '2024-11-07', '2024-12-07');
INSERT INTO `book` VALUES (7, 'SpringBoot企业级开发教程', '9787115512796', '人民邮电出版社', '传智播客', 270, 56, '2020-12-17', '0', '', '', '');
INSERT INTO `book` VALUES (8, 'Spark大数据分析与实战', '9787302534327', '清华大学出版社', '传智播客', 228, 49, '2020-12-18', '0', '', '', '');
INSERT INTO `book` VALUES (10, '边城', '9787543067028', '武汉出版社', '沈从文', 368, 26, '2020-12-20', '2', '张广凡', '2024-11-07', '2024-12-07');
INSERT INTO `book` VALUES (12, '自在独行', '9787535488473', '长江文艺出版社', '贾平凹', 320, 39, '2020-12-22', '1', '庄振宇', '2024-11-07', '2024-12-07');
INSERT INTO `book` VALUES (13, '沉默的巡游', '9787544280662', '南海出版公司', '东野圭吾', 400, 59, '2020-12-23', '0', '', '', '');
INSERT INTO `book` VALUES (15, 'Vue.js', '9787544280663', '人民邮电出版社', '传智播客', 198, 45, '2020-12-23', '0', NULL, NULL, NULL);
INSERT INTO `book` VALUES (16, '吞噬星空', '9787543067021', '人民邮电出版社', '曹雪芹', 200, 52, '2023-03-23', '2', '庄振宇', '2024-11-07', '2022-12-07');
INSERT INTO `book` VALUES (17, '色大声道', '9787546905618', '人民邮电出版社', '残血器', 413, 3332, '2023-03-24', '1', '林煜乔', '2024-11-07', '2024-12-07');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `record_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '借阅记录id',
  `record_bookname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借阅的图书名称',
  `record_bookisbn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借阅的图书的ISBN编号',
  `record_borrower` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书借阅人',
  `record_borrowtime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书借阅时间',
  `record_remandtime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书归还时间',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (4, 'JavaWeb程序设计任务教程', '9787115439369', '张广凡', '2024-11-11', '2024-11-11');
INSERT INTO `record` VALUES (7, 'SpringBoot企业级开发教程', '9787115512796', '张广凡', '2023-03-23', '2024-11-11');
INSERT INTO `record` VALUES (23, 'Java基础案例教程（第2版）', '9787115547477', '庄振宇', '2024-11-11', '2024-11-11');
INSERT INTO `record` VALUES (24, '沉默的巡游', '9787544280662', '林煜乔', '2024-11-11', '2024-11-11');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱（用户账号）',
  `user_role` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户角色',
  `user_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户状态（0:正常,1:禁用）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
-- 插入数据时，省略 `user_id` 字段，自动生成
INSERT INTO `user` (user_name, user_password, user_email, user_role, user_status)
VALUES ('zgf', 'zxc123', 'zhanggf2022@dgut.edu.cn', 'ADMIN', '0');

INSERT INTO `user` (user_name, user_password, user_email, user_role, user_status)
VALUES ('zzy', 'zxc123', 'zhuangzy2022@dgut.edu.cn', 'USER', '0');

SET FOREIGN_KEY_CHECKS = 1;
