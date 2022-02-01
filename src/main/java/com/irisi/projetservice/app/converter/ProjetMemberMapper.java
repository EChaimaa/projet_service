package com.irisi.projetservice.app.converter;

import com.irisi.projetservice.app.dto.ProjetDetailDto;
import com.irisi.projetservice.app.dto.ProjetMemberDto;
import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;

import java.util.ArrayList;
import java.util.List;

public class ProjetMemberMapper extends AbstractMapper<ProjetMemberPojo, ProjetMemberDto> {


    @Override
    public ProjetMemberPojo toPojo(ProjetMemberDto dto) {
        if (dto == null) {
            return null;
        } else {
            ProjetMemberPojo item = new ProjetMemberPojo();

            item.setId(dto.getId());
            ProjetMapper projetMapper = new ProjetMapper();
            item.setProjet(projetMapper.toPojo(dto.getProjet()));
            EmployeMapper employeMapper = new EmployeMapper();
            item.setEmploye(employeMapper.toPojo(dto.getEmploye()));
            item.setNbrHeures(dto.getNbrHeures());

//            ProjetDetailMapper projetDetailMapper = new ProjetDetailMapper();
//            List<ProjetDetailPojo> projetWorkDetails = new ArrayList<ProjetDetailPojo>();
//            dto.getWorkDetails().forEach(d -> projetWorkDetails.add(projetDetailMapper.toPojo(d)));
//            item.setWorkDetails(projetWorkDetails);

            return item;
        }
    }

    @Override
    public ProjetMemberDto toDto(ProjetMemberPojo item) {
        if(item == null){
            return null;
        }else{
            ProjetMemberDto dto = new ProjetMemberDto();
            dto.setId(item.getId());
            ProjetMapper projetMapper = new ProjetMapper();
            dto.setProjet(projetMapper.toDto(item.getProjet()));
            EmployeMapper employeMapper = new EmployeMapper();
            dto.setEmploye(employeMapper.toDto(item.getEmploye()));
            dto.setNbrHeures(item.getNbrHeures());

//            ProjetDetailMapper projetDetailMapper = new ProjetDetailMapper();
//            List<ProjetDetailDto> projetWorkDetails = new ArrayList<ProjetDetailDto>();
//            item.getWorkDetails().forEach(d -> projetWorkDetails.add(projetDetailMapper.toDto(d)));
//            dto.setWorkDetails(projetWorkDetails);

            return dto;

        }
    }
}
