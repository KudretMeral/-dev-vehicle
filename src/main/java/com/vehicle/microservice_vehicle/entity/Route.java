package com.vehicle.microservice_vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Route extends BaseEntity{

    @NotEmpty(message = "Rota İsmi Boş Olamaz")
    @Column(name = "name")
    private String name;

    @ManyToMany
    @Size(min = 2, message = "En Az 2 İstasyon olmalı")
    private List<Station> stations;

    public Route() {
    }

    public Route(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
