package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scaled=1, shrink-to-fit=no,text/html; charset=UTF-8\">\n");
      out.write("        <title>home page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <style>\n");
      out.write("            @import url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap');\n");
      out.write("            *{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0; \n");
      out.write("                box-sizing: border-box;\n");
      out.write("                font-family: \"Josafin Slab\",serif;\n");
      out.write("            }\n");
      out.write("            main{\n");
      out.write("\n");
      out.write("                height: 90vh;\n");
      out.write("                background-image: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.1)),url('images/GMIT001.jpg');\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("            nav{\n");
      out.write("                width: 100%; height: 15vh;\n");
      out.write("                background: rgb(0 0 0 / 58%);\n");
      out.write("                color: white; \n");
      out.write("                display: flex; \n");
      out.write("                justify-content: space-between;\n");
      out.write("                align-items: center;\n");
      out.write("                text_transform: uppercase;\n");
      out.write("            }\n");
      out.write("            .logo{\n");
      out.write("                margin: 0px;\n");
      out.write("                margin-top: 5px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            nav .logo-text{\n");
      out.write("                width: 25%; \n");
      out.write("                text-align: center;\n");
      out.write("                position: relative;\n");
      out.write("                padding-left: 10px;\n");
      out.write("            }\n");
      out.write("            nav .menu{\n");
      out.write("                width: 70%; \n");
      out.write("                height: 5vh;\n");
      out.write("                font-size: 20px;\n");
      out.write("                display: flex; \n");
      out.write("                justify-content: flex-end;               \n");
      out.write("            } \n");
      out.write("            nav .menu a{\n");
      out.write("                width: 10%;\n");
      out.write("                text-decoration: none;                \n");
      out.write("                color: white;\n");
      out.write("                font-weight: bold;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("/*            nav .menu a:hover{\n");
      out.write("                color: cyan;\n");
      out.write("            }*/\n");
      out.write("            ul{\n");
      out.write("                list-style-type: none;\n");
      out.write("                margin: 0;\n");
      out.write("                padding:0;\n");
      out.write("                /*                overflow:hidden;*/\n");
      out.write("                font-family: cursive;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .li{\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            li a.dropbtn{\n");
      out.write("                display: initial;\n");
      out.write("                color: white;\n");
      out.write("                text-align: justify;\n");
      out.write("                padding: 15px 24px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            li a:hover {\n");
      out.write("                background-color: lightblue;\n");
      out.write("            }\n");
      out.write("            li .dropdown{\n");
      out.write("\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("            .dropdown-content{\n");
      out.write("                display: none;\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: grey;\n");
      out.write("                min-width: 16px;\n");
      out.write("                z-index: 1;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            .dropdown-content a{\n");
      out.write("                color:black;               \n");
      out.write("                padding: 10px 30px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: table;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown:hover\n");
      out.write("            .dropdown-content{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            .dropdown-content a{\n");
      out.write("                width: 100% !important;\n");
      out.write("            }\n");
      out.write("            main{\n");
      out.write("                width: 100%;\n");
      out.write("                height: 85vh;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center; \n");
      out.write("                color:white;\n");
      out.write("            }          \n");
      out.write("            section h5{\n");
      out.write("                margin: -250px 10px 20px 0;\n");
      out.write("                font-size: 55px;\n");
      out.write("                font-weight: 400;\n");
      out.write("                text-shadow: 2px 1px 5px black;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            section p{\n");
      out.write("                margin: 30px 300px 40px 0;\n");
      out.write("                font-size: 25px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                text-align: right;\n");
      out.write("                color: white;\n");
      out.write("                word-spacing: 2px;\n");
      out.write("                margin-bottom: 25px;\n");
      out.write("                text-shadow: 1px 1px 1px black;\n");
      out.write("            }\n");
      out.write("            .footer {\n");
      out.write("\n");
      out.write("                position: static;\n");
      out.write("                width: 100% ;\n");
      out.write("                height: 30px;\n");
      out.write("                background-color: #353535;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                /*                bottom: -20;*/\n");
      out.write("                padding: 35px 50px;\n");
      out.write("                padding-top: 0px;\n");
      out.write("                padding-right: 50px;\n");
      out.write("                /*                padding-bottom: 1;*/\n");
      out.write("                padding-left: 20px;\n");
      out.write("\n");
      out.write("            }   \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav>\n");
      out.write("            <div class=\"logo\"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px;margin-left: 2px;margin-top: -1px;'></div>\n");
      out.write("            <div class=\"logo-text\" ><h1 > G.MADEGOWDA INSTITUTE OF TECHNOLOGY </h1> </div>\n");
      out.write("            <div class=\"menu\">                                              \n");
      out.write("                <a href=\"index.jsp\">Home</a>\n");
      out.write("                <a href=\"http://gmitmandya.in\">About us</a>\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"dropdown\" >\n");
      out.write("                        <a href=\"#\" class=\"dropbtn\">Login as <i class=\"fa fa-caret-down\"></i></a>\n");
      out.write("                        <div class=\"dropdown-content\">\n");
      out.write("                            <a href=\"plogin.jsp\">Principal</a>\n");
      out.write("                            <a href=\"hlogin.jsp\">HOD</a>\n");
      out.write("                            <a href=\"flogin.jsp\">Faculty</a>\n");
      out.write("                            <a href=\"slogin.jsp\">Student</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <a href=\"admin_login.jsp\"> Admin </a>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div>   \n");
      out.write("            <main>  \n");
      out.write("                <section>\n");
      out.write("\n");
      out.write("                    <h5 > Welcome To Examination Portal </h5>\n");
      out.write("                    <p>\"Education is the most powerful Weapon\"</p>\n");
      out.write("                </section>                          \n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      out.write("<!--        <div class=\"footer\"><b style=\"font-size: 20px\">\n");
      out.write("                                contact us:</b><br>\n");
      out.write("                            Phone: 08232-235676 / 5566<br>\n");
      out.write("                            Email:principalgmit@gmail.com<br>\n");
      out.write("                            <br>\n");
      out.write("\n");
      out.write("                <small>\n");
      out.write("                    © 2020 GMIT | A project by G.madegowda institute of technology\n");
      out.write("                </small>\n");
      out.write("        </div>  -->\n");
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
      out.write("</html>\n");
      out.write("</body>\n");
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
