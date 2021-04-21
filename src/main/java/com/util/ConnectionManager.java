package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager connectionManager;
    private Connection connection;



    private ConnectionManager() {

        try {
            connection = DriverManager.getConnection ("jdbc:h2:C:\\Users\\dumitru.horge\\IdeaProjects\\h2db\\person.h2", "root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }


    public static ConnectionManager getConnectionManagerInstance() {
        if (connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return  connectionManager;
    }
}
