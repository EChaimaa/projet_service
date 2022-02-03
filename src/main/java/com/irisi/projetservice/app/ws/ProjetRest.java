package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.ProjetMapper;
import com.irisi.projetservice.app.dto.ProjetDto;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.domain.projet.create.ProjectCreateInput;
import com.irisi.projetservice.domain.projet.create.ProjectCreateProcess;
import com.irisi.projetservice.domain.projet.delete.ProjectDeleteInput;
import com.irisi.projetservice.domain.projet.delete.ProjectDeleteProcess;
import com.irisi.projetservice.infra.entity.ProjetEntity;
import com.irisi.projetservice.infra.facade.ProjetInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-projet/projets")
public class ProjetRest {
    @Autowired
    ProjetInfra projetInfra;
    @Autowired
    ProjectCreateProcess projectCreateProcess;
    @Autowired
    ProjectDeleteProcess projectDeleteProcess;

    @PostMapping("/")
    public Result createProjet(@RequestBody ProjetDto projetDto) {
        ProjetMapper projetMapper = new ProjetMapper();
        ProjetPojo projet = projetMapper.toPojo(projetDto);
        ProjectCreateInput projectCreateInput = new ProjectCreateInput();
        projectCreateInput.setProjetPojo(projet);
        return projectCreateProcess.execute(projectCreateInput);
    }

    @Transactional
    @DeleteMapping("/{refProjet}")
    public Result deleteProjet(@PathVariable String refProjet) {
        ProjectDeleteInput projectDeleteInput = new ProjectDeleteInput();
        projectDeleteInput.setReference(refProjet);
        return projectDeleteProcess.execute(projectDeleteInput);
    }

    @GetMapping("/{refProjet}")
    public ProjetPojo findByReference(@PathVariable String refProjet) {
        return projetInfra.findByReference(refProjet);
    }

    @GetMapping("/")
    public List<ProjetEntity> findAll(){
        return projetInfra.findAll();
    }
}
