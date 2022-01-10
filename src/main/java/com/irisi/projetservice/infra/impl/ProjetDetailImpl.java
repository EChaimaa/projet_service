package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.dao.ProjetMemberDao;
import com.irisi.projetservice.infra.dao.ProjetDetailDao;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;
import com.irisi.projetservice.infra.facade.ProjetDetailInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetDetailImpl extends AbstractInfraImpl implements ProjetDetailInfra {
    @Autowired
    ProjetDetailDao projetDetailDao;
    @Autowired
    ProjetMemberDao projetMemberDao;

//    @Override
//    public ProjetDetailPojo findByProjetMember(Long id) {
//        Optional<ProjetMemberEntity> projetMemberEntity = projetMemberDao.findById(id);
//        if (projetMemberEntity == null) return null;
//
//        ProjetDetailEntity projetDetailEntity = projetDetailDao.findByProjetMemberId(id);
//        if (projetDetailEntity == null) return null;
//
//        ProjetDetailPojo projetDetailPojo = new ProjetDetailPojo();
//        BeanUtils.copyProperties(projetDetailEntity, projetDetailPojo);
//        return projetDetailPojo;
//    }

    @Override
    public ProjetDetailEntity save(ProjetDetailEntity projetDetailEntity) {
        return projetDetailDao.save(projetDetailEntity);
    }

    @Override
    public ProjetDetailEntity save(ProjetDetailPojo projetDetailPojo) {
        ProjetDetailEntity projetDetailEntity = new ProjetDetailEntity();
        BeanUtils.copyProperties(projetDetailPojo, projetDetailEntity);
        return save(projetDetailEntity);
    }

    @Override
    public ProjetDetailEntity update(ProjetDetailEntity projetDetailEntity) {
        if (projetDetailDao.findById(projetDetailEntity.getId()) == null) return null;
        return projetDetailDao.save(projetDetailEntity);
    }

    @Override
    public ProjetDetailEntity update(ProjetDetailPojo projetDetailPojo) {
        ProjetDetailEntity projetDetailEntity = new ProjetDetailEntity();
        BeanUtils.copyProperties(projetDetailPojo, projetDetailEntity);
        return update(projetDetailEntity);
    }

    @Override
    public List<ProjetDetailEntity> findAll() {
        return projetDetailDao.findAll();
    }
}
