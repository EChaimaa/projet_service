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
        Date beginTime = abstractProcessInput.getBeginTime();
        Date endTime = abstractProcessInput.getBeginTime();
        String referenceProjet = abstractProcessInput.getProjet().getReference();
        String matriculeEmploye = abstractProcessInput.getEmploye().getMatricule();
        ProjetMemberPojo projetMember = projetMemberInfra.findByProjetAndEmploye(referenceProjet, matriculeEmploye);

        if (beginTime == null || endTime == null || projetMember == null) {
            result.addErrorMessage("projetMember.update.prob_update");
        }
    }

    @Override
    public void run(ProjectMemberUpdateInput abstractProcessInput, Result result) {
        Date beginTime = abstractProcessInput.getBeginTime();
        Date endTime = abstractProcessInput.getBeginTime();

        long diff = endTime.getTime() - beginTime.getTime();
        long hours = TimeUnit.MILLISECONDS.toHours(diff);

        String referenceProjet = abstractProcessInput.getProjet().getReference();
        String matriculeEmploye = abstractProcessInput.getEmploye().getMatricule();
        ProjetMemberPojo projetMember = projetMemberInfra.findByProjetAndEmploye(referenceProjet, matriculeEmploye);

        projetMember.setNbrHeures(projetMember.getNbrHeures()+hours);
        projetMemberInfra.update(projetMember);
        ProjetDetailPojo projetDetail = new ProjetDetailPojo(beginTime, endTime, projetMember);
        projetDetailInfra.save(projetDetail);
        result.addInfoMessage("projetMember.update.operation_success");
    }
}
