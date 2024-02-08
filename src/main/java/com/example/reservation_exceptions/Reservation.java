package com.example.reservation_exceptions;

import com.example.reservation_exceptions.Domain_Exceptions.DomainExceptions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private int roomNumber;
    private Date checkin;
    private Date checkout;

    //data formatada
    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(int roomNumber, Date checkin, Date checkout) throws DomainExceptions{
        if (!checkout.after(checkin)) {
            throw new DomainExceptions("Check-Out date must be after Ckeck-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        //.getTime() - retorna a quantidade de milisegundos de uma data..
        long diff = checkout.getTime() - checkin.getTime();
        //Converte os milisegundos para dias.
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) throws DomainExceptions{
        //Instanciando data de agora
        Date now = new Date();
        //Condição data antes de agora
        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainExceptions("Reservation date update must be future dates");
        //Condição data de saida antes da entrada.
        } else if (!checkout.after(checkin)) {
            throw new DomainExceptions("Check-Out date must be after Ckeck-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        return "Room: " + roomNumber
                + ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                + ", duration: "
                + duration()
                + " nights.";
    }
}
