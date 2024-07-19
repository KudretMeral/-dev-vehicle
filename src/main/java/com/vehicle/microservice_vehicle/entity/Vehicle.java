package com.vehicle.microservice_vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
public class Vehicle extends BaseEntity{

    @NotEmpty(message = "Plaka Boş Olamaz")
    @Column(name = "license_plate",nullable = false)
    private String licensePlate;
    @Column(name = "model")
    private String model;
    @Column(name = "capacity")
    private int capacity;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @ManyToOne
    private Route route;


    public Vehicle() {
    }

    public Vehicle( String licensePlate, String model, int capacity, LocalDateTime createTime, Route route) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.capacity = capacity;
        this.createTime = createTime;
        this.route = route;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
