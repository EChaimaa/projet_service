package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.EmployeDto;
import com.irisi.projetservice.infra.entity.CategorieEntity;
import com.irisi.projetservice.infra.entity.EmployeEntity;

public class EmployeMapper extends AbstractMapper<EmployeEntity, EmployeDto>{
    @Override
    public EmployeEntity toEntity(EmployeDto dto) {
        if(dto == null){
            return null;
        }else{
            EmployeEntity item = new EmployeEntity();
            item.setNom(dto.getNom());
            item.setPrenom(dto.getPrenom());
            CategorieMapper categorieMapper = new CategorieMapper();
            item.setCategorie(categorieMapper.toEntity(dto.getCategorieDto()));
            item.setMatricule(dto.getMatricule());
            return item;
        }
    }

    @Override
    public EmployeDto toDto(EmployeEntity item) {
        if(item == null){
            return null;
        }else{
            EmployeDto dto = new EmployeDto();
            dto.setNom(item.getNom());
            dto.setPrenom(item.getPrenom());
            dto.setMatricule(item.getMatricule());
            CategorieMapper categorieMapper = new CategorieMapper();
            dto.setCategorieDto(categorieMapper.toDto(item.getCategorie()));
            return dto;
        }
    }
}
