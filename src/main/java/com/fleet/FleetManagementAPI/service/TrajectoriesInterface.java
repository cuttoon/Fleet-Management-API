package com.fleet.FleetManagementAPI.service;

import com.fleet.FleetManagementAPI.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface TrajectoriesInterface {

    // le borre el public abstract
    Page<Trajectories> findByTaxiAndDate(Integer taxiId, LocalDateTime  date, Pageable pageable);
}
