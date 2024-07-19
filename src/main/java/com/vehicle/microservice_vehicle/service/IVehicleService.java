package com.vehicle.microservice_vehicle.service;

import com.vehicle.microservice_vehicle.entity.Vehicle;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IVehicleService {

    List<Vehicle> findAll();


    Vehicle save(Vehicle vehicle);


    Vehicle update(Vehicle vehicle);


    void delete(Long id);


    Vehicle assignRoute(Long vehicleId, Long routeId);
}
