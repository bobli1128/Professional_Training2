/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.79_3306
Source Server Version : 50016
Source Host           : 192.168.1.79:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2017-07-27 11:13:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `meeting_apply`
-- ----------------------------
DROP TABLE IF EXISTS `meeting_apply`;
CREATE TABLE `meeting_apply` (
  `MI_ID` int(11) NOT NULL auto_increment,
  `MI_TITLE` varchar(40) character set utf8 default NULL,
  `MI_DEGREE` int(11) default NULL,
  `MI_CONTENT` varchar(50) character set utf8 collate utf8_estonian_ci default NULL,
  `MI_START_TIME` timestamp NULL default NULL,
  `MI_END_TIME` timestamp NULL default NULL,
  `MI_BOOK_TIME` timestamp NULL default NULL,
  `MI_COUNT` int(11) default NULL,
  `MI_ORDER` varchar(255) character set utf8 default NULL,
  `MI_ROOM` varchar(255) character set utf8 default NULL,
  `MI_STATUS` varchar(200) character set utf8 default NULL,
  `MI_DEPA` varchar(30) character set utf8 default NULL,
  `MI_USER_ID` int(11) default NULL,
  `MI_MEETROOM_ID` int(11) default NULL,
  PRIMARY KEY  (`MI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT COMMENT='InnoDB free: 3072 kB; (`MI_USER_ID`) REFER `test/user_info`(';

-- ----------------------------
-- Records of meeting_apply
-- ----------------------------
INSERT INTO meeting_apply VALUES ('1', '年中工作总结会', '1', '年中工作总结', '2017-07-28 09:00:00', '2017-07-28 11:00:00', '2017-07-24 11:00:00', '150', '文宇', '第四会议室', '1', null, '1', '604');
INSERT INTO meeting_apply VALUES ('2', '“设备更新”汇总会', '0', '关于需要更新的设备汇总', '2017-07-25 10:00:00', '2017-07-25 11:00:00', '2017-07-22 09:00:00', '8', '文宇', '小型会议室', '1', null, '2', '605');
INSERT INTO meeting_apply VALUES ('3', '“软件夏令营”动员会', '0', '参加软件夏令营活动的动员会', '2017-08-05 13:30:00', '2017-08-05 14:30:00', '2017-07-18 13:30:00', '350', '文婧', '大礼堂', '1', null, '3', '608');
INSERT INTO meeting_apply VALUES ('4', '三季度工作策划会', '0', '三季度的工作策划', '2017-08-01 09:00:00', '2017-08-01 10:30:00', '2017-07-18 11:00:00', '18', '文婧', '管理层会议室', '1', null, '4', '606');
INSERT INTO meeting_apply VALUES ('5', '八月员工例会', '0', '员工例会', '2017-08-01 15:00:00', '2017-08-01 17:00:00', '2017-07-20 11:00:00', '380', '沐春阳', '大礼堂', '0', null, '5', '608');
INSERT INTO meeting_apply VALUES ('6', '学习交流分享会', '0', '经验交流会', '2017-07-27 09:00:00', '2017-07-27 11:30:00', '2017-07-21 11:00:00', '80', '文婧', '第一会议室', '0', null, '6', '605');
INSERT INTO meeting_apply VALUES ('7', '“高性能计算机“讲座', '0', '讲座', '2017-08-03 15:00:00', '2017-08-03 17:00:00', '2017-07-24 11:00:00', '390', '文婧', '大礼堂', '0', null, '5', '608');
INSERT INTO meeting_apply VALUES ('8', '七月成果报告会', '0', '七月案例成果总结', '2017-07-28 11:00:00', '2017-08-10 17:30:00', '2017-07-18 11:02:00', '150', '文婧', '第四会议室', '0', null, '5', '604');
INSERT INTO meeting_apply VALUES ('16', '自底向上的革命', '0', '暗室逢灯撒地方', '2017-07-27 14:00:00', '2017-07-28 17:02:00', '2017-07-26 13:22:00', '2000', '张飞', '大礼堂', '1', '组织部', '5', '605');
