/*
Navicat MySQL Data Transfer

Source Server         : mysql57
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : xuanke

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-07-04 16:45:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `Anum` varchar(255) NOT NULL,
  `Aname` varchar(255) DEFAULT NULL,
  `Director` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Anum`),
  KEY `Director` (`Director`),
  CONSTRAINT `academy_ibfk_1` FOREIGN KEY (`Director`) REFERENCES `teacher` (`Tnum`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1', '信科', '11');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `Clnum` varchar(10) NOT NULL COMMENT '班级编号',
  `Cname` varchar(10) DEFAULT NULL COMMENT '班级名称',
  `Dnum` varchar(6) DEFAULT NULL COMMENT '系、专业编号',
  `Grade` varchar(255) DEFAULT NULL COMMENT '所属年级',
  PRIMARY KEY (`Clnum`),
  KEY `Clnum` (`Clnum`),
  KEY `Dnum` (`Dnum`),
  CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`Dnum`) REFERENCES `depart` (`Dnum`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '1', '1', '16');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cnum` varchar(6) NOT NULL COMMENT '课程编号',
  `Cname` varchar(20) NOT NULL COMMENT '课程名称',
  `Credit` varchar(3) DEFAULT NULL COMMENT '学分',
  `Period` varchar(3) DEFAULT NULL COMMENT '课时',
  `academy` varchar(255) NOT NULL,
  `Tnum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Cnum`),
  KEY `academy` (`academy`),
  KEY `Tnum` (`Tnum`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`academy`) REFERENCES `academy` (`Anum`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`Tnum`) REFERENCES `teacher` (`Tnum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据库', '3', '36', '1', '11');

-- ----------------------------
-- Table structure for depart
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `Dnum` varchar(255) NOT NULL COMMENT '专业编号',
  `Dname` varchar(255) NOT NULL,
  `Director` varchar(255) DEFAULT NULL COMMENT '负责人',
  `Anum` varchar(255) DEFAULT NULL COMMENT '所在学院',
  PRIMARY KEY (`Dnum`),
  KEY `Dnum` (`Dnum`,`Dname`),
  KEY `Dname` (`Dname`),
  KEY `Director` (`Director`),
  KEY `Anum` (`Anum`),
  CONSTRAINT `depart_ibfk_1` FOREIGN KEY (`Director`) REFERENCES `teacher` (`Tnum`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `depart_ibfk_2` FOREIGN KEY (`Anum`) REFERENCES `academy` (`Anum`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES ('1', '1', '11', '1');

-- ----------------------------
-- Table structure for stucourse
-- ----------------------------
DROP TABLE IF EXISTS `stucourse`;
CREATE TABLE `stucourse` (
  `Snum` varchar(10) DEFAULT NULL COMMENT '学号',
  `Cnum` varchar(10) DEFAULT NULL COMMENT '课程编号',
  `Grade` varchar(4) DEFAULT NULL COMMENT '成绩',
  `Tnum` varchar(255) DEFAULT NULL COMMENT '教师编号',
  `Ynum` date DEFAULT NULL COMMENT '开课年度',
  `Term` int(255) DEFAULT NULL COMMENT '开课学期1|2',
  KEY `1` (`Snum`),
  KEY `2` (`Cnum`),
  KEY `Tnum` (`Tnum`),
  CONSTRAINT `stucourse_ibfk_1` FOREIGN KEY (`Snum`) REFERENCES `student` (`Snum`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stucourse_ibfk_2` FOREIGN KEY (`Cnum`) REFERENCES `course` (`Cnum`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stucourse_ibfk_3` FOREIGN KEY (`Tnum`) REFERENCES `teacher` (`Tnum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stucourse
-- ----------------------------
INSERT INTO `stucourse` VALUES ('1', '1', null, '11', null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Snum` varchar(10) NOT NULL,
  `Sname` varchar(255) NOT NULL,
  `Ssex` varchar(255) DEFAULT NULL COMMENT '男、女(M/F)',
  `Sbirth` datetime DEFAULT NULL,
  `Clnum` varchar(11) DEFAULT NULL COMMENT '班级号',
  `Email` varchar(255) DEFAULT NULL,
  `Passwd` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL COMMENT '状态（在校，毕业或者转学）',
  PRIMARY KEY (`Snum`),
  KEY `Clnum` (`Clnum`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Clnum`) REFERENCES `classes` (`Clnum`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'litju', '女', '2019-01-01 00:00:00', '1', '1103416066@qq.com', '1', '大二');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Tnum` varchar(10) NOT NULL,
  `Tname` varchar(255) NOT NULL,
  `Tsex` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL COMMENT '职称',
  `Tphone` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Tbirth` datetime DEFAULT NULL,
  `academy` varchar(11) DEFAULT NULL COMMENT '学院',
  `Passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Tnum`),
  KEY `academy` (`academy`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`academy`) REFERENCES `academy` (`Anum`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('11', 'aa', '女', '普通教师', '13122224557', '3475488468@qq.com', '1978-09-23 00:00:00', '1', '11');
