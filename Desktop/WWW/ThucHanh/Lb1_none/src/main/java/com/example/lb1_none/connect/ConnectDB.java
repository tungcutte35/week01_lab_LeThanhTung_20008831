package com.example.lb1_none.connect;

import java.sql.*;

public class ConnectDB {
    private static ConnectDB insance;
    private java.sql.Connection conn;
    String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    String DB_URL = "jdbc:mariadb://localhost:3306/mydb";
    String USER = "root";
    String PASS = "1";
    public ConnectDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(
                DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
    }

    public static ConnectDB getInsance() throws Exception {
        if(insance == null){
            insance = new ConnectDB();
        }
        return insance;
    }

    public Connection getConn() {
        return conn;
    }
}
