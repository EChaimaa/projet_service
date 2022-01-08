package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.ProjetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDao extends JpaRepository<ProjetEntity, Long> {
    ProjetEntity findByReference(String reference);
    int deleteByReference(String reference);
}
