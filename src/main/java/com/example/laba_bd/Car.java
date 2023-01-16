package com.example.laba_bd;


import java.util.Date;

public class Car {
    private int id;

    private String name;

    private String manufacture;

    private int numberOfEngine;
    private int year;

    private Date dateOfLastInspection;
    public Car(){}

    public Car(int id, String name, String manufacture, int numberOfEngine, int year, Date dateOfLastInspection) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.numberOfEngine = numberOfEngine;
        this.year = year;
        this.dateOfLastInspection = dateOfLastInspection;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getNumberOfEngine() {
        return numberOfEngine;
    }

    public void setNumberOfEngine(int numberOfEngine) {
        this.numberOfEngine = numberOfEngine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getDateOfLastInspection() {
        return dateOfLastInspection;
    }

    public void setDateOfLastInspection(Date dateOfLastInspection) {
        this.dateOfLastInspection = dateOfLastInspection;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", numberOfEngine=" + numberOfEngine + '\'' +
                ", year=" + year + '\'' +
                ", dateOfLastInspection=" + dateOfLastInspection +
                '}';
    }
}
