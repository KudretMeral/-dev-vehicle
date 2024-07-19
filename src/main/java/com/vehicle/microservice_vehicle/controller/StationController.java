package com.vehicle.microservice_vehicle.controller;

import com.vehicle.microservice_vehicle.entity.Station;
import com.vehicle.microservice_vehicle.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stations")
public class StationController {

    @Autowired
    IStationService stationService;


    @GetMapping("/getAllStations")
    public List<Station> listStations() {
        return stationService.findAll();
    }

    @PostMapping("/createStation")
    public Station createStation(@RequestBody Station station) {
        return stationService.save(station);
    }

    @PutMapping("/updateStation")
    public Station updateStation(@RequestBody Station station) {
        return stationService.update(station);
    }

    @DeleteMapping("/deleteStation/{id}")
    public void deleteStation(@PathVariable Long id) {
        stationService.delete(id);
    }
}
