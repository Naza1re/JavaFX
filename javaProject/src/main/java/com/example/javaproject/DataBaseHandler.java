package com.example.javaproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException,SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;


    }


    public void signUpUser(String firstName,String lastName,String userName,
                           String password,String gender)
    {
    String insert = "INSERT INTO" + Const.USER_TABLE + "("+
            Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
            Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
            Const.USERS_GENDER + ")" +
            "VALUES(?,?,?,?,?)";


        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,firstName);
            prSt.setString(2,lastName);
            prSt.setString(3,userName);
            prSt.setString(4,password);
            prSt.setString(5,gender);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }








}
