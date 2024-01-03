<%-- 
    Document   : FacPasswordUpdate
    Created on : Jul 18, 2021, 7:06:29 PM
    Author     : niranjanprasad M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty Password Update</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <style>
            .container{
                max-width: 550px;
                background: #676d12;
                color: white;
                padding: 2rem 2rem;
                margin-top: 100px;
            }
            .error{
                color:red;
            }
            .status{
                background: #6b170a;
                color: white;
                text-align: center;
                margin: 20px;
                font-weight: bold;
                font-size: 20px;
            }
            nav{
                width: 100%; height: 14vh;
                background: rgb(0 0 0 / 58%);
                color: white; 
                display: flex; 
                justify-content: space-between;
                align-items: center;
                text_transform: uppercase;
            }
            /*            nav .logo{
                           align:center;
                            
                        }*/
            nav .logo-text{
                width: 25%; 
                text-align: center;
                position: relative;

            }
            nav .menu{
                width: 70%; 
                height: 5vh;
                font-size: 20px;
                display: flex; 
                justify-content: flex-end;               
            } 
            nav .menu a{
                width: 10%;
                text-decoration: none;                
                color: white;
                font-weight: bold;
            }
        </style>

    </head>

    <body>


        <!--        <nav>
                    <div class="logo"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px;margin-left: 2px;margin-top: -1px;'></div>
                    <div class="logo-text" ><h3 > G.MADEGOWDA INSTITUTE OF TECHNOLOGY </h3> </div>
                    <div class="menu">                                              
                        <a href="index.jsp">Home</a>
                        <a href="http://gmitmandya.in">About us</a> 
                    </div>
                </nav>-->

        <%if (request.getAttribute("status") != null) {%>
        <div class="status"><%=request.getAttribute("status")%></div>
        <%}%>
        <div class="container" >
            <!--<div class="jumbotron">-->


            <%if (session.getAttribute("npuname") != null || session.getAttribute("fid") != null) {%>
            <form id="newpass" method="post" action="Register">
                <!--<div class="forgot">-->
                <center> <span style="font-size: 29px;font-weight: bold;">Enter Your Password</span>
                    <div class="form-group" style="margin-top: 10px;">
                        <div>
                            <input id="current_password" class="form-control" style="width:50%" type="password" placeholder="Current Password" name="current_password"> 
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <div>
                            <input id="n_password" class="form-control" style="width:50%" type="password" placeholder="New Password" name="n_password"> 
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <input id="c_password" class="form-control" style="width:50%" type="password" placeholder="Confirm New Password" name="c_password"> 
                        </div>
                    </div>
                    <div class="form-group">
                        <div  style="width:100%">
                            <input type="submit" name="FacPasswordUpdate" value="Submit" >
                        </div>
                    </div> </center>
<!--                    </div>-->
            </form>  
            <%} else {
                    RequestDispatcher rd = request.getRequestDispatcher("fprofile.jsp");
                    rd.forward(request, response);
                }%>
        </div>

        <script>
            jQuery(document).ready(function ($) {
                $("#newpass").validate({
                    ignore: [],
                    rules: {
                        current_password: {
                            required: true,
                            minlength:6
                        },
                        n_password: {
                            required: true,
                            minlength: 6
                        },
                        c_password: {
                            required: true,
                            equalTo: "#n_password"
                        }
                    }
                });
            });
        </script>
        <%@include file="footer.jsp"%>
    </body>
</html>


