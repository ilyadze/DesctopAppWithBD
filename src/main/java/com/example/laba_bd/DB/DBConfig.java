package com.example.laba_bd.DB;

import com.example.laba_bd.Accountings;
import com.example.laba_bd.Car;
import com.example.laba_bd.Owner;

import java.sql.*;
import java.util.ArrayList;

public class DBConfig {
    protected String HOST = "localhost";
    protected String PORT = "3306";
    protected String LOGIN = "root";
    protected String PASS = "Ilya12132581321";
    protected String DB_NAME = "car_park";

    private Connection dbConn = null;

    // Метод для подключения к БД с использованием значений выше
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }


     //Метод для получения всех заданий из таблицы todo
    public ArrayList<Car> getCars() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM automobile ORDER BY `id` DESC";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        ArrayList<Car> cars = new ArrayList<>();
        while(res.next()) {
            Car car = new Car();
            car.setId(res.getInt("id"));
            car.setName(res.getString("name"));
            car.setManufacture(res.getString("manufacture"));
            car.setNumberOfEngine(res.getInt("number_of_engine"));
            car.setYear(res.getInt("year"));
            car.setDateOfLastInspection(res.getDate("date_of_last_inspection"));
            cars.add(car);
        }

        return cars;
    }

    public ArrayList<Owner> getOwners() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM car_owners ORDER BY `id` DESC";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        ArrayList<Owner> owners = new ArrayList<>();
        while(res.next()) {
            Owner owner = new Owner();
            owner.setId(res.getInt("id"));
            owner.setFio(res.getString("fio"));
            owner.setAddress(res.getString("address"));
            owner.setAccountNumber(res.getString("account_number"));
            owner.setDateOfBirthday(res.getDate("date_of_birthday"));
            owner.setCitizenship(res.getString("citizenship"));
            owners.add(owner);
        }

        return owners;

    }

    public ArrayList<Accountings> getAccountings() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM payment_accounting ORDER BY `id` DESC";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        ArrayList<Accountings> accountings = new ArrayList<>();
        while(res.next()) {
            Accountings accounting = new Accountings();
            accounting.setId(res.getInt("id"));
            accounting.setIdAutomobile(res.getInt("automobile"));
            accounting.setIdOwner(res.getInt("owner"));
            accounting.setHour(res.getInt("hour"));
            accounting.setArrivalDate(res.getDate("arrival_date"));
            accounting.setDateOfDeparture(res.getDate("date_of_departure"));
            accounting.setPrice(res.getDouble("price"));

            accountings.add(accounting);
        }

        return accountings;

    }



}
