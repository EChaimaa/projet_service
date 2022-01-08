package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.projetDetailPojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.projetDetailEntity;

import java.util.List;

public interface projetDetailInfra extends AbstractInfra {
    projetDetailPojo findByProjetMember(Long id);

    projetDetailEntity save(projetDetailEntity projetDetailEntity);

    projetDetailEntity save(projetDetailPojo projetDetailPojo);

    projetDetailEntity update(projetDetailEntity projetDetailEntity);

    projetDetailEntity update(projetDetailPojo projetDetailPojo);

    List<projetDetailEntity> findAll();
}
