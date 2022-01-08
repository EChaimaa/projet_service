package com.irisi.projetservice.infra.dao;

import com.irisi.projetservice.infra.entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<CategorieEntity, Long> {
    CategorieEntity findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
