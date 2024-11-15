package com.healthcare.healthcare_backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthcare.healthcare_backend.Entity.HealthEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepo extends JpaRepository<HealthEntity, Integer> {

}
