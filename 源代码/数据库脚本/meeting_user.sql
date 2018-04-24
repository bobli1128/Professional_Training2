/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.79_3306
Source Server Version : 50016
Source Host           : 192.168.1.79:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2017-07-27 11:13:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `meeting_user`
-- ----------------------------
DROP TABLE IF EXISTS `meeting_user`;
CREATE TABLE `meeting_user` (
  `MU_ID` int(11) NOT NULL auto_increment,
  `UI_ID` int(11) NOT NULL,
  `MI_ID` int(11) NOT NULL,
  PRIMARY KEY  (`MU_ID`),
  KEY `fk_3` (`UI_ID`),
  KEY `fk_4` (`MI_ID`),
  CONSTRAINT `fk_3` FOREIGN KEY (`UI_ID`) REFERENCES `user_info` (`UI_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_4` FOREIGN KEY (`MI_ID`) REFERENCES `meeting_apply` (`MI_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of meeting_user
-- ----------------------------
