package com.construction.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/build";
    private static final String USER = "your_database_user";
    private static final String PASSWORD = "your_database_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
