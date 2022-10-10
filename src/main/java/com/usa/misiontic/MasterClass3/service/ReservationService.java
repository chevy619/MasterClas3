
package com.usa.misiontic.MasterClass3.service;

import com.usa.misiontic.MasterClass3.entities.Message;
import com.usa.misiontic.MasterClass3.entities.Reservation;
import com.usa.misiontic.MasterClass3.repository.MessageRepository;
import com.usa.misiontic.MasterClass3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getCategory(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            r.setStatus("created");
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if(e.isPresent()){
                return r;
            }else{
                r.setStatus("created");
                return reservationRepository.save(r);
            }
        }
    }
    
    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(c.getIdReservation());
            if(q.isPresent()){
                if(c.getStartDate()!=null){
                    q.get().setStartDate(c.getStartDate());
                }
                if(c.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(c.getDevolutionDate());
                }
                if(c.getStatus()!=null){
                    q.get().setStatus(c.getStatus());
                }
                if(c.getScore()!=null){
                    q.get().setScore(c.getScore());
                }
                if(c.getMachine()!=null){
                    q.get().setMachine(c.getMachine());
                }
                if(c.getClient()!=null){
                    q.get().setClient(c.getClient());
                }
                reservationRepository.save(q.get());
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
        Optional<Reservation> e = reservationRepository.getReservation(id);
        
        if(e.isPresent()){
            reservationRepository.delete(e.get());
            flag = true;
        }        
        return flag;
    }
}
