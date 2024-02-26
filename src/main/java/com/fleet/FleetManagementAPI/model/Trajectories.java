package com.fleet.FleetManagementAPI.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "trajectories")
public class Trajectories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="taxi_id", nullable = false)
    private Taxis taxis;

    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd", iso= DateTimeFormat.ISO.DATE)
    private LocalDateTime date;

    @Column
    private float latitude;

    @Column
    private float longitude;

    public Trajectories() {
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
