package com.fleet.FleetManagementAPI.repository;

import com.fleet.FleetManagementAPI.model.Taxis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxisRepository extends JpaRepository<Taxis, Integer> {

    // indicar de que modelo se hara el CRUD

}
