package com.me.common.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by C167 on 2016/2/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath*:bean/applicationContext*.xml"),
        @ContextConfiguration(name = "child", locations = "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
})
@ActiveProfiles("test")
@Transactional
public abstract class BaseControllerTest {
    @Resource
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;
    protected MockHttpSession mocksession;
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac)
//                .alwaysDo(print())
                .build();
        mocksession = new MockHttpSession();
        this.mockMvc.perform(
                post("/login").param("name", "admin").param("password",
                        "abc123").session(mocksession)).andExpect(status().isOk());
    }
}
