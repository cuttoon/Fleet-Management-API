package com.fleet.FleetManagementAPI.repository;

import com.fleet.FleetManagementAPI.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {

    // @Query("SELECT t FROM Trajectories t WHERE t.taxis.id = :taxiId")
    @Query("SELECT t FROM Trajectories t WHERE t.taxis.id = ?1 AND TO_CHAR(t.date, 'dd-MM-yyyy') = ?2")
    Page<Trajectories> findByTaxisAndDate(@RequestParam("taxiId") Integer taxiId, @RequestParam("date") String date, Pageable pageable);

    //@Query("SELECT t FROM Trajectories t WHERE t.taxis.id = :taxiId AND (t.taxis.id, t.date) IN (SELECT t2.taxis.id, MAX(t2.date) FROM Trajectories t2 WHERE t2.taxis.id = :taxiId GROUP BY t2.taxis.id)")
    @Query("SELECT t FROM Trajectories t WHERE t.id IN " +
            "(SELECT MAX(t2.id) FROM Trajectories t2 GROUP BY t2.taxis) ")
    Page<Trajectories> findByLastUbication(Pageable pageable);
}



