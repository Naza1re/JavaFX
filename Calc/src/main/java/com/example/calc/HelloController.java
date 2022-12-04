package com.example.calc;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class HelloController {



    @FXML
    private Text output;
    private long num1;
    private long num2;
    private boolean start = true;
    private String  operator = "";

    private Model model = new Model();



    @FXML
    private void processnum(ActionEvent event){

        if(start){
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText()+value);

    }

    @FXML
    private void processoperator(ActionEvent event){
    String value = ((Button)event.getSource()).getText();
    if(!"=".equals(value)){
        if (!operator.isEmpty()) return;
        operator = value;
        num1 = Long.parseLong(output.getText());
        output.setText("");


    }
    else{
        if(operator.isEmpty())return;
        output.setText(String.valueOf(model.calculation(num1,Long.parseLong(output.getText()),operator)));
        operator= "";
        start = true;
    }

    }



}
