package com.fleet.FleetManagementAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NamedQuery(name = "Trajectories.findByTaxisAndDate", query = "select a from Trajectories a where a.taxis=:taxiId")
@Entity
@Table(name = "trajectories")
public class Trajectories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnoreProperties(value = "itemsTrajectories")
    @ManyToOne
    @JoinColumn(name="taxi_id", nullable = false, referencedColumnName = "id")
    private Taxis taxis;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    public Trajectories() {
    }

    public Trajectories(Integer id, Taxis taxis, LocalDateTime date, Float latitude, Float longitude) {
        this.id = id;
        this.taxis = taxis;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Trajectories(Taxis taxis, LocalDateTime date, float latitude, float longitude) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
