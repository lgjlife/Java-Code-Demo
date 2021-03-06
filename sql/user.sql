/*用户信息表*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
   `id` BIGINT   AUTO_INCREMENT COMMENT "用户ID",
   `nick_name`  VARCHAR(30) DEFAULT NULL COMMENT "昵称" ,
   `login_password` VARCHAR(50) NOT NULL COMMENT "登录密码",
   `salt` VARCHAR(50) DEFAULT NULL COMMENT "登录密码盐",
   `actual_name` VARCHAR(100) DEFAULT NULL COMMENT "真实姓名",
   `gender`  VARCHAR(10) DEFAULT NULL COMMENT "性别",
   `age`  TINYINT UNSIGNED DEFAULT NULL  COMMENT "年龄",
   `header_url` VARCHAR(100) DEFAULT NULL COMMENT "头像URL",
   /*0:未注册，1：已注册，2：登录状态，3：离线状态，4,禁止登录状态，5：注销状态）*/
   `status` TINYINT DEFAULT NULL COMMENT "状态",
   `email` VARCHAR(30) COMMENT "电子邮箱",
   `email_active` TINYINT DEFAULT NULL COMMENT "邮箱是否激活",
   `phone_num` VARCHAR(20)  DEFAULT NULL  COMMENT "电话号码",
   `register_time` TIMESTAMP DEFAULT  CURRENT_TIMESTAMP COMMENT "注册时间",
   `last_login_time` DATETIME DEFAULT NULL COMMENT "最后登录时间",
   `update_time` TIMESTAMP DEFAULT  CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "注册时间",
   `login_nums`  INT DEFAULT NULL COMMENT "登录次数",
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="用户表";
