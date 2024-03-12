package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Trajectories;
import com.fleet.FleetManagementAPI.service.TrajectoriesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            Pageable pageable) {

        Page<Trajectories> trajectories = trajectoriesService.findByLastUbications(pageable);

        if(trajectories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(trajectories, HttpStatus.OK);
        }
    }

}
