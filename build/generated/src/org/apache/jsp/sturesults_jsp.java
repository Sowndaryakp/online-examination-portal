package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sturesults_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Student results</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" >\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("        <!--<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>-->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Add a gray background color with some padding */\n");
      out.write("            body {\n");
      out.write("                font-family: Arial;\n");
      out.write("                padding: 10px;\n");
      out.write("                background: #f1f1f1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header{   \n");
      out.write("                background-color: white;\n");
      out.write("                padding:10px;\n");
      out.write("                width: 30%; \n");
      out.write("                margin: auto;\n");
      out.write("                float: top;\n");
      out.write("                text-align: center;\n");
      out.write("                box-shadow:1px 1px 10px grey; \n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            .jumbotron{\n");
      out.write("                box-shadow:1px 1px 10px grey; \n");
      out.write("                border-radius: 5px;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
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
      out.write("            /*        #search\n");
      out.write("                    {\n");
      out.write("                        width: 50%; \n");
      out.write("                    }*/\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"header\">\n");
      out.write("            <h2> \"MY RESULTS\" </h2>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <center>\n");
      out.write("       \n");
      out.write("             <br>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"container \">\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("<!--                <font color=\"black\" size=\"6\" style=\"margin:2px;\">\n");
      out.write("                Unit test or Individual test results \n");
      out.write("                </font>-->\n");
      out.write("                <!--                 <input class=\"form-control\" id=\"search\" type=\"text\" placeholder=\"Search..\">-->\n");
      out.write("                <p style=\"float:left;\">USN : 4MG17CS018</p>\n");
      out.write("                \n");
      out.write("                <table class=\"table\" style=\"margin-top:-20px;\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr style=\"background-color: lightblue;\">\n");
      out.write("                    <br>\n");
      out.write("                    <th>Slno</th>\n");
      out.write("                    <th>SEM</th>\n");
      out.write("                    <th>Subject Code</th>\n");
      out.write("                    <th>Subject Name</th>\n");
      out.write("                    <th>Marks</th>\n");
      out.write("                    <th>Result</th>\n");
      out.write("                   \n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("<!--                    <tbody id=\"table\">\n");
      out.write("                       \n");
      out.write("                        <tr>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <td>\n");
      out.write("                                <a class=\"btn btn-success\" href =\"fapprove?slno=\">Approve</a>\n");
      out.write("                                <a class=\"btn btn-danger\" href =\"fdelete?slno=\">Delete</a>\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr> \n");
      out.write("\n");
      out.write("                        \n");
      out.write("                    </tbody>-->\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>                      \n");
      out.write("    </center>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
