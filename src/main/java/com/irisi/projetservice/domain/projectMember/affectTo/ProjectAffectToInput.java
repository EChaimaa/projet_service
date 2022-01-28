package com.irisi.projetservice.domain.projectMember.affectTo;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;

public class ProjectAffectToInput extends AbstractProcessInput {
    private ProjetMemberPojo projetMember;

    public ProjetMemberPojo getProjetMember() {
        return projetMember;
    }

    public void setProjetMember(ProjetMemberPojo projetMember) {
        this.projetMember = projetMember;
    }
}
