package com.tn.spring.learningspring.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RESERVATION_ID")
    private long id;

    @Column(name="ROOM_ID")
    private long room;

    @Column(name="GUEST_ID")
    private long guest;

    @Column(name="RES_DATE")
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoom() {
        return room;
    }

    public void setRoom(long room) {
        this.room = room;
    }

    public long getGuest() {
        return guest;
    }

    public void setGuest(long guest) {
        this.guest = guest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
               "id=" + id +
               ", room=" + room +
               ", guest=" + guest +
               ", date='" + date + '\'' +
               '}';
    }
}
