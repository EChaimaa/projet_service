package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ClientDto;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.entity.ClientEntity;

public class ClientMapper extends AbstractMapper<ClientPojo, ClientDto>{
    @Override
    public ClientPojo toPojo(ClientDto dto) {
        if(dto == null){
            return  null;
        }else {
            ClientPojo item = new ClientPojo();
            item.setId(dto.getId());
            item.setNom(dto.getNom());
            item.setPrenom(dto.getPrenom());
            item.setReference(dto.getReference());
            return item;
        }
    }

    @Override
    public ClientDto toDto(ClientPojo item) {
        if(item == null){
            return null;
        }else{
            ClientDto dto = new ClientDto();
            dto.setId(item.getId());
            dto.setNom(item.getNom());
            dto.setPrenom(item.getPrenom());
            dto.setReference(item.getReference());
            return dto;
        }
    }
}
