package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.ProjetMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetMemberDao extends JpaRepository<ProjetMemberEntity, Long> {
    ProjetMemberEntity findByReference(String reference);
}