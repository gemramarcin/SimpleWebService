package com.example.gtj.footballers;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(FootballerController.class)
public class FootballerControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private FootballerService service;

    @Test
    @DisplayName("should return JSON array")
    public void shouldReturnJsonArray()
            throws Exception {
        //given
        Footballer footballer = new Footballer();
        footballer.setLastName("Ronaldo");

        List<Footballer> allFootballers = new ArrayList<>();
        allFootballers.add(footballer);

        //when
        given(service.getAll()).willReturn(allFootballers);

        //then
        mvc.perform(get("/footballers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'lastName':'Ronaldo'}]"));
    }
}




