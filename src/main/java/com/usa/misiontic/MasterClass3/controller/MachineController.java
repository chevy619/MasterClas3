
package com.usa.misiontic.MasterClass3.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.usa.misiontic.MasterClass3.entities.Machine;
import com.usa.misiontic.MasterClass3.service.MachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Machine")
@JsonPropertyOrder({"id", "name", "brand", "year", "description", "category", "messages", "reservations"})
public class MachineController {
    @Autowired
    private MachineService machineService;
    
    @GetMapping("/all")
    public List<Machine> getAll(){
        return machineService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine p){
        return machineService.save(p);
    }
    
    
    
    
    
}
