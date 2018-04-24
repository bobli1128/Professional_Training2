/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.79_3306
Source Server Version : 50016
Source Host           : 192.168.1.79:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2017-07-27 11:14:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `UI_ID` int(11) NOT NULL auto_increment,
  `UI_ACCOUNT` varchar(30) character set utf8 default NULL,
  `UI_PWD` varchar(30) character set utf8 default NULL,
  `UI_NAME` varchar(30) character set utf8 default NULL,
  `UI_DEPARTMENT` varchar(30) character set utf8 NOT NULL,
  `UI_ROLES` varchar(30) character set utf8 default NULL,
  `UI_STATUS` varchar(30) character set utf8 default NULL,
  `UI_TEL` varchar(30) character set utf8 default NULL,
  `UI_EMAIL` varchar(30) character set utf8 default NULL,
  PRIMARY KEY  (`UI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO user_info VALUES ('1', 'lixue', '123456', '李雪', '设计部', '1', '1', '15897653467', '182736908@qq.com');
INSERT INTO user_info VALUES ('2', 'zhangyangfan', '1', '张扬帆', '公关部', '0', '1', '13278908654', '785659658@qq.com');
INSERT INTO user_info VALUES ('3', 'zhaoyin', '1', '赵寅', '广告部', '0', '1', '13261618977', '1395239627@qq.com');
INSERT INTO user_info VALUES ('4', 'liuli', '1', '刘丽', '广告部', '0', '1', '13290889765', '454576@qq.com');
INSERT INTO user_info VALUES ('5', 'muchunyang', '1', '沐春阳', '销售部', '0', '0', '13398762345', '2324343@QQ.com');
INSERT INTO user_info VALUES ('6', 'liqingqing', '1', '李青青', '人事部', '1', '1', '13398763456', '23435435@QQ.COM');
INSERT INTO user_info VALUES ('7', 'gaoyuhan', '1', '高雨涵', '销售部', '0', '0', '13345678909', '232324@QQ.COM');
INSERT INTO user_info VALUES ('8', 'hanyan', '1', '韩艳', '銷售部', '0', '0', '13261618977', '2334556@QQ.COM');
INSERT INTO user_info VALUES ('9', 'wenjing', '1', '文婧', '组织部', '0', '1', '13309877890', '234445@QQ.COM');
INSERT INTO user_info VALUES ('10', 'zhaoqian', '1', '赵倩', '财务部', '0', '0', '13298766789', '2324345@QQ.COM');
INSERT INTO user_info VALUES ('11', 'zhengzhenhua', '1', '郑振华', '后勤部', '0', '0', '13398765432', '2324355@QQ.COM');
INSERT INTO user_info VALUES ('12', 'wenyu', '1', '文宇', '后勤部', '0', '1', '13256787345', '4554767@qq.com');
INSERT INTO user_info VALUES ('15', 'bailuoheng', '123456', '白落衡', '组织部', '0', '0', '13256787345', '345556@QQ.COM');
INSERT INTO user_info VALUES ('16', 'linana', '123', '李娜娜', '财务部', '0', '1', '13256787345', '345556@QQ.COM');
INSERT INTO user_info VALUES ('17', 'muxueli', '123', '沐雪离', '人事部', '0', '0', '13283830978', '232245@QQ.COM');
INSERT INTO user_info VALUES ('18', 'qimengyao', '1', '齐梦瑶', '组织部', '0', '2', '13256787345', '23444@QQ.COM');
