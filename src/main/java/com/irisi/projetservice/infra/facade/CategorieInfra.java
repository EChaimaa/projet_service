package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.CategorieEntity;

import java.util.List;

public interface CategorieInfra extends AbstractInfra {
    CategoriePojo findByReference(String reference);

    int deleteByReference(String reference);

    CategorieEntity save(CategorieEntity categorieEntity);

    CategorieEntity save(CategoriePojo categoriePojo);

    CategorieEntity update(CategorieEntity clientEntity);

    CategorieEntity update(CategoriePojo categoriePojo);

    List<CategorieEntity> findAll();
}