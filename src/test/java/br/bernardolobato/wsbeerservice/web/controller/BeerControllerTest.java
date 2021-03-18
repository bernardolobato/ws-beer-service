package br.bernardolobato.wsbeerservice.web.controller;

import br.bernardolobato.wsbeerservice.controller.BeerController;
import br.bernardolobato.wsbeerservice.web.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getBeerById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"+ UUID.randomUUID().toString())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoasJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoasJson)
        )
                .andExpect(status().isCreated());
    }

    @Test
    void updateNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoasJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+ UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoasJson))
                .andExpect(status().isOk());
    }
}
