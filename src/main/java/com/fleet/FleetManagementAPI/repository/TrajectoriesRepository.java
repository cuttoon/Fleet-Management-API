package com.fleet.FleetManagementAPI.repository;

import com.fleet.FleetManagementAPI.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {

    Page<Trajectories> findByTaxisAndDate(@Param("taxiId") Integer taxiId);
}



