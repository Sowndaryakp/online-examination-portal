package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Registration;

@WebServlet(name = "sdelete", urlPatterns = {"/sdelete"})
public class sdelete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            int sslno = Integer.parseInt(request.getParameter("sslno"));
            Registration reg = new Registration(session);
            String status = reg.sdelete(sslno);
            if (status.equals("success")) {
                request.setAttribute("status","Successfully Deleted");
                request.getRequestDispatcher("srequest.jsp").forward(request, response);
            }
            if (status.equals("failure")) {
                 request.setAttribute("status","Deletion failure");
                request.getRequestDispatcher("srequest.jsp").forward(request, response);
            }
        } catch (Exception e) {
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
