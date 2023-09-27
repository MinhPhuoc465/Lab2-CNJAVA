package com.lab2_52100465.core;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.sql.DriverManager.getConnection;


public class Database {
    protected Connection connection;

    public Database() {
        try {
            this.connection = getConnection("jdbc:mysql://localhost:3310/ProductManagement", "root", "phu0cminh@2703");
            System.out.println("connection success");
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("connection fail");
        }
    }
}