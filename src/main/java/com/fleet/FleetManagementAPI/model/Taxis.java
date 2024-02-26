package com.fleet.FleetManagementAPI.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "taxis")
public class Taxis {

    @Id
    private Integer id;

    @Column
    private String plate;

    /* @OneToMany(mappedBy = "taxis")
    private Collection<Trajectories> itemsTrajectories = new ArrayList<>(); */


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

   /* public Collection<Trajectories> getItemsTrajectories() {
        return itemsTrajectories;
    }

    public void setItemsTrajectories(Collection<Trajectories> itemsTrajectories) {
        this.itemsTrajectories = itemsTrajectories;
    } */
}
