<%-- 
    Document   : H_exam_list
    Created on : Jul 16, 2021, 11:53:54 AM
    Author     : niranjanprasad M
--%>

<%@page import="model.Hexamlist"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hosted Exams List</title>
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
                margin-left: -100px;
                margin-right: 20px;
            }
            /*        #search
                    {
                        width: 50%; 
                    }*/

        </style>
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
                background-image: url(images/homebg.webp);
            }

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }


            /* Center the image and position the close button */
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;
            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                width: 70%;
                padding: 10px;
                padding-left: 130px;

            }
            .container2{
                padding: 50px;
                padding-bottom: 70px;
                padding-top: 20px;
            }

            span.psw {
                float: right;
                padding-bottom:  5px;
                /*  margin: 2px;*/
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;

            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 10% auto; /* 10% from the top, 10% from the bottom and centered */
                border: 1px solid #888;
                width: 25%; /* Could be more or less, depending on screen size */
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 15px;
                top: -20;
                color: #000;
                font-size: 30px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }

            /* Add Zoom Animation */
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
                from {-webkit-transform: scale(0)} 
                to {-webkit-transform: scale(1)}
            }

            @keyframes animatezoom {
                from {transform: scale(0)} 
                to {transform: scale(1)}
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }

            #msg{
                background-color: lightgreen;
                color: black;
                border: 1px solid green;
                width: 24%;
                font-size: 25px;
                padding: 5px;
                padding-left: 100px;
                margin: 80px 580px;

            }

            .exam_detail{
                padding: 20px;
            }
            .start_btn{
                background-color: limegreen;
                border-radius: 10px;
                text-decoration: none;
                padding: 10px;
                font-size: x-large;

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
                <font color="black" size="6" style="margin:2px;">
                Hosted Exams List
                </font>
                <!--                 <input class="form-control" id="search" type="text" placeholder="Search..">-->
                <table class="table" style="margin-top:20px;">
                    <thead>
                        <tr style="background-color: lightblue;">
                    <br>
                    <th>Slno</th>
                    <th>Subject Code</th>
                    <th>Subject Name</th>
                    <th>Exam duration</th>


                    <th>Action</th>
                    </tr>
                    </thead>
                    <tbody id="table">
                        <%
                            Registration reg = new Registration(session);
                            ArrayList<Hexamlist> mydata = reg.getHexamdetails();

                            Iterator<Hexamlist> itr = mydata.iterator();
                            while (itr.hasNext()) {
                                Hexamlist he = itr.next();
                        %>
                        <tr>
                            <td><%=he.getid4()%></td>
                            <td><%=he.getsubcode()%></td>
                            <td><%=he.getsubjectname()%></td>
                            <td><%=he.getduration()%></td>

                            <td>
                                <a class="btn btn-primary" href ="#" onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Open</a>

                            </td>
                        </tr> 


                    <%}
                    %> 

                    </tbody>
                </table>
                <div id="id01" class="modal" >

                    <form class="modal-content animate" style="border-radius:20px;" action="register" method="post">
                        <div class="imgcontainer">

                            <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                            <h2><strong>Hosted Exam</strong></h2>
                            <div class="exam_detail" style="margin-top:-20px;">
                                <br>

                                <h3>Subject Code   :17cs82</h3><br>
                                <h3>Subject Name   : BDA</h3><br>
                                <h3>Exam duration : 1 hour 30 min</h3><br><br>

                            </div>


                            <div class="popupcontainer">

                                <a class="start_btn" href="splitscreen.jsp" id="gotit">
                                    <strong>Start</strong></a><br><br>
                            </div>
                        </div>


                    </form>

       
                </div>

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

    <script>
        // Get the modal
        var modal = document.getElementById('id01');

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
    <%@include file="footer.jsp"%>
</body>
</html>
