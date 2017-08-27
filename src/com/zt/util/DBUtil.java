package com.zt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {

    private static ResourceBundle rb = ResourceBundle.getBundle("jdbc");

    static{
        try {
            Class.forName(rb.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection  con = null;
        try {
            con = DriverManager.getConnection(rb.getString("url"),rb.getString("user"), rb.getString("pwd"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeAll(ResultSet rs , Statement st,Connection con){
        try {
            if(rs!=null)
                rs.close();

            if(st!=null)
                st.close();

            if(con!=null)
                con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}