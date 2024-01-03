/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

public class Ans {
    
private Connection con;
    

    public Ans() {
        try {
                
            Class.forName("com.mysql.jdbc.Driver"); // load the drivers
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
            // connection with data base

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Ans(String answer) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            
                ps = (PreparedStatement) con.prepareStatement("insert into answers values(0,?,now())");
                
                ps.setString(1, answer);
//                ps.setString(2, subname);
//                ps.setString(3, sid);
                
                
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public Ans(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

