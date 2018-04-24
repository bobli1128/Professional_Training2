/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.79_3306
Source Server Version : 50016
Source Host           : 192.168.1.79:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2017-07-27 11:13:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `meeting_room`
-- ----------------------------
DROP TABLE IF EXISTS `meeting_room`;
CREATE TABLE `meeting_room` (
  `MR_ID` int(11) NOT NULL auto_increment,
  `MR_ADDRESS` varchar(40) collate utf8_unicode_ci default NULL,
  `MR_NAME` varchar(40) collate utf8_unicode_ci default NULL,
  `MR_MANAGER` int(11) default NULL,
  `MR_COUNT` int(11) default NULL,
  `MR_MONTH` timestamp NULL default NULL,
  `MR_DESC` varchar(40) character set utf8 default NULL,
  `MR_STATUS` varchar(10) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`MR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of meeting_room
-- ----------------------------
INSERT INTO meeting_room VALUES ('602', '健翔大厦6层606间602', '第二会议室', '2', '100', '2017-07-14 00:23:00', '100人电脑会议室', '1');
INSERT INTO meeting_room VALUES ('603', '健翔大厦6层606间603', '第三会议室', '1', '100', null, '100人高级会议室', '1');
INSERT INTO meeting_room VALUES ('604', '健翔大厦6层606间604', '第四会议室', '0', '200', '2017-07-06 00:32:00', '200人会议室', '1');
INSERT INTO meeting_room VALUES ('605', '健翔大厦6层606间605', '小型会议室', '1', '10', '2017-07-17 13:43:00', '只可容纳少数人', '1');
INSERT INTO meeting_room VALUES ('606', '健翔大厦6层606间606', '管理层会议室', '1', '50', '2017-07-26 13:25:00', '管理层专用会议室', '1');
INSERT INTO meeting_room VALUES ('608', '健翔大厦6层606间608', '大礼堂', '1', '400', '2017-07-29 12:04:00', '大型会议和讲座可用', '0');
