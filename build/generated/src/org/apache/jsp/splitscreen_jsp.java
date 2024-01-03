package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.pstudent;
import model.Registration;

public final class splitscreen_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script src=\"https://cdn.ckeditor.com/4.15.0/standard/ckeditor.js\"></script>\n");
      out.write("        <script src=\"https://pagecdn.io/lib/ckeditor/4.13.0/ckeditor.js\" ></script>\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script type = \"text/javascript\" src = \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js\"></script>\n");
      out.write("        <!-- Add icon library -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Add a gray background color with some padding */\n");
      out.write("            body {\n");
      out.write("                font-family: Arial;\n");
      out.write("                padding: 20px;\n");
      out.write("                background: #f1f1f1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* question part */\n");
      out.write("            .header {\n");
      out.write("                padding: 100px;\n");
      out.write("                float: left;\n");
      out.write("                width: 80%;\n");
      out.write("                font-size: 40px;\n");
      out.write("                text-align: center;\n");
      out.write("                background: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Create two unequal columns that floats next to each other */\n");
      out.write("            /* answer sheet */\n");
      out.write("            .leftcolumn {   \n");
      out.write("                float: left;\n");
      out.write("                width: 80%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* remaining time */\n");
      out.write("            .rightcolumn {\n");
      out.write("                float: right;\n");
      out.write("                width: 20%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Add a card effect for articles */\n");
      out.write("            .card {\n");
      out.write("                background-color: white;\n");
      out.write("                padding: 20px;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                margin-right: 15px;\n");
      out.write("                margin-left: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */\n");
      out.write("            @media screen and (max-width: 800px) {\n");
      out.write("                .rightcolumn, .leftcolumn {   \n");
      out.write("                    width: 100%;\n");
      out.write("                    padding: 0;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*download button*/\n");
      out.write("            .btn {\n");
      out.write("                background-color: DodgerBlue;\n");
      out.write("                border: none;\n");
      out.write("                color: white;\n");
      out.write("                padding: 12px 30px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 20px;\n");
      out.write("                margin-left: 1000px;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dwnbtn{\n");
      out.write("                background-color: DodgerBlue;\n");
      out.write("                border: none;\n");
      out.write("                color: white;\n");
      out.write("                padding: 12px 30px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Darker background on mouse-over */\n");
      out.write("            .btn:hover {\n");
      out.write("                background-color: RoyalBlue;\n");
      out.write("            }\n");
      out.write("            p{\n");
      out.write("                font-size: xx-large;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("        </style>\n");
      out.write("        <style>\n");
      out.write("            .button{\n");
      out.write("                width:25%;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                color: white;\n");
      out.write("                display: block;\n");
      out.write("                padding: 12px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                background-color: cornflowerblue;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .button:hover{\n");
      out.write("                background-color: #2691d9;\n");
      out.write("            }\n");
      out.write("        </style> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
 if (session.getAttribute("sname") != null) {
                Registration reg = new Registration(session);
                pstudent s = reg.getpsUserDetails();

        
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"rightcolumn\">\n");
      out.write("            <div class=\"card\" >\n");
      out.write("                <h3>Remaining time</h3>\n");
      out.write("                <p id=\"demo\"></p>\n");
      out.write("\n");
      out.write("                <script>\n");
      out.write("\n");
      out.write("                    // Set the date we're counting down to\n");
      out.write("                    var countDownDate = new Date(\"june 3, 2021 15:58:00\").getTime();\n");
      out.write("\n");
      out.write("                    // Update the count down every 1 second\n");
      out.write("                    var x = setInterval(function () {\n");
      out.write("\n");
      out.write("                        // Get today's date and time\n");
      out.write("                        var now = new Date().getTime();\n");
      out.write("\n");
      out.write("                        // Find the distance between now and the count down date\n");
      out.write("                        var distance = countDownDate - now;\n");
      out.write("\n");
      out.write("                        // Time calculations for hours, minutes and seconds\n");
      out.write("                        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));\n");
      out.write("                        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));\n");
      out.write("                        var seconds = Math.floor((distance % (1000 * 60)) / 1000);\n");
      out.write("\n");
      out.write("                        // Output the result in an element with id=\"demo\"\n");
      out.write("                        document.getElementById(\"demo\").innerHTML = hours + \"h : \" + minutes + \"m : \" + seconds + \"s \";\n");
      out.write("\n");
      out.write("                        // If the count down is over, write some text \n");
      out.write("                        if (distance < 0) {\n");
      out.write("                            clearInterval(x);\n");
      out.write("                            document.getElementById(\"demo\").innerHTML = \"Internals OVER\";\n");
      out.write("                        }\n");
      out.write("                    }, 1000);\n");
      out.write("                </script>\n");
      out.write("                <h2>Profile</h2>\n");
      out.write("\n");
      out.write("                \n");
      out.write("                ");
 if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {
      out.write("\n");
      out.write("                Name: ");
      out.print(session.getAttribute("sname"));
}
      out.write("\n");
      out.write("                <br>\n");
      out.write("                ");
 if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {
      out.write("\n");
      out.write("                USN: ");
      out.print(session.getAttribute("sid"));
}
      out.write("\n");
      out.write("                \n");
      out.write("               \n");
      out.write("                \n");
      out.write("\n");
      out.write("                <h4>Subject: JAVA</h4></div>\n");
      out.write("            <br><br><br><br><br>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("<!--            <h2>questions</h2><br><br>\n");
      out.write("            <button class=\"dwnbtn\"><i class=\"fa fa-download\"></i> Download</button>-->\n");
      out.write("\n");
      out.write("<!-- <div>\n");
      out.write("                                <img src=\"fac_exam_que/EQue-cs01.pdf\" name=\"pdf\">\n");
      out.write("                            </div>-->\n");
      out.write("\n");
      out.write(" \n");
      out.write("            <a data-toggle=\"iframe\" data-target=\"uploadimages/profile-cs078.pdf\" data-backdrop=\"static\" onclick=\"fetchpdf('pdf');\">PDF</a>\n");
      out.write("            <br><br>       \n");
      out.write("            <iframe title=\"result frame\" class=\"pdf\" id=\"pdf\" name=\"pdf\" src=\"uploadimages/profile-cs078.pdf\"></iframe>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("\n");
      out.write("\n");
      out.write(" <button type=submit class=\"btnp\" onclick=\" window.open('fac_exam_que/EQue-cs01.pdf'); return true;\"> OPEN PDF in another Window</button>\n");
      out.write("            <a data-toggle=\"iframe\" data-target=\"fac_exam_que/EQue-cs01.pdf\" data-backdrop=\"static\" onclick=\"fetchpdf('pdf');\">PDF</a>\n");
      out.write("            <br><br>  \n");
      out.write("  <iframe title=\"result frame\" class=\"pdf\" id=\"pdf\" name=\"pdf\" src=\"fac_exam_que/EQue-cs01.pdf\"></iframe>\n");
      out.write("            </div></div>\n");
      out.write("        <form method=\"post\" action=\"answer\">\n");
      out.write("            <div class=\"row\">s\n");
      out.write("                <div class=\"leftcolumn\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <h2>ANSWER HERE</h2>\n");
      out.write("                        <textarea name=\"answer\" id=\"que\" ></textarea>\n");
      out.write("                        <script>\n");
      out.write("\n");
      out.write("                            CKEDITOR.replace('que');\n");
      out.write("                            // Enable local \"abbr\" plugin from /myplugins/abbr/ folder.\n");
      out.write("                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');\n");
      out.write("\n");
      out.write("                            // extraPlugins needs to be set too.\n");
      out.write("                            CKEDITOR.replace('que', {\n");
      out.write("                                extraPlugins: 'abbr'\n");
      out.write("                            });\n");
      out.write("                        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <!--                <a class=\"btn btn-success\" href =\"#\">Submit</a>-->\n");
      out.write("\n");
      out.write("                        <!--<button type=\"button\" onclick=\"document.getElementById('id01').style.display='none'\" class=\"cancelbtn\">Cancel</button>-->\n");
      out.write("                        <button class=\"btn\" type=\"submit\" name=\"answer\" >Submit</button>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
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
