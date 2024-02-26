package com.fleet.FleetManagementAPI.service;

import com.fleet.FleetManagementAPI.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TrajectoriesInterface {

    public abstract Page<Trajectories> findByTaxiAndDate(Integer id, LocalDateTime date, Pageable pageable);
}
