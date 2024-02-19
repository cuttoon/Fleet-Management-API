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

    @Column
    private Integer taxi_id;

    @Column
    private LocalDate date;

    @Column
    private float latitude;

    @Column
    private float longitude;

    @ManyToOne
    @JoinColumn(name = "taxi_id", nullable = false)
    private Taxis taxis;

    public Trajectories() {
    }

    public Trajectories(Integer taxi_id, LocalDate date, float latitude, float longitude, Taxis taxis) {
        this.taxi_id = taxi_id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.taxis = taxis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(Integer taxi_id) {
        this.taxi_id = taxi_id;
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

    public Taxis getTaxis() {
        return taxis;
    }

    public void setTaxis(Taxis taxis) {
        this.taxis = taxis;
    }
}
