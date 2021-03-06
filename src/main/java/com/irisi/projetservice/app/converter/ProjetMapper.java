package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ProjetDto;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.entity.ProjetEntity;

public class ProjetMapper extends AbstractMapper<ProjetPojo, ProjetDto> {
    @Override
    public ProjetPojo toPojo(ProjetDto dto) {
        if (dto == null) {
            return null;
        } else {
            ProjetPojo item = new ProjetPojo();
            ClientMapper clientMapper = new ClientMapper();
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
    public ProjetDto toDto(ProjetPojo item) {
        if (item == null) {
            return null;
        } else {
            ProjetDto dto = new ProjetDto();
            dto.setId(item.getId());
            dto.setReference(item.getReference());
            dto.setName(item.getName());
            dto.setBeginTime(item.getBeginTime());
            dto.setEndTime(item.getEndTime());
            ClientMapper clientMapper = new ClientMapper();
            dto.setClient(clientMapper.toDto(item.getClient()));
            //projetMemebers
            return dto;
        }
    }
}
