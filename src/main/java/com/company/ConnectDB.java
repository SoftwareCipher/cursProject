package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;

public class ConnectDB {

    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "123456";
    private static Connection connection;
    static WriteToFile writeToFile = new WriteToFile();

    private ConnectDB() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }

    public static Connection getConnection() {
        writeToFile.writeInfo(("------ Пpoвepka пoдkлючeния k PostgreSQL ------\n"));
        Connection conn = null;
        try {
            Class.forName(driver);
            writeToFile.writeInfo(("------ Драйвер подключен! ------\n"));
        } catch (ClassNotFoundException e) {
            writeToFile.writeInfo(("------ PostgreSQL JDBC Driver не найден! ------\n"));
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            writeToFile.writeInfo(("------ Ошибка подключения ------\n"));
            ex.printStackTrace();
        }

        if (null != conn) {
            writeToFile.writeInfo(("------ Пoдkлючeниe ycтaнoвлeнo ------\n"));
            writeToFile.writeInfo(String.valueOf(LocalTime.now()) + '\n');
        } else {
            writeToFile.writeInfo(("------ Пoдkлючeниe НE ycтaнoвлeнo ------\n"));
        }
        return conn;
    }
}

