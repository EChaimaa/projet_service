package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;

import java.util.List;

public interface ProjetMemberInfra extends AbstractInfra {
    ProjetMemberPojo findByReference(String reference);

    int deleteByReference(String reference);

    ProjetMemberEntity save(ProjetMemberEntity projetMemberEntity);

    ProjetMemberEntity save(ProjetMemberPojo projetMemberPojo);

    ProjetMemberEntity update(ProjetMemberEntity projetMemberEntity);

    ProjetMemberEntity update(ProjetMemberPojo projetMemberPojo);

    List<ProjetMemberEntity> findAll();
}
