package com.irisi.projetservice.domain.projectMember.update;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;
import com.irisi.projetservice.infra.facade.ProjetDetailInfra;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProjectMemberUpdateProcessImpl extends AbstractProcessImpl<ProjectMemberUpdateInput> implements ProjectMemberUpdateProcess {
    ProjetDetailInfra projetDetailInfra;
    ProjetMemberInfra projetMemberInfra;

    public ProjectMemberUpdateProcessImpl(ProjetDetailInfra projetDetailInfra, ProjetMemberInfra projetMemberInfra) {
        this.projetDetailInfra = projetDetailInfra;
        this.projetMemberInfra = projetMemberInfra;
    }

    @Override
    public void validate(ProjectMemberUpdateInput abstractProcessInput, Result result) {
        Date beginTime = abstractProcessInput.getProjetDetail().getBeginTime();
        Date endTime = abstractProcessInput.getProjetDetail().getEndTime();
        String referenceProjet = abstractProcessInput.getProjetDetail().getProjetMember().getProjet().getReference();
        String matriculeEmploye = abstractProcessInput.getProjetDetail().getProjetMember().getEmploye().getMatricule();
        ProjetMemberPojo projetMember = projetMemberInfra.findByProjetAndEmploye(referenceProjet, matriculeEmploye);

        if (beginTime == null || endTime == null || projetMember == null) {
            result.addErrorMessage("projetMember.update.bad_parameters");
        }
    }

    @Override
    public void run(ProjectMemberUpdateInput abstractProcessInput, Result result) {
        ProjetDetailPojo projetDetailPojo = abstractProcessInput.getProjetDetail();
        Date beginTime = projetDetailPojo.getBeginTime();
        Date endTime = projetDetailPojo.getEndTime();
        String referenceProjet = projetDetailPojo.getProjetMember().getProjet().getReference();
        String matriculeEmploye = projetDetailPojo.getProjetMember().getEmploye().getMatricule();
        ProjetMemberPojo projetMember = projetMemberInfra.findByProjetAndEmploye(referenceProjet, matriculeEmploye);

        System.out.println("I am here: "+projetMember.toString());
        long diff = endTime.getTime() - beginTime.getTime();
        long hours = TimeUnit.MILLISECONDS.toHours(diff);

        projetMember.setNbrHeures(projetMember.getNbrHeures()+hours);
        projetMemberInfra.update(projetMember);
        ProjetDetailPojo projetDetail = new ProjetDetailPojo(beginTime, endTime, projetMember);
        System.out.println("I am here: "+projetDetail.toString());
        projetDetailInfra.save(projetDetail);
        result.addInfoMessage("projetMember.update.operation_success");
    }
}
