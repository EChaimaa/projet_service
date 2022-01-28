package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.CategorieEntity;

import java.util.List;

public interface CategorieInfra extends AbstractInfra {
    CategoriePojo findByLibelle(String libelle);

    int deleteByLibelle(String libelle);

    CategorieEntity save(CategorieEntity categorieEntity);

    CategoriePojo save(CategoriePojo categoriePojo);

    CategorieEntity update(CategorieEntity clientEntity);

    CategorieEntity update(CategoriePojo categoriePojo);

    List<CategorieEntity> findAll();
}
