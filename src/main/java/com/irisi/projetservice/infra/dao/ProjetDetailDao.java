package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.ProjetDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDetailDao extends JpaRepository<ProjetDetailEntity, Long> {

//    ProjetDetailEntity findByProjetMemberId(Long projetMemberId);

    int deleteByProjetMemberId(Long projetMemberId);
}
