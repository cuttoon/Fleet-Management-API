package com.fleet.FleetManagementAPI.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "trajectories")
public class Trajectories {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer taxi_id;

    @Column
    private LocalDate date;

    @Column
    private float latitude;

    @Column
    private float longitude;


}
