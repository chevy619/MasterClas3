
package com.usa.misiontic.MasterClass3.service;

import com.usa.misiontic.MasterClass3.entities.Machine;
import com.usa.misiontic.MasterClass3.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;
    
    public List<Machine> getAll(){
        return machineRepository.getAll();
    }
    
    public Optional<Machine> getProduct(int id){
        return machineRepository.getMachine(id);
    }
    
    public Machine save(Machine p){
        if(p.getId()==null){
            return machineRepository.save(p);
        }else{
            Optional<Machine> e = machineRepository.getMachine(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return machineRepository.save(p);
            }
        }
    }
    
    public Machine update(Machine p){
        if(p.getId()!=null){
            Optional<Machine> q = machineRepository.getMachine(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getYears()!=null){
                    q.get().setYears(p.getYears());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                machineRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        } 
    }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Machine> e = machineRepository.getMachine(id);
        
        if(e.isPresent()){
            machineRepository.delete(e.get());
            flag = true;
        }        
        return flag;
    }
}
