package model;

import java.util.Properties;
import javax.mail.*;
import java.sql.*;
import java.util.ArrayList;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;




public class Registration {

    private Connection con;
    HttpSession se;

    public Registration(HttpSession session) {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // load the drivers
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "root");
            // connection with data base
            se = session;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String fregistration(String fname, String fid, String fphone, String femail, String fdep, String fdob, String fgender, String faadhaar, String fpan, String faddress, String fphoto, String fcid, String fpwd,String FSTATUS) {
        PreparedStatement ps;
        String status = "";
        
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select * from fregister where fid='" + fid + "' or femail='" + femail + "';");
            boolean b = rs.next();
            if (b) {
                status = "existed";
            } else {
                ps = (PreparedStatement) con.prepareStatement("insert into fregister values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)");
                ps.setString(1, fname);
                ps.setString(2, fid);
                ps.setString(3, fphone);
                ps.setString(4, femail);
                ps.setString(5, fdep);
                ps.setString(6, fdob);
                ps.setString(7, fgender);
                ps.setString(8, faadhaar);
                ps.setString(9, fpan);
                ps.setString(10, faddress);
                ps.setString(11, fphoto);
                ps.setString(12, fcid);
                ps.setString(13, fpwd);
                 ps.setString(14, FSTATUS="pending");
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    //flogin session
    public String flogin(String fid, String fpwd) {
        String status1 = "", id = "";
        String fname = "", fids = "",fphone="",femail="", fdep="",fdob="",fgender="",faadhaar="",fpan="",faddress="";

        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            rs = st.executeQuery("select * from fregister where fid='" + fid + "' and fpwd='" + fpwd + "' and fstatus='active';");
            boolean b = rs.next();
            if (b == true) {
                id = rs.getString("slno");
                fname = rs.getString("fname");
                fids = rs.getString("fid");
                fphone = rs.getString("fphone");
                femail = rs.getString("femail");
                fdep = rs.getString("fdep");
                fdob = rs.getString("fdob");
                fgender = rs.getString("fgender");
                faadhaar = rs.getString("faadhaar");
                fpan = rs.getString("fpan");
                faddress = rs.getString("faddress");
                fpwd = rs.getString("fpwd");

                se.setAttribute("fname", fname);
                se.setAttribute("fid", fid);
                  se.setAttribute("fphone", fphone);
                 se.setAttribute("femail", femail);
                se.setAttribute("fdep", fdep);
                se.setAttribute("fdob", fdob);
                se.setAttribute("fgender", fgender);
                se.setAttribute("faadhaar", faadhaar);
                se.setAttribute("fpan", fpan);
                se.setAttribute("faddress", faddress);
                se.setAttribute("fpwd", fpwd);
                se.setAttribute("id", id);
                 se.setAttribute("type", "faculty");
                status1 = "success";
            } else {
                status1 = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status1;
    }
     //hod registration

    public String hregistration(String hname, String hid, String hphone, String hemail, String hdep, String hdob, String hgender, String haadhaar, String hpan, String haddress, String hphoto, String hcid, String hpwd, String HSTATUS) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select * from hregister where hid='" + hid + "' or hemail ='" + hemail + "';");
            boolean b = rs.next();
            if (b) {
                status = "existed";
            } else {
                ps = (PreparedStatement) con.prepareStatement("insert into hregister values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)");
                ps.setString(1, hname);
                ps.setString(2, hid);
                ps.setString(3, hphone);
                ps.setString(4, hemail);
                ps.setString(5, hdep);
                ps.setString(6, hdob);
                ps.setString(7, hgender);
                ps.setString(8, haadhaar);
                ps.setString(9, hpan);
                ps.setString(10, haddress);
                ps.setString(11, hphoto);
                ps.setString(12, hcid);
                ps.setString(13, hpwd);
                 ps.setString(14, HSTATUS="pending");
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    //hlogin session
     public String hlogin(String hid, String hpwd) {
        String status1 = "", id = "";
        String hname = "", hids = "",hphone="",hemail="", hdep="",hdob="",hgender="",haadhaar="",hpan="",haddress="";

        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            rs = st.executeQuery("select * from hregister where hid='" + hid + "' and hpwd='" + hpwd + "' and hstatus='active';");
            boolean b = rs.next();
            if (b == true) {
                id = rs.getString("hslno");
                hname = rs.getString("hname");
                hids = rs.getString("hid");
                hphone = rs.getString("hphone");
                hemail = rs.getString("hemail");
                hdep = rs.getString("hdep");
                hdob = rs.getString("hdob");
                hgender = rs.getString("hgender");
                haadhaar = rs.getString("haadhaar");
                hpan = rs.getString("hpan");
                haddress = rs.getString("haddress");
                hpwd = rs.getString("hpwd");
                
                se.setAttribute("hname", hname);
                se.setAttribute("hid", hid);
                 se.setAttribute("hphone", hphone);
                 se.setAttribute("hemail", hemail);
                se.setAttribute("hdep", hdep);
                se.setAttribute("hdob", hdob);
                se.setAttribute("hgender", hgender);
                se.setAttribute("haadhaar", haadhaar);
                se.setAttribute("hpan", hpan);
                se.setAttribute("haddress", haddress);
                se.setAttribute("hpwd", hpwd);
                se.setAttribute("id", id);
                se.setAttribute("type", "hod");
                status1 = "success";
            } else {
                status1 = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status1;
    }
     //preg registraion
    public String pregistration(String pname, String pid, String pphone, String pemail, String pdob, String pgender, String paadhaar, String ppan, String paddress, String pphoto, String pcid, String ppwd, String PSTATUS) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select * from pregister where pid='" + pid + "' or pemail='" + pemail + "';");
            boolean b = rs.next();
            if (b) {
                status = "existed";
            } else {
                ps = (PreparedStatement) con.prepareStatement("insert into pregister values(0,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)");
                ps.setString(1, pname);
                ps.setString(2, pid);
                ps.setString(3, pphone);
                ps.setString(4, pemail);        
                ps.setString(5, pdob);
                ps.setString(6, pgender);
                ps.setString(7, paadhaar);
                ps.setString(8, ppan);
                ps.setString(9, paddress);
                ps.setString(10, pphoto);
                ps.setString(11, pcid);
                ps.setString(12, ppwd);
                 ps.setString(13, PSTATUS="pending");
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    //plogin session
     public String plogin(String pid, String ppwd) {
        String status1 = "", id = "";
        String pname = "", pids = "";

        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            rs = st.executeQuery("select * from pregister where pid='" + pid + "' and ppwd='" + ppwd + "' and pstatus='active';");
            boolean b = rs.next();
            if (b == true) {
                id = rs.getString("pslno");
                pname = rs.getString("pname");
                pids = rs.getString("pid");
                se.setAttribute("pname", pname);
                se.setAttribute("pid", pid);
                se.setAttribute("id", id);
                se.setAttribute("type", "principal");
                status1 = "success";
            } else {
                status1 = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status1;
    }
     //sreg registration
    public String sregistration(String sname, String sid, String sphone, String semail, String sdep, String ssem, String sdob, String sgender, String saadhaar, String saddress, String sphoto, String scid, String spwd, String SSTATUS) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select * from sregister where sid='" + sid + "' or semail='" + semail + "';" );
            boolean b = rs.next();
            if (b) {
                status = "existed";
            } else {
                ps = (PreparedStatement) con.prepareStatement("insert into sregister values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)");
                ps.setString(1, sname);
                ps.setString(2, sid);
                ps.setString(3, sphone);
                ps.setString(4, semail);
                ps.setString(5, sdep);
                ps.setString(6, ssem);
                ps.setString(7, sdob);
                ps.setString(8, sgender);
                ps.setString(9, saadhaar);               
                ps.setString(10, saddress);
                ps.setString(11, sphoto);
                ps.setString(12, scid);
                ps.setString(13, spwd);
                ps.setString(14, SSTATUS="pending");
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
     public String slogin(String sid, String spwd) {
        String status1 = "", id = "";
        String sname = "", sids = "",sphone="",semail="", sdep="",ssem="",sdob="",sgender="",saadhaar="",saddress="";

        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            rs = st.executeQuery("select * from sregister where sid='" + sid + "' and spwd='" + spwd + "' and sstatus='active';");
            boolean b = rs.next();
            if (b == true) {
                id = rs.getString("sslno");
                sname = rs.getString("sname");
                sids = rs.getString("sid");
                sphone = rs.getString("sphone");
                semail = rs.getString("semail");
                sdep = rs.getString("sdep");
                ssem = rs.getString("ssem");
                sdob = rs.getString("sdob");
                sgender = rs.getString("sgender");
                saadhaar = rs.getString("saadhaar");
                saddress = rs.getString("saddress");
                spwd = rs.getString("spwd");
                
                se.setAttribute("sname", sname);
                se.setAttribute("sid", sid);
                 se.setAttribute("sphone", sphone);
                 se.setAttribute("semail", semail);
                se.setAttribute("sdep", sdep);
                  se.setAttribute("ssem", ssem);
                se.setAttribute("sdob", sdob);
                se.setAttribute("sgender", sgender);
                se.setAttribute("saadhaar", saadhaar);
                se.setAttribute("saddress", saddress);
                se.setAttribute("spwd", spwd);
                se.setAttribute("id", id);
                se.setAttribute("type", "student");
                status1 = "success";
            } else {
                status1 = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status1;
    }
     public String adminlogin(String username, String password) {
        String status1 = "", id = "";
        String usernames = "", passwords = "";

        
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            rs = st.executeQuery("select * from adminlogin where username='" + username + "' and password ='" + password + "';");
            boolean b = rs.next();
            if (b == true) {
            id = rs.getString("aslno");
                usernames = rs.getString("username");
                passwords = rs.getString("password");
                se.setAttribute("username", username);
                se.setAttribute("password", password);
                se.setAttribute("id", id);
                se.setAttribute("type", "admin");
                status1 = "success";
            } else {
                status1 = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status1;
    }
      public ArrayList<student> getsUserDetails(){
         Statement st;
         ResultSet rs;
         ArrayList<student> a2 = new ArrayList<student>();
         try{
             st = con.createStatement();
             String qry = "select * from sregister  where SSTATUS='pending' and  sdep=(select hdep from hregister where hid='"+se.getAttribute("hid")+"' )";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 student stu = new  student();
                 stu.setid(rs.getString("sslno"));
                stu.setsname(rs.getString("sname"));
                stu.setsid(rs.getString("sid"));
                stu.setsphone(rs.getString("sphone"));
//             
                 a2.add(stu);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
     public String sdelete(int sslno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  sregister set sstatus='deleted' where sslno='" + sslno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
      public String sapprove(int sslno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  sregister set sstatus='active' where sslno='" + sslno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
       public ArrayList<faculty> getfUserDetails(){
         Statement st;
         ResultSet rs;
         ArrayList<faculty> a2 = new ArrayList<faculty>();
         try{
             st = con.createStatement();
             String qry = "select * from fregister  where FSTATUS='pending' and  fdep=(select hdep from hregister where hid='"+se.getAttribute("hid")+"' )";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 faculty fu = new  faculty();
                 fu.setid1(rs.getString("slno"));
                fu.setfname(rs.getString("fname"));
                fu.setfid(rs.getString("fid"));
                fu.setfphone(rs.getString("fphone"));
//             
                 a2.add(fu);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
       public String fdelete(int slno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  fregister set fstatus='deleted' where slno='" + slno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
      public String fapprove(int slno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  fregister set fstatus='active' where slno='" + slno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
       public ArrayList<hod> gethUserDetails(){
         ResultSet rs;
         Statement st;
         ArrayList<hod> a2 = new ArrayList<hod>();
         try{
             st = con.createStatement();
             String qry = "select * from hregister where HSTATUS='pending'";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 hod ho = new  hod();
                 ho.setid2(rs.getString("hslno"));
                ho.sethname(rs.getString("hname"));
                ho.sethid(rs.getString("hid"));
                ho.sethphone(rs.getString("hphone"));
//             
                 a2.add(ho);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
       public String hdelete(int hslno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  hregister set hstatus='deleted' where hslno='" + hslno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
      public String happrove(int hslno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  hregister set hstatus='active' where hslno='" + hslno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
      public ArrayList<principal> getpUserDetails(){
         Statement st;
         ResultSet rs;
         ArrayList<principal> a2 = new ArrayList<principal>();
         try{
             st = con.createStatement();
             String qry = "select * from pregister where PSTATUS='pending'";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 principal pri = new  principal();
                 pri.setid3(rs.getString("pslno"));
                pri.setpname(rs.getString("pname"));
                pri.setpid(rs.getString("pid"));
                pri.setpphone(rs.getString("pphone"));
//             
                 a2.add(pri);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
       public String pdelete(int pslno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  pregister set pstatus='deleted' where pslno='" + pslno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
      public String papprove(int pslno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  pregister set pstatus='active' where pslno='" + pslno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
      public pfaculty getpfUserDetails(){
         Statement st=null;
         ResultSet rs=null;
        pfaculty pf=null;
         try{
             st = con.createStatement();
             rs = st.executeQuery("select * from fregister");
             boolean b=rs.next();
             if(b==true){
                 pf=new pfaculty();
                pf.setfname(rs.getString("fname"));
                pf.setfid(rs.getString("fid"));
                pf.setfphone(rs.getString("fphone"));
                pf.setfemail(rs.getString("femail"));
                pf.setfdep(rs.getString("fdep"));
                pf.setfdob(rs.getString("fdob"));
                pf.setfgender(rs.getString("fgender"));
                pf.setfaadhaar(rs.getString("faadhaar"));
                pf.setfpan(rs.getString("fpan"));
                pf.setfaddress(rs.getString("faddress"));
                pf.setfpwd(rs.getString("fpwd"));
             }else{
                 pf=null;
             }
         }catch (Exception e){
             e.printStackTrace();
         }
          return pf;
     }
      public String fupdate(String fphone, String femail) {
        String status = "";
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            st.executeUpdate("update fregister set fphone='" + fphone + "',femail='" + femail +"' where slno='"+se.getAttribute("id")+"'" );
            status = "success";
        } catch (Exception e) {
            status = "failure";
            e.printStackTrace();
        }

        return status;
    }
       public  phod getphUserDetails(){
         Statement st=null;
         ResultSet rs=null;
        phod ph=null;
         try{
             st = con.createStatement();
             rs = st.executeQuery("select * from hregister");
             boolean b=rs.next();
             if(b==true){
                 ph=new  phod();
                ph.sethname(rs.getString("hname"));
                ph.sethid(rs.getString("hid"));
                ph.sethphone(rs.getString("hphone"));
                ph.sethemail(rs.getString("hemail"));
                ph.sethdep(rs.getString("hdep"));
                ph.sethdob(rs.getString("hdob"));
                ph.sethgender(rs.getString("hgender"));
                ph.sethaadhaar(rs.getString("haadhaar"));
                ph.sethpan(rs.getString("hpan"));
                ph.sethaddress(rs.getString("haddress"));
                ph.sethpwd(rs.getString("hpwd"));
             }else{
                 ph=null;
             }
         }catch (Exception e){
             e.printStackTrace();
         }
          return ph;
     }
      public String hupdate(String hphone, String hemail) {
        String status = "";
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            st.executeUpdate("update hregister set hphone='" + hphone + "',hemail='" + hemail +"' where hslno='"+se.getAttribute("id")+"'" );
            
            status = "success";
        } catch (Exception e) {
            status = "failure";
            e.printStackTrace();
        }

        return status;
    }
      public  pprincipal getppUserDetails(){
         Statement st=null;
         ResultSet rs=null;
        pprincipal pp=null;
         try{
             st = con.createStatement();
             rs = st.executeQuery("select * from pregister");
             boolean b=rs.next();
             if(b==true){
                 pp=new  pprincipal();
                pp.setpname(rs.getString("pname"));
                pp.setpid(rs.getString("pid"));
                pp.setpphone(rs.getString("pphone"));
                pp.setpemail(rs.getString("pemail"));
//                pp.setpdep(rs.getString("pdep"));
                pp.setpdob(rs.getString("pdob"));
                pp.setpgender(rs.getString("pgender"));
                pp.setpaadhaar(rs.getString("paadhaar"));
                pp.setppan(rs.getString("ppan"));
                pp.setpaddress(rs.getString("paddress"));
                pp.setppwd(rs.getString("ppwd"));
             }else{
                 pp=null;
             }
         }catch (Exception e){
             e.printStackTrace();
         }
          return pp;
     }
      public String pupdate(String pphone, String pemail) {
        String status = "";
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            st.executeUpdate("update pregister set pphone='" + pphone + "',pemail='" + pemail +"' where pslno='"+se.getAttribute("id")+"'" );            
            status = "success";
        } catch (Exception e) {
            status = "failure";
            e.printStackTrace();
        }

        return status;
    }
      public pstudent getpsUserDetails(){
         Statement st=null;
         ResultSet rs=null;
        pstudent ps=null;
         try{
             st = con.createStatement();
             rs = st.executeQuery("select * from sregister");
             boolean b=rs.next();
             if(b==true){
                 ps=new pstudent();
                ps.setsname(rs.getString("sname"));
                ps.setsid(rs.getString("sid"));
                ps.setsphone(rs.getString("sphone"));
                ps.setsemail(rs.getString("semail"));
                ps.setsdep(rs.getString("sdep"));
                 ps.setssem(rs.getString("ssem"));
                ps.setsdob(rs.getString("sdob"));
                ps.setsgender(rs.getString("sgender"));
                ps.setsaadhaar(rs.getString("saadhaar"));
               
                ps.setsaddress(rs.getString("saddress"));
                ps.setspwd(rs.getString("spwd"));
             }else{
                 ps=null;
             }
         }catch (Exception e){
             e.printStackTrace();
         }
          return ps;
     }
      public String supdate(String sphone, String semail,String ssem) {
        String status = "";
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            st.executeUpdate("update sregister set sphone='" + sphone + "',semail='" + semail +"',ssem='" + ssem +"' where sslno='"+se.getAttribute("id")+"'" );
            status = "success";
        } catch (Exception e) {
            status = "failure";
            e.printStackTrace();
        }

        return status;
    }
      //create exam
      
      public String examregistration(String fname,String fid,String fdep,String examtitle, String subjectname, String semester, String exampattern, String writingarea, String drawingtool, String scan, String security,String  noq,String  subcode,String  duration,String  STATUS ) {
        PreparedStatement ps;
        String status = "";
        int examid=0;
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            
        
                ps = (PreparedStatement) con.prepareStatement("insert into createexam values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())");
                 
               ps.setString(1, fname);
                ps.setString(2, fid);
                ps.setString(3, fdep);
                ps.setString(4, examtitle);
                ps.setString(5, subjectname);
                ps.setString(6, semester);
                ps.setString(7, exampattern);
                ps.setString(8, writingarea);
                ps.setString(9, drawingtool);
                ps.setString(10, scan);
                ps.setString(11, security);
                 ps.setString(12, noq);
                  ps.setString(13, subcode);
               ps.setString(14, duration); 
                ps.setString(15, STATUS="pending");
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
                 examid=0;
                rs=st.executeQuery("select LAST_INSERT_ID() AS examid");
                while(rs.next()){
                   examid=rs.getInt("examid");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status+"@"+examid;
    }
       public String uploadpdfmod( String fid,String doc,String dname) {
        PreparedStatement ps;
       String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            ps = (PreparedStatement) con.prepareStatement("insert into uploadpdf values(0,?,?,now(),?)");
            ps.setString(1, fid);
            ps.setString(2, doc);
            ps.setString(3, dname);
            int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
       //store input
//        public String noqmod( String noq) {
//        PreparedStatement ps;
//       String status = "";
//        try {
//            Statement st = null;
//            ResultSet rs = null;
//            st = con.createStatement();
//
//            ps = (PreparedStatement) con.prepareStatement("insert into noque values(0,?)");
//            ps.setString(1, noq);
//            int a = ps.executeUpdate();
//                if (a > 0) {
//                    status = "success";
//                } else {
//                    status = "failure";
//                }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return status;
//    }
//        public String noqse(String noq) {
//        String status1 = "", id = "";
//        String noqs = "";
//
//        try {
//            Statement st = null;
//            ResultSet rs = null;
//            st = con.createStatement();
//
//            rs = st.executeQuery("select * from noque;");
//            boolean b = rs.next();
//            if (b == true) {
//                id = rs.getString("noqslno");
//                noqs = rs.getString("noq");
//                se.setAttribute("noq", noq);
//                se.setAttribute("id", id);
//                status1 = "success";
//            } else {
//                status1 = "failure";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return status1;
//    }
        //All created exams list but not yet hosted
        public ArrayList<exam> getexamDetails(){
         Statement st;
         ResultSet rs;
         ArrayList<exam> a2 = new ArrayList<exam>();
         try{
             st = con.createStatement();
             String qry = "select * from createexam where STATUS='pending' ";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 exam e = new  exam();
                 e.setid(rs.getString("cslno"));
                e.setsubjectname(rs.getString("subjectname"));
                e.setsemester(rs.getString("semester"));
                e.setexampattern(rs.getString("exampattern"));
//             
                 a2.add(e);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
        //fac side pending exam to active status
         public String f_pendingtohost(int cslno) {
        int count = 0;
        Statement st = null;
        String status = "";
        try {
            st = con.createStatement();
            count = st.executeUpdate("update  createexam set STATUS='active' where cslno='" + cslno + "'");
            if (count > 0) {
                status = "success";
            } else {
                status = "failure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
        // hosted exam in faculty side
        public ArrayList<exam> gethostedexamDetails(){
         Statement st;
         ResultSet rs;
         ArrayList<exam> a2 = new ArrayList<exam>();
         try{
             st = con.createStatement();
             String qry = "select * from createexam where STATUS='active' ";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 exam e = new  exam();
                 e.setid(rs.getString("cslno"));
                e.setsubjectname(rs.getString("subjectname"));
                e.setsemester(rs.getString("semester"));
                e.setexampattern(rs.getString("exampattern"));
//             
                 a2.add(e);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
        public String sassignmentmod( String sid,String sdoc) {
        PreparedStatement ps;
       String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            ps = (PreparedStatement) con.prepareStatement("insert into sassignment values(0,?,?,now())");
            ps.setString(1, sid);
            ps.setString(2, sdoc);
            int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
        //        create assignment
        
         public String asgnregistration(String  fname,String fid,String fdep,String asgntitle, String asubjectname, String asemester, String asgnpattern) {
        PreparedStatement ps;
        String status = "";
        
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            
        
                ps = (PreparedStatement) con.prepareStatement("insert into fcassignment values(0,?,?,?,?,?,?,?,now())");
               ps.setString(1, fname);
                ps.setString(2, fid);
                ps.setString(3, fdep);
                ps.setString(4, asgntitle);
                ps.setString(5, asubjectname);
                ps.setString(6, asemester);
                ps.setString(7, asgnpattern);
                
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
           

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
         //assignment mod uploadpdf
         
          public String auploadpdfmod( String fid,String adoc) {
        PreparedStatement ps;
       String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            ps = (PreparedStatement) con.prepareStatement("insert into auploadpdf values(0,?,?)");
            ps.setString(1, fid);
            ps.setString(2, adoc);
            int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
//          assignment que mod
  public String aquestionmod( String aque) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();

            ps = (PreparedStatement) con.prepareStatement("insert into aquestion values(0,?)");
        
            ps.setString(1, aque);
            int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
  //details
  public ArrayList<phoddetails> getphoddetailsUserDetails(){
         ResultSet rs;
         Statement st;
         ArrayList<phoddetails> a2 = new ArrayList<phoddetails>();
         try{
             st = con.createStatement();
             String qry = "select * from hregister where HSTATUS='active'";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 phoddetails ho = new  phoddetails();
                 ho.setid1(rs.getString("hslno"));
                ho.sethname(rs.getString("hname"));
                ho.sethid(rs.getString("hid"));
                 ho.sethdep(rs.getString("hdep"));
               ho.sethemail(rs.getString("hemail"));
                ho.sethphone(rs.getString("hphone"));
//             
                 a2.add(ho);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
    public ArrayList<pfacultydetails> getpfacultydetailsUserDetails(){
         ResultSet rs;
         Statement st;
         ArrayList<pfacultydetails> a2 = new ArrayList<pfacultydetails>();
         try{
             st = con.createStatement();
             String qry = "select * from fregister where FSTATUS='active'";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 pfacultydetails fo = new  pfacultydetails();
                 fo.setid2(rs.getString("slno"));
                fo.setfname(rs.getString("fname"));
                fo.setfid(rs.getString("fid"));
                 fo.setfdep(rs.getString("fdep"));
               fo.setfemail(rs.getString("femail"));
                fo.setfphone(rs.getString("fphone"));
//             
                 a2.add(fo);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
    public ArrayList<pstudentdetails> getpstudentdetailsUserDetails(){
         ResultSet rs;
         Statement st;
         ArrayList<pstudentdetails> a2 = new ArrayList<pstudentdetails>();
         try{
             st = con.createStatement();
             String qry = "select * from sregister where SSTATUS='active'";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 pstudentdetails so = new  pstudentdetails();
                 so.setid3(rs.getString("sslno"));
                so.setsname(rs.getString("sname"));
                so.setsid(rs.getString("sid"));
                 so.setsdep(rs.getString("sdep"));
               so.setsemail(rs.getString("semail"));
                so.setsphone(rs.getString("sphone"));
//             
                 a2.add(so);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }
    
    //student forgot password
    
    public String FetchNameByEmail(String semail) {
        String name = "", update = "";
        ResultSet rs = null;
        try {
            update = "select sid,sname from sregister where semail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, semail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                name = rs.getString("sid") + "__" + rs.getString("sname");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }

    //------------ Check validate email  --------------- 
    public int ValidateEmail(String semail) {
        int count = 0;
        ResultSet rs;
        try {
            String update = "select semail from sregister where semail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, semail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public int PasswordTrack(String id, String name, String email, String password) {
        int status = 0;

        try {
            String qry = "insert into passwordtrack values(?,?,?,?,?,now());";
            PreparedStatement preparedstatement = null;
            preparedstatement = (PreparedStatement) con.prepareStatement(qry);
            preparedstatement.setInt(1, 0);
            preparedstatement.setString(2, id);
            preparedstatement.setString(3, name);
            preparedstatement.setString(4, email);
            preparedstatement.setString(5, password);
            status = preparedstatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    //-----------------Insert Score Data in score_t1----------------

    public pstudent GetPasswordTrackDetails(String email, String code) {
        pstudent s = new pstudent();
        try {
            ResultSet rs = null;
            Statement statement = null;
            statement = (Statement) con.createStatement();
            rs = statement.executeQuery("select * from passwordtrack where semail= '" + email + "'  and spassword='" + code + "'order by date desc limit 1;");
            while (rs.next()) {
                s.setsname(rs.getString("sname"));
                s.setsemail(rs.getString("semail"));
                s.setspassword(rs.getString("spassword"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public int UpdatePasswordInPassTrack(String uemailMobile, String scode, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE passwordtrack SET spassword =? WHERE semail =? and spassword=?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemailMobile);
            preparedstatement1.setString(3, scode);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // ---------------Update user Password and password_date-----------------------
    public int UpdatePassword(String uemail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE sregister SET spwd =? WHERE semail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public void SendMail(String msg, String subject,String semail) {
        String from = "harshakumarm20@gmail.com";
        String password = "Harsham3";
        String to = semail;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(msg,"text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
     //faculty forgot password
    
    public String FetchFacNameByEmail(String femail) {
        String name = "", update = "";
        ResultSet rs = null;
        try {
            update = "select fid,fname from fregister where femail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, femail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                name = rs.getString("fid") + "__" + rs.getString("fname");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }

    //------------ Check validate email  --------------- 
    public int FacValidateEmail(String femail) {
        int count = 0;
        ResultSet rs;
        try {
            String update = "select femail from fregister where femail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, femail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public int FacPasswordTrack(String id, String name, String email, String password) {
        int status = 0;

        try {
            String qry = "insert into facpasswordtrack values(?,?,?,?,?,now());";
            PreparedStatement preparedstatement = null;
            preparedstatement = (PreparedStatement) con.prepareStatement(qry);
            preparedstatement.setInt(1, 0);
            preparedstatement.setString(2, id);
            preparedstatement.setString(3, name);
            preparedstatement.setString(4, email);
            preparedstatement.setString(5, password);
            status = preparedstatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    //-----------------Insert Score Data in score_t1----------------

    public pfaculty FacGetPasswordTrackDetails(String email, String code) {
        pfaculty f = new pfaculty();
        try {
            ResultSet rs = null;
            Statement statement = null;
            statement = (Statement) con.createStatement();
            rs = statement.executeQuery("select * from facpasswordtrack where femail= '" + email + "'  and fpassword='" + code + "'order by date desc limit 1;");
            while (rs.next()) {
                f.setfname(rs.getString("fname"));
                f.setfemail(rs.getString("femail"));
                f.setfpassword(rs.getString("fpassword"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public int FacUpdatePasswordInPassTrack(String uemailMobile, String scode, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE facpasswordtrack SET fpassword =? WHERE femail =? and fpassword=?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemailMobile);
            preparedstatement1.setString(3, scode);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // ---------------Update user Password and password_date-----------------------
    public int FacUpdatePassword(String uemail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE fregister SET fpwd =? WHERE femail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public void FacSendMail(String msg, String subject,String femail) {
        String from = "harshakumarm20@gmail.com";
        String password = "Harsham3";
        String to = femail;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(msg,"text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    //HOD forgot password
    
    public String FetchHODNameByEmail(String hemail) {
        String name = "", update = "";
        ResultSet rs = null;
        try {
            update = "select hid,hname from hregister where hemail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, hemail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                name = rs.getString("hid") + "__" + rs.getString("hname");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }

    //------------ Check validate email  --------------- 
    public int HODValidateEmail(String hemail) {
        int count = 0;
        ResultSet rs;
        try {
            String update = "select hemail from hregister where hemail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, hemail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public int HODPasswordTrack(String id, String name, String email, String password) {
        int status = 0;

        try {
            String qry = "insert into hodpasswordtrack values(?,?,?,?,?,now());";
            PreparedStatement preparedstatement = null;
            preparedstatement = (PreparedStatement) con.prepareStatement(qry);
            preparedstatement.setInt(1, 0);
            preparedstatement.setString(2, id);
            preparedstatement.setString(3, name);
            preparedstatement.setString(4, email);
            preparedstatement.setString(5, password);
            status = preparedstatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    //-----------------Insert Score Data in score_t1----------------

    public phod HODGetPasswordTrackDetails(String email, String code) {
        phod h = new phod();
        try {
            ResultSet rs = null;
            Statement statement = null;
            statement = (Statement) con.createStatement();
            rs = statement.executeQuery("select * from hodpasswordtrack where hemail= '" + email + "'  and hpassword='" + code + "'order by date desc limit 1;");
            while (rs.next()) {
                h.sethname(rs.getString("hname"));
                h.sethemail(rs.getString("hemail"));
                h.sethpassword(rs.getString("hpassword"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h;
    }

    public int HODUpdatePasswordInPassTrack(String uemailMobile, String scode, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE hodpasswordtrack SET hpassword =? WHERE hemail =? and hpassword=?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemailMobile);
            preparedstatement1.setString(3, scode);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // ---------------Update user Password and password_date-----------------------
    public int HODUpdatePassword(String uemail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE hregister SET hpwd =? WHERE hemail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public void HODSendMail(String msg, String subject,String hemail) {
        String from = "harshakumarm20@gmail.com";
        String password = "Harsham3";
        String to = hemail;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(msg,"text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    //Principal forgot password
    
    public String FetchPNameByEmail(String pemail) {
        String name = "", update = "";
        ResultSet rs = null;
        try {
            update = "select pid,pname from pregister where pemail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, pemail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                name = rs.getString("pid") + "__" + rs.getString("pname");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }

    //------------ Check validate email  --------------- 
    public int PValidateEmail(String pemail) {
        int count = 0;
        ResultSet rs;
        try {
            String update = "select pemail from pregister where pemail=?";
            PreparedStatement preparedstatement1 = null;
            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
            preparedstatement1.setString(1, pemail);
            rs = preparedstatement1.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public int PPasswordTrack(String id, String name, String email, String password) {
        int status = 0;

        try {
            String qry = "insert into ppasswordtrack values(?,?,?,?,?,now());";
            PreparedStatement preparedstatement = null;
            preparedstatement = (PreparedStatement) con.prepareStatement(qry);
            preparedstatement.setInt(1, 0);
            preparedstatement.setString(2, id);
            preparedstatement.setString(3, name);
            preparedstatement.setString(4, email);
            preparedstatement.setString(5, password);
            status = preparedstatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    //-----------------Insert Score Data in score_t1----------------

    public pprincipal PGetPasswordTrackDetails(String email, String code) {
        pprincipal p = new pprincipal();
        try {
            ResultSet rs = null;
            Statement statement = null;
            statement = (Statement) con.createStatement();
            rs = statement.executeQuery("select * from ppasswordtrack where pemail= '" + email + "'  and ppassword='" + code + "'order by date desc limit 1;");
            while (rs.next()) {
                p.setpname(rs.getString("pname"));
                p.setpemail(rs.getString("pemail"));
                p.setppassword(rs.getString("ppassword"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public int PUpdatePasswordInPassTrack(String uemailMobile, String scode, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE ppasswordtrack SET ppassword =? WHERE pemail =? and ppassword=?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemailMobile);
            preparedstatement1.setString(3, scode);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // ---------------Update user Password and password_date-----------------------
    public int PUpdatePassword(String uemail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE pregister SET ppwd =? WHERE pemail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, uemail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public void PSendMail(String msg, String subject,String pemail) {
        String from = "harshakumarm20@gmail.com";
        String password = "Harsham3";
        String to = pemail;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(msg,"text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    // student update password in profile
   // ---------------Update user Password and password_date-----------------------
    public int UpdateNewPassword(String semail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE sregister SET spwd =? WHERE semail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, semail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    // faculty update password in profile
   // ---------------Update user Password and password_date-----------------------
    public int UpdateNewFacPassword(String femail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE fregister SET fpwd =? WHERE femail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, femail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
     // HOD update password in profile
   // ---------------Update user Password and password_date-----------------------
    public int UpdateNewHODPassword(String hemail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE hregister SET hpwd =? WHERE hemail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, hemail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    // Principal update password in profile
   // ---------------Update user Password and password_date-----------------------
    public int UpdateNewPriPassword(String pemail, String password) {
        int status = 0;
        String update = "";
        try {
            update = "UPDATE pregister SET ppwd =? WHERE pemail =?;";
            java.sql.PreparedStatement preparedstatement1 = null;
            preparedstatement1 = con.prepareStatement(update);
            preparedstatement1.setString(1, password);
            preparedstatement1.setString(2, pemail);
            status = preparedstatement1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    //question download
     public  ssquestion getquestiontopdf(){
         Statement st=null;
         ResultSet rs=null;
        ssquestion pp=null;
         try{
             st = con.createStatement();
             rs = st.executeQuery("select * from questiondes");
             boolean b=rs.next();
             if(b==true){
                 pp=new ssquestion();
              
                pp.setque(rs.getString("que"));
              
                
             }else{
                 pp=null;
             }
         }catch (Exception e){
             e.printStackTrace();
         }
          return pp;
     }
    // hosted exam details
    public ArrayList<Hexamlist> getHexamdetails(){
         ResultSet rs;
         Statement st;
         ArrayList<Hexamlist> a2 = new ArrayList<Hexamlist>();
         try{
             st = con.createStatement();
             String qry = "select * from createexam  where STATUS='active'";
             rs = st.executeQuery(qry);
             while(rs.next()){
                 Hexamlist hel = new  Hexamlist();
                 hel.setid4(rs.getString("cslno"));
                hel.setsubcode(rs.getString("subcode"));
                hel.setsubjectname(rs.getString("subjectname"));
                hel.setduration(rs.getString("duration"));
//             
                 a2.add(hel);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return a2;
     }

    
}




