package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.ProjetDetailMapper;
import com.irisi.projetservice.app.converter.ProjetMemberMapper;
import com.irisi.projetservice.app.dto.ProjetDetailDto;
import com.irisi.projetservice.app.dto.ProjetMemberDto;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ProjetDetailPojo;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.projectMember.affectTo.ProjectAffectToInput;
import com.irisi.projetservice.domain.projectMember.affectTo.ProjectAffectToProcess;
import com.irisi.projetservice.domain.projectMember.delete.ProjetMemberDeleteInput;
import com.irisi.projetservice.domain.projectMember.delete.ProjetMemberDeleteProcess;
import com.irisi.projetservice.domain.projectMember.update.ProjectMemberUpdateInput;
import com.irisi.projetservice.domain.projectMember.update.ProjectMemberUpdateProcess;
import com.irisi.projetservice.infra.entity.ProjetMemberEntity;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-projet/projets-members")
public class ProjetMemberRest {
    @Autowired
    ProjetMemberInfra projetMemberInfra;
    @Autowired
    ProjectAffectToProcess projectAffectToProcess;
    @Autowired
    ProjetMemberDeleteProcess projetMemberDeleteProcess;
    @Autowired
    ProjectMemberUpdateProcess projectMemberUpdateProcess;

    @PostMapping("/")
    public Result affectTo(@RequestBody ProjetMemberDto projetMemberDto){
        ProjetMemberMapper projetMemberMapper = new ProjetMemberMapper();
        ProjetMemberPojo projetMember = projetMemberMapper.toPojo(projetMemberDto);
        ProjectAffectToInput projectAffectToInput = new ProjectAffectToInput();
        projectAffectToInput.setProjetMember(projetMember);
        return projectAffectToProcess.execute(projectAffectToInput);
    }

    @Transactional
    @DeleteMapping("/{reference}/{matricule}")
    public Result deleteProjetMember(@PathVariable String reference, @PathVariable String matricule){
        ProjetMemberDeleteInput projetMemberDeleteInput = new ProjetMemberDeleteInput();
        projetMemberDeleteInput.setReference(reference);
        projetMemberDeleteInput.setMatricule(matricule);
        return projetMemberDeleteProcess.execute(projetMemberDeleteInput);
    }

    @PutMapping("/")
    public Result updateWorkHours(@RequestBody ProjetDetailDto projetDetailDto){
        ProjetDetailMapper projetDetailMapper = new ProjetDetailMapper();
        ProjetDetailPojo projetDetail = projetDetailMapper.toPojo(projetDetailDto);
        ProjectMemberUpdateInput projectMemberUpdateInput = new ProjectMemberUpdateInput();
        projectMemberUpdateInput.setProjetDetail(projetDetail);
        return projectMemberUpdateProcess.execute(projectMemberUpdateInput);
    }

    @GetMapping("/{refProjet}")
    public List<ProjetMemberPojo> findProjetMembersByProject(@PathVariable String refProjet){
        return projetMemberInfra.findByProjet(refProjet);
    }
    @GetMapping("/")
    public List<ProjetMemberEntity> findAll(){
        return projetMemberInfra.findAll();
    }
}
