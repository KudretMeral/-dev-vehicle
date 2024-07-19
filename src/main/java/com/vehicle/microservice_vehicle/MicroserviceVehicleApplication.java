package com.vehicle.microservice_vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="customAuditorAware")
@SpringBootApplication
public class MicroserviceVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceVehicleApplication.class, args);
	}

}
