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
import model.swassignment;
import model.question;
import org.json.JSONArray;
import org.json.JSONObject;
@WebServlet(name = "swassignmentser", urlPatterns = {"/swassignmentser"})
@MultipartConfig
public class swassignmentser extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         PrintWriter out = response.getWriter();
        
        swassignment reg = new swassignment();
       
//        System.out.println(request.getParameter("signUp"));
        
        try {
//            System.out.println("due to covid ");
            if (request.getParameter("swassignment") != null) 
            {
                
                                // public String getParameter(String name):is used to obtain the value of a parameter by name
                String wasgn = request.getParameter("wasgn");
//                String subname = request.getParameter("subname");
//                String sid = request.getParameter("sid");
      
                
                
//                     System.out.println("successssss ");
                    String status = reg.swassignment(wasgn);

                     if (status.equals("success")) {
                        
                        request.setAttribute("status", " Assignment Submitted Successfully ");
                        
                         RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp" );
                        rd1.forward(request, response);
                        
                    } else if (status.equals("failure")) {
                             request.setAttribute("status", "submittion failed");
                         RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp" );
                        rd1.forward(request, response);
                    }
                    
            

}

        } 
        
        
        catch (Exception e)
        {
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
 
