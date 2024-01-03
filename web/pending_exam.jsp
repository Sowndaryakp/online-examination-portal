<%-- 
    Document   : pending_exam
    Created on : Jul 16, 2021, 3:19:44 PM
    Author     : niranjanprasad M
--%>

<%@page import="model.exam"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>qp</title>
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
        <font color="black" size="6">
        Pending Exam Details
        </font>
        <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%>
        <div class="container ">
            <div class="jumbotron">
                <!--                 <input class="form-control" id="search" type="text" placeholder="Search..">-->
                <table class="table">
                    <thead>
                        <tr style="background-color: lightblue;">
                    <br>
                    <th>Slno</th>
                    <th>Subject</th>
                    <th>Sem</th>
                    <th>Exam Pattern</th>
                    <!--<th>Conducted date</th>-->
<!--                    <th>View qp</th>-->
                    <th>Action</th>
                    
                    </tr>
                    </thead>
                    <tbody id="table">
                        <%
                            Registration reg = new Registration(session);
                            ArrayList<exam> mydata = reg.getexamDetails();

                            Iterator<exam> itr = mydata.iterator();
                            while (itr.hasNext()) {
                                exam e = itr.next();
                        %>
                        <tr>
                            <td><%=e.getid()%></td>
                            <td><%=e.getsubjectname()%></td>
                            <td><%=e.getsemester()%></td>
                            <td><%=e.getexampattern()%></td>
<!--                            <td>
                               <a class="btn btn-primary" href ="qpdetails?slno=<%=e.getid()%>">Details</a>
                            </td>-->
                            <td>
                             <a class="btn btn-primary" href ="f_pentohost?cslno=<%=e.getid()%>">Host</a>   
                            </td>  
                        </tr> 

                        <%}
                        %> 
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