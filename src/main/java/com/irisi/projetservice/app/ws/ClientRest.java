package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.ClientMapper;
import com.irisi.projetservice.app.dto.ClientDto;
import com.irisi.projetservice.domain.client.create.ClientCreateInput;
import com.irisi.projetservice.domain.client.create.ClientCreateProcess;
import com.irisi.projetservice.domain.client.delete.ClientDeleteInput;
import com.irisi.projetservice.domain.client.delete.ClientDeleteProcess;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.entity.ClientEntity;
import com.irisi.projetservice.infra.facade.ClientInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-projet/clients")
public class ClientRest {
    @Autowired
    ClientInfra clientInfra;
    @Autowired
    ClientCreateProcess clientCreateProcess;
    @Autowired
    ClientDeleteProcess clientDeleteProcess;

    @PostMapping("/")
    public Result createClient(@RequestBody ClientDto clientDto){
        ClientMapper clientMapper = new ClientMapper();
        ClientPojo client = clientMapper.toPojo(clientDto);
        ClientCreateInput clientCreateInput = new ClientCreateInput();
        clientCreateInput.setClientPojo(client);
        return clientCreateProcess.execute(clientCreateInput);
    }

    @GetMapping("/")
    public List<ClientEntity> findAll(){
        return clientInfra.findAll();
    }

    @Transactional
    @DeleteMapping("/{reference}")
    public Result deleteClient(@PathVariable String reference){
        ClientDeleteInput clientDeleteInput = new ClientDeleteInput();
        clientDeleteInput.setReference(reference);
        return clientDeleteProcess.execute(clientDeleteInput);
    }
}
