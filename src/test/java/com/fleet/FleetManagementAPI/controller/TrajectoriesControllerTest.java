package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.model.Trajectories;
import com.fleet.FleetManagementAPI.service.TrajectoriesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(TrajectoriesController.class)
@AutoConfigureMockMvc
class TrajectoriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrajectoriesService trajectoriesService;

    @InjectMocks
    private TrajectoriesController trajectoriesController;

    @Test
    void findByIdandDate() throws Exception {

        Taxis taxi = new Taxis(1, "ABC123");

        Trajectories trajectory = new Trajectories(1, taxi, LocalDateTime.now(), 1542646f, 145262565f);

        // Se crea una lista de trajecorias
        List<Trajectories> trajectoriesList = Collections.singletonList(trajectory);

        Page<Trajectories> trajectoriesPage = new PageImpl<>(trajectoriesList);

        // Mockeando del comportamiento del servicio
        Mockito.when(trajectoriesService.findByTaxiAndDates(Mockito.anyInt(), Mockito.anyString(),
                Mockito.any(Pageable.class))).thenReturn(trajectoriesPage);

        // -> solicitud GET utilizando mockMvc
        mockMvc.perform(MockMvcRequestBuilders.get("/trajectories/findByIdandDate")
                        .param("taxiId", String.valueOf(taxi.getId()))
                        .param("date", trajectory.getDate().toString())
                        .param("page", "0")  // Ajuste del tamaño de página a 10
                        .param("size", "20")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value(trajectory.getId()));
    }

    @Test
    void getLastUbication() throws Exception {

        // Datos de ejemplo
        Trajectories trajectory = new Trajectories();
        trajectory.setId(1);
        trajectory.setTaxis(new Taxis(6418, "ABC123"));
        trajectory.setDate(LocalDateTime.now());
        trajectory.setLatitude(1542646f);
        trajectory.setLongitude(145262565f);

        // Se crea una lista de elementos de tipo Trajectories
        List<Trajectories> trajectoryList = Collections.singletonList(trajectory);

        Page<Trajectories> trajectoryPage = new PageImpl<>(trajectoryList);

        Mockito.when(trajectoriesService.findByLastUbications(
                Mockito.eq(PageRequest.of(0, 1)))).thenReturn(trajectoryPage);

    }
}

