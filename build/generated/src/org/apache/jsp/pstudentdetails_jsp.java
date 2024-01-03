package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.pstudentdetails;
import java.util.Iterator;
import java.util.ArrayList;
import model.Registration;

public final class pstudentdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/dashboardheader.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>faculty request</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" >\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("        <!--<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>-->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .errmsg{\n");
      out.write("                background: green;\n");
      out.write("                padding: 6px;\n");
      out.write("                width: 50%;\n");
      out.write("                color: white;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .jumbotron{\n");
      out.write("                background-color: white;\n");
      out.write("            }\n");
      out.write("            #search\n");
      out.write("            {\n");
      out.write("                width: 50%; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scaled=1, shrink-to-fit=no\">\n");
      out.write("        <title>home page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("         <!--<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>-->\n");
      out.write("        <style>\n");
      out.write("            @import url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap');\n");
      out.write("            *{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0; \n");
      out.write("                box-sizing: border-box;\n");
      out.write("                font-family: \"Josafin Slab\",serif;\n");
      out.write("            }\n");
      out.write("            nav{\n");
      out.write("                width: 100%; height: 15vh;\n");
      out.write("                background: rgba(0,0,0,0.7);\n");
      out.write("                color: white; \n");
      out.write("                display: flex; \n");
      out.write("                justify-content: space-between;\n");
      out.write("                align-items: center;\n");
      out.write("                text_transform: uppercase;\n");
      out.write("            }\n");
      out.write("             .logo{\n");
      out.write("               margin: 0px;\n");
      out.write("/*               margin-top: 5px;*/\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            nav .logo-text{\n");
      out.write("                width: 25%; \n");
      out.write("                text-align: center;\n");
      out.write("                position: relative;\n");
      out.write("                margin-left: 20px;\n");
      out.write("            }\n");
      out.write("            nav .menu{\n");
      out.write("                width: 70%; \n");
      out.write("                height: 5vh;\n");
      out.write("                font-size: 24px;\n");
      out.write("                display: flex; \n");
      out.write("                justify-content: flex-end;               \n");
      out.write("            } \n");
      out.write("            nav .menu a{\n");
      out.write("                width: 15%;\n");
      out.write("                text-decoration: none;                \n");
      out.write("                color: white;\n");
      out.write("                font-weight: bold;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            nav .menu a:hover{\n");
      out.write("                color: cyan;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            main{\n");
      out.write("                width: 100%;\n");
      out.write("                height: 85vh;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center; \n");
      out.write("                color:white;\n");
      out.write("            }\n");
      out.write("            .btn,.btn-success{\n");
      out.write("                margin-right: 20px;\n");
      out.write("              \n");
      out.write("            }\n");
      out.write("            </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    \n");
      out.write("        <nav>\n");
      out.write("            <div class=\"logo\"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px'></div>\n");
      out.write("            <div class=\"logo-text\" ><h2 style=\"font-size:25px;\"><b> G.MADEGOWDA INSTITUTE OF TECHNOLOGY</b> </h2> </div>\n");
      out.write("            <div class=\"menu\">                                              \n");
      out.write("                 <a href=\"dashboard.jsp\">Home</a>\n");
      out.write("                 <a href=\"Register?logout=yes\">Logout\n");
      out.write("                 </a>\n");
      out.write("                 <a href=\"#\">   \n");
      out.write("                      ");
 if (session.getAttribute("type") != null && session.getAttribute("type").equals("admin")) {
      out.write("\n");
      out.write("                ");
      out.print(session.getAttribute("username"));
}
      out.write("\n");
      out.write("                     \n");
      out.write("                     ");
 if (session.getAttribute("type") != null && session.getAttribute("type").equals("principal")) {
      out.write("\n");
      out.write("                ");
      out.print(session.getAttribute("pname"));
}
      out.write("\n");
      out.write("                \n");
      out.write("                 ");
 if (session.getAttribute("type") != null && session.getAttribute("type").equals("hod")) {
      out.write("\n");
      out.write("                ");
      out.print(session.getAttribute("hname"));
}
      out.write("\n");
      out.write("                \n");
      out.write("                 ");
 if (session.getAttribute("type") != null && session.getAttribute("type").equals("faculty")) {
      out.write("\n");
      out.write("                ");
      out.print(session.getAttribute("fname"));
}
      out.write("\n");
      out.write("                \n");
      out.write("                 ");
 if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {
      out.write("\n");
      out.write("                ");
      out.print(session.getAttribute("sname"));
}
      out.write("\n");
      out.write("                \n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("        </nav>  \n");
      out.write("                <br><br>\n");
      out.write("<!--                 <a class=\"btn btn-success\" style=\"float: right;\" href =\"dashboard.jsp\">BACK</a>-->\n");
      out.write("    </html>\n");
      out.write("</body>");
      out.write("\n");
      out.write("    <center>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <font color=\"black\" size=\"6\">\n");
      out.write("       Student Details\n");
      out.write("        </font>\n");
      out.write("        ");
 if (request.getAttribute("status") != null) {
      out.write("\n");
      out.write("        <h1 class=\"errmsg\"> ");
      out.print( request.getAttribute("status"));
      out.write("</h1>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <div class=\"container \">\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("                <input class=\"form-control\" id=\"search\" type=\"text\" placeholder=\"Search..\">\n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr style=\"background-color: lightblue;\">\n");
      out.write("                    <br>\n");
      out.write("                    <th>Slno</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>USN</th>\n");
      out.write("                    <th>Department</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th>Phone</th>\n");
      out.write("                    <!--<th>View</th>-->\n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody id=\"table\">\n");
      out.write("                        ");

                            Registration reg = new Registration(session);
                            ArrayList<pstudentdetails> mydata = reg.getpstudentdetailsUserDetails();

                            Iterator<pstudentdetails> itr = mydata.iterator();
                            while (itr.hasNext()) {
                                pstudentdetails pstudent = itr.next();
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(pstudent.getid3());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pstudent.getsname());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pstudent.getsid());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pstudent.getsdep());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pstudent.getsemail());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pstudent.getsphone());
      out.write("</td>\n");
      out.write("<!--                    <form action=\"#\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"\"> -->\n");
      out.write("                        </tr> \n");
      out.write("\n");
      out.write("                        ");
}
                        
      out.write(" \n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>                      \n");
      out.write("    </center>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            $(\"#search\").on(\"keyup\", function () {\n");
      out.write("                var value = $(this).val().toLowerCase();\n");
      out.write("                $(\"#table tr\").filter(function () {\n");
      out.write("                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > 0);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Footer Page</title>\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("            .footer {\n");
      out.write("              \n");
      out.write("                position: fixed;\n");
      out.write("                width: 100% ;\n");
      out.write("                background-color: #353535;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                bottom: 0;\n");
      out.write("                padding: 35px 50px;\n");
      out.write("                padding-top: 5px;\n");
      out.write("                padding-right: 50px;\n");
      out.write("                padding-bottom: 5px;\n");
      out.write("                padding-left: 30px;\n");
      out.write("                margin-left: 0;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }  \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <div class=\"footer\">\n");
      out.write("             <small>\n");
      out.write("                      © 2020 GMIT | A project by Students of GMIT\n");
      out.write("             </small>\n");
      out.write("         </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
