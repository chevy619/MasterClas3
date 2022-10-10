
package com.usa.misiontic.MasterClass3.repository;

import com.usa.misiontic.MasterClass3.entities.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.misiontic.MasterClass3.repository.crudrepository.MachineCrudRepository;

@Repository
public class MachineRepository {
    @Autowired
    private MachineCrudRepository machineCrudRepository;
    
    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    
    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }
    
    public Machine save(Machine p){
        return machineCrudRepository.save(p);
    }
    
    public void delete(Machine p){
        machineCrudRepository.delete(p);
    }
    
}
