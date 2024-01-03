package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ssquestion;
import java.util.Iterator;
import java.util.ArrayList;
import model.Registration;

public final class ssque_005ftop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
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
      out.write("    \n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            .container{\n");
      out.write("                background-color: white;\n");
      out.write("                padding:10px;\n");
      out.write("                width: 68%;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow:1px 1px 10px grey; \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>principal Profile Form</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script type = \"text/javascript\" src = \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         \n");
      out.write("\n");
      out.write("          <br><br>\n");
      out.write("         ");
 if (request.getAttribute("status") != null) {
      out.write("\n");
      out.write("        <h1 class=\"errmsg\"> ");
      out.print( request.getAttribute("status"));
      out.write("</h1>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        ");
 if (session.getAttribute("sid")!=null){
            Registration reg = new Registration(session);
            ssquestion pp = reg.getquestiontopdf();
//                            
//                            ArrayList<pfaculty> mydata = reg.getpfUserDetails();
//                              ArrayList<pfaculty> a2 = new ArrayList<pfaculty>();
//
////                            Iterator<pfaculty> itr = mydata.iterator();
////                            while (itr.hasNext()) {
////                                pfaculty pf = itr.next();
                        
      out.write("\n");
      out.write("     <div class=\"container\">\n");
      out.write("            <div class=\"row col-md-10 col-md-offset-1\">\n");
      out.write("                <div class=\"panel panel-primary\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("\n");
      out.write("                        <h2 style=\"text-align:center\">Profile</h2>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body\" style=\"padding-left: 60px; padding-right: 70px; padding-top: 20px; \">\n");
      out.write("\n");
      out.write("                         <div>\n");
      out.write("                               <iframe title=\"result frame\" class=\"pdf\" id=\"pdf\" name=\"pdf\" src=\"fac_exam_que/EQue-cs01.pdf\"></iframe>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        <form method=\"post\" action=\"pupdate\"> \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <button class=\"button-1\" type=\"submit\" name=\"submit\"> Update</button>\n");
      out.write("                                <!--<a class=\"btn btn-success\" name=\"submit\" href =\"fupdate?update=yes\">Update</a>-->\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("               </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                            <br><br>\n");
      out.write("                             ");
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
      out.write("                </body>\n");
      out.write("                </html>\n");
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
