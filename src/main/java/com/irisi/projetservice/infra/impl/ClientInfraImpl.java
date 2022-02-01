package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.converter.ClientConverter;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.dao.ClientDao;
import com.irisi.projetservice.infra.entity.ClientEntity;
import com.irisi.projetservice.infra.facade.ClientInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientInfraImpl extends AbstractInfraImpl implements ClientInfra {
    @Autowired
    ClientDao clientDao;

    @Override
    public ClientPojo findByReference(String reference) {
        ClientEntity clientEntity = clientDao.findByReference(reference);
        if(clientEntity == null){
            return null;
        }
        ClientConverter clientConverter = new ClientConverter();
        ClientPojo clientPojo = clientConverter.toPojo(clientEntity);
        return clientPojo;
    }

    @Override
    public int deleteByReference(String reference) {
        return clientDao.deleteByReference(reference);
    }

    @Override
    public ClientEntity save(ClientEntity clientEntity) {
        if(findByReference(clientEntity.getReference()) != null){
            return null;
        }
        return clientDao.save(clientEntity);
    }

    @Override
    public ClientPojo save(ClientPojo clientPojo) {
        ClientConverter clientConverter = new ClientConverter();
        ClientEntity clientEntity = clientConverter.toEntity(clientPojo);
        ClientPojo client = clientConverter.toPojo(save(clientEntity));
        return client;
    }

    @Override
    public ClientEntity update(ClientEntity clientEntity) {
        if(findByReference(clientEntity.getReference()) == null){
            return null;
        }
        return clientDao.save(clientEntity);
    }

    @Override
    public ClientEntity update(ClientPojo clientPojo) {
        ClientConverter clientConverter = new ClientConverter();
        ClientEntity clientEntity = clientConverter.toEntity(clientPojo);
        return update(clientEntity);
    }

    @Override
    public List<ClientEntity> findAll() {
        return clientDao.findAll();
    }
}
