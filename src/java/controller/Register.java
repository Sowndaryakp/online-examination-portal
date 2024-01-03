package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

import model.Registration; // we need to import the class
import model.pfaculty;
import model.phod;
import model.pprincipal;
import model.pstudent;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
@MultipartConfig
public class Register extends HttpServlet {

    private Object status;
    private String subjectname;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // type of the response sent to the client or browser

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Registration reg = new Registration(session);

        try {

            if (request.getParameter("fregister") != null) {

                // public String getParameter(String name):is used to obtain the value of a parameter by name
                String fname = request.getParameter("fname");
                String fid = request.getParameter("fid");
                String fphone = request.getParameter("fphone");
                String femail = request.getParameter("femail");
                String fdep = request.getParameter("fdep");
                String fdob = request.getParameter("fdob");
                String fgender = request.getParameter("gender");
                String faadhaar = request.getParameter("faadhaar");
                String fpan = request.getParameter("fpan");
                String faddress = request.getParameter("faddress");
                String fphoto = "profile-" + fid + ".png";
                String fcid = "id-" + fid + ".png";
                String fpwd = request.getParameter("fpwd");
                String fcpwd = request.getParameter("fcpwd");
                String FSTATUS = "";

                if (fpwd.equals(fcpwd)) {
                    String status = reg.fregistration(fname, fid, fphone, femail, fdep, fdob, fgender, faadhaar, fpan, faddress, fphoto, fcid, fpwd, FSTATUS);

                    if (status.equals("existed")) {

                        request.setAttribute("status", "Existed record");

                        RequestDispatcher rd1 = request.getRequestDispatcher("fregister.jsp");
                        rd1.forward(request, response);

                    } else if (status.equals("success")) {
                        // upload profile photo
                        InputStream inputStream1 = null;
                        String imagedetails = "";
                        String imageformat = "";
                        Part filePart1 = (Part) request.getPart("fphoto");
                        Collection<String> headers = filePart1.getHeaders("content-disposition");
                        for (String header : headers) {
                            imagedetails = header.split(";")[2].replace("filename=", "");
                            imageformat = imagedetails.replace("\"", "");
                        }
                        int size = (int) filePart1.getSize();//----getting size of the image---------------//
                        inputStream1 = filePart1.getInputStream();

                        File outputfile = new File("E:/netbeans/EXAM/web/uploadimages/profile-" + fid + ".pdf");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                        }

                        InputStream inputStream2 = null;
                        String imagedetails2 = "";
                        String imageformat2 = "";
                        Part filePart2 = (Part) request.getPart("fcid");
                        Collection<String> headers2 = filePart2.getHeaders("content-disposition");
                        for (String header2 : headers2) {
                            imagedetails2 = header2.split(";")[2].replace("filename=", "");
                            imageformat2 = imagedetails2.replace("\"", "");
                        }
                        int size2 = (int) filePart2.getSize();//----gettin size of the image---------------//
                        inputStream2 = filePart2.getInputStream();

                        File outputfile2 = new File("E:/netbeans/EXAM/web/uploadimages/id-" + fid + ".png");
                        OutputStream outt2 = new FileOutputStream(outputfile2);
                        byte[] buffer2 = new byte[1024];
                        int length2 = -1;
                        while ((length2 = inputStream2.read(buffer2)) != -1) {
                            outt2.write(buffer2, 0, length2);
                        }
                        request.setAttribute("status", "Successfully Registered");

                        RequestDispatcher rd1 = request.getRequestDispatcher("flogin.jsp");
                        rd1.forward(request, response);
                    } else if (status.equals("failure")) {
                        request.setAttribute("status", "Registration failed");
                        RequestDispatcher rd1 = request.getRequestDispatcher("fregister.jsp");
                        rd1.forward(request, response);
                    }
                }
            } //flogin session implementation
            else if (request.getParameter("flogin") != null) {
                String fid = request.getParameter("fid");
                String fpwd = request.getParameter("fpwd");
                String status = reg.flogin(fid, fpwd);
                if (status.equals("success")) {

                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");

                    rd1.forward(request, response);

                } else if (status.equals("failure")) {
                    request.setAttribute("status", "Login failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("flogin.jsp");
                    rd1.forward(request, response);
                }
            } // hod registrartion 
            else if (request.getParameter("hregister") != null) {
                String hname = request.getParameter("hname");
                String hid = request.getParameter("hid");
                String hphone = request.getParameter("hphone");
                String hemail = request.getParameter("hemail");
                String hdep = request.getParameter("hdep");
                String hdob = request.getParameter("hdob");
                String hgender = request.getParameter("gender");
                String haadhaar = request.getParameter("haadhaar");
                String hpan = request.getParameter("hpan");
                String haddress = request.getParameter("haddress");
                String hphoto = "profile-" + hid + ".png";
                String hcid = "id-" + hid + ".png";
                String hpwd = request.getParameter("hpwd");
                String hcpwd = request.getParameter("hcpwd");
                String HSTATUS = "";

                if (hpwd.equals(hcpwd)) {
                    String status = reg.hregistration(hname, hid, hphone, hemail, hdep, hdob, hgender, haadhaar, hpan, haddress, hphoto, hcid, hpwd, HSTATUS);

                    if (status.equals("existed")) {

                        request.setAttribute("status", "Existed record");

                        RequestDispatcher rd1 = request.getRequestDispatcher("hregister.jsp");
                        rd1.forward(request, response);

                    } else if (status.equals("success")) {
                        // upload profile photo
                        InputStream inputStream1 = null;
                        String imagedetails = "";
                        String imageformat = "";
                        Part filePart1 = (Part) request.getPart("hphoto");
                        Collection<String> headers = filePart1.getHeaders("content-disposition");
                        for (String header : headers) {
                            imagedetails = header.split(";")[2].replace("filename=", "");
                            imageformat = imagedetails.replace("\"", "");
                        }
                        int size = (int) filePart1.getSize();//----gettin size of the image---------------//
                        inputStream1 = filePart1.getInputStream();

                        File outputfile = new File("E:/netbeans/EXAM/web/uploadimages/profile-" + hid + ".png");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                        }

                        InputStream inputStream2 = null;
                        String imagedetails2 = "";
                        String imageformat2 = "";
                        Part filePart2 = (Part) request.getPart("hcid");
                        Collection<String> headers2 = filePart2.getHeaders("content-disposition");
                        for (String header2 : headers2) {
                            imagedetails2 = header2.split(";")[2].replace("filename=", "");
                            imageformat2 = imagedetails2.replace("\"", "");
                        }
                        int size2 = (int) filePart2.getSize();//----gettin size of the image---------------//
                        inputStream2 = filePart2.getInputStream();

                        File outputfile2 = new File("E:/netbeans/EXAM/web/uploadimages/id-" + hid + ".png");
                        OutputStream outt2 = new FileOutputStream(outputfile2);
                        byte[] buffer2 = new byte[1024];
                        int length2 = -1;
                        while ((length2 = inputStream2.read(buffer2)) != -1) {
                            outt2.write(buffer2, 0, length2);
                        }
                        request.setAttribute("status", "Successfully Registered");

                        RequestDispatcher rd1 = request.getRequestDispatcher("hlogin.jsp");
                        rd1.forward(request, response);
                    } else if (status.equals("failure")) {
                        request.setAttribute("status", "Registration failed");
                        RequestDispatcher rd1 = request.getRequestDispatcher("hregister.jsp");
                        rd1.forward(request, response);
                    }

                }

            } //hlogin seession
            else if (request.getParameter("hlogin") != null) {
                String hid = request.getParameter("hid");
                String hpwd = request.getParameter("hpwd");
                String status = reg.hlogin(hid, hpwd);
                if (status.equals("success")) {

                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");

                    rd1.forward(request, response);

                } else if (status.equals("failure")) {
                    request.setAttribute("status", "Login failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("hlogin.jsp");
                    rd1.forward(request, response);
                }
            } else if (request.getParameter("logout") != null) {
                session.invalidate();
                RequestDispatcher rd1 = request.getRequestDispatcher("HOMEPAGE_1.html");
                rd1.forward(request, response);
            } //princi registration
            else if (request.getParameter("pregister") != null) {
                String pname = request.getParameter("pname");
                String pid = request.getParameter("pid");
                String pphone = request.getParameter("pphone");
                String pemail = request.getParameter("pemail");
                String pdob = request.getParameter("pdob");
                String pgender = request.getParameter("gender");
                String paadhaar = request.getParameter("paadhaar");
                String ppan = request.getParameter("ppan");
                String paddress = request.getParameter("paddress");
                String pphoto = "profile-" + pid + ".png";
                String pcid = "id-" + pid + ".png";
                String ppwd = request.getParameter("ppwd");
                String pcpwd = request.getParameter("pcpwd");
                String PSTATUS = "";

                if (ppwd.equals(pcpwd)) {
                    String status = reg.pregistration(pname, pid, pphone, pemail, pdob, pgender, paadhaar, ppan, paddress, pphoto, pcid, ppwd, PSTATUS);

                    if (status.equals("existed")) {

                        request.setAttribute("status", "Existed record");

                        RequestDispatcher rd1 = request.getRequestDispatcher("pregister.jsp");
                        rd1.forward(request, response);

                    } else if (status.equals("success")) {
                        // upload profile photo
                        InputStream inputStream1 = null;
                        String imagedetails = "";
                        String imageformat = "";
                        Part filePart1 = (Part) request.getPart("pphoto");
                        Collection<String> headers = filePart1.getHeaders("content-disposition");
                        for (String header : headers) {
                            imagedetails = header.split(";")[2].replace("filename=", "");
                            imageformat = imagedetails.replace("\"", "");
                        }
                        int size = (int) filePart1.getSize();//----gettin size of the image---------------//
                        inputStream1 = filePart1.getInputStream();

                        File outputfile = new File("E:/netbeans/EXAM/web/uploadimages/profile-" + pid + ".png");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                        }

                        InputStream inputStream2 = null;
                        String imagedetails2 = "";
                        String imageformat2 = "";
                        Part filePart2 = (Part) request.getPart("pcid");
                        Collection<String> headers2 = filePart2.getHeaders("content-disposition");
                        for (String header2 : headers2) {
                            imagedetails2 = header2.split(";")[2].replace("filename=", "");
                            imageformat2 = imagedetails2.replace("\"", "");
                        }
                        int size2 = (int) filePart2.getSize();//----gettin size of the image---------------//
                        inputStream2 = filePart2.getInputStream();

                        File outputfile2 = new File("E:/netbeans/EXAM/web/uploadimages/id-" + pid + ".png");
                        OutputStream outt2 = new FileOutputStream(outputfile2);
                        byte[] buffer2 = new byte[1024];
                        int length2 = -1;
                        while ((length2 = inputStream2.read(buffer2)) != -1) {
                            outt2.write(buffer2, 0, length2);
                        }
                        request.setAttribute("status", "Successfully Registered");

                        RequestDispatcher rd1 = request.getRequestDispatcher("plogin.jsp");
                        rd1.forward(request, response);
                    } else if (status.equals("failure")) {
                        request.setAttribute("status", "Registration failed");
                        RequestDispatcher rd1 = request.getRequestDispatcher("pregister.jsp");
                        rd1.forward(request, response);
                    }

                }

            } //plogin seeion
            else if (request.getParameter("plogin") != null) {
                String pid = request.getParameter("pid");
                String ppwd = request.getParameter("ppwd");
                String status = reg.plogin(pid, ppwd);
                if (status.equals("success")) {

                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");

                    rd1.forward(request, response);

                } else if (status.equals("failure")) {
                    request.setAttribute("status", "Login failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("plogin.jsp");
                    rd1.forward(request, response);
                }
            } //sregistration
            else if (request.getParameter("sregister") != null) {
                String sname = request.getParameter("sname");
                String sid = request.getParameter("sid");
                String sphone = request.getParameter("sphone");
                String semail = request.getParameter("semail");
                String sdep = request.getParameter("sdep");
                String ssem = request.getParameter("ssem");
                String sdob = request.getParameter("sdob");
                String sgender = request.getParameter("gender");
                String saadhaar = request.getParameter("saadhaar");
                String saddress = request.getParameter("saddress");
                String sphoto = "profile-" + sid + ".png";
                String scid = "id-" + sid + ".png";
                String spwd = request.getParameter("spwd");
                String scpwd = request.getParameter("scpwd");
                String SSTATUS = "";

                if (spwd.equals(scpwd)) {
                    String status = reg.sregistration(sname, sid, sphone, semail, sdep, ssem, sdob, sgender, saadhaar, saddress, sphoto, scid, spwd, SSTATUS);

                    if (status.equals("existed")) {

                        request.setAttribute("status", "Existed record");

                        RequestDispatcher rd1 = request.getRequestDispatcher("sregister.jsp");
                        rd1.forward(request, response);

                    } else if (status.equals("success")) {
                        // upload profile photo
                        InputStream inputStream1 = null;
                        String imagedetails = "";
                        String imageformat = "";
                        Part filePart1 = (Part) request.getPart("sphoto");
                        Collection<String> headers = filePart1.getHeaders("content-disposition");
                        for (String header : headers) {
                            imagedetails = header.split(";")[2].replace("filename=", "");
                            imageformat = imagedetails.replace("\"", "");
                        }
                        int size = (int) filePart1.getSize();//----gettin size of the image---------------//
                        inputStream1 = filePart1.getInputStream();

                        File outputfile = new File("E:/netbeans/EXAM/web/uploadimages/profile-" + sid + ".png");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                        }

                        InputStream inputStream2 = null;
                        String imagedetails2 = "";
                        String imageformat2 = "";
                        Part filePart2 = (Part) request.getPart("scid");
                        Collection<String> headers2 = filePart2.getHeaders("content-disposition");
                        for (String header2 : headers2) {
                            imagedetails2 = header2.split(";")[2].replace("filename=", "");
                            imageformat2 = imagedetails2.replace("\"", "");
                        }
                        int size2 = (int) filePart2.getSize();//----gettin size of the image---------------//
                        inputStream2 = filePart2.getInputStream();

                        File outputfile2 = new File("E:/netbeans/EXAM/web/uploadimages/id-" + sid + ".png");
                        OutputStream outt2 = new FileOutputStream(outputfile2);
                        byte[] buffer2 = new byte[1024];
                        int length2 = -1;
                        while ((length2 = inputStream2.read(buffer2)) != -1) {
                            outt2.write(buffer2, 0, length2);
                        }
                        request.setAttribute("status", "Successfully Registered");

                        RequestDispatcher rd1 = request.getRequestDispatcher("slogin.jsp");
                        rd1.forward(request, response);
                    } else if (status.equals("failure")) {
                        request.setAttribute("status", "Registration failed");
                        RequestDispatcher rd1 = request.getRequestDispatcher("sregister.jsp");
                        rd1.forward(request, response);
                    }

                }

            } //slogin session 
            else if (request.getParameter("slogin") != null) {
                String sid = request.getParameter("sid");
                String spwd = request.getParameter("spwd");
                String status = reg.slogin(sid, spwd);
                if (status.equals("success")) {

                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");

                    rd1.forward(request, response);

                } else if (status.equals("failure")) {
                    request.setAttribute("status", "Login failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("slogin.jsp");
                    rd1.forward(request, response);
                }
            } //admin session
            else if (request.getParameter("adminlogin") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String status;
                status = reg.adminlogin(username, password);
                if (status.equals("success")) {

                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");

                    rd1.forward(request, response);

                } else if (status.equals("failure")) {
                    request.setAttribute("status", "Login failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("admin_login.jsp");
                    rd1.forward(request, response);
                }
            } //create exam
            else if (request.getParameter("createexam") != null) {
//                 System.out.println("hii");
                String fname = session.getAttribute("fname").toString();
                String fid = session.getAttribute("fid").toString();
                String fdep = session.getAttribute("fdep").toString();
                String examtitle = request.getParameter("examtitle");
                String subjectname = request.getParameter("subjectname");
                String semester = request.getParameter("semester");
                String exampattern = request.getParameter("exampattern");
                String writingarea = request.getParameter("writingarea");
                String drawingtool = request.getParameter("drawingtool");
                String scan = request.getParameter("scan");
                String security = request.getParameter("security");
                String noq = request.getParameter("noq");
                String subcode = request.getParameter("subcode");
                String duration = request.getParameter("duration");
                String STATUS = request.getParameter("STATUS");

                String status = reg.examregistration(fname, fid, fdep, examtitle, subjectname, semester, exampattern, writingarea, drawingtool, scan, security, noq, subcode, duration,STATUS);
                System.out.println(status);
                if (status.split("@")[0].equals("success")) {

                    if (exampattern.equals("doc")) {
                        RequestDispatcher rd1 = request.getRequestDispatcher("uploadpdf.jsp");
                        rd1.forward(request, response);
                    } else if (exampattern.equals("que")) {
                        RequestDispatcher rd1 = request.getRequestDispatcher("question.jsp");
                        rd1.forward(request, response);
                    } else if (exampattern.equals("question")) {
                        RequestDispatcher rd1 = request.getRequestDispatcher("mcq.jsp?examid=" + status.split("@")[1]);
                        rd1.forward(request, response);
                    }
                } else if (status.split("@")[0].equals("failure")) {
                    request.setAttribute("status", "creating exam failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("exam.jsp");
                    rd1.forward(request, response);
                }

            } else if (request.getParameter("uploadpdf") != null) {
                String fid = session.getAttribute("fid").toString();
                String doc = "question-" + fid + " .pdf";
                String dname = "@" + doc + ".pdf";
                String status = reg.uploadpdfmod(fid, doc, dname);
                if (status.equals("failure")) {

                    request.setAttribute("status", "Failure");

                    RequestDispatcher rd1 = request.getRequestDispatcher("uploadpdf.jsp");
                    rd1.forward(request, response);
                } else if (status.equals("success")) 
                    //upload PDF Trial and ERROR
//{
//
//                    InputStream inputStream1 = null;
//                    String imagedetails = "";
//                    String imageformat = "";
//                    Part filePart1 = (Part) request.getPart("doc");
//                    Collection<String> headers = filePart1.getHeaders("content-disposition");
//                    for (String header : headers) {
//                        imagedetails = header.split(";")[2].replace("filename=", "");
//                        imageformat = imagedetails.replace("\"", "");
//                    }
//                    int size = (int) filePart1.getSize();//----getting size of the image---------------//
//                    inputStream1 = filePart1.getInputStream();
//
//                    File outputfile = new File("E:/EXAM/web/uploadimages/question-" + fid + ".pdf");
//                    OutputStream outt = new FileOutputStream(outputfile);
//                    byte[] buffer = new byte[1024];
//                    int length = -1;
//                    while ((length = inputStream1.read(buffer)) != -1) {
//                        outt.write(buffer, 0, length);
//                    }
//                    request.setAttribute("status", "Success");
//                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
//                    rd1.forward(request, response);
//
//                }
                {
                        // upload PDF
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

                        File outputfile = new File("E:/netbeans/EXAM/web/fac_exam_que/EQue-" + fid + ".pdf");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                        }

                        request.setAttribute("status", "Successfully Registered");

                        RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
                        rd1.forward(request, response);
                    } 

            } //storing max noq to mcq
            //             else if (request.getParameter("noque") != null ) {
            ////                 System.out.println("hii");
            //                          
            //                String noq = request.getParameter("noq");
            //               
            //            
            //                  String status = reg.noqmod(noq);
            //                   String status1 = reg.noqse(noq);
            ////                  System.out.println(status);
            //                      if (status.equals("success"))  {
            //              if (status1.equals("success"))  {
            //
            //                    RequestDispatcher rd1 = request.getRequestDispatcher("mcq.jsp");
            //
            //                    rd1.forward(request, response);
            //
            //                } else if (status.equals("failure")) {
            //                    request.setAttribute("status", "Login failed");
            //                    RequestDispatcher rd1 = request.getRequestDispatcher("popup.jsp");
            //                    rd1.forward(request, response);
            //                }
            //                      RequestDispatcher rd1 = request.getRequestDispatcher("mcq.jsp");
            //                        rd1.forward(request, response);                       
            //             } else if (status.equals("failure")) {
            //                    request.setAttribute("status", "failed");
            //                    RequestDispatcher rd1 = request.getRequestDispatcher("popup.jsp");
            //                    rd1.forward(request, response);
            //                }
            //
            //                }
            //upload assignment
            else if (request.getParameter("sassignment") != null) {
                String sid = session.getAttribute("sid").toString();
                String sdoc = "asgn-" + sid + " .pdf";
                String status = reg.sassignmentmod(sid, sdoc);
                if (status.equals("failure")) {

                    request.setAttribute("status", "Failure");

                    RequestDispatcher rd1 = request.getRequestDispatcher("sassignment.jsp");
                    rd1.forward(request, response);
                } else if (status.equals("success")) 
//                {
//
//                    InputStream inputStream1 = null;
//                    String imagedetails = "";
//                    String imageformat = "";
//                    Part filePart1 = (Part) request.getPart("sdoc");
//                    Collection<String> headers = filePart1.getHeaders("content-disposition");
//                    for (String header : headers) {
//                        imagedetails = header.split(";")[2].replace("filename=", "");
//                        imageformat = imagedetails.replace("\"", "");
//                    }
//                    int size = (int) filePart1.getSize();//----getting size of the image---------------//
//                    inputStream1 = filePart1.getInputStream();
//
//                    File outputfile = new File("E:/EXAM/web/uploadimages/asgn-" + sid + ".pdf");
//                    OutputStream outt = new FileOutputStream(outputfile);
//                    byte[] buffer = new byte[1024];
//                    int length = -1;
//                    while ((length = inputStream1.read(buffer)) != -1) {
//                        outt.write(buffer, 0, length);
//                    }
//                    request.setAttribute("status", "Success");
//                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
//                    rd1.forward(request, response);
//
//                }
                {
                        // Student Assignment upload PDF
                        InputStream inputStream1 = null;
                        String imagedetails = "";
                        String imageformat = "";
                        Part filePart1 = (Part) request.getPart("sdoc");
                        Collection<String> headers = filePart1.getHeaders("content-disposition");
                        for (String header : headers) {
                            imagedetails = header.split(";")[2].replace("filename=", "");
                            imageformat = imagedetails.replace("\"", "");
                        }
                        int size = (int) filePart1.getSize();//----getting size of the image---------------//
                        inputStream1 = filePart1.getInputStream();

                        File outputfile = new File("E:/netbeans/EXAM/web/stu_asgn_ans/Aans-" + sid + ".pdf");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                        }

                        request.setAttribute("status", "Successfully Registered");

                        RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
                        rd1.forward(request, response);
                    } 

            } //session noq
            else if (request.getParameter("noque") != null) {
                String noq = request.getParameter("noq");

            } //new
            else if (request.getParameter("fcassignment") != null) {
                String fname = session.getAttribute("fname").toString();
                String fid = session.getAttribute("fid").toString();
                String fdep = session.getAttribute("fdep").toString();
                String asgntitle = request.getParameter("asgntitle");
                String asubjectname = request.getParameter("asubjectname");
                String asemester = request.getParameter("asemester");
                String asgnpattern = request.getParameter("asgnpattern");

                String status = reg.asgnregistration(fname, fid, fdep, asgntitle, asubjectname, asemester, asgnpattern);

                if (status.equals("success")) {

                    if (asgnpattern.equals("adoc")) {
                        RequestDispatcher rd1 = request.getRequestDispatcher("auploadpdf.jsp");
                        rd1.forward(request, response);
                    } else if (asgnpattern.equals("aque")) {
                        RequestDispatcher rd1 = request.getRequestDispatcher("aquestion.jsp");
                        rd1.forward(request, response);
                    }

                } else if (status.equals("failure")) {
                    request.setAttribute("status", "creating assignment failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("fcassignment.jsp");
                    rd1.forward(request, response);
                }

            } //            asgn upload pdf
            else if (request.getParameter("auploadpdf") != null) {
                String fid = session.getAttribute("fid").toString();
                String adoc = "aquestion-" + fid + " .pdf";
                String status = reg.auploadpdfmod(fid, adoc);
                if (status.equals("failure")) {

                    request.setAttribute("status", "Failure");

                    RequestDispatcher rd1 = request.getRequestDispatcher("auploadpdf.jsp");
                    rd1.forward(request, response);
                } else if (status.equals("success")) 
//                {
//
//                    InputStream inputStream1 = null;
//                    String imagedetails = "";
//                    String imageformat = "";
//                    Part filePart1 = (Part) request.getPart("adoc");
//                    Collection<String> headers = filePart1.getHeaders("content-disposition");
//                    for (String header : headers) {
//                        imagedetails = header.split(";")[2].replace("filename=", "");
//                        imageformat = imagedetails.replace("\"", "");
//                    }
//                    int size = (int) filePart1.getSize();//----getting size of the image---------------//
//                    inputStream1 = filePart1.getInputStream();
//
//                    File outputfile = new File("E:/EXAM/web/uploadimages/aquestion-" + fid + ".pdf");
//                    OutputStream outt = new FileOutputStream(outputfile);
//                    byte[] buffer = new byte[1024];
//                    int length = -1;
//                    while ((length = inputStream1.read(buffer)) != -1) {
//                        outt.write(buffer, 0, length);
//                    }
//                    request.setAttribute("status", "Success");
//                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
//                    rd1.forward(request, response);
//
//                }
                    {
                        // faculty Assignment question upload PDF
                        InputStream inputStream1 = null;
                        String imagedetails = "";
                        String imageformat = "";
                        Part filePart1 = (Part) request.getPart("adoc");
                        Collection<String> headers = filePart1.getHeaders("content-disposition");
                        for (String header : headers) {
                            imagedetails = header.split(";")[2].replace("filename=", "");
                            imageformat = imagedetails.replace("\"", "");
                        }
                        int size = (int) filePart1.getSize();//----getting size of the image---------------//
                        inputStream1 = filePart1.getInputStream();

                        File outputfile = new File("E:/netbeans/EXAM/web/fac_asgn_que/AQUpload-" + fid + ".pdf");
                        OutputStream outt = new FileOutputStream(outputfile);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = inputStream1.read(buffer)) != -1) {
                            outt.write(buffer, 0, length);
                        }

                        request.setAttribute("status", "Successfully Registered");

                        RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
                        rd1.forward(request, response);
                    } 

            }
//            assignment que
            if (request.getParameter("aquestion") != null) {

                // public String getParameter(String name):is used to obtain the value of a parameter by name
//                String fid = session.getAttribute("fid").toString();
//                String fname = session.getAttribute("fname").toString();
//                String sub = "Chem";
                String aque = request.getParameter("aque");

                String status = reg.aquestionmod(aque);
                if (status.equals("success")) {
                    request.setAttribute("status", "Successfully Created");
                    RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
                    rd1.forward(request, response);
                } else if (status.equals("failure")) {
                    request.setAttribute("status", "Failed");
                    RequestDispatcher rd1 = request.getRequestDispatcher("aquestion.jsp");
                    rd1.forward(request, response);
                }

            } // student forgot password
            else if (request.getParameter("forgotpassword") != null) {
                String semail = request.getParameter("semail");
                int count = reg.ValidateEmail(semail);
                if (count == 0) {
                    request.setAttribute("status", "Enter valid email address");
                    RequestDispatcher rd = request.getRequestDispatcher("ForgotPassword.jsp");
                    rd.forward(request, response);
                } else {
                    int randnumber = 0;
                    randnumber = (int) (Math.random() * 100000);
                    String code = "" + randnumber;
                    String idName = reg.FetchNameByEmail(semail);
                    String id = idName.split("__")[0];
                    String uname = idName.split("__")[1];
                    reg.PasswordTrack(id, uname, semail, randnumber + "");
                    final StringBuilder sb = new StringBuilder("<html> ");
                    sb.append("<body>");
                    sb.append("<div style='width: 100%;background: aliceblue;'>");
                    sb.append("<p class=notsobig-text >Hi<strong> " + uname + ",</strong></p>");
                    sb.append(" <p class=notsobig-text>You have requested to reset your password. Kindly click the below link to reset.</p> ");
                    sb.append("<div> <a target='_blank' style='text-decoration: none;padding: 2px 14px;background: #8bc34a;border-radius: 2px;overflow: hidden;margin: 10px;margin-left: 0;width: auto;display: inline-block;border: 1px solid #76b031;font-family: Helvetica,Arial,sans-serif;' href='http://localhost:8084/EXAM/Register?code1=" + code + "&&semail=" + semail + "'> <strong style='font-size: 13px;font-weight: bold;color: white;white-space: nowrap;'>Reset Password</strong> </a></div>");
                    sb.append("</div>");
                    sb.append("</body>");
                    sb.append("</html>");
                    reg.SendMail(sb.toString(), "Password Reset Link", semail);
                    session.setAttribute("securitycode1", code);
                    request.setAttribute("status", "Verification code successfully sent on your email. ");
                    RequestDispatcher rd = request.getRequestDispatcher("ForgotPassword.jsp");
                    rd.forward(request, response);
                }
            } else if (request.getParameter("code1") != null && request.getParameter("semail") != null) {
                try {
                    String code1 = request.getParameter("code1").replace(" ", "+");
                    String semail = request.getParameter("semail");
                    pstudent s = reg.GetPasswordTrackDetails(semail, code1);
                    String name = "", uemail = "", scode = "";
                    if (s.getsname().length() > 0) {
                       
                        name = s.getsname();
                        uemail = s.getsemail();
                        scode = s.getspassword();
                    }
                    if (code1.equals(scode)) {
                      
                        session.setAttribute("scode", scode);
                        session.setAttribute("npuname", name);
                        session.setAttribute("npuemail", uemail);
                        RequestDispatcher rd = request.getRequestDispatcher("NewPassword.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Invalid or expired verification link.");
                        RequestDispatcher rd = request.getRequestDispatcher("ForgotPassword.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (session.getAttribute("scode") != null && request.getParameter("submit_NewPassword") != null) {
                try {
                    int status = 0, inPassTrack = 0;
                    String uemail = session.getAttribute("npuemail").toString();
                    String uname = session.getAttribute("npuname").toString();
                    String scode = session.getAttribute("scode").toString();

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (pass.equals(cpass)) {
                        status = reg.UpdatePassword(uemail, pass);
                        inPassTrack = reg.UpdatePasswordInPassTrack(uemail, scode, pass);
                        session.setAttribute("npuname", null);
                        session.setAttribute("npuemail", null);
                        session.setAttribute("scode", null);
                        RequestDispatcher rd = request.getRequestDispatcher("slogin.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("NewPassword.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            // faculty forgot password
            else if (request.getParameter("fforgotpassword") != null) {
                String femail = request.getParameter("femail");
                int count = reg.FacValidateEmail(femail);
                if (count == 0) {
                    request.setAttribute("status", "Enter valid email address");
                    RequestDispatcher rd = request.getRequestDispatcher("FForgotpassword.jsp");
                    rd.forward(request, response);
                } else {
                    int randnumber = 0;
                    randnumber = (int) (Math.random() * 100000);
                    String code = "" + randnumber;
                    String idName = reg.FetchFacNameByEmail(femail);
                    String id = idName.split("__")[0];
                    String uname = idName.split("__")[1];
                    reg.FacPasswordTrack(id, uname, femail, randnumber + "");
                    final StringBuilder sb = new StringBuilder("<html> ");
                    sb.append("<body>");
                    sb.append("<div style='width: 100%;background: aliceblue;'>");
                    sb.append("<p class=notsobig-text >Hi<strong> " + uname + ",</strong></p>");
                    sb.append(" <p class=notsobig-text>You have requested to reset your password. Kindly click the below link to reset.</p> ");
                    sb.append("<div> <a target='_blank' style='text-decoration: none;padding: 2px 14px;background: #8bc34a;border-radius: 2px;overflow: hidden;margin: 10px;margin-left: 0;width: auto;display: inline-block;border: 1px solid #76b031;font-family: Helvetica,Arial,sans-serif;' href='http://localhost:8084/EXAM/Register?code1=" + code + "&&femail=" + femail + "'> <strong style='font-size: 13px;font-weight: bold;color: white;white-space: nowrap;'>Reset Password</strong> </a></div>");
                    sb.append("</div>");
                    sb.append("</body>");
                    sb.append("</html>");
                    reg.FacSendMail(sb.toString(), "Password Reset Link", femail);
                    session.setAttribute("securitycode1", code);
                    request.setAttribute("status", "Verification code successfully sent on your email. ");
                    RequestDispatcher rd = request.getRequestDispatcher("FForgotpassword.jsp");
                    rd.forward(request, response);
                }
            } else if (request.getParameter("code1") != null && request.getParameter("femail") != null) {
                try {
                    String code1 = request.getParameter("code1").replace(" ", "+");
                    String femail = request.getParameter("femail");
                    pfaculty f = reg.FacGetPasswordTrackDetails(femail, code1);
                    String name = "", uemail = "", scode = "";
                    if (f.getfname().length() > 0) {
                       
                        name = f.getfname();
                        uemail = f.getfemail();
                        scode = f.getfpassword();
                    }
                    if (code1.equals(scode)) {
                      
                        session.setAttribute("scode", scode);
                        session.setAttribute("npuname", name);
                        session.setAttribute("npuemail", uemail);
                        RequestDispatcher rd = request.getRequestDispatcher("FacNewpassword.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Invalid or expired verification link.");
                        RequestDispatcher rd = request.getRequestDispatcher("FForgotpassword.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (session.getAttribute("scode") != null && request.getParameter("submit_FacNewpassword") != null) {
                try {
                    int status = 0, inPassTrack = 0;
                    String uemail = session.getAttribute("npuemail").toString();
                    String uname = session.getAttribute("npuname").toString();
                    String scode = session.getAttribute("scode").toString();

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (pass.equals(cpass)) {
                        status = reg.FacUpdatePassword(uemail, pass);
                        inPassTrack = reg.FacUpdatePasswordInPassTrack(uemail, scode, pass);
                        session.setAttribute("npuname", null);
                        session.setAttribute("npuemail", null);
                        session.setAttribute("scode", null);
                        RequestDispatcher rd = request.getRequestDispatcher("flogin.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("FacNewpassword.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
             // HOD forgot password
            else if (request.getParameter("Hodforgotpassword") != null) {
                String hemail = request.getParameter("hemail");
                int count = reg.HODValidateEmail(hemail);
                if (count == 0) {
                    request.setAttribute("status", "Enter valid email address");
                    RequestDispatcher rd = request.getRequestDispatcher("HODForgotpassword.jsp");
                    rd.forward(request, response);
                } else {
                    int randnumber = 0;
                    randnumber = (int) (Math.random() * 100000);
                    String code = "" + randnumber;
                    String idName = reg.FetchHODNameByEmail(hemail);
                    String id = idName.split("__")[0];
                    String uname = idName.split("__")[1];
                    reg.HODPasswordTrack(id, uname, hemail, randnumber + "");
                    final StringBuilder sb = new StringBuilder("<html> ");
                    sb.append("<body>");
                    sb.append("<div style='width: 100%;background: aliceblue;'>");
                    sb.append("<p class=notsobig-text >Hi<strong> " + uname + ",</strong></p>");
                    sb.append(" <p class=notsobig-text>You have requested to reset your password. Kindly click the below link to reset.</p> ");
                    sb.append("<div> <a target='_blank' style='text-decoration: none;padding: 2px 14px;background: #8bc34a;border-radius: 2px;overflow: hidden;margin: 10px;margin-left: 0;width: auto;display: inline-block;border: 1px solid #76b031;font-family: Helvetica,Arial,sans-serif;' href='http://localhost:8084/EXAM/Register?code1=" + code + "&&hemail=" + hemail + "'> <strong style='font-size: 13px;font-weight: bold;color: white;white-space: nowrap;'>Reset Password</strong> </a></div>");
                    sb.append("</div>");
                    sb.append("</body>");
                    sb.append("</html>");
                    reg.HODSendMail(sb.toString(), "Password Reset Link", hemail);
                    session.setAttribute("securitycode1", code);
                    request.setAttribute("status", "Verification code successfully sent on your email. ");
                    RequestDispatcher rd = request.getRequestDispatcher("HODForgotpassword.jsp");
                    rd.forward(request, response);
                }
            } else if (request.getParameter("code1") != null && request.getParameter("hemail") != null) {
                try {
                    String code1 = request.getParameter("code1").replace(" ", "+");
                    String hemail = request.getParameter("hemail");
                    phod h = reg.HODGetPasswordTrackDetails(hemail, code1);
                    String name = "", uemail = "", scode = "";
                    if (h.gethname().length() > 0) {
                       
                        name = h.gethname();
                        uemail = h.gethemail();
                        scode = h.gethpassword();
                    }
                    if (code1.equals(scode)) {
                      
                        session.setAttribute("scode", scode);
                        session.setAttribute("npuname", name);
                        session.setAttribute("npuemail", uemail);
                        RequestDispatcher rd = request.getRequestDispatcher("HODNewpassword.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Invalid or expired verification link.");
                        RequestDispatcher rd = request.getRequestDispatcher("HODForgotpassword.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (session.getAttribute("scode") != null && request.getParameter("submit_HODNewpassword") != null) {
                try {
                    int status = 0, inPassTrack = 0;
                    String uemail = session.getAttribute("npuemail").toString();
                    String uname = session.getAttribute("npuname").toString();
                    String scode = session.getAttribute("scode").toString();

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (pass.equals(cpass)) {
                        status = reg.HODUpdatePassword(uemail, pass);
                        inPassTrack = reg.HODUpdatePasswordInPassTrack(uemail, scode, pass);
                        session.setAttribute("npuname", null);
                        session.setAttribute("npuemail", null);
                        session.setAttribute("scode", null);
                        RequestDispatcher rd = request.getRequestDispatcher("hlogin.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("HODNewpassword.jsp");
                        rd.forward(request, response);
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            // Principal forgot password
            else if (request.getParameter("Pforgotpassword") != null) {
                String pemail = request.getParameter("pemail");
                int count = reg.PValidateEmail(pemail);
                if (count == 0) {
                    request.setAttribute("status", "Enter valid email address");
                    RequestDispatcher rd = request.getRequestDispatcher("PForgotpassword.jsp");
                    rd.forward(request, response);
                } else {
                    int randnumber = 0;
                    randnumber = (int) (Math.random() * 100000);
                    String code = "" + randnumber;
                    String idName = reg.FetchPNameByEmail(pemail);
                    String id = idName.split("__")[0];
                    String uname = idName.split("__")[1];
                    reg.PPasswordTrack(id, uname, pemail, randnumber + "");
                    final StringBuilder sb = new StringBuilder("<html> ");
                    sb.append("<body>");
                    sb.append("<div style='width: 100%;background: aliceblue;'>");
                    sb.append("<p class=notsobig-text >Hi<strong> " + uname + ",</strong></p>");
                    sb.append(" <p class=notsobig-text>You have requested to reset your password. Kindly click the below link to reset.</p> ");
                    sb.append("<div> <a target='_blank' style='text-decoration: none;padding: 2px 14px;background: #8bc34a;border-radius: 2px;overflow: hidden;margin: 10px;margin-left: 0;width: auto;display: inline-block;border: 1px solid #76b031;font-family: Helvetica,Arial,sans-serif;' href='http://localhost:8084/EXAM/Register?code1=" + code + "&&pemail=" + pemail + "'> <strong style='font-size: 13px;font-weight: bold;color: white;white-space: nowrap;'>Reset Password</strong> </a></div>");
                    sb.append("</div>");
                    sb.append("</body>");
                    sb.append("</html>");
                    reg.PSendMail(sb.toString(), "Password Reset Link", pemail);
                    session.setAttribute("securitycode1", code);
                    request.setAttribute("status", "Verification code successfully sent on your email. ");
                    RequestDispatcher rd = request.getRequestDispatcher("PForgotpassword.jsp");
                    rd.forward(request, response);
                }
            } else if (request.getParameter("code1") != null && request.getParameter("pemail") != null) {
                try {
                    String code1 = request.getParameter("code1").replace(" ", "+");
                    String pemail = request.getParameter("pemail");
                    pprincipal p = reg.PGetPasswordTrackDetails(pemail, code1);
                    String name = "", uemail = "", scode = "";
                    if (p.getpname().length() > 0) {
                       
                        name = p.getpname();
                        uemail = p.getpemail();
                        scode = p.getppassword();
                    }
                    if (code1.equals(scode)) {
                      
                        session.setAttribute("scode", scode);
                        session.setAttribute("npuname", name);
                        session.setAttribute("npuemail", uemail);
                        RequestDispatcher rd = request.getRequestDispatcher("PNewpassword.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Invalid or expired verification link.");
                        RequestDispatcher rd = request.getRequestDispatcher("PForgotpassword.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (session.getAttribute("scode") != null && request.getParameter("submit_PNewpassword") != null) {
                try {
                    int status = 0, inPassTrack = 0;
                    String uemail = session.getAttribute("npuemail").toString();
                    String uname = session.getAttribute("npuname").toString();
                    String scode = session.getAttribute("scode").toString();

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (pass.equals(cpass)) {
                        status = reg.PUpdatePassword(uemail, pass);
                        inPassTrack = reg.PUpdatePasswordInPassTrack(uemail, scode, pass);
                        session.setAttribute("npuname", null);
                        session.setAttribute("npuemail", null);
                        session.setAttribute("scode", null);
                        RequestDispatcher rd = request.getRequestDispatcher("plogin.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("PNewpassword.jsp");
                        rd.forward(request, response);
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            //student password update
            else if (request.getParameter("StuPasswordUpdate") != null) {
                
                try {
                    int status = 0;
                    String semail = session.getAttribute("semail").toString();
                    String spwd = session.getAttribute("spwd").toString();
                    
                    String currentpass = request.getParameter("current_password");

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (currentpass.equals(spwd) && pass.equals(cpass)) {
                        status = reg.UpdateNewPassword(semail, pass);
                        
                        request.setAttribute("status", "Password updated successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("sprofile.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("StuPasswordUpdate.jsp");
                        rd.forward(request, response);
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            //Faculty password update
      
            else if (request.getParameter("FacPasswordUpdate") != null) {
                
                try {
                    int status = 0;
                    String femail = session.getAttribute("femail").toString();
                    String fpwd = session.getAttribute("fpwd").toString();
                    
                    String currentpass = request.getParameter("current_password");

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (currentpass.equals(fpwd) && pass.equals(cpass)) {
                        status = reg.UpdateNewFacPassword(femail, pass);
                        
                         request.setAttribute("status", "Password updated successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("fprofile.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("FacPasswordUpdate.jsp");
                        rd.forward(request, response);
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            //HOD password update
      
            else if (request.getParameter("HODPasswordUpdate") != null) {
                
                try {
                    int status = 0;
                    String hemail = session.getAttribute("hemail").toString();
                    String hpwd = session.getAttribute("hpwd").toString();
                    
                    String currentpass = request.getParameter("current_password");

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (currentpass.equals(hpwd) && pass.equals(cpass)) {
                        status = reg.UpdateNewHODPassword(hemail, pass);
                        
                         request.setAttribute("status", "Password updated successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("hprofile.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("HODPasswordUpdate.jsp");
                        rd.forward(request, response);
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
             //Principal password update
      
            else if (request.getParameter("PriPasswordUpdate") != null) {
                
                try {
                    int status = 0;
                    String pemail = session.getAttribute("pemail").toString();
                    String ppwd = session.getAttribute("ppwd").toString();
                    
                    String currentpass = request.getParameter("current_password");

                    String pass = request.getParameter("n_password");
                    String cpass = request.getParameter("c_password");
                    if (currentpass.equals(ppwd) && pass.equals(cpass)) {
                        status = reg.UpdateNewPriPassword(pemail, pass);
                        
                         request.setAttribute("status", "Password updated successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("pprofile.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "Passwords do not match!");
                        RequestDispatcher rd = request.getRequestDispatcher("PriPasswordUpdate.jsp");
                        rd.forward(request, response);
                    }
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
