package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.converter.EmployeConverter;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.dao.EmployeDao;
import com.irisi.projetservice.infra.entity.EmployeEntity;
import com.irisi.projetservice.infra.facade.EmployeInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeInfraImpl extends AbstractInfraImpl implements EmployeInfra {
    @Autowired
    EmployeDao employeDao;

    @Override
    public EmployePojo findByMatricule(String matricule) {
        EmployeEntity employeEntity = employeDao.findByMatricule(matricule);
        if(employeEntity == null){
            return  null;
        }
        EmployeConverter employeConverter = new EmployeConverter();
        EmployePojo employePojo = employeConverter.toPojo(employeEntity);
        return employePojo;
    }

    @Override
    public int deleteByMatricule(String matricule) {
        return employeDao.deleteByMatricule(matricule);
    }

    @Override
    public EmployeEntity save(EmployeEntity employeEntity) {
        if(findByMatricule(employeEntity.getMatricule()) != null){
            return null;
        }
        return employeDao.save(employeEntity);
    }

    @Override
    public EmployePojo save(EmployePojo employePojo) {
        EmployeConverter employeConverter = new EmployeConverter();
        EmployeEntity employeEntity = employeConverter.toEntity(employePojo);
        EmployePojo employe = employeConverter.toPojo(save(employeEntity));
        return employe;
    }

    @Override
    public EmployeEntity update(EmployeEntity employeEntity) {
        if(findByMatricule(employeEntity.getMatricule()) == null){
            return null;
        }
        return employeDao.save(employeEntity);
    }

    @Override
    public EmployeEntity update(EmployePojo employePojo) {
        EmployeConverter employeConverter = new EmployeConverter();
        EmployeEntity employeEntity = employeConverter.toEntity(employePojo);
        return update(employeEntity);
    }

    @Override
    public List<EmployeEntity> findAll() {
        return employeDao.findAll();
    }
}
