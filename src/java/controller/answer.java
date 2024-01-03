/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ans;
import javax.servlet.annotation.MultipartConfig;
/**
 *
 * @author niranjanprasad M
 */
@WebServlet(name = "answer", urlPatterns = {"/answer"})
public class answer extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         PrintWriter out = response.getWriter();
        
        Ans reg = new Ans();
       
//        System.out.println(request.getParameter("signUp"));
        
        try {
//            System.out.println("due to covid ");
            if (request.getParameter("answer") != null) 
            {
                
                                // public String getParameter(String name):is used to obtain the value of a parameter by name
                String answer = request.getParameter("answer");
//                String subname = request.getParameter("subname");
//                String sid = request.getParameter("sid");
      
                
                
//                     System.out.println("successssss ");
                    String status = reg.Ans(answer);

                     if (status.equals("success")) {
                        
                        request.setAttribute("status", "Successfully submitted");
                        
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
