package com.irisi.projetservice.infra.converter;

import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;

public class ProjetDetailConverter extends AbstractConverter<ProjetDetailPojo, ProjetDetailEntity> {
    @Override
    public ProjetDetailPojo toPojo(ProjetDetailEntity dto) {
        if(dto == null){
            return null;
        }else{
            ProjetDetailPojo item = new ProjetDetailPojo();
            item.setId(dto.getId());
            item.setBeginTime(dto.getBeginTime());
            item.setEndTime(dto.getEndTime());
            ProjetMemberConverter projetMemberConverter = new ProjetMemberConverter();
            item.setProjetMember(projetMemberConverter.toPojo(dto.getProjetMember()));
            return item;
        }
    }

    @Override
    public ProjetDetailEntity toEntity(ProjetDetailPojo item) {
        if(item == null){
            return null;
        }else{
            ProjetDetailEntity dto = new ProjetDetailEntity();
            dto.setId(item.getId());
            dto.setBeginTime(item.getBeginTime());
            dto.setEndTime(item.getEndTime());
            ProjetMemberConverter projetMemberConverter = new ProjetMemberConverter();
            dto.setProjetMember(projetMemberConverter.toEntity(item.getProjetMember()));
            return dto;
        }
    }
}
