package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ProjetDetailDto;
import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;

public class ProjetDetailMapper extends AbstractMapper<ProjetDetailPojo, ProjetDetailDto>{
    @Override
    public ProjetDetailPojo toPojo(ProjetDetailDto dto) {
        if(dto == null){
            return null;
        }else{
            ProjetDetailPojo item = new ProjetDetailPojo();
            item.setId(dto.getId());
            item.setBeginTime(dto.getBeginTime());
            item.setEndTime(dto.getEndTime());
            ProjetMemberMapper projetMemberMapper = new ProjetMemberMapper();
            item.setProjetMember(projetMemberMapper.toPojo(dto.getProjetMember()));
            return item;
        }
    }

    @Override
    public ProjetDetailDto toDto(ProjetDetailPojo item) {
        if(item == null){
            return null;
        }else{
            ProjetDetailDto dto = new ProjetDetailDto();
            dto.setId(item.getId());
            dto.setBeginTime(item.getBeginTime());
            dto.setEndTime(item.getEndTime());
            ProjetMemberMapper projetMemberMapper = new ProjetMemberMapper();
            dto.setProjetMember(projetMemberMapper.toDto(item.getProjetMember()));
            return dto;
        }
    }
}
