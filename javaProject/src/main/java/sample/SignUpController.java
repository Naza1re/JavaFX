package sample;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.javaproject.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SgnUpLastName;

    @FXML
    private CheckBox SignUpCheckboxFemale;

    @FXML
    private CheckBox SignUpCheckboxMale;

    @FXML
    private TextField SignUpName;

    @FXML
    private Button authSigninButton;

    @FXML
    private TextField lognField;

    @FXML
    private PasswordField passwordfield;

    @FXML
    void initialize() {
        DataBaseHandler DbHandler = new DataBaseHandler();

        authSigninButton.setOnAction(event -> {
            DbHandler.signUpUser(SignUpName.getText(), SgnUpLastName.getText(),
                    lognField.getText(),passwordfield.getText(),
            "Male");
        });


    }

}
