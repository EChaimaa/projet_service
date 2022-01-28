package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.ClientEntity;

import java.util.List;

public interface ClientInfra extends AbstractInfra {
    ClientPojo findByReference(String reference);

    int deleteByReference(String reference);

    ClientEntity save(ClientEntity clientEntity);

    ClientPojo save(ClientPojo clientPojo);

    ClientEntity update(ClientEntity clientEntity);

    ClientEntity update(ClientPojo clientPojo);

    List<ClientEntity> findAll();
}
