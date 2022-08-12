package com.dd.api;

import java.sql.*;

public class HiveTest {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) {
        try {
            Class.forName(driverName);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection("jdbc:hive2://172.30.1.191:10000/default", null, null);
            stmt = con.createStatement();
        }
        catch ( SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            String tableName = "sample_datas";
            ResultSet res;
            stmt.execute("create table IF NOT EXISTS " + tableName + " (key int, value string)");

            String sql = "INSERT INTO TABLE "+tableName+" VALUES (1, 'test1'), (2, 'test2')";
            stmt.execute(sql);

            sql = "SELECT key ,value FROM "+tableName;
            res = stmt.executeQuery(sql);

            while (res.next()) {
                System.out.printf("%d %s\n", res.getInt(1), res.getString(2));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}