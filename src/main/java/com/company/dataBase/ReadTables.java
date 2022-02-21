package com.company.dataBase;

import com.company.readFile.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTables {
    DataBaseConnect dbConnect = new DataBaseConnect();
    Connection con = dbConnect.getConnection();
    PreparedStatement preparedStatement;

    public void readT() {
        readTablePerson();
        readTableNotification();
        readTablePack();
        readTableDepartment();
    }

    private void readTablePerson() {
        Connection con = dbConnect.getConnection();
        Logger.writeInfoTable("Таблица person:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Logger.writeInfoTable(resultSet.getString("id"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("fio"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("email"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("phone"));
                Logger.writeInfoTable("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    private void readTableNotification() {
        Connection con = dbConnect.getConnection();
        Logger.writeInfoTable("Таблица notification:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM notification");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Logger.writeInfoTable(resultSet.getString("id"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("notification"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("status"));
                Logger.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    private void readTableDepartment() {
        Connection con = dbConnect.getConnection();
        Logger.writeInfoTable("Таблица department:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Logger.writeInfoTable(resultSet.getString("id"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("description"));
                Logger.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    private void readTablePack() {
        Connection con = dbConnect.getConnection();
        Logger.writeInfoTable("Таблица pack:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM pack");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Logger.writeInfoTable(resultSet.getString("id"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("senderName"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("senderDepart"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("recipientDepart"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("recipientPhoneNumber"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("recipientName"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("status"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("dateCreation"));
                Logger.writeInfoTable(" | ");
                Logger.writeInfoTable(resultSet.getString("dateChange"));
                Logger.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }
}
