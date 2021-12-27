package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.entity.CategorieEntity;
import com.irisi.projetservice.infra.facade.CategorieInfra;

import java.util.List;

public class CategorieInfraImpl extends AbstractInfraImpl implements CategorieInfra {
    @Override
    public CategoriePojo findByReference(String reference) {
        return null;
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public CategorieEntity save(CategorieEntity categorieEntity) {
        return null;
    }

    @Override
    public CategorieEntity save(CategoriePojo categoriePojo) {
        return null;
    }

    @Override
    public CategorieEntity update(CategorieEntity clientEntity) {
        return null;
    }

    @Override
    public CategorieEntity update(CategoriePojo categoriePojo) {
        return null;
    }

    @Override
    public List<CategorieEntity> findAll() {
        return null;
    }
}
