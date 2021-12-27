package com.irisi.projetservice.infra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<EmployeDao, Long> {
    EmployeDao findByMatricule(String matricule);
}
