package com.company.dataBase;

import com.company.readFile.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadNotificationThread extends Thread {
    DataBaseConnect dbConnect = new DataBaseConnect();
    SelectDB selectDB = new SelectDB();
    int numberColum = selectDB.columNumberNotification();
    PreparedStatement preparedStatement;
    String notification = "";
    String status = "";

    public void run() {
        Connection con = dbConnect.getConnection();
        try {
            for (int i = 1; i <= numberColum; i++) {
                Logger.writeInfo(("Строка таблицы: " + i + '\n'));
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
            Logger.writeInfo(("Уведомление: " + notification + ", статус: " + status + '\n'));
        }
    }
    private void ifTrueSentStatus() {
        if (status.equals("sent")) {
            Logger.writeInfo(("Уведомление: " + notification + ", статус: " + status + '\n'));
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