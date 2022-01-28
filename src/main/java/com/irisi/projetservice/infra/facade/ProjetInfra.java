package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.ProjetEntity;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;

import java.util.List;

public interface ProjetInfra extends AbstractInfra {
    ProjetPojo findByReference(String reference);

    int deleteByReference(String reference);

    ProjetEntity save(ProjetEntity projetEntity);

    ProjetPojo save(ProjetPojo projetPojo);

    ProjetEntity update(ProjetEntity projetEntity);

    ProjetEntity update(ProjetPojo projetPojo);

    List<ProjetEntity> findAll();
}
