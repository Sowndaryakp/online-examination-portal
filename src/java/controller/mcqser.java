/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.MCQ; 
import model.pstudentdetails;
import org.json.JSONArray;
import org.json.JSONObject;
@WebServlet(name = "mcqser", urlPatterns = {"/mcqser"})
@MultipartConfig
public class mcqser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // type of the response sent to the client or browser

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        MCQ m = new MCQ(session);
        JSONObject json=new JSONObject();
        JSONArray array=new JSONArray();
        try {
            if (request.getParameter("mcq") != null) {

                // public String getParameter(String name):is used to obtain the value of a parameter by name
//                String fid = session.getAttribute("fid").toString();
//                String fname =noofque
//                String sub = "Chem";
                String question = request.getParameter("question");
                String op1 = request.getParameter("op1");
                String op2 = request.getParameter("op2");
                String op3 = request.getParameter("op3");
                String op4 = request.getParameter("op4");
                String crctans = request.getParameter("crctans");
                String examid = request.getParameter("examid");
//              String noofque = request.getParameter("noofque");
//              String noq = session.getAttribute("noq").toString();
//                String que = null;
             
                
             int status=m.mcqmod(question, op1, op2, op3, op4, crctans, examid);
            
             if(status>0){

                 json.put("status","Inserted");
                 
             }else{
                 json.put("status","NotInserted");
             }
             out.println(json);
                }
            }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
 
