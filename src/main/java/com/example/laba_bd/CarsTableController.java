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

public class CarsTableController {

    private ObservableList<Car> carsList = FXCollections.observableArrayList();

    @FXML
    private TableView<Car> carsTable;

    @FXML
    private TableColumn<Car, Integer> idCarColumn;

    @FXML
    private TableColumn<Car, String> modelColumn;

    @FXML
    private TableColumn<Car, String> manufactureColumn;

    @FXML
    private TableColumn<Car, Integer> numberOfEngineColumn;

    @FXML
    private TableColumn<Car, Integer> yearColumn;

    @FXML
    private TableColumn<Car, Date> dateOfLastInspectionColumn;

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
        List<Car> cars = dbConfig.getCars();
        initCarsList(cars);
        idCarColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>( "id"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("name"));
        manufactureColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("manufacture"));
        numberOfEngineColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer > ("numberOfEngine"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("year"));
        dateOfLastInspectionColumn.setCellValueFactory(new PropertyValueFactory<Car, Date>("dateOfLastInspection"));

        carsTable.setItems(carsList);
    }

    private void initCarsList(List<Car> cars) {
        for (Car car:cars) {
            carsList.add(car);
        }
    }
}
