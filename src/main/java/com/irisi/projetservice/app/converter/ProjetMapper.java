package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ProjetDto;
import com.irisi.projetservice.infra.entity.ProjetEntity;

public class ProjetMapper extends AbstractMapper<ProjetEntity, ProjetDto> {
    @Override
    public ProjetEntity toEntity(ProjetDto dto) {
        if (dto == null) {
            return null;
        } else {
            ProjetEntity item = new ProjetEntity();
            ClientMapper clientMapper = new ClientMapper();
            item.setClient(clientMapper.toEntity(dto.getClientDto()));
            item.setReference(dto.getReference());
            //projetmembers
            return item;
        }
    }

    @Override
    public ProjetDto toDto(ProjetEntity item) {
        if (item == null) {
            return null;
        } else {
            ProjetDto dto = new ProjetDto();
            dto.setReference(item.getReference());
            ClientMapper clientMapper = new ClientMapper();
            dto.setClientDto(clientMapper.toDto(item.getClient()));
            //projetMemebers
            return dto;
        }
    }
}
