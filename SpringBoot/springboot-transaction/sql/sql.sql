DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
   `id` BIGINT   AUTO_INCREMENT COMMENT "ID",
   `name`  VARCHAR(200)  COMMENT "名字",
   index(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="用户表";

show create table transaction;