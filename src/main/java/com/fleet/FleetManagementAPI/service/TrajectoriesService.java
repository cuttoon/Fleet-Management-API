package com.fleet.FleetManagementAPI.service;

import com.fleet.FleetManagementAPI.model.Taxis;
import com.fleet.FleetManagementAPI.model.Trajectories;
import com.fleet.FleetManagementAPI.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TrajectoriesService implements TrajectoriesInterface{

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    @Override
    public Page<Trajectories> findByTaxiAndDates(Integer taxiId) {
        return trajectoriesRepository.findByTaxisAndDate(taxiId);
    }

    @Override
    public Page<Trajectories> findAll(Pageable pageable) {
        return trajectoriesRepository.findAll(pageable);
    }
}
