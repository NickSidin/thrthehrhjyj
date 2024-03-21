package com.example.thrthehrhjyj;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Income {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addincomeButton;

    @FXML
    private Button expenseButton;

    @FXML
    private Button finButton;

    @FXML
    private Button incomeButton;

    @FXML
    private Button mainButton;
    @FXML
    private String inputData; // переменная для хранения переданных данных

    public void setData(String data) {
        inputData = data; // сохраняем переданные данные
    }
    @FXML
    void initialize() {
        mainButton.setOnAction(actionEvent -> {
//прячем первое окно
            mainButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
//указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("main.fxml"));
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

        incomeButton.setOnAction(actionEvent -> {
//прячем первое окно
            incomeButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
//указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("addincome.fxml"));
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

        expenseButton.setOnAction(actionEvent -> {
//прячем первое окно
            expenseButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
//указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("addexpense.fxml"));
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

        finButton.setOnAction(actionEvent -> {
//прячем первое окно
            finButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
//указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("fin.fxml"));
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

        addincomeButton.setOnAction(actionEvent -> {
//прячем первое окно
            addincomeButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
//указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("addincome.fxml"));
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


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("income.fxml"));
        try {
            Parent root = loader.load();
            Income income = loader.getController();
            income.setData(inputData); // передаем данные на страницу income.fxml
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}