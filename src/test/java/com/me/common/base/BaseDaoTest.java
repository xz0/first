package com.me.common.base;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by C167 on 2015/7/16.
 */
@ContextConfiguration(locations = {"classpath*:bean/applicationContext*.xml"})
@ActiveProfiles("test")
@Transactional
public abstract class BaseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

}

