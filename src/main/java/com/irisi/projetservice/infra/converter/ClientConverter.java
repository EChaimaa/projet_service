package com.irisi.projetservice.infra.converter;

import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.entity.ClientEntity;

public class ClientConverter extends AbstractConverter<ClientPojo, ClientEntity> {
    @Override
    public ClientPojo toPojo(ClientEntity dto) {
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
    public ClientEntity toEntity(ClientPojo item) {
        if(item == null){
            return null;
        }else{
            ClientEntity dto = new ClientEntity();
            dto.setId(item.getId());
            dto.setNom(item.getNom());
            dto.setPrenom(item.getPrenom());
            dto.setReference(item.getReference());
            return dto;
        }
    }
}
