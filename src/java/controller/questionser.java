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
import model.question;

@WebServlet(name = "questionser", urlPatterns = {"/questionser"})
@MultipartConfig
public class questionser extends HttpServlet {
     private Object status;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // type of the response sent to the client or browser

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        question q = new question(session);
      
        try {
            if (request.getParameter("question") != null) {

                // public String getParameter(String name):is used to obtain the value of a parameter by name
//                
//                String fname = session.getAttribute("fname").toString();
//                String sub = "Chem";
                String que = request.getParameter("que");
//                String subcode = request.getParameter("subcode");
//                String fid = session.getAttribute("fid").toString();
                
 
             String status=q.questionmod(que);
            if (status.equals("success")) {
                request.setAttribute("status", "Successfully Created");
                RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
                rd1.forward(request, response);
            } else if (status.equals("failure")) {
                      request.setAttribute("status", "Failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("question.jsp");
                    rd1.forward(request, response);
                }
                
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