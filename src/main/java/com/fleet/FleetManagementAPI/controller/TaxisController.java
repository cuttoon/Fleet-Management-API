package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Taxis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/taxis")
public class TaxisController {

    public TaxisController(){
    }

    @GetMapping(path = "/listar")
    public List<Taxis> getTaxis(){
        return List.of(
                new Taxis(
                        2541L,
                        "platenumber"
                )
        );
    }
}
