package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NewPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\" https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        .container{\n");
      out.write("            max-width: 550px;\n");
      out.write("            background: #676d12;\n");
      out.write("            color: white;\n");
      out.write("            padding: 2rem 2rem;\n");
      out.write("        }\n");
      out.write("        .error{\n");
      out.write("            color:red;\n");
      out.write("        }\n");
      out.write("        .status{\n");
      out.write("            background: #6b170a;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            margin: 20px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            font-size: 20px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
if (request.getAttribute("status") != null) {
      out.write("\n");
      out.write("        <div class=\"status\">");
      out.print(request.getAttribute("status"));
      out.write("</div>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!--<div class=\"jumbotron\">-->\n");
      out.write("            ");
if (session.getAttribute("npuname") != null) {
      out.write("\n");
      out.write("            <form id=\"newpass\" method=\"post\" action=\"Register\">\n");
      out.write("                <!--<div class=\"forgot\">-->\n");
      out.write("                <span style=\"font-size: 29px;font-weight: bold;\">Enter your new password</span>\n");
      out.write("                <div class=\"form-group\" style=\"margin-top: 10px;\">\n");
      out.write("                    <div>\n");
      out.write("                        <input id=\"n_password\" class=\"form-control\" style=\"width:50%\" type=\"password\" placeholder=\"Password\" name=\"n_password\"> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div>\n");
      out.write("                        <input id=\"c_password\" class=\"form-control\" style=\"width:50%\" type=\"password\" placeholder=\"Confirm Password\" name=\"c_password\"> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div  style=\"width:100%\">\n");
      out.write("                        <input type=\"submit\" name=\"submit_NewPassword\" value=\"Submit\" >\n");
      out.write("                        <!--<input type=\"hidden\" name=\"SubmitEmail\" value=\"submitemail\"/>-->\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("                <!--</div>-->\n");
      out.write("            </form>  \n");
      out.write("            ");
} else {
                    RequestDispatcher rd = request.getRequestDispatcher("slogin.jsp");
                    rd.forward(request, response);
                    }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            jQuery(document).ready(function ($) {\n");
      out.write("                $(\"#newpass\").validate({\n");
      out.write("                    ignore: [],\n");
      out.write("                    rules: {\n");
      out.write("                        n_password: {\n");
      out.write("                            required: true,\n");
      out.write("                            minlength: 6\n");
      out.write("                        },\n");
      out.write("                        c_password: {\n");
      out.write("                            required: true,\n");
      out.write("                            equalTo: \"#n_password\"\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
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
