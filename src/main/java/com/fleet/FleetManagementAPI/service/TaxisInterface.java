package com.fleet.FleetManagementAPI.service;

import com.fleet.FleetManagementAPI.model.Taxis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface TaxisInterface {

    public abstract Taxis findById(Integer id);

    public abstract Page<Taxis> findAll(Pageable pageable);
}
