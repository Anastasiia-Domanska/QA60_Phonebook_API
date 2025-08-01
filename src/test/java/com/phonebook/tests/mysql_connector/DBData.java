package com.phonebook.tests.mysql_connector;

public class DBData {
    //connection URL"jdbc:mysql://localhost:port/databaseName"
    public static final String dbURL = "jdbc:mysql://localhost:3306/Phonebook";
    //database username
    public static final String userName = "root1";  // mysql -u root1 -p
    //database password
    public static final String password = "root1";

    public static final int index1 = 1;
    public static final int index2 = 2;
    //query
    public static final String querySelectUsers = "SELECT * FROM USERS;";
    public static final String queryDeleteUsers = "DELETE FROM USERS WHERE USERNAME='test@gmail.com';"; // delete all %@gmail.com
    public static final String queryCreateUsers = "INSERT INTO USERS(username, password) VALUES ('email', 'password');";
}
