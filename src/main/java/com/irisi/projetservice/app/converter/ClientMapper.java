package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ClientDto;
import com.irisi.projetservice.infra.entity.ClientEntity;

public class ClientMapper extends AbstractMapper<ClientEntity, ClientDto>{
    @Override
    public ClientEntity toEntity(ClientDto dto) {
        if(dto == null){
            return  null;
        }else {
            ClientEntity item = new ClientEntity();
            item.setNom(dto.getNom());
            item.setPrenom(dto.getPrenom());
            item.setReference(dto.getReference());
            return item;
        }
    }

    @Override
    public ClientDto toDto(ClientEntity item) {
        if(item == null){
            return null;
        }else{
            ClientDto dto = new ClientDto();
            dto.setNom(item.getNom());
            dto.setPrenom(item.getPrenom());
            dto.setReference(item.getReference());
            return dto;
        }
    }
}
