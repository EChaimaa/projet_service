package com.irisi.projetservice.infra.converter;

import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.entity.ProjetEntity;

public class ProjetConverter extends AbstractConverter<ProjetPojo, ProjetEntity> {
    @Override
    public ProjetPojo toPojo(ProjetEntity dto) {
        if (dto == null) {
            return null;
        } else {
            ProjetPojo item = new ProjetPojo();
            ClientConverter clientMapper = new ClientConverter();
            item.setId(dto.getId());
            item.setClient(clientMapper.toPojo(dto.getClient()));
            item.setReference(dto.getReference());
            item.setName(dto.getName());
            item.setEndTime(dto.getEndTime());
            item.setBeginTime(dto.getBeginTime());
            //projetmembers
            return item;
        }
    }

    @Override
    public ProjetEntity toEntity(ProjetPojo item) {
        if (item == null) {
            return null;
        } else {
            ProjetEntity dto = new ProjetEntity();
            dto.setId(item.getId());
            dto.setReference(item.getReference());
            dto.setName(item.getName());
            dto.setBeginTime(item.getBeginTime());
            dto.setEndTime(item.getEndTime());
            ClientConverter clientConverter = new ClientConverter();
            dto.setClient(clientConverter.toEntity(item.getClient()));
            //projetMemebers
            return dto;
        }
    }
}
