
package com.usa.misiontic.MasterClass3.repository.crudrepository;


import com.usa.misiontic.MasterClass3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    
}
