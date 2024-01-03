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

@WebServlet(name = "papprove", urlPatterns = {"/papprove"})
public class papprove extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            int pslno = Integer.parseInt(request.getParameter("pslno"));
            Registration reg = new Registration(session);
            String status = reg.papprove(pslno);
            if (status.equals("success")) {
                request.setAttribute("status","Successfully Approved");
                request.getRequestDispatcher("prequest.jsp").forward(request, response);
            }
            if (status.equals("failure")) {
                 request.setAttribute("status","Approval failure");
                request.getRequestDispatcher("prequest.jsp").forward(request, response);
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