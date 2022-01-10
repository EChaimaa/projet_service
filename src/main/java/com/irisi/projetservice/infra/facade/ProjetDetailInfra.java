package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;

import java.util.List;

public interface ProjetDetailInfra extends AbstractInfra {
//    ProjetDetailPojo findByProjetMember(Long id);

    ProjetDetailEntity save(ProjetDetailEntity projetDetailEntity);

    ProjetDetailEntity save(ProjetDetailPojo projetDetailPojo);

    ProjetDetailEntity update(ProjetDetailEntity projetDetailEntity);

    ProjetDetailEntity update(ProjetDetailPojo projetDetailPojo);

    List<ProjetDetailEntity> findAll();
}
