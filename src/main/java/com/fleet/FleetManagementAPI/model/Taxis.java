package com.fleet.FleetManagementAPI.model;

public class Taxis {

    private Long id;
    private String plate;

    public Taxis() {
    }

    public Taxis(Long id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    public Taxis(String plate) {
        this.plate = plate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
