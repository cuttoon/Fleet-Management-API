package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Trajectories;
import com.fleet.FleetManagementAPI.repository.TaxisRepository;
import com.fleet.FleetManagementAPI.repository.TrajectoriesRepository;
import com.fleet.FleetManagementAPI.service.TaxisService;
import com.fleet.FleetManagementAPI.service.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/trajectories")
public class TrajectoriesController {

    private final TrajectoriesService trajectoriesService;

    public TrajectoriesController(TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }


    // /listar/{id}/date/{date}
    /* @GetMapping("/listar")
    public ResponseEntity<?> getUbication(
            @RequestParam Integer id,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime date,
            Pageable pageable) {
        Page<Trajectories> trajectories = trajectoriesService.findByTaxiAndDate(id, date, pageable);
        // return new ResponseEntity<>(trajectories, HttpStatus.OK);

        if(trajectories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(trajectories, HttpStatus.OK);
        }
    } */

    @GetMapping("/listar")
    public ResponseEntity<Page<Trajectories>> getUbication(
            @RequestParam Integer taxiId,
            @RequestParam  @DateTimeFormat(pattern = "yyy-MM-dd") LocalDateTime date,
            Pageable pageable) {
        Page<Trajectories> trajectories = trajectoriesService.findByTaxiAndDate(taxiId, date, pageable);
        // return new ResponseEntity<>(trajectories, HttpStatus.OK);

        if(trajectories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(trajectories, HttpStatus.OK);
        }
    }

}
