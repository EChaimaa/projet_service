package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.converter.ProjetConverter;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.dao.ProjetDao;
import com.irisi.projetservice.infra.entity.ClientEntity;
import com.irisi.projetservice.infra.entity.ProjetEntity;
import com.irisi.projetservice.infra.facade.ProjetInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetInfraImpl extends AbstractInfraImpl implements ProjetInfra {
    @Autowired
    ProjetDao projetDao;

    @Override
    public ProjetPojo findByReference(String reference) {
        ProjetEntity projetEntity = projetDao.findByReference(reference);
        if(projetEntity == null){
            return null;
        }
        ProjetPojo projetPojo = new ProjetPojo();
        BeanUtils.copyProperties(projetEntity, projetPojo);
        return projetPojo;
    }

    @Override
    public int deleteByReference(String reference) {
        return projetDao.deleteByReference(reference);
    }

    @Override
    public ProjetEntity save(ProjetEntity projetEntity) {
        if(findByReference(projetEntity.getReference()) != null){
            return null;
        }
        return projetDao.save(projetEntity);
    }

    @Override
    public ProjetPojo save(ProjetPojo projetPojo) {
        ProjetConverter projetConverter = new ProjetConverter();
        ProjetEntity projetEntity = projetConverter.toEntity(projetPojo);
        ProjetPojo projet = projetConverter.toPojo(save(projetEntity));
        return projet;
    }

    @Override
    public ProjetEntity update(ProjetEntity projetEntity) {
        if(findByReference(projetEntity.getReference()) == null){
            return null;
        }
        return projetDao.save(projetEntity);
    }

    @Override
    public ProjetEntity update(ProjetPojo projetPojo) {
        ProjetEntity projetEntity = new ProjetEntity();
        BeanUtils.copyProperties(projetPojo, projetEntity);
        return update(projetEntity);
    }

    @Override
    public List<ProjetEntity> findAll() {
        return projetDao.findAll();
    }
}
