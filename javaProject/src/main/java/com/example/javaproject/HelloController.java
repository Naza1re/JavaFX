package com.example.javaproject;
import java.io.IOException;
import java.net.URL;
import javafx.scene.Parent;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LognSgnUpButton;


    @FXML
    private Button authSigninButton;

    @FXML
    private TextField loginfield;

    @FXML
    private PasswordField passwordfueld;

    @FXML
    void initialize() {



        authSigninButton.setOnAction(event -> {
            String loginText = loginfield.getText().trim();
            String loginPassword = passwordfueld.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals(""))
            {
            loginUser(loginText,loginPassword);

            }
            else
                System.out.println("Login or Passwprd is empty");

        });
        LognSgnUpButton.setOnAction(event -> {
            LognSgnUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation((getClass().getResource("SignUp.fxml")));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();

            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Регистрация ");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });





    }

    private void loginUser(String loginText, String loginPassword) {


    }

}
