package com.vehicle.microservice_vehicle.service;

import com.vehicle.microservice_vehicle.entity.Route;
import com.vehicle.microservice_vehicle.entity.Vehicle;
import com.vehicle.microservice_vehicle.repository.RouteRepository;
import com.vehicle.microservice_vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Autowired
    private RouteRepository routeRepository;

    @Transactional(readOnly = true)  //Hüseyin Bey burda flush'ın önüne geçeriz.
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Transactional
    @Override
    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getLicensePlate() == null || vehicle.getLicensePlate().isEmpty()) {
            throw new IllegalArgumentException("Plaka Boş Olamaz");
        }
        return vehicleRepository.save(vehicle);
    }

    @Transactional
    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicle.getId())
                .orElseThrow(() -> new IllegalArgumentException("Otobüs Bulunamadı"));
        existingVehicle.setLicensePlate(vehicle.getLicensePlate());
        existingVehicle.setRoute(vehicle.getRoute());
        existingVehicle.setCapacity(vehicle.getCapacity());
        existingVehicle.setModel(vehicle.getModel());
        return vehicleRepository.save(existingVehicle);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Vehicle assignRoute(Long vehicleId, Long routeId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Otobüs Bulunamadı"));
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Rota Bulunamadı"));
        vehicle.setRoute(route);
        return vehicleRepository.save(vehicle);
    }
}
