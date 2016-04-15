package com.me.sys.dao;

import com.me.common.base.BaseDaoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.sql.DataSource;

/**
 * Created by C167 on 2016/2/29.
 */
@TransactionConfiguration(transactionManager = "txManagerSys", defaultRollback = true)
public abstract class SysBaseDaoTest extends BaseDaoTest {
    protected DataSource datasourceSys;
    @Override
    @Autowired
    public void setDataSource(DataSource datasourceSys) {
        super.setDataSource(datasourceSys);
        this.datasourceSys = datasourceSys;
    }
}
