package com.tn.spring.learningspring.util;

import com.tn.spring.learningspring.data.Guest;
import com.tn.spring.learningspring.data.GuestRepository;
import com.tn.spring.learningspring.data.Reservation;
import com.tn.spring.learningspring.data.ReservationRepository;
import com.tn.spring.learningspring.data.Room;
import com.tn.spring.learningspring.data.RoomRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationEvent> {
   private final RoomRepository roomRepository;
   private final GuestRepository guestRepository;

   private final ReservationRepository reservationRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {

        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);
        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);
        Iterable<Reservation> reservations = this.reservationRepository.findAll();
        reservations.forEach(System.out::println);

    }
}
