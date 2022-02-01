package com.irisi.projetservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProjetDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @ManyToOne
    private ProjetMemberEntity projetMember;

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

    public ProjetMemberEntity getProjetMember() {
        return projetMember;
    }

    public void setProjetMember(ProjetMemberEntity projetMember) {
        this.projetMember = projetMember;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
