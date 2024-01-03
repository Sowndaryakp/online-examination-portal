///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package model;
//
///**
// *
// * @author niranjanprasad M
// */
//public class Registration1 {
//    
//    
//    public String FetchNameByEmail(String uemailMobile) {
//        String name = "", update = "";
//        ResultSet rs = null;
//        try {
//            update = "select id,name from userdata where email=?";
//            PreparedStatement preparedstatement1 = null;
//            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
//            preparedstatement1.setString(1, uemailMobile);
//            rs = preparedstatement1.executeQuery();
//            while (rs.next()) {
//                name = rs.getString("id") + "__" + rs.getString("name");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return name;
//    }
//
//    //------------ Check validate email  --------------- 
//    public int ValidateEmail(String uemail) {
//        int count = 0;
//        ResultSet rs;
//        try {
//            String update = "select email from userdata where email=?";
//            PreparedStatement preparedstatement1 = null;
//            preparedstatement1 = (PreparedStatement) con.prepareStatement(update);
//            preparedstatement1.setString(1, uemail);
//            rs = preparedstatement1.executeQuery();
//            while (rs.next()) {
//                count++;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return count;
//    }
//
//    public int PasswordTrack(String id, String name, String email, String password) {
//        int status = 0;
//
//        try {
//            String qry = "insert into passwordtrack values(?,?,?,?,?,now());";
//            PreparedStatement preparedstatement = null;
//            preparedstatement = (PreparedStatement) con.prepareStatement(qry);
//            preparedstatement.setInt(1, 0);
//            preparedstatement.setString(2, id);
//            preparedstatement.setString(3, name);
//            preparedstatement.setString(4, email);
//            preparedstatement.setString(5, password);
//            status = preparedstatement.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return status;
//    }
//    //-----------------Insert Score Data in score_t1----------------
//
//    public User GetPasswordTrackDetails(String email, String code) {
//        User s = new User();
//        try {
//            ResultSet rs = null;
//            Statement statement = null;
//            statement = (Statement) con.createStatement();
//            rs = statement.executeQuery("select * from passwordtrack where email= '" + email + "'  and password='" + code + "'order by date desc limit 1;");
//            while (rs.next()) {
//                s.setname(rs.getString("name"));
//                s.setemail(rs.getString("email"));
//                s.setpw(rs.getString("password"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return s;
//    }
//
//    public int UpdatePasswordInPassTrack(String uemailMobile, String scode, String password) {
//        int status = 0;
//        String update = "";
//        try {
//            update = "UPDATE passwordtrack SET password =? WHERE email =? and password=?;";
//            java.sql.PreparedStatement preparedstatement1 = null;
//            preparedstatement1 = con.prepareStatement(update);
//            preparedstatement1.setString(1, password);
//            preparedstatement1.setString(2, uemailMobile);
//            preparedstatement1.setString(3, scode);
//            status = preparedstatement1.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return status;
//    }
//
//    // ---------------Update user Password and password_date-----------------------
//    public int UpdatePassword(String uemail, String password) {
//        int status = 0;
//        String update = "";
//        try {
//            update = "UPDATE userdata SET pw =? WHERE email =?;";
//            java.sql.PreparedStatement preparedstatement1 = null;
//            preparedstatement1 = con.prepareStatement(update);
//            preparedstatement1.setString(1, password);
//            preparedstatement1.setString(2, uemail);
//            status = preparedstatement1.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return status;
//    }
//
//    public void SendMail(String msg, String subject,String email) {
//        String from = "abc@gmail.com";
//        String password = "123456";
//        String to = email;
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(from, password);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject(subject);
//            message.setContent(msg,"text/html");
//            Transport.send(message);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    
//}
