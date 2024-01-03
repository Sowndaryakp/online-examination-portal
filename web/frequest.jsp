<%@page import="model.faculty"%>
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
                
            }
            .container{
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
       
        
        <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%>
        <div class="container ">
            <div class="jumbotron">
                <!--                 <input class="form-control" id="search" type="text" placeholder="Search..">-->
                <font color="black" size="6">
        Faculty Registration Request 
        </font>
        <table class="table" style="margin-top:10px;">
                    <thead>
                        <tr style="background-color: lightblue;">
                    <br>
                    <th>Slno</th>
                    <th>Name</th>
                    <th>Fid</th>
                    <th>Phone</th>
                    
                    <th>Action</th>
                    </tr>
                    </thead>
                    <tbody id="table">
                        <%
                            Registration reg = new Registration(session);
                            ArrayList<faculty> mydata = reg.getfUserDetails();

                            Iterator<faculty> itr = mydata.iterator();
                            while (itr.hasNext()) {
                                faculty f = itr.next();
                        %>
                        <tr>
                            <td><%=f.getid1()%></td>
                            <td><%=f.getfname()%></td>
                            <td><%=f.getfid()%></td>
                            <td><%=f.getfphone()%></td>
                            
                            <td>
                                <a class="btn btn-success" href ="fapprove?slno=<%=f.getid1()%>">Approve</a>
                                <a class="btn btn-danger" href ="fdelete?slno=<%=f.getid1()%>">Delete</a>

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