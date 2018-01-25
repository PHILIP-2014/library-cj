/*
Navicat MySQL Data Transfer

Source Server         : server200
Source Server Version : 50173
Source Host           : 192.168.1.200:3306
Source Database       : library-cj

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-04-25 16:29:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_book
-- ----------------------------
DROP TABLE IF EXISTS `b_book`;
CREATE TABLE `b_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT '' COMMENT '书名',
  `description` varchar(150) DEFAULT '' COMMENT '描述',
  `type` int(3) DEFAULT 0 COMMENT '0 else 1 FY 2 CJ 3 SM...',
  `author` varchar(30) DEFAULT '' COMMENT '作者',
  `editor` varchar(20) DEFAULT '' COMMENT '出版社',
  `total` int(3) DEFAULT 0 COMMENT '总数',
  `remain` int(3) DEFAULT 0 COMMENT '剩余',
  `language` int(1) DEFAULT 1 COMMENT '1简体中文 2繁体中文 3英文',
  `status` int(1) DEFAULT 1 COMMENT '1正常 2下架',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_user
-- ----------------------------
DROP TABLE IF EXISTS `b_user`;
CREATE TABLE `b_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT '' COMMENT '用户真实姓名',
  `nick_name` varchar(30) DEFAULT '' COMMENT '用户昵称',
  `password` varchar(40) DEFAULT NULL COMMENT '登陆密码',
  `role` int(1) DEFAULT 1 COMMENT '1普通用户 2管理员',
  `type` int(1) DEFAULT 1 COMMENT '1弟兄 2姊妹 3朋友',
  `email` varchar(50) DEFAULT NULL COMMENT '常用邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `qq` varchar(20) DEFAULT NULL COMMENT 'qq号或者微信号',
  `age` varchar(3) DEFAULT NULL COMMENT '用户年龄',
  `gmt_last_login` datetime DEFAULT NULL COMMENT '最近登录时间',
  `ip_addr` varchar(30) DEFAULT NULL COMMENT '最近登录IP',
  `status` int(1) DEFAULT 1 COMMENT '1正常 0注销',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for c_record
-- ----------------------------
DROP TABLE IF EXISTS `c_record`;
CREATE TABLE `c_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bid` bigint(20) DEFAULT NULL COMMENT 'book_id',
  `uid` bigint(20) DEFAULT NULL COMMENT 'user_id',
  `flag_borrow` tinyint(1) DEFAULT 0 COMMENT '借阅标志 0未借 1已借',
  `gmt_borrow` datetime DEFAULT NULL COMMENT '借阅时间',
  `gmt_to_return` datetime DEFAULT NULL COMMENT '应还时间',
  `flag_return` tinyint(1) DEFAULT NULL COMMENT '归还标志 0未还 1已还',
  `gmt_return` datetime DEFAULT NULL COMMENT '归还时间',
  `status` int(1) DEFAULT 1 COMMENT '1正常 2失效',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for c_doc
-- ----------------------------
DROP TABLE IF EXISTS `c_doc`;
CREATE TABLE `c_doc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT '' COMMENT '文件名',
  `uid_upload` bigint(20) DEFAULT NULL COMMENT '上传者',
  `suffix` varchar(45) DEFAULT '' COMMENT '文档后缀',
  `size` bigint(20) NOT NULL COMMENT '文件大小',
  `md5` varchar(45) NOT NULL COMMENT '文件md5值',
  `is_trash` tinyint(1) DEFAULT 0 COMMENT '文件状态',
  `uid_trash` bigint(20) DEFAULT NULL COMMENT '删除人',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

