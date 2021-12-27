package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.entity.ClientEntity;
import com.irisi.projetservice.infra.facade.ClientInfra;

import java.util.List;

public class ClientInfraImpl extends AbstractInfraImpl implements ClientInfra {
    @Override
    public ClientPojo findByReference(String reference) {
        return null;
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public ClientEntity save(ClientEntity clientEntity) {
        return null;
    }

    @Override
    public ClientEntity save(ClientPojo clientPojo) {
        return null;
    }

    @Override
    public ClientEntity update(ClientEntity clientEntity) {
        return null;
    }

    @Override
    public ClientEntity update(ClientPojo clientPojo) {
        return null;
    }

    @Override
    public List<ClientEntity> findAll() {
        return null;
    }
}
