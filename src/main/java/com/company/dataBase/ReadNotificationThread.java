package com.company.dataBase;

import com.company.readFile.WriteFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadNotificationThread extends Thread {
    DBConnect dbConnect = new DBConnect();
    SelectDB selectDB = new SelectDB();
    int numberColum = selectDB.columNumberNotification();
    PreparedStatement preparedStatement;
    String notification = "";
    String status = "";

    public void run() {
        Connection con = dbConnect.getConnection();
        try {
            for (int i = 1; i <= numberColum; i++) {
                WriteFile.writeInfo(("Order number: " + i + '\n'));
                preparedStatement =
                        con.prepareStatement("SELECT * FROM notification where id = ?");
                preparedStatement.setInt(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    notification = resultSet.getString("notification");
                    status = resultSet.getString("status");
                }
                ifFalseSentStatus();
                ifNewStatus(i);
                ifTrueSentStatus();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }

    private void ifFalseSentStatus() {
        if (!status.equals("sent")) {
            WriteFile.writeInfo(("Notification : " + notification + ", status: " + status + '\n'));
        }
    }
    private void ifTrueSentStatus() {
        if (status.equals("sent")) {
            WriteFile.writeInfo(("Notification: " + notification + ", status: " + status + '\n'));
        }
    }

    private void ifNewStatus(int id) {
        Connection con = dbConnect.getConnection();
        try {
            if (status.equals("new")) {
                preparedStatement =
                        con.prepareStatement("Update notification SET status = 'sent' where id = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            dbConnect.closeConnection(con);
        }
    }
}