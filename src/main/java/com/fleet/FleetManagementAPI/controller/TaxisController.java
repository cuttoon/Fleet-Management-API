package com.fleet.FleetManagementAPI.controller;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.repository.TaxisRepository;
import com.fleet.FleetManagementAPI.service.TaxisService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/taxis")
public class TaxisController {

    // inyección para el controlador
    private TaxisService taxisService;

    private TaxisRepository taxisRepository;

    @Autowired
    public TaxisController(TaxisService taxisService){
        this.taxisService = taxisService;
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<?> getTaxis(){

        final Pageable pageable = PageRequest.of(0, 10,
                Sort.by(Sort.Direction.ASC, "plate"));

        // return this.taxisService.getTaxis(pageable);

        Page<Taxis> collection = taxisService.findAll(pageable);

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(collection, HttpStatus.OK);
        }
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
