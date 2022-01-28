package com.irisi.projetservice.infra.converter;

import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.entity.EmployeEntity;

public class EmployeConverter extends AbstractConverter<EmployePojo, EmployeEntity> {
    @Override
    public EmployePojo toPojo(EmployeEntity dto) {
        if(dto == null){
            return null;
        }else{
            EmployePojo item = new EmployePojo();
            item.setId(dto.getId());
            item.setNom(dto.getNom());
            item.setPrenom(dto.getPrenom());
            CategorieConverter categorieConverter = new CategorieConverter();
            item.setCategorie(categorieConverter.toPojo(dto.getCategorie()));
            item.setMatricule(dto.getMatricule());
            return item;
        }
    }

    @Override
    public EmployeEntity toEntity(EmployePojo item) {
        if(item == null){
            return null;
        }else{
            EmployeEntity dto = new EmployeEntity();
            dto.setId(item.getId());
            dto.setNom(item.getNom());
            dto.setPrenom(item.getPrenom());
            dto.setMatricule(item.getMatricule());
            CategorieConverter categorieConverter = new CategorieConverter();
            dto.setCategorie(categorieConverter.toEntity(item.getCategorie()));
            return dto;
        }
    }
}
