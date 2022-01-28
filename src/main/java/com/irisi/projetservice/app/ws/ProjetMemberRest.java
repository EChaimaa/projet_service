package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.ProjetMapper;
import com.irisi.projetservice.app.converter.ProjetMemberMapper;
import com.irisi.projetservice.app.dto.ProjetDto;
import com.irisi.projetservice.app.dto.ProjetMemberDto;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.domain.projectMember.affectTo.ProjectAffectToInput;
import com.irisi.projetservice.domain.projectMember.affectTo.ProjectAffectToProcess;
import com.irisi.projetservice.domain.projet.create.ProjectCreateInput;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gestion-projet/projets-members")
public class ProjetMemberRest {
    @Autowired
    ProjetMemberInfra projetMemberInfra;
    @Autowired
    ProjectAffectToProcess projectAffectToProcess;

    @PostMapping("/")
    public Result affectTo(@RequestBody ProjetMemberDto projetMemberDto){
        ProjetMemberMapper projetMemberMapper = new ProjetMemberMapper();
        ProjetMemberPojo projetMember = projetMemberMapper.toPojo(projetMemberDto);
        ProjectAffectToInput projectAffectToInput = new ProjectAffectToInput();
        projectAffectToInput.setProjetMember(projetMember);
        return projectAffectToProcess.execute(projectAffectToInput);
    }
}
