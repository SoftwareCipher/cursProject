package com.company.dataBase;

import com.company.readFile.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SelectDB {
    DataBaseConnect dbConnect = new DataBaseConnect();
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

    public void updatePackStatus(int id) {
        Connection con = dbConnect.getConnection();
        try {
            preparedStatement =
                    con.prepareStatement("Update pack SET status = ? where id = ?");
            preparedStatement.setString(1, "old");
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    public void updateNotification(int id, String str) {
        Connection con = dbConnect.getConnection();
        try {
            preparedStatement =
                    con.prepareStatement("Update notification SET notification = ? where id = ?");
            preparedStatement.setString(1, str);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    public void updateTimeChange(int id, LocalDateTime time) {
        Connection con = dbConnect.getConnection();
        try {
            preparedStatement =
                    con.prepareStatement("Update pack SET dateChange = ? where id = ?");
            preparedStatement.setTimestamp(1, Timestamp.valueOf(time));
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    public void checkTable(String name) {
        Connection con = dbConnect.getConnection();
        Statement statement;
        try {
            statement = con.createStatement();
            String query = "SELECT * FROM " + name;
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                String n = res.getString(1);
            }
            System.out.println(res);
            Logger.writeInfo("Таблица " + name + " сущесвует!\n");
        } catch (SQLException exc) {
            Logger.writeInfo("Таблицы " + name + " нет!\n");
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    public boolean checkDepartment(int id) {
        Connection con = dbConnect.getConnection();
        boolean result = false;
        Statement statement;
        try {
            statement = con.createStatement();
            String query = "SELECT id FROM department where id = " + id;
            ResultSet res = statement.executeQuery(query);
            int i = 0;
            while (res.next()) {
                i = res.getInt(1);
            }
            if (i == 0) {
                result = true;
            }
        } catch (SQLException exc) {
            exc.getMessage();
        }finally {
            dbConnect.closeConnection(con);
        }
        return result;

    }

}
