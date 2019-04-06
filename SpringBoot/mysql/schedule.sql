/*
* Mysql 用户相关的数据表操作
* 数据库： Mysql
* 版本： 5.7.21
* 数据库名称：spring_boot
* 数据表：
*     1.  scheduler   任务调度表
*
* 创建日期：2018/07/05
* 更新日期：2018/07/05
* 修改记录：
*/
/*管理员表*/
DROP TABLE IF  EXISTS `scheduler`;
CREATE TABLE `scheduler` (
  `scheduler_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(30) DEFAULT NULL COMMENT '任务名称',
  `job_groud` varchar(30) DEFAULT NULL COMMENT '任务所在的组',
  `job_cron` varchar(100) DEFAULT NULL COMMENT '任务时间表达式',
  `job_create` datetime DEFAULT NULL COMMENT '任务创建时间',
  PRIMARY KEY (`scheduler_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务调度表'