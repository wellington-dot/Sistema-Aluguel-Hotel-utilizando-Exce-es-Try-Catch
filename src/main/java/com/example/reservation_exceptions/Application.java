package com.example.reservation_exceptions;

import com.example.reservation_exceptions.Domain_Exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SortedMap;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = input.nextInt();
            System.out.print("Checkin date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(input.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(input.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update reservation: ");
            System.out.print("Checkin date (dd/MM/yyyy): ");
            checkIn = sdf.parse(input.next());
            System.out.print("CheckOut date (dd/MM/yyyy): ");
            checkOut = sdf.parse(input.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        }catch (ParseException e){
            System.out.println("Invalid date format");
        }catch (DomainExceptions e){
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error..");
        }

        input.close();
    }
}
