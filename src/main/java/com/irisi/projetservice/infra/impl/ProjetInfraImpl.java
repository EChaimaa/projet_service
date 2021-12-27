package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.entity.ProjetEntity;
import com.irisi.projetservice.infra.facade.ProjetInfra;

import java.util.List;

public class ProjetInfraImpl extends AbstractInfraImpl implements ProjetInfra {

    @Override
    public ProjetPojo findByReference(String reference) {
        return null;
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public ProjetEntity save(ProjetEntity projetEntity) {
        return null;
    }

    @Override
    public ProjetEntity save(ProjetPojo projetPojo) {
        return null;
    }

    @Override
    public ProjetEntity update(ProjetEntity projetEntity) {
        return null;
    }

    @Override
    public ProjetEntity update(ProjetPojo projetPojo) {
        return null;
    }

    @Override
    public List<ProjetEntity> findAll() {
        return null;
    }
}
