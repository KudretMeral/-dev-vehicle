package com.vehicle.microservice_vehicle.controller;

import com.vehicle.microservice_vehicle.entity.Route;
import com.vehicle.microservice_vehicle.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/routes")
public class RouteController {

    @Autowired
    IRouteService routeService;

    @GetMapping("/getAllRoutes")
    public List<Route> listRoutes() {
        return routeService.findAll();
    }

    @PostMapping("/createRoute")
    public Route createRoute(@RequestBody Route route) {
        return routeService.save(route);
    }

    @PutMapping("/updateRoute")
    public Route updateRoute( @RequestBody Route route) {
        return routeService.update(route);
    }

    @DeleteMapping("/deleteRoute/{id}")
    public void deleteRoute(@PathVariable Long id) {
        routeService.delete(id);
    }
}
