User  Goods   Type 三个表
建表sql如下 ，DAOsql语句中 表名注意 用``引起。

1.说明：三表无外键联系
2.同桌两人一组 负责一个表的 daoimpl 及对应的servlet，jsp页面，  
3.目标：user  goods  type 在jsp页面的增删改查即可
4.分页不用做
5.各po的Service接口没有定义，请自行按习惯定义即可
6.jstl  el表达式  jdbc  jar包已加

分工如下：
王楠 刘伟强： User
杜凯 刘贵状： Goods
韩少鹏 王涛： type


CREATE TABLE `user` (

`uid` int NOT NULL AUTO_INCREMENT,

`uname` varchar(20) NULL,

`password` varchar(50) NULL,

PRIMARY KEY (`uid`) 

);



CREATE TABLE `goods` (

`gid` int NOT NULL AUTO_INCREMENT,

`gname` varchar(20) NULL,

`gprice` varchar(20) NULL,

`quantity` int NULL,

`gphoto` varchar(64) NULL,

`gdesc` varchar(32) NULL,

`gtype` int NULL,

PRIMARY KEY (`gid`) 

);



CREATE TABLE `type` (

`tid` int NOT NULL AUTO_INCREMENT,

`tname` varchar(20) NULL,

`tphoto` varchar(64) NULL,

`tdesc` varchar(20) NULL,

PRIMARY KEY (`tid`) 

);

