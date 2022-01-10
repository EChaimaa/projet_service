package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ProjetDetailDto;
import com.irisi.projetservice.app.dto.ProjetMemberDto;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;

import java.util.ArrayList;
import java.util.List;

public class ProjetMemberMapper extends AbstractMapper<ProjetMemberEntity, ProjetMemberDto> {


    @Override
    public ProjetMemberEntity toEntity(ProjetMemberDto dto) {
        if (dto == null) {
            return null;
        } else {
            ProjetMemberEntity item = new ProjetMemberEntity();

            ProjetMapper projetMapper = new ProjetMapper();
            item.setProjet(projetMapper.toEntity(dto.getProjetDto()));
            EmployeMapper employeMapper = new EmployeMapper();
            item.setEmploye(employeMapper.toEntity(dto.getEmployeDto()));
            item.setNbrHeures(dto.getNbrHeures());

            ProjetDetailMapper projetDetailMapper = new ProjetDetailMapper();
            List<ProjetDetailEntity> projetWorkDetails = new ArrayList<ProjetDetailEntity>();
            dto.getWorkDetailsDtos().forEach(d -> projetWorkDetails.add(projetDetailMapper.toEntity(d)));
            item.setWorkDetails(projetWorkDetails);

            return item;
        }
    }

    @Override
    public ProjetMemberDto toDto(ProjetMemberEntity item) {
        if(item == null){
            return null;
        }else{
            ProjetMemberDto dto = new ProjetMemberDto();
            ProjetMapper projetMapper = new ProjetMapper();
            dto.setProjetDto(projetMapper.toDto(item.getProjet()));
            EmployeMapper employeMapper = new EmployeMapper();
            dto.setEmployeDto(employeMapper.toDto(item.getEmploye()));
            dto.setNbrHeures(item.getNbrHeures());

            ProjetDetailMapper projetDetailMapper = new ProjetDetailMapper();
            List<ProjetDetailDto> projetWorkDetails = new ArrayList<ProjetDetailDto>();
            item.getWorkDetails().forEach(d -> projetWorkDetails.add(projetDetailMapper.toDto(d)));
            dto.setWorkDetailsDtos(projetWorkDetails);

            return dto;

        }
    }
}
