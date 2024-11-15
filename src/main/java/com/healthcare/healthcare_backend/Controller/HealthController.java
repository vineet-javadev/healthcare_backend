package com.healthcare.healthcare_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.healthcare_backend.Model.HealthDaw;
import com.healthcare.healthcare_backend.Services.HealthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HealthController {

    @Autowired(required = true)
    private HealthService healthService;

    @GetMapping("/healthService/{serviceID}") // This is the endpoint
    public HealthDaw getService(@PathVariable Integer serviceID) {
        return healthService.getService(serviceID);
    }

    @GetMapping("/healthServices") // This is the endpoint
    public List<HealthDaw> getServices() {
        System.out.println("request to get all data");
        return healthService.getAllServices();
    }

    @PostMapping("/healthService/addService") // This is the endpoint
    public HealthDaw addService(@RequestBody HealthDaw healthDaw) {
        return healthService.addService(healthDaw);
    }

    @PutMapping("/healthService/updateService") // This is the endpoint
    public HealthDaw updateService(@RequestBody HealthDaw healthDaw) {
        return healthService.updateService(healthDaw);
    }

    @DeleteMapping("/healthService/deleteService/{id}") // This is the endpoint
    public String deleteService(@PathVariable Integer id) {
        return healthService.deleteService(id);
    }

}
