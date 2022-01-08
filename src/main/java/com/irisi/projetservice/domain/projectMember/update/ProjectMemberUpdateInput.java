package com.irisi.projetservice.domain.projectMember.update;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;

import java.util.Date;

public class ProjectMemberUpdateInput extends AbstractProcessInput {
    private Date beginTime;
    private Date endTime;
    private ProjetMemberPojo projetMemberPojo;

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

    public ProjetMemberPojo getProjetMemberPojo() {
        return projetMemberPojo;
    }

    public void setProjetMemberPojo(ProjetMemberPojo projetMemberPojo) {
        this.projetMemberPojo = projetMemberPojo;
    }
}
