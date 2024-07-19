package com.vehicle.microservice_vehicle;


import com.vehicle.microservice_vehicle.entity.Vehicle;
import com.vehicle.microservice_vehicle.repository.VehicleRepository;
import com.vehicle.microservice_vehicle.service.IVehicleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class VehicleServiceTests {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private IVehicleService vehicleService;

    @Test
    public void testSaveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate("06KM018");

        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

        Vehicle savedVehicle = vehicleService.save(vehicle);
        assertNotNull(savedVehicle);
        assertEquals("06KM018", savedVehicle.getLicensePlate());
    }

    @Test
    public void testUpdateVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setLicensePlate("06KM018");

        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(vehicle));
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

        Vehicle updatedVehicle = vehicleService.update(1L, vehicle);
        assertNotNull(updatedVehicle);
        assertEquals("06KM018", updatedVehicle.getLicensePlate());
    }

    @Test
    public void testDeleteVehicle() {
        vehicleService.delete(1L);
        verify(vehicleRepository, times(1)).deleteById(1L);
    }
}
