<%@page import="model.phoddetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>faculty request</title>
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
            #search
            {
                width: 50%; 
            }

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
                <font color="black" size="6">
        HOD Details
        </font>
                <input class="form-control" id="search" type="text" placeholder="Search.." style="margin-top:20px;">
                <table class="table">
                    <thead>
                        <tr style="background-color: lightblue;">
                    <br>
                    <th>Slno</th>
                    <th>Name</th>
                    <th>Hid</th>
                    <th>Department</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <!--<th>View</th>-->
                    </tr>
                    </thead>
                    <tbody id="table">
                        <%
                            Registration reg = new Registration(session);
                            ArrayList<phoddetails> mydata = reg.getphoddetailsUserDetails();

                            Iterator<phoddetails> itr = mydata.iterator();
                            while (itr.hasNext()) {
                                phoddetails phod = itr.next();
                        %>
                         <script>
        $(document).ready(function () {
            $("#search").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#table").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(hname) > 0);
                });
            });
        });
    </script>
                        <tr>
                            <td><%=phod.getid1()%></td>
                            <td><%=phod.gethname()%></td>
                            <td><%=phod.gethid()%></td>
                            <td><%=phod.gethdep()%></td>
                            <td><%=phod.gethemail()%></td>
                            <td><%=phod.gethphone()%></td>
<!--                    <form action="#" method="post">
                        <input type="hidden" name=""> -->
                        </tr> 

                        <%}
                        %> 
                    </tbody>
                </table>
            </div>
        </div>                      
    </center>

   
    <%@include file="footer.jsp"%>
</body>
</html>