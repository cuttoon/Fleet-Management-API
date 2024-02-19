package com.fleet.FleetManagementAPI.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "trajectories")
public class Trajectories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "taxi_id", nullable = false)
    private Taxis taxis;

    @Column
    private LocalDate date;

    @Column
    private float latitude;

    @Column
    private float longitude;

    public Trajectories() {
    }

    public Trajectories(Taxis taxis, LocalDate date, float latitude, float longitude) {
        this.taxis = taxis;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Taxis getTaxis() {
        return taxis;
    }

    public void setTaxis(Taxis taxis) {
        this.taxis = taxis;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
