package com.oocl.web.sampleWebApp.controller;

import com.oocl.web.sampleWebApp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_check_has_location_and_status_code_is_201() throws Exception {
        String userJsonString = "{ \"usename\": \"Skittle\"}";
        this.mockMvc
                .perform(post("/users").contentType("application/json").content(userJsonString))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/users/0"));
    }

}
