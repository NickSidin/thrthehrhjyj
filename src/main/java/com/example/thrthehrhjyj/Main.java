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

public class Main {

    @FXML
    private ResourceBundle resources;


    @FXML
    private Button exitButton;

    @FXML
    private Button expenseButton;

    @FXML
    private Button finButton;

    @FXML
    private Button incomeButton;
    @FXML
    private Button mainButton;


    @FXML
    void initialize() {
        exitButton.setOnAction(actionEvent -> {
//прячем первое окно
            exitButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
//указываем место расположения нужного файла
            loader.setLocation(getClass().getResource("hello-view.fxml"));
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
            loader.setLocation(getClass().getResource("income.fxml"));
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

    }
}
