package com.healthcare.healthcare_backend.ServiceInterface;

import java.util.List;

import com.healthcare.healthcare_backend.Model.HealthDaw;

public interface HealthServiceInterface {

    public HealthDaw getService(Integer id);

    public List<HealthDaw> getAllServices();

    public HealthDaw addService(HealthDaw healthDaw);

    public HealthDaw updateService(HealthDaw healthDaw);

    public String deleteService(Integer id);

}
