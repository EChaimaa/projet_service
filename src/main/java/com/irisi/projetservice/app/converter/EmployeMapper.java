package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.EmployeDto;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.entity.EmployeEntity;

public class EmployeMapper extends AbstractMapper<EmployePojo, EmployeDto>{
    @Override
    public EmployePojo toPojo(EmployeDto dto) {
        if(dto == null){
            return null;
        }else{
            EmployePojo item = new EmployePojo();
            item.setId(dto.getId());
            item.setNom(dto.getNom());
            item.setPrenom(dto.getPrenom());
            CategorieMapper categorieMapper = new CategorieMapper();
            item.setCategorie(categorieMapper.toPojo(dto.getCategorie()));
            item.setMatricule(dto.getMatricule());
            return item;
        }
    }

    @Override
    public EmployeDto toDto(EmployePojo item) {
        if(item == null){
            return null;
        }else{
            EmployeDto dto = new EmployeDto();
            dto.setId(item.getId());
            dto.setNom(item.getNom());
            dto.setPrenom(item.getPrenom());
            dto.setMatricule(item.getMatricule());
            CategorieMapper categorieMapper = new CategorieMapper();
            dto.setCategorie(categorieMapper.toDto(item.getCategorie()));
            return dto;
        }
    }
}
