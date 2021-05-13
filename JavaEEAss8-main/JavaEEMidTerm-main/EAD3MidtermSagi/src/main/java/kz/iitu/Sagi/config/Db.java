package kz.iitu.Sagi.config;

import exception.RequestException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static String URL = "jdbc:postgresql://localhost:5432/endTerm";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "12345";


    public static Connection getConn(){
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RequestException("Invalid connection!!! ");
        }
        return connection;
    }
}

