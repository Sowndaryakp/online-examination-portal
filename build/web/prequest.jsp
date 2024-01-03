<%@page import="model.principal"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Principal request</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
        Principal Registration Request 
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
                    <th>Name</th>
                    <th>pid</th>
                    <th>Phone</th>
                    
                    <th>Action</th>
                    </tr>
                    </thead>
                    <tbody id="table">
                        <%
                            Registration reg = new Registration(session);
                            ArrayList<principal> mydata = reg.getpUserDetails();

                            Iterator<principal> itr = mydata.iterator();
                            while (itr.hasNext()) {
                                principal p = itr.next();
                        %>
                        <tr>
                            <td><%=p.getid3()%></td>
                            <td><%=p.getpname()%></td>
                            <td><%=p.getpid()%></td>
                            <td><%=p.getpphone()%></td>
                            
                            <td>
                                <a class="btn btn-success" href ="papprove?pslno=<%=p.getid3()%>">Approve</a>
                                <a class="btn btn-danger" href ="pdelete?pslno=<%=p.getid3()%>">Delete</a>

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