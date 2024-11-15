package com.healthcare.healthcare_backend.Entity;

import com.healthcare.healthcare_backend.Model.HealthDaw;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HealthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceID;
    private String serviceName;
    @Column(length = 5000)
    private String serviceDescription;
    private Integer servicePrice;

    public HealthEntity(HealthDaw healthDaw) {
        this.serviceName = healthDaw.getServiceName();
        this.serviceDescription = healthDaw.getServiceDescription();
        this.servicePrice = healthDaw.getServicePrice();
    }
}
