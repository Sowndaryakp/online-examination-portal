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
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

public class MCQ {

//    String question, op1, op2, op3, op4;
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public String getOp1() {
//        return op1;
//    }
//
//    public void setOp1(String op1) {
//        this.op1 = op1;
//    }
//
//    public String getOp2() {
//        return op2;
//    }
//
//    public void setOp2(String op2) {
//        this.op2 = op2;
//    }
//
//    public String getOp3() {
//        return op3;
//    }
//
//    public void setOp3(String op3) {
//        this.op3 = op3;
//    }
//
//    public String getOp4() {
//        return op4;
//    }
//
//    public void setOp4(String op4) {
//        this.op4 = op4;
//    }
//
//    public Connection getCon() {
//        return con;
//    }
//
//    public void setCon(Connection con) {
//        this.con = con;
//    }
//
//    public HttpSession getSe() {
//        return se;
//    }
//
//    public void setSe(HttpSession se) {
//        this.se = se;
//    }

    private Connection con;
    HttpSession se;
    JSONObject json = new JSONObject();
    JSONArray array = new JSONArray();

    public MCQ(HttpSession session) {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // load the drivers
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
            // connection with data base
            se = session;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int FetchLastSet(String examid) {
        int nofque = 0;
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select noq from createexam where cslno=" + examid + " ;");
            while (rs.next()) {
                nofque = rs.getInt("noq");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nofque;
    }

    public int mcqmod(String question, String op1, String op2, String op3, String op4, String crctans, String examid) {
        PreparedStatement ps;
        int status = 0;
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            ps = (PreparedStatement) con.prepareStatement("insert into mcq values(0,?,?,?,?,?,?,?)");
//            ps.setString(1, fid);
//            ps.setString(2, fname);
//            ps.setString(3, sub);
            ps.setString(1, question);
            ps.setString(2, op1);
            ps.setString(3, op2);
            ps.setString(4, op3);
            ps.setString(5, op4);
            ps.setString(6, crctans);
            ps.setString(7, examid);
//            ps.setString(8, noofque);
//            ps.setString(8, noq);

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    
}
