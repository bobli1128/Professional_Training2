/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.79_3306
Source Server Version : 50016
Source Host           : 192.168.1.79:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2017-07-27 11:12:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentid` int(11) NOT NULL auto_increment,
  `departmentname` varchar(200) character set utf8 NOT NULL,
  PRIMARY KEY  (`departmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO department VALUES ('1', '人事部');
INSERT INTO department VALUES ('2', '公关部');
INSERT INTO department VALUES ('3', '组织部');
INSERT INTO department VALUES ('4', '设计部');
INSERT INTO department VALUES ('5', '财务部');
INSERT INTO department VALUES ('6', '销售部');
INSERT INTO department VALUES ('7', '后勤部');
INSERT INTO department VALUES ('8', '广告部');
INSERT INTO department VALUES ('9', '新闻部');
