package com.vehicle.microservice_vehicle.service;

import com.vehicle.microservice_vehicle.entity.Station;
import com.vehicle.microservice_vehicle.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StationService implements IStationService{


    @Autowired
    private StationRepository stationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    @Transactional
    public Station save(Station station) {
        return stationRepository.save(station);
    }

    @Override
    @Transactional
    public Station update(Station station) {
        Station existingStation = stationRepository.findById(station.getId())
                .orElseThrow(() -> new IllegalArgumentException("İstasyon Bulunamadı"));
        existingStation.setName(station.getName());
        existingStation.setLocation(station.getLocation());
        return stationRepository.save(existingStation);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        stationRepository.deleteById(id);
    }
}
