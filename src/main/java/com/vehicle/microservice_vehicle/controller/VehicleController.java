package com.vehicle.microservice_vehicle.controller;

import com.vehicle.microservice_vehicle.entity.Vehicle;
import com.vehicle.microservice_vehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicle")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;


    @GetMapping("/getAllVehicle")
    public List<Vehicle> listVehiclees() {

        return vehicleService.findAll();
    }
    @PostMapping("/assignRoute")
    public Vehicle assignRoute(@RequestParam Long vehicleId, @RequestParam Long routeId) {
        return vehicleService.assignRoute(vehicleId, routeId);
    }
    @PostMapping("/createVehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @PutMapping("/updateVehicle")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle);
    }

    @DeleteMapping("/deleteVehicle/{id}")  //Hüseyin Bey, aslında api'den ID göndermek güvenlik açığı, Bunlar normalde POST İLE GÖNDERİLMELİ. öRNEK OLSUN DİYE YAPTIM
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
    }
}
