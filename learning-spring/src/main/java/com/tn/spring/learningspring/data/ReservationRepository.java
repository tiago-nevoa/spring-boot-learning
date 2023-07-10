package com.tn.spring.learningspring.data;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    //Iterable<Reservation> findReservationByReservationDate(Date date);
}
