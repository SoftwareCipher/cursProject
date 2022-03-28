package com.company.dataBase;

import com.company.readFile.WriteFile;

import java.sql.*;

public class CheckTables{
    DBConnect dbConnect = new DBConnect();

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
            WriteFile.writeInfo("Table " + name + " exists !\n");
        } catch (SQLException exc) {
            WriteFile.writeInfo("Table " + name + " not exists !\n");
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
