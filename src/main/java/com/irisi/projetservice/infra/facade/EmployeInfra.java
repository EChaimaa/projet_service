package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.EmployeEntity;

import java.util.List;

public interface EmployeInfra extends AbstractInfra {
    EmployePojo findByMatricule(String matricule);

    int deleteByMatricule(String matricule);

    EmployeEntity save(EmployeEntity employeEntity);

    EmployeEntity save(EmployePojo employePojo);

    EmployeEntity update(EmployeEntity employeEntity);

    EmployeEntity update(EmployePojo employePojo);

    List<EmployeEntity> findAll();
}
