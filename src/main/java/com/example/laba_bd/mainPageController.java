package com.example.laba_bd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class mainPageController {
//    private List<Car> cars

    @FXML
    private Button buttonCars;

    @FXML
    private Button buttonAccoutings;

    @FXML
    private Button buttonOwners;

    @FXML
    public void checkButtonCars(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/carsTable.fxml"));


//        loader.setLocation();
        try {
            Parent root = loader.load();
//            CarsTableController carsTableController = loader.getController();
//            carsTableController.initialize();
            Stage stage = (Stage) (buttonCars.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void checkButtonOwners(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/ownersTable.fxml"));
//        loader.setLocation();
        try {
            Parent root = loader.load();
            Stage stage = (Stage) (buttonOwners.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void checkButtonAccounting(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/accoutingsTable.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) (buttonAccoutings.getScene().getWindow());

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}