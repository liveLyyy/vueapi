/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : vue_api

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-12-27 18:56:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `u_id` int(11) NOT NULL COMMENT '用户ID',
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `c_id` int(11) NOT NULL COMMENT '类别ID',
  `title` varchar(999) COLLATE utf8_unicode_ci NOT NULL COMMENT '文章标题',
  `desc` varchar(999) COLLATE utf8_unicode_ci NOT NULL COMMENT '概要',
  `content` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '正文',
  `likes` int(11) DEFAULT NULL COMMENT '点赞数',
  `views` int(11) DEFAULT NULL COMMENT '浏览人数',
  `is_top` tinyint(4) DEFAULT '0' COMMENT '是否为推荐,1为推荐',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '文章创建时间',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '文章更新时间',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1025', '1', '1', 'Java的前世今生', 'Java', '', '1', '1', '0', '2019-12-27 09:33:48', '2019-12-26 15:25:46');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
  `cname` varchar(99) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序，越大越优先(0-10)',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Java', '2019-12-26 10:54:10', '2');
INSERT INTO `category` VALUES ('9', 'Spring', '2019-12-26 11:01:30', '1');
INSERT INTO `category` VALUES ('11', 'HTML', '2019-12-26 11:01:38', '3');
INSERT INTO `category` VALUES ('13', 'MyBatis', '2019-12-25 20:26:06', '6');
INSERT INTO `category` VALUES ('14', 'Spring Boot', '2019-12-26 11:01:24', '5');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单ID',
  `parent_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '父类ID',
  `text` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `url` varchar(99) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单导航',
  `level` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '1' COMMENT '级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('GN002D000', '0', '用户管理', '', '0');
INSERT INTO `menu` VALUES ('GN002D100', 'GN002D000', '用户列表', 'users', '1');
INSERT INTO `menu` VALUES ('GN003D000', '0', '权限管理', '', '0');
INSERT INTO `menu` VALUES ('GN003D100', 'GN003D000', '角色权限', null, '1');
INSERT INTO `menu` VALUES ('GN003D101', 'GN003D000', '权限列表', 'rights', '1');
INSERT INTO `menu` VALUES ('GN004D000', '0', '类别管理', 'category', '0');
INSERT INTO `menu` VALUES ('GN004D102', 'GN004D000', '分类详情', 'categorys', '1');
INSERT INTO `menu` VALUES ('GN005D000', '0', '文章管理', 'article', '0');
INSERT INTO `menu` VALUES ('GN005D100', 'GN005D000', '文章列表', 'articles', '1');
INSERT INTO `menu` VALUES ('GN005D200', 'GN005D000', '发布文章', 'postarticles', '1');
INSERT INTO `menu` VALUES ('GN006D000', '0', '评论管理', '', '0');
INSERT INTO `menu` VALUES ('GN006D100', 'GN006D000', '评论列表', null, '1');
INSERT INTO `menu` VALUES ('GN007D000', '0', '文件管理', null, '0');
INSERT INTO `menu` VALUES ('GN008D000', '0', '数据管理', null, '0');
INSERT INTO `menu` VALUES ('GN008D100', 'GN008D000', '数据列表', null, '1');
INSERT INTO `menu` VALUES ('GN008D200', 'GN008D000', '数据统计', null, '1');
INSERT INTO `menu` VALUES ('GN009D000', '0', '系统设置', null, '0');
INSERT INTO `menu` VALUES ('GN009D100', 'GN009D000', '系统日志', null, '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL COMMENT '角色ID',
  `rolename` varchar(99) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户');
INSERT INTO `role` VALUES ('2', '超级管理员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `rid` int(30) NOT NULL DEFAULT '1' COMMENT '角色ID',
  `username` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `phone` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '电话号码',
  `email` varchar(999) COLLATE utf8_unicode_ci NOT NULL COMMENT '邮箱',
  `token` varchar(999) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '令牌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1031 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1025', '2', 'admin', '123456', '1234567896', '156@qq.com', '5749475e525b534b555250415a54');
INSERT INTO `user` VALUES ('1026', '1', 'root', '123456', '15236951236', '123@qq.com', '5749475f5657524f565550415a545a564a');
INSERT INTO `user` VALUES ('1029', '2', '123', '123456', '15263955632', '123@qq.com', '5749475f555b554a5e5e50415a545a564a');
