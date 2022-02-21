package com.company.dataBase;

import com.company.readFile.Logger;
import com.company.entities.Department;
import com.company.entities.Notification;
import com.company.entities.Package;
import com.company.entities.Person;

import java.sql.*;

public class SaveDate {
    DataBaseConnect dbConnect = new DataBaseConnect();
    SelectDB selectDB = new SelectDB();

    public void savePerson(Person person) {
        Connection con = dbConnect.getConnection();
        selectDB.checkTable("person");
        try {
            String sql =
                    "Insert into Person (fio, email, phone) Values (?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, person.getFio());
            preparedStatement.setString(2, person.getEmail());
            preparedStatement.setInt(3, person.getPhoneNumber());
            preparedStatement.executeUpdate();
            Logger.writeInfo(person.getFio() + " "
                    + person.getEmail() + " "
                    + person.getPhoneNumber() + '\n');
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    public void saveDepartment(Department department) {
        Connection con = dbConnect.getConnection();
        if(selectDB.checkDepartment(department.getId())) {
            selectDB.checkTable("department");
            try {
                String sql = "Insert into department (id, description) Values (?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, department.getId());
                preparedStatement.setString(2, department.getDesc());

                preparedStatement.executeUpdate();

                Logger.writeInfo(department.getId() + " "
                        + department.getDesc() + '\n');
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                dbConnect.closeConnection(con);
            }
        }
    }

    public void savePackage(Package pack) {
        Connection con = dbConnect.getConnection();
        selectDB.checkTable("pack");
        try {
            String sql = "Insert into pack (senderName, senderDepart, recipientDepart, recipientPhoneNumber," +
                    "recipientName, status, dateCreation, dateChange) Values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, pack.getSenderName());
            preparedStatement.setString(2, pack.getSenderDepart());
            preparedStatement.setString(3, pack.getRecipientDepart());
            preparedStatement.setInt(4, pack.getRecipientPhoneNumber());
            preparedStatement.setString(5, pack.getRecipientName());
            preparedStatement.setString(6, pack.getStatus());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(pack.getDateCreation()));
            preparedStatement.setTimestamp(8, Timestamp.valueOf(pack.getDateChange()));
            preparedStatement.executeUpdate();
            Logger.writeInfo(pack.getSenderName() + " "
                    + pack.getSenderDepart() + " "
                    + pack.getRecipientDepart() + " "
                    + pack.getRecipientPhoneNumber() + " "
                    + pack.getRecipientName() + " "
                    + pack.getStatus() + " "
                    + Timestamp.valueOf(pack.getDateCreation()) + " "
                    + Timestamp.valueOf(pack.getDateChange()) + '\n');
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    public void saveNotification(Notification notification) {
        Connection con = dbConnect.getConnection();
        selectDB.checkTable("notification");
        try {
            String sql = "Insert into notification (notification, status) Values (?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, notification.getText());
            preparedStatement.setString(2, notification.getStatus());
            preparedStatement.executeUpdate();
            Logger.writeInfo(notification.getText() + " "
                    + notification.getStatus() + '\n');
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }
}