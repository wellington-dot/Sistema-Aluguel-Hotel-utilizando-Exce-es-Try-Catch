package com.example.reservation_exceptions.Domain_Exceptions;

//Classe de exceção
public class DomainExceptions extends Exception{

    //Cnstrutor da exceção com argumento String, para adicionar msg na instanciação
    public DomainExceptions(String msg) {
        super(msg);
    }
}
