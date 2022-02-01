package com.irisi.projetservice.domain.projectMember.update;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;

import java.util.Date;

public class ProjectMemberUpdateInput extends AbstractProcessInput {
    private ProjetDetailPojo projetDetail;

    public ProjetDetailPojo getProjetDetail() {
        return projetDetail;
    }

    public void setProjetDetail(ProjetDetailPojo projetDetail) {
        this.projetDetail = projetDetail;
    }
}
