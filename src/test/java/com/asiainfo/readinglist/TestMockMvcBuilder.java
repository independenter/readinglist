package com.asiainfo.readinglist;

;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.asiainfo.readinglist.entiy.Book;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ReadinglistApplication.class})
@WebAppConfiguration
public class TestMockMvcBuilder {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rl/readingList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books",
                        Matchers.is(Matchers.empty())));
    }

    @Test
    public void homePage1() throws Exception {

        String example= "{\"id\":1, \"name\":\"kqzu\"}";
        mockMvc.perform(get("/rl/readingList"))
                //.contentType(MediaType.APPLICATION_JSON)   //用contentType表示具体请求中的媒体类型信息，MediaType.APPLICATION_JSON表示互联网媒体类型的json数据格式（见备注）
                //.content(example)
                //.accept(MediaType.APPLICATION_JSON) //accept指定客户端能够接收的内容类型
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")) //验证响应contentType == application/json;charset=UTF-8
                .andExpect(jsonPath("$.id").value(1)) //验证id是否为1，jsonPath的使用
                .andExpect(jsonPath("$.name").value("kqzhu"));  // 验证name是否等于Zhukeqian
    }

    @Test
    public void postBook() throws Exception {
        mockMvc.perform(post("/rl/craig")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "BOOK TITLE")
                .param("author", "BOOK AUTHOR")
                .param("isbn", "1234567890")
                .param("description", "DESCRIPTION"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/craig"));
        Book expectedBook = new Book();
        expectedBook.setId(28L);
        expectedBook.setReader("craig");
        expectedBook.setTitle("BOOK TITLE");
        expectedBook.setAuthor("BOOK AUTHOR");
        expectedBook.setIsbn("1234567890");
        expectedBook.setDescription("DESCRIPTION");
        mockMvc.perform(get("/rl/craig"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", hasSize(1)))
                .andExpect(model().attribute("books",
                        contains(samePropertyValuesAs(expectedBook))));
    }
}
