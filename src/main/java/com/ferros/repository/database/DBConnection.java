package com.ferros.repository.database;

import java.sql.*;

public class DBConnection {

    private static final String URL ="jdbc:postgresql://127.0.0.1:5432/jdbc_crud";
    private static final String USERNAME ="postgres";
    private static final String PASSWORD ="dr005764";

    private Connection  connection= null;


    public Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();

        }

        if (connection != null) {
//            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        return connection;
        }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Unable to close connection");
            e.printStackTrace();
        }
    }
    }



