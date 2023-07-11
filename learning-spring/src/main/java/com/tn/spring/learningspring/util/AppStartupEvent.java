package com.tn.spring.learningspring.util;

import java.util.Date;
import java.util.List;

import com.tn.spring.learningspring.business.ReservationService;
import com.tn.spring.learningspring.business.RoomReservation;
import com.tn.spring.learningspring.data.Guest;
import com.tn.spring.learningspring.data.Reservation;
import com.tn.spring.learningspring.data.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
    }
}
