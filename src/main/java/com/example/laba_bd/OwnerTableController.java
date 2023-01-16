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
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OwnerTableController {

    private ObservableList<Owner> ownersList = FXCollections.observableArrayList();

    @FXML
    private TableView<Owner> ownersTable;
    @FXML
    private TableColumn<Owner, Integer> idOwner;

    @FXML
    private TableColumn<Owner, String> FIO;

    @FXML
    private TableColumn<Owner, String> address;

    @FXML
    private TableColumn<Owner, String> accountNumber;

    @FXML
    private TableColumn<Owner, Date> dateOfBirthday;

    @FXML
    private TableColumn<Owner, String> citizenship;

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
        List<Owner> owners = dbConfig.getOwners();
        initOwnersList(owners);
        idOwner.setCellValueFactory(new PropertyValueFactory<Owner, Integer>( "id"));
        FIO.setCellValueFactory(new PropertyValueFactory<Owner, String>("fio"));
        address.setCellValueFactory(new PropertyValueFactory<Owner, String>("address"));
        accountNumber.setCellValueFactory(new PropertyValueFactory<Owner, String> ("accountNumber"));
        dateOfBirthday.setCellValueFactory(new PropertyValueFactory<Owner, Date>("dateOfBirthday"));
        citizenship.setCellValueFactory(new PropertyValueFactory<Owner, String>("citizenship"));

        ownersTable.setItems(ownersList);
    }

    private void initOwnersList(List<Owner> owners) {
        for (Owner owner:owners) {
            ownersList.add(owner);
        }
    }

}
