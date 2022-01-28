package com.irisi.projetservice.infra.converter;

import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.entity.CategorieEntity;

public class CategorieConverter extends AbstractConverter<CategoriePojo, CategorieEntity> {
    @Override
    public CategoriePojo toPojo(CategorieEntity dto) {
        if(dto == null){
            return null;
        }else {
            CategoriePojo item = new CategoriePojo();
            item.setId(dto.getId());
            item.setLibelle(dto.getLibelle());
            item.setSalaireParHeure(dto.getSalaireParHeure());
            return item;
        }
    }

    @Override
    public CategorieEntity toEntity(CategoriePojo item) {
        if(item == null){
            return null;
        }
        CategorieEntity dto = new CategorieEntity();
        dto.setId(item.getId());
        dto.setLibelle(item.getLibelle());
        dto.setSalaireParHeure(item.getSalaireParHeure());
        return dto;
    }
}
