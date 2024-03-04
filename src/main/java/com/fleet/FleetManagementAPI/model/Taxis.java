package com.fleet.FleetManagementAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "taxis")
public class Taxis {

    @Id
    private Integer id;

    @Column(name = "plate")
    private String plate;

    @JsonIgnore
    @OneToMany(mappedBy = "taxis", cascade = CascadeType.ALL)
    private Collection<Trajectories> itemsTrajectories = new ArrayList<>();


    public Taxis() {
    }

    public Taxis(Integer id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

   public Collection<Trajectories> getItemsTrajectories() {
        return itemsTrajectories;
    }

    public void setItemsTrajectories(List<Trajectories> itemsTrajectories) {
        this.itemsTrajectories = itemsTrajectories;
    }
}
