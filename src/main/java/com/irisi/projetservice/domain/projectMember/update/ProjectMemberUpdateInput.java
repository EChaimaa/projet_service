package com.irisi.projetservice.domain.projectMember.update;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;

import java.util.Date;

public class ProjectMemberUpdateInput extends AbstractProcessInput {
    private Date beginTime;
    private Date endTime;
    private ProjetPojo projet;
    private EmployePojo employe;

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public ProjetPojo getProjet() {
        return projet;
    }

    public void setProjet(ProjetPojo projet) {
        this.projet = projet;
    }

    public EmployePojo getEmploye() {
        return employe;
    }

    public void setEmploye(EmployePojo employe) {
        this.employe = employe;
    }
}
