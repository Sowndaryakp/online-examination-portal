<%-- 
    Document   : hosted_asgn
    Created on : Aug 11, 2021, 11:15:57 PM
    Author     : niranjanprasad M
--%>


<%@page import="model.hod"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hosted Assignments</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <style>
            .errmsg{
                background: green;
                padding: 6px;
                width: 50%;
                color: white;
                font-weight: bold;
            }
            .jumbotron{
                background-color: white;
                box-shadow:1px 1px 10px grey; 
                border-radius: 5px; 
            }
            /*        #search
                    {
                        width: 50%; 
                    }*/

        </style>
    </head>
    <body>
        <%@include file="dashboardheader.jsp"%>
    <center>

        <br>

        <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%>
        <div class="container ">
            <div class="jumbotron">
                <font color="black" size="6" style="margin:2px;">
                Hosted Assignments List
                </font>
                <!--                 <input class="form-control" id="search" type="text" placeholder="Search..">-->
                <table class="table" style="margin-top:20px;">
                    <thead>
                        <tr style="background-color: lightblue;">
                    <br>
                    <th>Slno</th>
                    <th>SUB_code</th>
                    <th>SUB_name</th>
                    <th>Submission Date</th>
                    

                    <th>Action</th>
                    <th></th>
                    </tr>
                    </thead>
                    <tbody id="table">
                       <tr>
                    <td>1.</td>
                    
                    <td>17CS81</td>
                    <td>IOT</td>
                    <td>15/08/2021</td>
                            <td>
                                <a class="btn btn-primary" href ="swassignment.jsp">Write</a>     

                            </td>
                            <td>
                                <a class="btn btn-primary" href ="sassignment.jsp">upload</a>     

                            </td>
                            </tr>
                            
                             <tr>
                    <td>2.</td>
                    
                    <td>17CS82</td>
                    <td>BDA</td>
                    <td>13/08/2021</td>
                            <td>
                                <a class="btn btn-primary" href ="swassignment.jsp">Write</a>     

                            </td>
                            <td>
                                <a class="btn btn-primary" href ="sassignment.jsp">upload</a>     

                            </td>
                            </tr>
                            
                            <tr>
                    <td>3.</td>
                    
                    <td>17CS833</td>
                    <td>NM</td>
                    <td>17/08/2021</td>
                            <td>
                                <a class="btn btn-primary" href ="swassignment.jsp">Write</a>     

                            </td>
                            <td>
                                <a class="btn btn-primary" href ="sassignment.jsp">upload</a>     

                            </td>
                            </tr>
                            
                            
                    </tbody>
                </table>
            </div>
        </div>                      
    </center>

    <script>
        $(document).ready(function () {
            $("#search").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#table tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > 0);
                });
            });
        });
    </script>
    <%@include file="footer.jsp"%>
</body>
</html>
