package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.projetDetailPojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.dao.ProjetMemberDao;
import com.irisi.projetservice.infra.dao.projetDetailDao;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;
import com.irisi.projetservice.infra.entity.projetDetailEntity;
import com.irisi.projetservice.infra.facade.projetDetailInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class projetDetailImpl extends AbstractInfraImpl implements projetDetailInfra {
    @Autowired
    projetDetailDao projetDetailDao;
    @Autowired
    ProjetMemberDao projetMemberDao;

    @Override
    public projetDetailPojo findByProjetMember(Long id) {
        Optional<ProjetMemberEntity> projetMemberEntity = projetMemberDao.findById(id);
        if (projetMemberEntity == null) return null;

        projetDetailEntity projetDetailEntity = projetDetailDao.findByProjetMemberId(id);
        if (projetDetailEntity == null) return null;

        projetDetailPojo projetDetailPojo = new projetDetailPojo();
        BeanUtils.copyProperties(projetDetailEntity, projetDetailPojo);
        return projetDetailPojo;
    }

    @Override
    public projetDetailEntity save(projetDetailEntity projetDetailEntity) {
        if (findByProjetMember(projetDetailEntity.getProjetMember().getId()) != null) return null;
        return projetDetailDao.save(projetDetailEntity);
    }

    @Override
    public projetDetailEntity save(projetDetailPojo projetDetailPojo) {
        projetDetailEntity projetDetailEntity = new projetDetailEntity();
        BeanUtils.copyProperties(projetDetailPojo, projetDetailEntity);
        return save(projetDetailEntity);
    }

    @Override
    public projetDetailEntity update(projetDetailEntity projetDetailEntity) {
        if (findByProjetMember(projetDetailEntity.getProjetMember().getId()) == null) return null;
        return projetDetailDao.save(projetDetailEntity);
    }

    @Override
    public projetDetailEntity update(projetDetailPojo projetDetailPojo) {
        projetDetailEntity projetDetailEntity = new projetDetailEntity();
        BeanUtils.copyProperties(projetDetailPojo, projetDetailEntity);
        return update(projetDetailEntity);
    }

    @Override
    public List<projetDetailEntity> findAll() {
        return projetDetailDao.findAll();
    }
}
