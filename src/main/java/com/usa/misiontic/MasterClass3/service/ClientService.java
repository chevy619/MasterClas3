
package com.usa.misiontic.MasterClass3.service;

import com.usa.misiontic.MasterClass3.entities.Client;
import com.usa.misiontic.MasterClass3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getCategory(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> e = clientRepository.getClient(c.getIdClient());
            if(e.isPresent()){
                return c;
            }else{
                return clientRepository.save(c);
            }
        }
    }
 //FALTA TERMINAR LA LOGICA DEL SERVICIO DECUAERDO A LOS ATRIBUTOS DE LA CLASE CLIENT   
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(c.getIdClient());
            if(q.isPresent()){
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if(c.getEmail()!=null){
                    q.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    q.get().setPassword(c.getPassword());
                }
                if(c.getAge()!=null){
                    q.get().setAge(c.getAge());
                }
                if(c.getMessages()!=null){
                    q.get().setMessages(c.getMessages());
                }
                if(c.getReservations()!=null){
                    q.get().setReservations(c.getReservations());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        } 
    }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional<Client> e = clientRepository.getClient(id);
        
        if(e.isPresent()){
            clientRepository.delete(e.get());
            flag = true;
        }        
        return flag;
    }
}
