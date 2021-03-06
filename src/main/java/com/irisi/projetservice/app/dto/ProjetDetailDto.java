package com.irisi.projetservice.app.dto;

import java.util.Date;

public class ProjetDetailDto {
    private Long id;
    private Date beginTime;
    private Date endTime;
    private ProjetMemberDto projetMember;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ProjetMemberDto getProjetMember() {
        return projetMember;
    }

    public void setProjetMember(ProjetMemberDto projetMember) {
        this.projetMember = projetMember;
    }
}
