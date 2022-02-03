package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.EmployeMapper;
import com.irisi.projetservice.app.dto.EmployeDto;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.employe.create.EmployeCreateInput;
import com.irisi.projetservice.domain.employe.create.EmployeCreateProcess;
import com.irisi.projetservice.domain.employe.delete.EmployeDeleteInput;
import com.irisi.projetservice.domain.employe.delete.EmployeDeleteProcess;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.entity.EmployeEntity;
import com.irisi.projetservice.infra.facade.EmployeInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-projet/employes")
public class EmployeRest {
    @Autowired
    EmployeInfra employeInfra;
    @Autowired
    EmployeCreateProcess employeCreateProcess;
    @Autowired
    EmployeDeleteProcess employeDeleteProcess;

    @PostMapping("/")
    public Result createEmploye(@RequestBody EmployeDto employeDto){
        EmployeMapper employeMapper = new EmployeMapper();
        EmployePojo employe = employeMapper.toPojo(employeDto);
        EmployeCreateInput employeCreateInput = new EmployeCreateInput();
        employeCreateInput.setEmploye(employe);
        return employeCreateProcess.execute(employeCreateInput);
    }

    @GetMapping("/")
    public List<EmployeEntity> findAll(){
        return employeInfra.findAll();
    }

    @Transactional
    @DeleteMapping("/{matricule}")
    public Result deleteEmploye(@PathVariable String matricule){
        EmployeDeleteInput employeDeleteInput = new EmployeDeleteInput();
        employeDeleteInput.setMatricule(matricule);
        return employeDeleteProcess.execute(employeDeleteInput);
    }
}
