package com.cursmysql;
import javafx.scene.chart.ScatterChart;

import java.sql.*;


public abstract class DbConnector {
    private static Connection connection = null;

    public static  Connection getDbConnection() {
        //JDBC driver name and database URL
        String url = "jdbc:mysql://localhost:3306/facultate";
        // Database credential
        String pass = "";
        String user = "root";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // STEP3: Open a connection
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println(connection);
            System.out.println("Successfully connected to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  connection;

    }
}
