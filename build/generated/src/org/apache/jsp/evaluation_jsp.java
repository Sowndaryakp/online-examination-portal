package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.pstudent;
import model.Registration;

public final class evaluation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
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
      out.write("                width: 100%; \n");
      out.write("                margin: auto;\n");
      out.write("                float: top;\n");
      out.write("                text-align: center;\n");
      out.write("                box-shadow:1px 1px 10px grey; \n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            .containerleft{\n");
      out.write("                background-color: white;\n");
      out.write("                padding:10px;\n");
      out.write("                width: 68%;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow:1px 1px 10px grey; \n");
      out.write("            }\n");
      out.write("            .studetails{\n");
      out.write("                padding: 0px 10px 0px 30px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .pdf{\n");
      out.write("                width:100%;\n");
      out.write("                height: 200%;\n");
      out.write("                height:1100px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .containerright{\n");
      out.write("                background-color: white;\n");
      out.write("                padding:10px;\n");
      out.write("                width: 30%;\n");
      out.write("                float: right;\n");
      out.write("                margin-top: -1290px;\n");
      out.write("                box-shadow:1px 1px 10px grey; \n");
      out.write("                border-radius: 20px;\n");
      out.write("            }\n");
      out.write("            .btn {\n");
      out.write("                width:150px;\n");
      out.write("                height: 50px;\n");
      out.write("                font-size: 20px;\n");
      out.write("                background-color: lightgreen;\n");
      out.write("                border-radius: 20px;\n");
      out.write("                margin-left: 150px;\n");
      out.write("            }\n");
      out.write("            .btn:hover{\n");
      out.write("                background-color:green;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .btnp{\n");
      out.write("                margin-left: 400px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <h2> \"WELCOME TO EVALUATION\" </h2>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"containerleft\" >\n");
      out.write("            <div class=\"studetails\">\n");
      out.write("            <h4>STUDENT DETAILS</h4>\n");
      out.write("            <p>NAME : NIRANJAN </p>\n");
      out.write("            <p>USN : 4MG17CS018</p>\n");
      out.write("            </div>\n");
      out.write("            <button type=submit class=\"btnp\" onclick=\" window.open('uploadimages/profile-cs078.pdf'); return true;\"> OPEN PDF in another Window</button>\n");
      out.write("            <a data-toggle=\"iframe\" data-target=\"uploadimages/profile-cs078.pdf\" data-backdrop=\"static\" onclick=\"fetchpdf('pdf');\">PDF</a>\n");
      out.write("            <br><br>       \n");
      out.write("            <iframe title=\"result frame\" class=\"pdf\" id=\"pdf\" name=\"pdf\" src=\"uploadimages/profile-cs078.pdf\"></iframe>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"containerright\">\n");
      out.write("            <h4 style=\"text-align: center;\">Enter your marks to respective question numbers</h4>\n");
      out.write("\n");
      out.write("            <label>1.</label>\n");
      out.write("            <input type=\"number\"><h4 style=\"text-align:center;\">OR</h4>\n");
      out.write("            <label>2.</label>\n");
      out.write("            <input><br><br><hr><br>\n");
      out.write("\n");
      out.write("            <label>3.</label>\n");
      out.write("            <input><h4 style=\"text-align:center;\">OR</h4>\n");
      out.write("            <label>4.</label>\n");
      out.write("            <input><br><br><hr><br>\n");
      out.write("\n");
      out.write("            <label>5.</label>\n");
      out.write("            <input><h4 style=\"text-align:center;\">OR</h4>\n");
      out.write("            <label>6.</label>\n");
      out.write("            <input><br><br><hr><br>\n");
      out.write("\n");
      out.write("            <label>7.</label>\n");
      out.write("            <input><h4 style=\"text-align:center;\">OR</h4>\n");
      out.write("            <label>8.</label>\n");
      out.write("            <input><br><br><hr><br>\n");
      out.write("\n");
      out.write("            <label>9.</label>\n");
      out.write("            <input><h4 style=\"text-align:center;\">OR</h4>\n");
      out.write("            <label>10.</label>\n");
      out.write("            <input><br><br><hr><br>\n");
      out.write("\n");
      out.write("            <p><button class=\"btn\">Submit</button></p>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("<script>\n");
      out.write("            function fetchpdf(pdf){\n");
      out.write("                \n");
      out.write("               var Myiframe = document.getElementById(pdf);\n");
      out.write("               \n");
      out.write("               var content = Myiframe.contentWindow.document.body.innerHTML;\n");
      out.write("               \n");
      out.write("               \n");
      out.write("           }\n");
      out.write("            </script>-->\n");
      out.write("\n");
      out.write("\n");
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
