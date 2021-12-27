package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;

import java.util.List;

public class ProjetMemberInfraImpl extends AbstractInfraImpl implements ProjetMemberInfra {
    @Override
    public ProjetMemberPojo findByReference(String reference) {
        return null;
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public ProjetMemberEntity save(ProjetMemberEntity projetMemberEntity) {
        return null;
    }

    @Override
    public ProjetMemberEntity save(ProjetMemberPojo projetMemberPojo) {
        return null;
    }

    @Override
    public ProjetMemberEntity update(ProjetMemberEntity projetMemberEntity) {
        return null;
    }

    @Override
    public ProjetMemberEntity update(ProjetMemberPojo projetMemberPojo) {
        return null;
    }

    @Override
    public List<ProjetMemberEntity> findAll() {
        return null;
    }
}
