package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.CategorieDto;
import com.irisi.projetservice.domain.pojo.CategoriePojo;

public class CategorieMapper extends AbstractMapper<CategoriePojo, CategorieDto>{
    @Override
    public CategoriePojo toPojo(CategorieDto dto) {
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
    public CategorieDto toDto(CategoriePojo item) {
        if(item == null){
            return null;
        }
        CategorieDto dto = new CategorieDto();
        dto.setId(item.getId());
        dto.setLibelle(item.getLibelle());
        dto.setSalaireParHeure(item.getSalaireParHeure());
        return dto;
    }
}
