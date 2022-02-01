package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.ProjetMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjetMemberDao extends JpaRepository<ProjetMemberEntity, Long> {
    ProjetMemberEntity findByProjetReferenceAndEmployeMatricule(String projetReference, String employeMatricule);
    List<ProjetMemberEntity> findByProjetReference(String projetReference);
}
