package com.example.laba_bd;

import com.example.laba_bd.DB.DBConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AccoutingsTableController {

    private ObservableList<Accountings> accountingList = FXCollections.observableArrayList();

    @FXML
    private TableView<Accountings> accountingsTable;
    @FXML
    private TableColumn<Accountings, Integer> idAccounting;

    @FXML
    private TableColumn<Accountings, Integer> idCar;

    @FXML
    private TableColumn<Accountings, Integer> idOwner;

    @FXML
    private TableColumn<Accountings, Integer> hour;

    @FXML
    private TableColumn<Accountings, Date> arrivalDate;

    @FXML
    private TableColumn<Accountings, Date> dateOfDeparture;

    @FXML
    private TableColumn<Accountings, BigDecimal> price;


    @FXML
    private Button buttonBack;


    @FXML
    public void checkButtonBack(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/mainPage.fxml"));
//        loader.setLocation();
        try {
            Parent root = loader.load();
            Stage stage = (Stage) (buttonBack.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void initialize () throws SQLException, ClassNotFoundException {
        DBConfig dbConfig = new DBConfig();
        List<Accountings> accountings = dbConfig.getAccountings();
        initCatsList(accountings);
        idAccounting.setCellValueFactory(new PropertyValueFactory<Accountings, Integer>( "id"));
        idCar.setCellValueFactory(new PropertyValueFactory<Accountings, Integer>("idAutomobile"));
        idOwner.setCellValueFactory(new PropertyValueFactory<Accountings, Integer>("idOwner"));
        hour.setCellValueFactory(new PropertyValueFactory<Accountings, Integer > ("hour"));
        arrivalDate.setCellValueFactory(new PropertyValueFactory<Accountings, Date>("arrivalDate"));
        dateOfDeparture.setCellValueFactory(new PropertyValueFactory<Accountings, Date>("dateOfDeparture"));
        price.setCellValueFactory(new PropertyValueFactory<Accountings, BigDecimal>("price"));

        accountingsTable.setItems(accountingList);
    }

    private void initCatsList(List<Accountings> accountings) {
        for (Accountings accounting:accountings) {
            accountingList.add(accounting);
        }
    }
}
