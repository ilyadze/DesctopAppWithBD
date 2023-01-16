package com.example.laba_bd;

import java.util.Date;

public class Accountings {

    private int id;

    private int idAutomobile;

    private int idOwner;

    private int hour;

    private Date arrivalDate;

    private Date dateOfDeparture;

    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAutomobile() {
        return idAutomobile;
    }

    public void setIdAutomobile(int idAutomobile) {
        this.idAutomobile = idAutomobile;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date date_of_departure) {
        this.dateOfDeparture = date_of_departure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nAccounting{" +
                "id=" + id +
                ", idAutomobile=" + idAutomobile +
                ", idOwner=" + idOwner +
                ", hour=" + hour +
                ", arrivalDate=" + arrivalDate +
                ", dateOfDeparture=" + dateOfDeparture +
                ", price=" + price +
                '}';
    }
}
