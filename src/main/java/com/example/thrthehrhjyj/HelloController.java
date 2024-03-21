package com.example.thrthehrhjyj;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView fon;

    @FXML
    private TextField loginButton;

    @FXML
    private PasswordField passwordButton;

    @FXML
    private Button vxodButton;

    @FXML
    private Button zaregistrButton;

    @FXML
    void initialize() {

        vxodButton.setOnAction(event -> {
//прячем первое окно
            vxodButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main.fxml"));
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

        zaregistrButton.setOnAction(event -> {
//прячем первое окно
            zaregistrButton.getScene().getWindow().hide();
//отображаем нужное окно
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("oknosignup.fxml"));
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

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {

        return null;
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM" + Const.USER_TABLE + "WHERE" +
                Const.USERS_USERNAME + "=? AND" + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }

    public void openNewScene(String window) {
//прячем первое окно
        zaregistrButton.getScene().getWindow().hide();
//отображаем нужное окно
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

        zaregistrButton.setOnAction(event -> {
            openNewScene("main.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        if (counter >= 1) {
            openNewScene("main.fxml");
        } else {
            Shake userLoginAnim = new Shake(loginButton);
            Shake userPassAnim = new Shake(passwordButton);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }
}