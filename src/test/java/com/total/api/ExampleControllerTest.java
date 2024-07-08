package com.total.api;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.total.api.Controllers.ExampleController;
import com.total.api.Dtos.ExampleCreateDto;
import com.total.api.Entities.Example;
import com.total.api.Services.ExampleService;

@WebMvcTest(ExampleController.class)
public class ExampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleService exampleService;

    // In this case this is some dummy data
    private List<Example> listExamples = null;
    private Example exampleOne = null;
    private ExampleCreateDto exampleCreateDto = null;
    final private String urlController = "/api/example";

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        this.listExamples = Arrays.asList(new Example(1L, "Lucc", "Arias",
                1, 1500D, false, LocalDateTime.now(), LocalDateTime.now()),
                new Example(2L, "Yari", "Martinez",
                        1, 2000D, false, LocalDateTime.now(), LocalDateTime.now()));
        this.exampleOne = new Example(1L, "Lucc", "Arias",
                1, 1500D, false, LocalDateTime.now(), LocalDateTime.now());
        this.exampleCreateDto = new ExampleCreateDto("Lucc", "Arias",
                1, 1500D, false);
    }


    @Test
    public void test_GetStudentByNameAndClass() throws Exception {
        when(exampleService.getAll()).thenReturn(listExamples);
        this.mockMvc.perform(get(urlController + "/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_GetProductById() throws Exception {
        when(exampleService.getOne(eq(1L))).thenReturn(exampleOne);
        this.mockMvc
                .perform(get(urlController + "/find/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void test_AddProducto() throws JsonProcessingException, Exception {
        when(exampleService.save(eq(exampleCreateDto))).thenReturn(exampleOne);
        this.mockMvc
                .perform(post(urlController + "/create")
                        .content(new ObjectMapper().writeValueAsString(exampleCreateDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
