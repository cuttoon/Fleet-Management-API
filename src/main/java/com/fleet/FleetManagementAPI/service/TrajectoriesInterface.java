package com.fleet.FleetManagementAPI.service;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface TrajectoriesInterface {

    // le borre el public abstract
    public abstract Page<Trajectories> findByTaxiAndDates(Integer taxiId, String date, Pageable pageable);

    public abstract Page<Trajectories> findAll(Pageable pageable);

    public abstract Page<Trajectories> findByLastUbications(Integer taxiId, Pageable pageable);
}
