package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.service.TaxisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;
import java.util.Collections;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(TaxisController.class)
@AutoConfigureMockMvc
class TaxiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaxisService taxisService;


    @Test
    void getTaxis() throws Exception {

        // mockeando data
        Taxis taxis = new Taxis();
        taxis.setId(7957);
        taxis.setPlate("ABCD");

        Pageable pageable = PageRequest.of(0, 10);
        Page<Taxis> taxisPage = new PageImpl<>(Collections.singletonList(taxis), pageable, 1);

        Mockito.when(taxisService.findAll(pageable)).thenReturn(taxisPage);

        // mockMvc.perform(); para el GET
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/taxis/listar")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value(7957))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].plate").value("ABCD"));
    }
}
