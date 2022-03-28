package com.company.dataBase;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SelectDB {
    DBConnect dbConnect = new DBConnect();
    PreparedStatement preparedStatement = null;

    public int columNumberPack() {
        Connection con = dbConnect.getConnection();
        int resul = 0;
        try {
            preparedStatement = con.prepareStatement("select count(*) from pack");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resul = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
        return resul;
    }

    public LocalDateTime columTime(int id) {
        Connection con = dbConnect.getConnection();
        Timestamp date = null;
        try {
            preparedStatement = con.prepareStatement("select dateCreation from pack where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                date = resultSet.getTimestamp("dateCreation");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
        return date.toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
    }

    public int columNumberNotification() {
        Connection con = dbConnect.getConnection();
        int resul = 0;
        try {
            preparedStatement = con.prepareStatement("select count(*) from notification");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resul = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
        return resul;
    }

    public String statusNotification(int id) {
        Connection con = dbConnect.getConnection();
        String notification = null;
        try {
            preparedStatement = con.prepareStatement("SELECT notification FROM notification WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                notification = resultSet.getString("notification");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
        return notification;
    }
}
