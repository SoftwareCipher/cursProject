package com.company;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SelectDB {
    Connection con = ConnectDB.getInstance();
    PreparedStatement preparedStatement = null;
    WriteToFile writeToFile = new WriteToFile();

    public int columNumberPack() {
        int resul = 0;
        try {
            preparedStatement = con.prepareStatement("select count(*) from pack");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resul = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resul;
    }

    public LocalDateTime columTime(int id) {
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
        }
        return date.toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
    }

    public int columNumberNotification() {
        int resul = 0;
        try {
            preparedStatement = con.prepareStatement("select count(*) from notification");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resul = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resul;
    }

    public String statusNotification(int id) {
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
        }
        return notification;
    }

    public void updatePackStatus(int id) {
        try {
            preparedStatement =
                    con.prepareStatement("Update pack SET status = ? where id = ?");
            preparedStatement.setString(1, "old");
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNotification(int id, String str) {
        try {
            preparedStatement =
                    con.prepareStatement("Update notification SET notification = ? where id = ?");
            preparedStatement.setString(1, str);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTimeChange(int id, LocalDateTime time) {
        try {
            preparedStatement =
                    con.prepareStatement("Update pack SET dateChange = ? where id = ?");
            preparedStatement.setTimestamp(1, Timestamp.valueOf(time));
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkTable(String name) {
        Statement statement;
        try {
            statement = con.createStatement();
            String query = "SELECT * FROM " + name;
            ResultSet res = statement.executeQuery(query);
            while(res.next()){
                String n = res.getString(1);
                System.out.println(n);
            }
            System.out.println(res);
            writeToFile.writeInfo("Таблица " + name + " сущесвует!\n");
        } catch (SQLException exc) {
            writeToFile.writeInfo("Таблицы " + name + " нет!\n");
        }
    }

    public boolean checkDepartment(int id){
        boolean result = false;
        Statement statement;
        try {
            statement = con.createStatement();
            String query = "SELECT id FROM department where id = " + id;
            ResultSet res = statement.executeQuery(query);
            int i = 0;
            while (res.next()){
                i = res.getInt(1);
            }
            if(i == 0){
                result = true;
            }
        } catch (SQLException exc) {
            exc.getMessage();
        }
        return result;
    }

}
