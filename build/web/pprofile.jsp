<%@page import="model.pprincipal"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    

    <head>
        <title>principal Profile Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <style>
             @import url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap');
            *{
                margin:0;
                padding: 0;
                font-family: "Josafin Slab",serif;
            }
            .form-control{
                width: 65%;
            }
            select {
                display: block;
                width: 100%;
                height: 34px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-shadow: 0 1px 1px rgba(0,0,0,.075);
            }
            .button-1{
                width:25%;
                border: none;
                border-radius: 4px;
                color: white;
                display: block;
                padding: 12px;
                font-size: 16px;
                background-color: cornflowerblue;

            }
            .button-1:hover{
                background-color: #2691d9;
            }
            
              .error{   
                color:red;
            }
            input{
                display: block;
            }
            #msg
            {
                background: red;
                color:black;
                border: 1px solid red;
                width:24%;
                font-weight: bold;
                font-size: 25px;
                padding: 5px;
            }
             .errmsg{
                background: lightgreen;
                padding: 6px;
                width: 40%;
                color: white;
                font-weight: bold;
                text-align: center;
                margin-left: 450px;
                margin-top: -30px;
                margin-bottom: 50px;
            }
            .jumbotron{
                background-color: white;
            }

        </style>

    </head>
    <body>
          <%@include file="dashboardheader.jsp"%>

          <br><br>
         <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%>
        
        <% if (session.getAttribute("pname")!=null){
            Registration reg = new Registration(session);
            pprincipal pp = reg.getppUserDetails();
//                            
//                            ArrayList<pfaculty> mydata = reg.getpfUserDetails();
//                              ArrayList<pfaculty> a2 = new ArrayList<pfaculty>();
//
////                            Iterator<pfaculty> itr = mydata.iterator();
////                            while (itr.hasNext()) {
////                                pfaculty pf = itr.next();
                        %>
     <div class="container">
            <div class="row col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">

                        <h2 style="text-align:center">Profile</h2>

                    </div>
                    <div class="panel-body" style="padding-left: 60px; padding-right: 70px; padding-top: 20px; ">

                         <div>
                                <img src="uploadimages/id-<%=session.getAttribute("pid")%>.png" height="180"  name="photo" id="img" class="imgcls" style="float:right;border:2px solid black; ">
                            </div>

                        <form method="post" action="pupdate"> 

                        
                        <div class="form-group">
                                <label>principal Name</label>
                                <input   class="form-control" name="pname" value="<%=pp.getpname()%>" disabled/> <br>
                            </div>
                           
                            <div class="form-group">
                                <label>principal ID</label>
                                <input  class="form-control"  id="pid" name="pid" value="<%=pp.getpid()%>" disabled/> <br>
                            </div>

                            <div class="form-group">
                                <label>Phone Number</label> 
                                <input  class="form-control" type="tel" id="pphone" name="pphone" value="<%=pp.getpphone()%>"  /><br>
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                
                                <input  class="form-control" type="email" id="pemail" name="pemail" value="<%=pp.getpemail()%>"  />
                            </div>

<!--                           


-->                            <div class="form-group">
                                <label>Date of Birth</br></label>
                                <input  class="form-control"  id="pdob" name="pdob" value="<%=pp.getpdob()%>"  disabled/> <br>
                            </div> 


                            <div class="form-group">  
                                <label>Gender</label>
                                <div>
                             <input  class="form-control" type="text" id="pgender" name="pgender" value="<%=pp.getpgender()%>"  disabled/> <br>
                                </div>
                            </div>


                            <div class="form-group">
                                <label>Aadhaar Number</label>  
                                <input  class="form-control" type="tel" id="paadhaar" name="paadhaar" value="<%=pp.getpaadhaar()%>" disabled/> <br>
                            </div>

                            <div class="form-group">
                                <label>PAN Card</label>
                                <input  class="form-control" type="text" id="ppan" name="ppan" value="<%=pp.getppan()%>" disabled/> <br>
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <input  class="form-control"  id="faddress" name="paddress" value="<%=pp.getpaddress()%>" disabled> <br>

                            </div>
                            
                            <div class="form-group">
                                <label>Change Password</label> 
                                <a href="PriPasswordUpdate.jsp" title="Change Password" style="float: right;margin-right: 650px;" class="" data-icon=""><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                </svg></a>
                                <input class="form-control" type="password" id="ppwd" name="ppwd" value="<%=pp.getppwd()%>" disabled /><br>
                            </div>
                            <center>
                            <div class="form-group">
                                <button class="button-1" type="submit" name="submit"> Update</button>
                                <!--<a class="btn btn-success" name="submit" href ="fupdate?update=yes">Update</a>-->
                            </div>
                            </center>
                        </form>
                    </div>
                    
               </div>
            </div>
        </div>
                            <%}%>
                            <br><br>
                             <%@include file="footer.jsp"%>
                </body>
                </html>