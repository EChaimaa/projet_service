package com.irisi.projetservice.domain.pojo;

import com.irisi.projetservice.infra.entity.ProjetMemberEntity;

import java.util.Date;

public class projetDetailPojo {
    private Date beginTime;
    private Date endTime;
    private ProjetMemberPojo projetMember;

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

    public ProjetMemberPojo getProjetMember() {
        return projetMember;
    }

    public void setProjetMember(ProjetMemberPojo projetMember) {
        this.projetMember = projetMember;
    }
}
