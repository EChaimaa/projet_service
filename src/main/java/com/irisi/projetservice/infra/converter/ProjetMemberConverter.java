package com.irisi.projetservice.infra.converter;

import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;

import java.util.ArrayList;
import java.util.List;

public class ProjetMemberConverter extends AbstractConverter<ProjetMemberPojo, ProjetMemberEntity> {


    @Override
    public ProjetMemberPojo toPojo(ProjetMemberEntity dto) {
        if (dto == null) {
            return null;
        } else {
            ProjetMemberPojo item = new ProjetMemberPojo();

            item.setId(dto.getId());
            ProjetConverter projetConverter = new ProjetConverter();
            item.setProjet(projetConverter.toPojo(dto.getProjet()));
            EmployeConverter employeConverter = new EmployeConverter();
            item.setEmploye(employeConverter.toPojo(dto.getEmploye()));
            item.setNbrHeures(dto.getNbrHeures());

//            ProjetDetailConverter projetDetailConverter = new ProjetDetailConverter();
//            List<ProjetDetailPojo> projetWorkDetails = new ArrayList<ProjetDetailPojo>();
//            dto.getWorkDetails().forEach(d -> projetWorkDetails.add(projetDetailConverter.toPojo(d)));
//            item.setWorkDetails(projetWorkDetails);

            return item;
        }
    }

    @Override
    public ProjetMemberEntity toEntity(ProjetMemberPojo item) {
        if(item == null){
            return null;
        }else{
            ProjetMemberEntity dto = new ProjetMemberEntity();
            dto.setId(item.getId());
            ProjetConverter projetConverter = new ProjetConverter();
            dto.setProjet(projetConverter.toEntity(item.getProjet()));
            EmployeConverter employeConverter = new EmployeConverter();
            dto.setEmploye(employeConverter.toEntity(item.getEmploye()));
            dto.setNbrHeures(item.getNbrHeures());

//            ProjetDetailConverter projetDetailConverter = new ProjetDetailConverter();
//            List<ProjetDetailEntity> projetWorkDetails = new ArrayList<ProjetDetailEntity>();
//            item.getWorkDetails().forEach(d -> projetWorkDetails.add(projetDetailConverter.toEntity(d)));
//            dto.setWorkDetails(projetWorkDetails);

            return dto;

        }
    }
}
