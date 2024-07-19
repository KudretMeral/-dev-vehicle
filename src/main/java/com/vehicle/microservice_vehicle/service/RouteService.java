package com.vehicle.microservice_vehicle.service;

import com.vehicle.microservice_vehicle.entity.Route;
import com.vehicle.microservice_vehicle.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RouteService implements IRouteService{

    @Autowired
    private RouteRepository routeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    @Transactional
    public Route save(Route route) {
        if (route.getStations().size() < 2) {
            throw new IllegalArgumentException("Bir rota en az 2 istasyon içermelidir.");
        }
        return routeRepository.save(route);
    }

    @Override
    @Transactional
    public Route update(Route route) {
        Route existingRoute = routeRepository.findById(route.getId())
                .orElseThrow(() -> new IllegalArgumentException("Rota Bulunamadı"));
        existingRoute.setStations(route.getStations());
        existingRoute.setName(route.getName());
        return routeRepository.save(existingRoute);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        routeRepository.deleteById(id);
    }
}
