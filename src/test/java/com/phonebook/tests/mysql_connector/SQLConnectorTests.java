package com.phonebook.tests.mysql_connector;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class SQLConnectorTests {
    Connection connection;

    @BeforeMethod
    public void loadDB(){
        //load jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection
            connection = DriverManager.getConnection(DBData.dbURL, DBData.userName, DBData.password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void closeDB(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getDataFromDBTest(){
        //создать обьект оператора
        try {
            Statement statement = connection.createStatement();
            //выполнить запрос
            ResultSet resultSet = statement.executeQuery(DBData.querySelectUsers);
            while (resultSet.next()){
                System.out.println("username: " + resultSet.getString(DBData.index1)
                        + "\npassword: " + resultSet.getString(DBData.index2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deleteUserFromDBTest(){
        try {
            PreparedStatement statement = connection.prepareStatement(DBData.queryDeleteUsers);
            statement.executeUpdate();
            ResultSet resultSet = statement.executeQuery(DBData.querySelectUsers);
            while (resultSet.next()){
                System.out.println("username: " + resultSet.getString(DBData.index1)
                        + "\npassword: " + resultSet.getString(DBData.index2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createUserTest(){
        try {
            PreparedStatement statement = connection.prepareStatement(DBData.queryCreateUsers);
            statement.executeUpdate();
            ResultSet resultSet = statement.executeQuery(DBData.querySelectUsers);
            while (resultSet.next()){
                System.out.println("username: " + resultSet.getString(DBData.index1)
                        + "\npassword: " + resultSet.getString(DBData.index2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
