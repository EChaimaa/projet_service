package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByReference(String reference);
    int deleteByReference(String reference);
}
