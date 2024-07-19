package com.vehicle.microservice_vehicle.service;

import com.vehicle.microservice_vehicle.entity.Route;

import java.util.List;

public interface IRouteService {
    List<Route> findAll();

    Route save(Route route);

    Route update(Route route);

    void delete(Long id);
}
