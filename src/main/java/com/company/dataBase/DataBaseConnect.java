package com.company.dataBase;

import com.company.readFile.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataBaseConnect {
    private static BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(10, true);
    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "123456";

    public void createPool() {
        try {
            Class.forName(driver);
            Logger.writeInfo(("------ Драйвер подключен! ------\n"));
        } catch (ClassNotFoundException e) {
            Logger.writeInfo(("------ PostgreSQL JDBC Driver не найден! ------\n"));
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            try {
                pool.add(DriverManager.getConnection(url, user, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                pool.put(conn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
