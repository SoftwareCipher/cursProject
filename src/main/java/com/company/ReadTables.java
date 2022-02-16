package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTables {
    Connection con = ConnectDB.getInstance();
    PreparedStatement preparedStatement;
    WriteToFile writeToFile = new WriteToFile();

    public void readT() {
        readTablePerson();
        readTableNotification();
        readTablePack();
        readTableDepartment();
    }

    private void readTablePerson() {
        writeToFile.writeInfoTable("Таблица person:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                writeToFile.writeInfoTable(resultSet.getString("id"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("fio"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("email"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("phone"));
                writeToFile.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void readTableNotification() {
        writeToFile.writeInfoTable("Таблица notification:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM notification");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                writeToFile.writeInfoTable(resultSet.getString("id"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("notification"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("status"));
                writeToFile.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void readTableDepartment() {
        writeToFile.writeInfoTable("Таблица department:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                writeToFile.writeInfoTable(resultSet.getString("id"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("description"));
                writeToFile.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void readTablePack() {
        writeToFile.writeInfoTable("Таблица pack:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM pack");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                writeToFile.writeInfoTable(resultSet.getString("id"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("senderName"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("senderDepart"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("recipientDepart"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("recipientPhoneNumber"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("recipientName"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("status"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("dateCreation"));
                writeToFile.writeInfoTable(" | ");
                writeToFile.writeInfoTable(resultSet.getString("dateChange"));
                writeToFile.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
