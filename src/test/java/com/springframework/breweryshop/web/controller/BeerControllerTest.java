package com.springframework.breweryshop.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.breweryshop.web.model.BeerDto;
import com.springframework.breweryshop.web.services.BeerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {


    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    String url = "http://localhost:8080/";

    @Before
    public void setUp() {
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("PALE_ALE")
                .upc(123456789012L)
                .build();
    }

    @Test
    public void getBeer() throws Exception{
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
        mockMvc.perform(get(url + "/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Beer1")));
    }

    @Test
    public void handlePost() throws Exception{
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New test").build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        // given
        given(beerService.saveNewBeer(any())).willReturn(savedDto);
        // perform
        mockMvc.perform(post(url + "api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void handleUpdate() throws Exception{
        BeerDto beerDto = validBeer;
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put(url + "api/v1/beer/" + validBeer.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isNoContent());
        then(beerService).should().updateBeer(any(),any());
    }
}