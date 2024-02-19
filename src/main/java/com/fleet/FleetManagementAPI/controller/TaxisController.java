package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.service.TaxisService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/taxis")
public class TaxisController {

    // inyección para el controlador
    private TaxisService taxisService;

    @Autowired
    public TaxisController(TaxisService taxisService){
        this.taxisService = taxisService;
    }

    @GetMapping(path = "/listar")
    public Page<Taxis> getTaxis(@PageableDefault(size = 20) Pageable pageable){

        return this.taxisService.getTaxis(pageable);
    }

    /*@GetMapping(path = "/listar")
    public List<Taxis> getTaxis(){
        return List.of(
                new Taxis(
                        2541L,
                        "platenumber"
                )
        );
    }*/
}
