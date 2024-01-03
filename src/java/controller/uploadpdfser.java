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
import model.uploadpdf;
import org.json.JSONArray;
import org.json.JSONObject;
@WebServlet(name = "uploadpdfser", urlPatterns = {"/uploadpdfser"})
@MultipartConfig
public class uploadpdfser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // type of the response sent to the client or browser

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        uploadpdf u = new uploadpdf(session);
        JSONObject json=new JSONObject();
        JSONArray array=new JSONArray();
        try {
            if (request.getParameter("uploadpdf") != null) {
                     System.out.println("hii");
                // public String getParameter(String name):is used to obtain the value of a parameter by name
                String fid = session.getAttribute("fid").toString();
//                String fname = session.getAttribute("fname").toString();
//                String sub = "Chem";
                String doc = request.getParameter("doc");
                String dname = request.getParameter("dname");
                
//                String que = null;
             
                
             int status=u.uploadpdfmod(fid,doc,dname);
              if(status>0){
                          
//              uploadpdf
                       InputStream inputStream1 = null;
                       String imagedetails = "";
                       String imageformat = "";
                      Part filePart1 = (Part) request.getPart("doc");
                       Collection<String> headers = filePart1.getHeaders("content-disposition");
                       for (String header : headers) {
                           imagedetails = header.split(";")[2].replace("filename=", "");
                           imageformat = imagedetails.replace("\"", "");
                       }
                        int size = (int) filePart1.getSize();//----getting size of the image---------------//
                        inputStream1 = filePart1.getInputStream();

                        File outputfile = new File("E:/netbeans/EXAM/web/uploadimages/profile-" + fid + ".jpg");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                    }
                          
//              RequestDispatcher rd1 = request.getRequestDispatcher("uploadpdf.jsp");
//                        rd1.forward(request, response);
                         json.put("status","Inserted");  
                 
             }else {
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
 
