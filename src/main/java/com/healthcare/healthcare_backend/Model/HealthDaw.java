package com.healthcare.healthcare_backend.Model;

import com.healthcare.healthcare_backend.Entity.HealthEntity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class HealthDaw {
    private Integer serviceID;
    private String serviceName;
    private String serviceDescription;
    private Integer servicePrice;

    public HealthDaw(Integer serviceID, String serviceName, String serviceDescription, Integer servicePrice) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
    }

    public HealthDaw(HealthEntity healthEntity) {
        this.serviceID = healthEntity.getServiceID();
        this.serviceName = healthEntity.getServiceName();
        this.serviceDescription = healthEntity.getServiceDescription();
        this.servicePrice = healthEntity.getServicePrice();
    }
}