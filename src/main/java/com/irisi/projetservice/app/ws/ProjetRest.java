package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.ClientMapper;
import com.irisi.projetservice.app.converter.ProjetMapper;
import com.irisi.projetservice.app.dto.ClientDto;
import com.irisi.projetservice.app.dto.ProjetDto;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.domain.projet.affect.ProjectAffectToProcess;
import com.irisi.projetservice.domain.projet.create.ProjectCreateInput;
import com.irisi.projetservice.domain.projet.create.ProjectCreateProcess;
import com.irisi.projetservice.domain.projet.delete.ProjectDeleteProcess;
import com.irisi.projetservice.infra.entity.ClientEntity;
import com.irisi.projetservice.infra.entity.ProjetEntity;
import com.irisi.projetservice.infra.facade.ProjetInfra;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gestion-projet/projets")
public class ProjetRest {
    @Autowired
    ProjetInfra projetInfra;
    ProjetMapper projetMapper;
    ClientMapper clientMapper;
    ProjectAffectToProcess projectAffectToProcess;
    ProjectCreateProcess projectCreateProcess;
    ProjectDeleteProcess projectDeleteProcess;
    ProjectCreateInput projectCreateInput;

    @PostMapping("/")
    public Result createProjet(@RequestBody ClientDto clientDto, @RequestBody ProjetDto projetDto){
        ProjetEntity projet = projetMapper.toEntity(projetDto);
        ClientEntity client = clientMapper.toEntity(clientDto);
        ProjetPojo projetPojo = new ProjetPojo();
        BeanUtils.copyProperties(projet, projetPojo);
        projectCreateInput.setProjetPojo(projetPojo);
        projectCreateInput.setReferenceClient(client.getReference());
        return projectCreateProcess.execute(projectCreateInput);
    }
}
