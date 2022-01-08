package com.irisi.projetservice.infra.impl;

import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.core.AbstractInfraImpl;
import com.irisi.projetservice.infra.dao.CategorieDao;
import com.irisi.projetservice.infra.entity.CategorieEntity;
import com.irisi.projetservice.infra.facade.CategorieInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieInfraImpl extends AbstractInfraImpl implements CategorieInfra {
    @Autowired
    CategorieDao categorieDao;

    @Override
    public CategoriePojo findByLibelle(String libelle) {
        CategorieEntity categorieEntity = categorieDao.findByLibelle(libelle);
        if(categorieEntity ==  null){
            return null;
        }
        CategoriePojo categoriePojo = new CategoriePojo();
        BeanUtils.copyProperties(categorieEntity, categoriePojo);
        return categoriePojo;
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return categorieDao.deleteByLibelle(libelle);
    }

    @Override
    public CategorieEntity save(CategorieEntity categorieEntity) {
        if(findByLibelle(categorieEntity.getLibelle()) != null){
            return null;
        }
        return categorieDao.save(categorieEntity);
    }

    @Override
    public CategorieEntity save(CategoriePojo categoriePojo) {
        CategorieEntity categorieEntity = new CategorieEntity();
        BeanUtils.copyProperties(categoriePojo, categorieEntity);
        return save(categorieEntity);
    }

    @Override
    public CategorieEntity update(CategorieEntity categorieEntity) {
        if(findByLibelle(categorieEntity.getLibelle()) == null){
            return null;
        }
        return categorieDao.save(categorieEntity);
    }

    @Override
    public CategorieEntity update(CategoriePojo categoriePojo) {
        CategorieEntity categorieEntity = new CategorieEntity();
        BeanUtils.copyProperties(categoriePojo, categorieEntity);
        return update(categorieEntity);
    }

    @Override
    public List<CategorieEntity> findAll() {
        return categorieDao.findAll();
    }
}
