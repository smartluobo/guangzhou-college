/*Table structure for table `sys_new_menu` */

DROP TABLE IF EXISTS `sys_new_menu`;

CREATE TABLE `sys_new_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序（升序）',
  `is_show` char(1) DEFAULT NULL COMMENT '是否在菜单中显示（1：显示；0：不显示）',
  `target` varchar(25) DEFAULT NULL COMMENT '菜单名称',
  `href` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=398 DEFAULT CHARSET=utf8;

/*Data for the table `sys_new_menu` */

insert  into `sys_new_menu`(`id`,`parent_id`,`parent_ids`,`name`,`sort`,`is_show`,`target`,`href`,`permission`,`icon`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values (1,0,'0,','顶级菜单',NULL,'0',NULL,NULL,NULL,NULL,1,'2020-06-16 01:00:27',1,'2020-06-16 01:00:38',NULL,'0'),(6,1,'0,1,','系统管理',10,'1','','/system','','',1,'2014-11-21 15:36:20',1,'2019-12-09 17:24:26',NULL,'0'),(7,6,'0,1,6,','系统管理',10,'1',NULL,'/system/systemConfig',NULL,NULL,1,'2013-11-21 15:54:28',1,'2013-11-21 15:54:35',NULL,'0'),(73,6,'0,1,6,','机型管理',30,'1','','/system/deviceConfig','','',1,'2014-12-24 09:43:21',1,'2019-12-09 17:25:47',NULL,'0'),(363,1,'0,1,','admin权限',0,'1',NULL,'/admin','',NULL,2,'2020-06-14 22:11:36',2,'2020-06-14 22:11:36','','0'),(364,363,'0,1,363,','用户管理',0,'1',NULL,'/admin/user','sys:user:view','false',2,'2020-06-14 22:11:50',2,'2020-06-14 22:11:50',NULL,'0'),(365,363,'0,1,363,','角色管理',0,'1',NULL,'/admin/role','sys:role:view','false',2,'2020-06-14 22:12:04',2,'2020-06-14 22:12:04',NULL,'0'),(366,363,'0,1,363,','菜单管理',0,'1',NULL,'/admin/menu','sys:menu:view','false',2,'2020-06-14 22:12:21',2,'2020-06-14 22:12:21',NULL,'0'),(367,1,'0,1,','订单管理',0,'1',NULL,'/order','',NULL,2,'2020-06-14 22:12:46',2,'2020-06-14 22:12:46','','0'),(368,367,'0,1,367,','订单列表',0,'1',NULL,'/order/list','','false',2,'2020-06-14 22:12:57',2,'2020-06-14 22:12:57',NULL,'0'),(369,1,'0,1,','商品列表',0,'1',NULL,'/goodsList','',NULL,2,'2020-06-14 22:13:12',2,'2020-06-14 22:13:12','','0'),(370,1,'0,1,','店铺列表',0,'1',NULL,'/shopList','',NULL,2,'2020-06-14 22:13:28',2,'2020-06-14 22:13:28','','0'),(371,1,'0,1,','sku管理',0,'1',NULL,'/sku','',NULL,2,'2020-06-14 22:13:43',2,'2020-06-14 22:13:43','','0'),(374,371,'0,1,371,','sku类型列表',0,'1',NULL,'/sku/skuType','','false',2,'2020-06-14 22:14:29',2,'2020-06-14 22:14:29',NULL,'0'),(375,371,'0,1,371,','sku明细列表',0,'1',NULL,'/sku/detail','','false',2,'2020-06-14 22:14:38',2,'2020-06-14 22:14:38',NULL,'0'),(376,1,'0,1,','活动管理',0,'1',NULL,'/active','',NULL,2,'2020-06-14 22:14:57',2,'2020-06-14 22:14:57','','0'),(377,1,'0,1,','分类列表',0,'1',NULL,'/category','',NULL,2,'2020-06-14 22:15:15',2,'2020-06-14 22:15:15','','0'),(378,1,'0,1,','首页轮播配置',0,'1',NULL,'/carousel','',NULL,2,'2020-06-14 22:15:30',2,'2020-06-14 22:15:30','','0'),(379,1,'0,1,','体验券',0,'1',NULL,'/experience','',NULL,2,'2020-06-14 22:15:44',2,'2020-06-14 22:15:44','','0'),(380,1,'0,1,','优惠券',0,'1',NULL,'/coupon','',NULL,2,'2020-06-14 22:16:01',2,'2020-06-14 22:16:01','','0'),(381,1,'0,1,','库存管理',0,'1',NULL,'/shopStorage','',NULL,2,'2020-06-14 22:16:12',2,'2020-06-14 22:16:12','','0'),(382,1,'0,1,','资产管理',0,'1',NULL,'/asset','',NULL,2,'2020-06-14 22:16:51',2,'2020-06-14 22:16:51','','0'),(384,1,'0,1,','用户列表',0,'1',NULL,'/userList','',NULL,2,'2020-06-14 22:17:19',2,'2020-06-14 22:17:19','','0'),(385,1,'0,1,','优惠企业列表',0,'1',NULL,'/preferentialCompany','',NULL,2,'2020-06-14 22:17:40',2,'2020-06-14 22:17:40','','0'),(386,1,'0,1,','推荐管理',0,'1',NULL,'/recommend','',NULL,2,'2020-06-14 22:17:54',2,'2020-06-14 22:17:54','','0'),(387,1,'0,1,','统计报表',0,'1',NULL,'/reportForms','',NULL,2,'2020-06-14 22:18:10',2,'2020-06-14 22:18:10','','0'),(388,387,'0,1,387,','营业额统计',0,'1',NULL,'/turnoverForms','','false',2,'2020-06-14 22:18:34',2,'2020-06-14 22:18:34',NULL,'0'),(390,387,'0,1,387,','订单统计',0,'1',NULL,'/orderForms','','false',2,'2020-06-14 22:21:33',2,'2020-06-14 22:21:33',NULL,'0'),(391,382,'0,1,382,','打印机管理',0,'1',NULL,'/asset/print','','false',2,'2020-06-14 22:30:12',2,'2020-06-14 22:30:12',NULL,'0'),(392,391,'0,1,382,391,','查看',0,'1',NULL,'/asset/print',NULL,'false',2,'2020-06-16 01:11:20',2,'2020-06-16 01:11:24',NULL,'0'),(393,364,'0,1,363,364,','查看',0,'1',NULL,'','user:info:view',NULL,2,'2020-06-16 01:30:28',2,'2020-06-16 01:30:28','','0'),(394,364,'0,1,363,364,','编辑',0,'1',NULL,'','user:info:edit','false',2,'2020-06-16 01:30:58',2,'2020-06-16 01:30:58',NULL,'0'),(395,368,'0,1,367,368,','查看',0,'1',NULL,'','sys:order:view','false',2,'2020-06-16 02:08:48',2,'2020-06-16 02:08:48',NULL,'0'),(396,368,'0,1,367,368,','编辑',0,'1',NULL,'','sys:order:edit','false',2,'2020-06-16 02:09:10',2,'2020-06-16 02:09:10',NULL,'0'),(397,1,'0,1,','免支付用户',0,'1',NULL,'/freeUser','',NULL,2,'2020-07-17 00:46:57',2,'2020-07-17 00:50:16','','0');

/*Table structure for table `sys_new_role` */

DROP TABLE IF EXISTS `sys_new_role`;

CREATE TABLE `sys_new_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `data_scope` varchar(25) NOT NULL,
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `role_type` char(1) NOT NULL DEFAULT '0' COMMENT '角色类型：（0测试  1运营   2公共）',
  `tab_auth` varchar(255) DEFAULT NULL COMMENT '此角色的tab权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

/*Data for the table `sys_new_role` */

insert  into `sys_new_role`(`id`,`name`,`data_scope`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`,`role_type`,`tab_auth`) values (1,'普通用户','0',1,'2014-11-12 09:28:56',1,'2019-12-09 17:39:05','测试','0','1','谢伟峰图片'),(4,'运营管理员','0',1,'2015-03-03 13:53:48',2,'2020-06-21 23:36:07','角色信息描述','0','1',''),(85,'加盟商店长角色','0',2,'2020-06-16 01:45:56',2,'2020-07-17 00:50:40','加盟商店长角色','0','1',NULL),(86,'普通操作员','0',2,'2020-06-21 11:07:06',2,'2020-06-21 11:07:06','普通操作员权限','0','0',NULL),(87,'超级用户','0',2,'2020-06-21 23:35:19',2,'2020-06-21 23:35:19','超级用户','0','1',NULL),(88,'eecup总部员工','0',194,'2020-06-22 00:14:23',2,'2020-07-17 00:47:06','eecup总部员工','0','1',NULL);

/*Table structure for table `sys_new_role_menu` */

DROP TABLE IF EXISTS `sys_new_role_menu`;

CREATE TABLE `sys_new_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `menu_id` int(11) NOT NULL COMMENT '操作编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_new_role_menu` */

insert  into `sys_new_role_menu`(`role_id`,`menu_id`) values (1,1),(1,6),(1,7),(4,1),(4,6),(4,7),(4,73),(4,363),(4,364),(4,365),(4,366),(4,367),(4,368),(4,369),(4,370),(4,371),(4,374),(4,375),(4,376),(4,377),(4,378),(4,379),(4,380),(4,381),(4,382),(4,384),(4,385),(4,386),(4,387),(4,388),(4,390),(4,391),(4,392),(4,393),(4,394),(4,395),(4,396),(85,6),(85,7),(85,73),(85,367),(85,368),(85,377),(85,381),(85,384),(85,385),(85,387),(85,388),(85,390),(85,395),(85,396),(85,397),(86,367),(86,368),(86,381),(86,395),(86,396),(87,1),(87,6),(87,7),(87,73),(87,363),(87,364),(87,365),(87,366),(87,367),(87,368),(87,369),(87,370),(87,371),(87,374),(87,375),(87,376),(87,377),(87,378),(87,379),(87,380),(87,381),(87,382),(87,384),(87,385),(87,386),(87,387),(87,388),(87,390),(87,391),(87,392),(87,393),(87,394),(87,395),(87,396),(88,6),(88,7),(88,73),(88,367),(88,368),(88,369),(88,370),(88,371),(88,374),(88,375),(88,376),(88,377),(88,378),(88,379),(88,380),(88,381),(88,382),(88,384),(88,385),(88,386),(88,387),(88,388),(88,390),(88,391),(88,392),(88,395),(88,396),(88,397);

/*Table structure for table `sys_new_role_role` */

DROP TABLE IF EXISTS `sys_new_role_role`;

CREATE TABLE `sys_new_role_role` (
  `role_id` int(11) NOT NULL,
  `low_role_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`low_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_new_role_role` */

insert  into `sys_new_role_role`(`role_id`,`low_role_id`) values (1,1),(4,4),(5,5),(6,6),(7,6),(8,6),(9,6),(10,6),(11,6),(12,6),(13,6),(14,6),(17,5),(17,15),(18,18),(19,6),(20,6),(21,5),(23,5),(25,5),(28,28),(30,21),(31,5),(31,21),(42,41),(48,48),(53,53);

/*Table structure for table `sys_new_user` */

DROP TABLE IF EXISTS `sys_new_user`;

CREATE TABLE `sys_new_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `register_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `email` varchar(200) NOT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `is_admin` int(2) DEFAULT '0' COMMENT '是否是超级用户',
  `store_ids` varchar(512) DEFAULT NULL COMMENT '店铺id',
  `store_name` varchar(512) DEFAULT NULL COMMENT '用户店铺名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=utf8;

/*Data for the table `sys_new_user` */

insert  into `sys_new_user`(`id`,`login_name`,`name`,`password`,`salt`,`register_date`,`email`,`phone`,`mobile`,`user_type`,`login_ip`,`login_date`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`,`is_admin`,`store_ids`,`store_name`) values (1,'admin','Admin','a2ce80535d31ab5d88680be89ffad607875f2372','7b070ef6323d8a88','2012-06-03 17:00:00','test@test.com','','',NULL,'127.0.0.1','2020-05-19 16:08:08',NULL,NULL,1,'2020-05-19 16:08:08','123','0',0,NULL,NULL),(2,'ylb','杨丽兵','864f7ec8441a8f82412fc89d74c2dc6b042784bd','815c6cd4f01199ab','2014-11-12 01:29:28','111@qq.com','18629671816','18629671818',NULL,'127.0.0.1','2020-05-19 19:32:38',1,'2014-11-12 09:29:28',2,'2020-05-19 19:32:38','','0',1,NULL,NULL),(174,'wangquan','王全','50bf5e7fcdf8fc549540199f024c4ba02c9405c8','cd04d4c5d4b57f86','2020-04-14 19:52:16','wangquan@ffalcon.cn',NULL,NULL,NULL,'127.0.0.1','2020-05-19 19:32:06',1,'2020-04-14 19:52:16',1,'2020-05-19 19:32:06',NULL,'0',0,NULL,NULL),(189,'tongtong','童童','60c12914d55ded0b1624367e3475a943b076ff64','c1fc5f20c00c23ff','2020-06-16 01:46:30','','','13530852671',NULL,NULL,NULL,2,'2020-06-16 01:46:30',2,'2020-06-16 01:46:30','','0',0,'12','深圳市福永同泰店'),(194,'luomingbo','罗明波','469a81b628ea858ca2700cede6238be3079ba87c','3da4a8f0f6d1877c','2020-06-21 23:39:40','','','13530852671',NULL,NULL,NULL,2,'2020-06-21 23:39:40',2,'2020-06-21 23:39:40','','0',1,'1,2,10,11,12','民治一分店,南山一分店,TCL国际E城店,江门市地王广场万岁寿司店,深圳市福永同泰店'),(195,'zhuangjt','zhuangjt','a4d6f2fdaa55085b3d1ab4caf5b22b7c3b251753','4064b52aa50b5786','2020-06-22 00:15:06','','','13554745606',NULL,NULL,NULL,194,'2020-06-22 00:15:06',194,'2020-08-09 20:22:41','','0',0,'1,2,10,14','民治一分店,南山一分店,TCL国际E城店'),(196,'licb','李陈兵','1eb578c754b34b288cffb22d4198519d6b2a50b7','b942d9319d5f58a2','2020-06-22 00:18:44','','','13827236537',NULL,NULL,NULL,194,'2020-06-22 00:18:44',194,'2020-06-22 00:20:42','','0',0,'1,2,10','民治一分店,南山一分店,TCL国际E城店'),(197,'yangf','杨芬','a6e68aaaf3473d56c46d18cb458e6d07d820c564','6253e66b5700cc4c','2020-07-11 21:35:22','','','13717031086',NULL,NULL,NULL,2,'2020-07-11 21:35:22',2,'2020-07-11 21:35:22','','0',0,'13','波顿科技园店');

/*Table structure for table `sys_new_user_role` */

DROP TABLE IF EXISTS `sys_new_user_role`;

CREATE TABLE `sys_new_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_new_user_role` */

insert  into `sys_new_user_role`(`user_id`,`role_id`) values (2,4),(3,4),(4,1),(5,4),(6,4),(7,4),(8,4),(9,2),(10,1),(10,2),(11,1),(11,2),(12,1),(12,2),(13,3),(14,1),(15,4),(16,4),(17,4),(18,6),(19,6),(20,6),(21,4),(22,6),(23,6),(24,28),(25,6),(26,4),(27,2),(28,1),(29,5),(30,5),(31,5),(32,21),(33,4),(34,4),(35,1),(36,4),(37,34),(38,4),(39,35),(40,34),(41,34),(42,38),(43,34),(44,35),(45,35),(46,42),(47,4),(48,34),(49,2),(50,35),(51,35),(52,35),(53,34),(54,46),(55,34),(56,34),(57,34),(58,1),(59,4),(60,4),(61,34),(62,34),(63,35),(64,4),(65,2),(66,1),(67,4),(68,2),(69,4),(70,4),(71,2),(72,35),(73,35),(74,35),(75,4),(76,4),(77,4),(78,4),(79,4),(80,50),(81,4),(82,4),(83,4),(84,4),(85,4),(86,4),(87,4),(88,54),(89,4),(90,35),(91,35),(92,1),(93,4),(94,54),(95,35),(96,35),(97,4),(98,4),(99,4),(100,4),(101,34),(102,4),(103,4),(104,55),(105,4),(106,34),(107,4),(108,4),(109,4),(110,4),(111,4),(112,4),(113,4),(114,4),(115,34),(116,4),(117,4),(118,4),(119,56),(120,4),(121,4),(122,4),(123,4),(124,34),(125,4),(126,4),(127,4),(128,4),(129,4),(130,4),(131,4),(132,4),(133,4),(134,4),(135,4),(136,4),(137,4),(138,4),(139,4),(140,4),(141,4),(142,4),(143,4),(144,4),(145,4),(146,4),(147,4),(148,4),(149,4),(150,4),(151,4),(152,4),(153,58),(154,4),(155,4),(156,4),(157,4),(158,4),(159,4),(160,50),(164,4),(165,4),(166,4),(167,4),(168,4),(169,4),(170,4),(171,4),(172,4),(173,4),(174,4),(175,4),(176,4),(177,4),(178,4),(179,4),(180,60),(182,1),(185,1),(186,1),(187,4),(188,81),(189,85),(190,85),(191,4),(192,4),(193,87),(194,87),(195,88),(196,88),(197,85);
