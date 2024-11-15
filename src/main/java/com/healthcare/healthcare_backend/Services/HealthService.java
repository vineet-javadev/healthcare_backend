package com.healthcare.healthcare_backend.Services;

import com.healthcare.healthcare_backend.Entity.HealthEntity;
import com.healthcare.healthcare_backend.Model.HealthDaw;
import com.healthcare.healthcare_backend.Repo.HealthRepo;
import com.healthcare.healthcare_backend.ServiceInterface.HealthServiceInterface;
import com.healthcare.healthcare_backend.Exception.ResourceNotFoundException; // Custom exception
import com.healthcare.healthcare_backend.Exception.InvalidInputException; // Custom exception

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthService implements HealthServiceInterface {

    @Autowired(required = true)
    private HealthRepo healthRepository;

    // Here we get a particular service
    @Override
    public HealthDaw getService(Integer id) {
        return healthRepository.findById(id)
                .map(HealthDaw::new)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id: " + id));
    }

    // Here we get all services
    @Override
    public List<HealthDaw> getAllServices() {
        List<HealthDaw> lst = new ArrayList<>();
        for (HealthEntity iterable_element : healthRepository.findAll()) {
            lst.add(new HealthDaw(iterable_element));
        }
        return lst;
    }

    // Here we add new service in database
    @Override
    public HealthDaw addService(HealthDaw healthDaw) {
        if (healthDaw == null || healthDaw.getServiceName() == null || healthDaw.getServiceDescription() == null
                || healthDaw.getServicePrice() == null) {
            throw new InvalidInputException("Invalid service data provided (Every field are required )");
        }
        HealthEntity temp = new HealthEntity(healthDaw);
        return new HealthDaw(healthRepository.save(temp));
    }

    // Here we update a particular service
    @Override
    public HealthDaw updateService(HealthDaw healthDaw) {
        Integer id = healthDaw.getServiceID();
        if (!healthRepository.existsById(id)) {
            throw new ResourceNotFoundException("Service not found with id: " + id);
        }
        if (healthDaw.getServiceDescription().length() >= 5000) {
            throw new InvalidInputException("Invalid service data provided ( Description is too Long )");
        }
        HealthDaw dataFromDB = getService(id);
        HealthEntity temp = new HealthEntity();
        temp.setServiceID(id);
        if (healthDaw.getServiceName() != null) {
            temp.setServiceName(healthDaw.getServiceName());
        } else {
            temp.setServiceName(dataFromDB.getServiceName());
        }
        if (healthDaw.getServiceDescription() != null) {
            temp.setServiceDescription(healthDaw.getServiceDescription());
        } else {
            temp.setServiceDescription(dataFromDB.getServiceDescription());
        }
        if (healthDaw.getServicePrice() != null) {
            temp.setServicePrice(healthDaw.getServicePrice());
        } else {
            temp.setServicePrice(dataFromDB.getServicePrice());
        }

        return new HealthDaw(healthRepository.save(temp));
    }

    // Here we delete a particular service
    @Override
    public String deleteService(Integer id) {
        if (healthRepository.existsById(id)) {
            healthRepository.deleteById(id);
            return "Service deleted";
        } else {
            throw new ResourceNotFoundException("Service not found with id: " + id);
        }
    }
}