package com.farmcollector.FarmReportAPI.controller;

import com.farmcollector.FarmReportAPI.dto.PlantedDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FarmDataAppControllerTest {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void testPlantedApi() throws Exception {

            PlantedDto dto = new PlantedDto();
            dto.setFarmName("MyFarm");
            dto.setSeason("2025");
            dto.setCrop("Corn");
            dto.setPlantingAreaAcres(23);
            dto.setExpectedHarvestTons(100);

            ObjectMapper mapper = new ObjectMapper();

            mockMvc.perform(post("/api/planted")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(dto)))
                    .andExpect(status().isCreated());
        }



}

