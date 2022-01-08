package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<EmployeEntity, Long> {
    EmployeEntity findByMatricule(String matricule);
    int deleteByMatricule(String matricule);
}
