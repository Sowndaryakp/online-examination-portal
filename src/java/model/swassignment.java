package model;

import java.sql.*;

public class swassignment {
    
private Connection con;
    

    public swassignment() {
        try {
                
            Class.forName("com.mysql.jdbc.Driver"); // load the drivers
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
            // connection with data base

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String swassignment(String wasgn) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            
                ps = (PreparedStatement) con.prepareStatement("insert into swassignment values(0,?,now())");
                
                ps.setString(1, wasgn);
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

    public swassignment(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

