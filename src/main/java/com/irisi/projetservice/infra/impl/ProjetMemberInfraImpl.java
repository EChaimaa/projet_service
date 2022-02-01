package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.infra.converter.ProjetMemberConverter;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.dao.EmployeDao;
import com.irisi.projetservice.infra.dao.ProjetDao;
import com.irisi.projetservice.infra.dao.ProjetMemberDao;
import com.irisi.projetservice.infra.entity.EmployeEntity;
import com.irisi.projetservice.infra.entity.ProjetEntity;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProjetMemberInfraImpl extends AbstractInfraImpl implements ProjetMemberInfra {
    @Autowired
    ProjetMemberDao projetMemberDao;
    @Autowired
    ProjetDao projetDao;
    @Autowired
    EmployeDao employeDao;

    @Override
    public ProjetMemberPojo findByProjetAndEmploye(String referenceProjet, String matriculeEmploye) {
        ProjetEntity projetEntity = projetDao.findByReference(referenceProjet);
        EmployeEntity employeEntity = employeDao.findByMatricule(matriculeEmploye);
        if(projetEntity == null|| employeEntity == null){
            return null;
        }
        ProjetMemberEntity projetMemberEntity = projetMemberDao.findByProjetReferenceAndEmployeMatricule(referenceProjet, matriculeEmploye);
        ProjetMemberConverter projetMemberConverter = new ProjetMemberConverter();
        ProjetMemberPojo projetMember = projetMemberConverter.toPojo(projetMemberEntity);
        return projetMember;
    }

    @Override
    public List<ProjetMemberPojo> findByProjet(String referenceProjet) {
        List<ProjetMemberEntity> memberEntities = projetMemberDao.findByProjetReference(referenceProjet);
        List<ProjetMemberPojo> members = new ArrayList<ProjetMemberPojo>();
        for (ProjetMemberEntity projetMemberEntity: memberEntities) {
            ProjetMemberConverter projetMemberConverter = new ProjetMemberConverter();
            ProjetMemberPojo projetMemberPojo = projetMemberConverter.toPojo(projetMemberEntity);
            members.add(projetMemberPojo);
        }
        return members;
    }

    @Override
    public ProjetMemberEntity save(ProjetMemberEntity projetMemberEntity) {
        return projetMemberDao.save(projetMemberEntity);
    }

    @Override
    public ProjetMemberPojo save(ProjetMemberPojo projetMemberPojo) {
        ProjetMemberConverter projetMemberConverter = new ProjetMemberConverter();
        ProjetMemberEntity projetMemberEntity = projetMemberConverter.toEntity(projetMemberPojo);
        ProjetMemberPojo projetMember = projetMemberConverter.toPojo(save(projetMemberEntity));
        return projetMember;
    }

    @Override
    public ProjetMemberEntity update(ProjetMemberEntity projetMemberEntity) {
        if (projetMemberDao.findById(projetMemberEntity.getId()) == null) {
            return null;
        }
        return projetMemberDao.save(projetMemberEntity);
    }

    @Override
    public ProjetMemberEntity update(ProjetMemberPojo projetMemberPojo) {
        ProjetMemberConverter projetMemberConverter = new ProjetMemberConverter();
        ProjetMemberEntity projetMemberEntity = projetMemberConverter.toEntity(projetMemberPojo);
        return update(projetMemberEntity);
    }

    @Override
    public int deleteByProjectAndEmploye(String reference, String matricule) {
        ProjetMemberPojo projetMember = findByProjetAndEmploye(reference, matricule);
        projetMemberDao.deleteById(projetMember.getId());
        return 1;
    }

    @Override
    public List<ProjetMemberEntity> findAll() {
        return projetMemberDao.findAll();
    }
}
