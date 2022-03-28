package com.company.dataBase;

import com.company.readFile.WriteFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTables {
    DBConnect dbConnect = new DBConnect();
    PreparedStatement preparedStatement;

    public void readAllTables() {
        readTablePerson();
        readTableNotification();
        readTablePack();
        readTableDepartment();
    }

    private void readTablePerson() {
        Connection con = dbConnect.getConnection();
        WriteFile.writeInfoTable("Table person:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WriteFile.writeInfoTable(resultSet.getString("id"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("fio"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("email"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("phone"));
                WriteFile.writeInfoTable("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    private void readTableNotification() {
        Connection con = dbConnect.getConnection();
        WriteFile.writeInfoTable("Table notification:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM notification order by id asc");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WriteFile.writeInfoTable(resultSet.getString("id"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("notification"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("status"));
                WriteFile.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    private void readTableDepartment() {
        Connection con = dbConnect.getConnection();
        WriteFile.writeInfoTable("Table department:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WriteFile.writeInfoTable(resultSet.getString("id"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("description"));
                WriteFile.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    private void readTablePack() {
        Connection con = dbConnect.getConnection();
        WriteFile.writeInfoTable("Table pack:\n");
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM pack order by id asc");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WriteFile.writeInfoTable(resultSet.getString("id"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("senderName"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("senderDepart"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("recipientDepart"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("recipientPhoneNumber"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("recipientName"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("status"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("dateCreation"));
                WriteFile.writeInfoTable(" | ");
                WriteFile.writeInfoTable(resultSet.getString("dateChange"));
                WriteFile.writeInfoTable("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }
}
