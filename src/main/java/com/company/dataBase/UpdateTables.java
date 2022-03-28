package com.company.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UpdateTables{
    DBConnect dbConnect = new DBConnect();
    PreparedStatement preparedStatement = null;

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
}
