package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.CategorieDto;
import com.irisi.projetservice.infra.entity.CategorieEntity;

public class CategorieMapper extends AbstractMapper<CategorieEntity, CategorieDto>{
    @Override
    public CategorieEntity toEntity(CategorieDto dto) {
        if(dto == null){
            return null;
        }else {
            CategorieEntity item = new CategorieEntity();
            item.setLibelle(dto.getLibelle());
            item.setsalaireParJour(dto.getSalaireParHeure());
            return item;
        }
    }

    @Override
    public CategorieDto toDto(CategorieEntity item) {
        if(item == null){
            return null;
        }
        CategorieDto dto = new CategorieDto();
        dto.setLibelle(item.getLibelle());
        dto.setSalaireParHeure(item.getsalaireParJour());
        return dto;
    }
}
