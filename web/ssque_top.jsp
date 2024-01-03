<%@page import="model.ssquestion"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    

    <head>
        <style>
            .containerleft{
                background-color: white;
                padding:10px;
                width: 100%;
                
                margin-top: -120px;
                margin-bottom: -120px;
/*                margin-top: -100px;*/
/*                border-radius: 5px;
                box-shadow:1px 1px 10px grey; */
            }
             .pdf{
                width:100%;
                height: 100%;
                height:500px;
                padding: 0px;

            }
            .header {
                padding: 10px;
                float: left;
                width: 80%;
                font-size: 40px;
                text-align: center;
                background: white;
            }
        </style>
        <title>spiltscreen top</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
<!--        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        -->
    </head>
    <body>
         

          <br><br>
         <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%>
        
        <% if (session.getAttribute("sid")!=null){
            Registration reg = new Registration(session);
            ssquestion pp = reg.getquestiontopdf();
//                            
//                            ArrayList<pfaculty> mydata = reg.getpfUserDetails();
//                              ArrayList<pfaculty> a2 = new ArrayList<pfaculty>();
//
////                            Iterator<pfaculty> itr = mydata.iterator();
////                            while (itr.hasNext()) {
////                                pfaculty pf = itr.next();
                        %>
     <div class="containerleft" >
                 
            <iframe title="result frame" class="pdf" id="pdf" name="pdf" src="fac_exam_que/BDA1.pdf"></iframe>

        </div>
                            <%}%>
                            <br><br>
                </body>
                </html>
