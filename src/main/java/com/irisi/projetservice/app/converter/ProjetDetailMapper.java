package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ProjetDetailDto;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;

public class ProjetDetailMapper extends AbstractMapper<ProjetDetailEntity, ProjetDetailDto>{
    @Override
    public ProjetDetailEntity toEntity(ProjetDetailDto dto) {
        if(dto == null){
            return null;
        }else{
            ProjetDetailEntity item = new ProjetDetailEntity();
            item.setBeginTime(dto.getBeginTime());
            item.setEndTime(dto.getEndTime());
            ProjetMemberMapper projetMemberMapper = new ProjetMemberMapper();
            item.setProjetMember(projetMemberMapper.toEntity(dto.getProjetMemberDto()));
            return item;
        }
    }

    @Override
    public ProjetDetailDto toDto(ProjetDetailEntity item) {
        if(item == null){
            return null;
        }else{
            ProjetDetailDto dto = new ProjetDetailDto();
            dto.setBeginTime(item.getBeginTime());
            dto.setEndTime(item.getEndTime());
            ProjetMemberMapper projetMemberMapper = new ProjetMemberMapper();
            dto.setProjetMemberDto(projetMemberMapper.toDto(item.getProjetMember()));
            return dto;
        }
    }
}
