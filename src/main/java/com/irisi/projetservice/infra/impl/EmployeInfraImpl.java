package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.entity.EmployeEntity;
import com.irisi.projetservice.infra.facade.EmployeInfra;

import java.util.List;

public class EmployeInfraImpl extends AbstractInfraImpl implements EmployeInfra {
    @Override
    public EmployePojo findByReference(String reference) {
        return null;
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public EmployeEntity save(EmployeEntity employeEntity) {
        return null;
    }

    @Override
    public EmployeEntity save(EmployePojo employePojo) {
        return null;
    }

    @Override
    public EmployeEntity update(EmployeEntity employeEntity) {
        return null;
    }

    @Override
    public EmployeEntity update(EmployePojo employePojo) {
        return null;
    }

    @Override
    public List<EmployeEntity> findAll() {
        return null;
    }
}
