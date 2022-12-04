package com.example.pogoda;
import org.json.JSONObject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GetData;

    @FXML
    private Text chous;

    @FXML
    private TextField city;

    @FXML
    private Text max;

    @FXML
    private Text min;

    @FXML
    private Text preasyre;

    @FXML
    private Text temprityre;

    @FXML
    void initialize() {
        GetData.setOnAction(event -> {
            String getUserCity = city.getText().trim();
            if(!getUserCity.equals("")) {


                String output = getUrlContent("http://api.openweathermap.org/data/2.5/find?q=" + getUserCity + "&type=like&APPID=97873f87fc1b4927356aa0b926698655");
                System.out.println(output);


                    JSONObject obj = new JSONObject(output);


                    temprityre.setText("Температура : " + obj.getJSONObject("main").getDouble("temp"));
                    chous.setText("Ощущается : " + obj.getJSONObject("main").getString("feels_like"));
                    max.setText("Температура : " + obj.getJSONObject("main").getString("temp_max"));
                    min.setText("Температура : " + obj.getJSONObject("main").getString("temp_min"));
                    preasyre.setText("Температура : " + obj.getJSONObject("main").getString("pressure"));
                }


        });


    }

    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((urlConn.getInputStream())));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");

            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Ты ввел не правильный город ");
        }
        return content.toString();
    }


}

