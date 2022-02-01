package com.irisi.projetservice.infra.facade;

import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.infra.core.AbstractInfra;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;

import java.util.List;

public interface ProjetMemberInfra extends AbstractInfra {

    ProjetMemberPojo findByProjetAndEmploye(String referenceProjet, String matriculeEmploye);

    List<ProjetMemberPojo> findByProjet(String referenceProjet);

    ProjetMemberEntity save(ProjetMemberEntity projetMemberEntity);

    ProjetMemberPojo save(ProjetMemberPojo projetMemberPojo);

    ProjetMemberEntity update(ProjetMemberEntity projetMemberEntity);

    ProjetMemberEntity update(ProjetMemberPojo projetMemberPojo);

    int deleteByProjectAndEmploye(String reference, String matricule);

    List<ProjetMemberEntity> findAll();
}
