package com.fleet.FleetManagementAPI.service;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.repository.TaxisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxisService {

    private final TaxisRepository taxisRepository;

    @Autowired
    public TaxisService(TaxisRepository taxisRepository){
        this.taxisRepository = taxisRepository;
    }

    public Page<Taxis> getTaxis(Pageable pageable){
        return taxisRepository.findAll(pageable);

    }

}
