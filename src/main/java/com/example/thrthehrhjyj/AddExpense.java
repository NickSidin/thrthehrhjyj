package com.example.thrthehrhjyj;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddExpense {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton1;
    @FXML
    private TextField textfield1;
    @FXML
    private TextField textfield2;
    @FXML
    private TextField textfield3;
    @FXML
    private String inputData;


        @FXML
        void initialize() {
            addButton1.setOnAction(actionEvent -> {
                inputData = textfield1.getText();
                inputData = textfield2.getText();
                inputData = textfield3.getText();
//прячем первое окно
                addButton1.getScene().getWindow().hide();
//отображаем нужное окно
                FXMLLoader loader = new FXMLLoader();
//указываем место расположения нужного файла
                loader.setLocation(getClass().getResource("expense.fxml"));
//загружаем файл для дальнейшего отображения
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            });

        }

    }