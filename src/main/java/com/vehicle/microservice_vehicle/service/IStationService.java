package com.vehicle.microservice_vehicle.service;

import com.vehicle.microservice_vehicle.entity.Station;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IStationService {
    List<Station> findAll();

    Station save(Station station);

    Station update(Station station);

    void delete(Long id);
}
