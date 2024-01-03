/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.util.Collections.list;
import javax.servlet.http.HttpSession;


public class question {
    
    private Connection con;
    HttpSession se;

    public question(HttpSession session) {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // load the drivers
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
            // connection with data base
            se = session;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public String questionmod( String que) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            ps = (PreparedStatement) con.prepareStatement("insert into questiondes values(0,?,now())");
        
            ps.setString(1, que);
//            ps.setString(2, subcode);
//            ps.setString(3, fid);
            
            int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}