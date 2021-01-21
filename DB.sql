/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 8.0.11 : Database - test
*********************************************************************
*/

CREATE TABLE `course` (
  `cno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程号',
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名',
  `credit` int(11) DEFAULT NULL COMMENT '学分',
  `semester` int(11) DEFAULT NULL COMMENT '开课学期',
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


insert  into `course`(`cno`,`cname`,`credit`,`semester`) values ('C001','高等数学',4,1),('C002','大学英语',3,1),('C003','大学英语',3,2),('C004','计算机文化学',2,2),('C005','Java',2,3),('C006','数据库基础',4,5),('C007','数据结构',4,4),('C008','计算机网络',4,4);


CREATE TABLE `score` (
  `sno` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `cno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程号',
  `grade` int(11) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`sno`,`cno`) USING BTREE,
  KEY `Cno` (`cno`) USING BTREE,
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`),
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `course` (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


CREATE TABLE `student` (
  `sno` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `sname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `ssex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `sage` int(11) DEFAULT NULL COMMENT '年龄',
  `dept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在系',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


insert  into `student`(`sno`,`sname`,`ssex`,`sage`,`dept`) values ('0811101','李勇','男',21,'计算机系'),('0811102','刘晨','男',20,'计算机系'),('0811103','王敏','女',20,'计算机系'),('0811104','张小红','女',19,'计算机系'),('0821101','张立','男',20,'信息管理系'),('0821102','吴宾','女',19,'信息管理系'),('0821103','张海','男',20,'信息管理系'),('0831101','钱小平','女',21,'通信工程系'),('0831102','王大力','男',20,'通信工程系'),('0831103','张珊珊','女',19,'通信工程系');

