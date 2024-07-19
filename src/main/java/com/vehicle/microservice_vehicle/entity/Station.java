package com.vehicle.microservice_vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Station extends BaseEntity{

    @NotEmpty(message = "İstasyon İsmi Boş Olamaz")
    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;


    public Station() {
    }

    public Station(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
