package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.projetDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projetDetailDao extends JpaRepository<projetDetailEntity, Long> {
    projetDetailEntity findByProjetMemberId(Long projetMemberId);
    int deleteByProjetMemberId(Long projetMemberId);
}
