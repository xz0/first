CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(64) NOT NULL COMMENT '登录名',
  `showName` varchar(64) NOT NULL COMMENT '中文名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '电话',
  `qq` varchar(100) DEFAULT NULL COMMENT 'QQ',
  `defaultShowMenu` int(11) DEFAULT NULL COMMENT '默认菜单id',
  `generalVerificationCode` varchar(100) DEFAULT NULL COMMENT '通用验证码',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 1:正常.0:停用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';