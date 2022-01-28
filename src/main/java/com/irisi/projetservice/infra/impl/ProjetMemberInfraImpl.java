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

import java.util.List;

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
        ProjetMemberEntity projetMemberEntity = projetMemberDao.findByProjetReferenceAndEmployeMatricule(referenceProjet, matriculeEmploye);
        if(projetEntity == null|| employeEntity == null){
            return null;
        }
        ProjetMemberPojo projetMemberPojo = new ProjetMemberPojo();
        BeanUtils.copyProperties(projetMemberEntity, projetMemberPojo);
        return projetMemberPojo;
    }

    @Override
    public ProjetMemberEntity save(ProjetMemberEntity projetMemberEntity) {
        if (projetMemberDao.findById(projetMemberEntity.getId()) != null) {
            return null;
        }
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
        ProjetMemberEntity projetMemberEntity = new ProjetMemberEntity();
        BeanUtils.copyProperties(projetMemberPojo, projetMemberEntity);
        return update(projetMemberEntity);
    }

    @Override
    public List<ProjetMemberEntity> findAll() {
        return projetMemberDao.findAll();
    }
}
