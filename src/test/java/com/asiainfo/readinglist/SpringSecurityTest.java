package com.asiainfo.readinglist;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcSecurityConfiguration.*;

import com.asiainfo.readinglist.entiy.Reader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ReadinglistApplication.class})
@WebAppConfiguration
public class SpringSecurityTest {

    @Autowired(required = false)
    @Qualifier("webApplicationContext")
    private WebApplicationContext context;

    private MockMvc mockMvc;
    //clientId
    final static String CLIENT_ID = "merryyou";
    //clientSecret
    final static String CLIENT_SECRET = "merryyou";
    //用户名
    final static String USERNAME = "admin";
    //密码
    final static String PASSWORD = "123456";

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Before
    public void setMockMvcContext(){
        //mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
//    @WithMockUser(username="craig",
//            password="password",
//            roles="READER")
    public void homePage_unauthenticatedUser() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location",
                        "http://localhost/login"));
    }

    @Test
    //@WithUserDetails("craig")
    public void homePage_authenticatedUser() throws Exception {
        Reader expectedReader = new Reader();
        expectedReader.setUsername("craig");
        expectedReader.setPassword("password");
        expectedReader.setFullname("Craig Walls");
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attribute("reader",
                        samePropertyValuesAs(expectedReader)))
                .andExpect(model().attribute("books", hasSize(0)));
    }
}
