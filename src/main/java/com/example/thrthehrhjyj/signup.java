package com.example.thrthehrhjyj;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signup {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signupButton;
    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;


    @FXML
    void initialize() {
        signupButton.setOnAction(actionEvent -> {
            // отправляем данные в базу данных
            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.signUpUser(login_field.getText(), password_field.getText());

            // прячем первое окно
            signupButton.getScene().getWindow().hide();

            // загружаем файл main.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main.fxml"));

            try {
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);

                // устанавливаем контроллер для main.fxml
            }
        });
    }
}