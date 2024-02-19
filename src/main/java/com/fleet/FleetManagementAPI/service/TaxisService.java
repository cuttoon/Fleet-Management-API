package com.fleet.FleetManagementAPI.service;

import com.fleet.FleetManagementAPI.model.Taxis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxisService {

    public List<Taxis> getTaxis(){
        return List.of(
                new Taxis(
                        245,
                        "plate123"
                )
        );

    }

}
