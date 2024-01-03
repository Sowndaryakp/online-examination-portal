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
import org.json.JSONArray;
import org.json.JSONObject;

public class uploadpdf {

    private Connection con;
    HttpSession se;
    JSONObject json = new JSONObject();
    JSONArray array = new JSONArray();

    public uploadpdf(HttpSession session) {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // load the drivers
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
            // connection with data base
            se = session;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public int uploadpdfmod( String fid,String doc,String dname) {
        PreparedStatement ps;
        int status = 0;
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            ps = (PreparedStatement) con.prepareStatement("insert into pdf values(0,?,?,now(),?)");
            ps.setString(1, fid);
            ps.setString(2, doc);
            ps.setString(3, dname);
           

           status= ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
