package com.me.sys.controller;

import com.me.common.base.BaseControllerTest;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by C167 on 2016/2/29.
 */
@TransactionConfiguration(transactionManager = "txManagerSys", defaultRollback = true)
public abstract class SysBaseControllerTest extends BaseControllerTest {
}
