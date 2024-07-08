package com.total.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.total.api.Controllers.ExampleController;
import com.total.api.Services.ExampleService;

@WebMvcTest(ExampleController.class)
public class ExampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleService ExampleService;
}
