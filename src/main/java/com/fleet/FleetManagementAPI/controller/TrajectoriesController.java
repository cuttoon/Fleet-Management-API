package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.model.Trajectories;
import com.fleet.FleetManagementAPI.repository.TaxisRepository;
import com.fleet.FleetManagementAPI.repository.TrajectoriesRepository;
import com.fleet.FleetManagementAPI.service.TaxisService;
import com.fleet.FleetManagementAPI.service.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/trajectories")
public class TrajectoriesController {

    private final TrajectoriesService trajectoriesService;

    public TrajectoriesController(TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }


    @GetMapping(path = "/findByIdandDate")
    public ResponseEntity<Page<Trajectories>> getTrajectories(
            @RequestParam Integer taxiId,
            @RequestParam String date,
            Pageable pageable) {

        Page<Trajectories> trajectories = trajectoriesService.findByTaxiAndDates(taxiId, date, pageable);

        if(trajectories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(trajectories, HttpStatus.OK);
        }
    }

    @GetMapping("/lastUbication")
    public ResponseEntity<Page<Trajectories>> getLastUbication(
            @RequestParam Integer taxiId,
            Pageable pageable) {

        Page<Trajectories> trajectories = trajectoriesService.findByLastUbications(taxiId, pageable);

        if(trajectories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(trajectories, HttpStatus.OK);
        }
    }

}
