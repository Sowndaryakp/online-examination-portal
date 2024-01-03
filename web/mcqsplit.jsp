<%-- 
    Document   : mcqsplit
    Created on : Jun 5, 2021, 1:11:42 PM
    Author     : niranjanprasad M
--%>

<%@page import="model.MCQ"%>
<%@page import="model.question"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.pstudent"%>
<%@page import="model.Registration"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
        <script src="https://pagecdn.io/lib/ckeditor/4.13.0/ckeditor.js" ></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <!-- Add icon library -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            * {
                box-sizing: border-box;
            }

            /* Add a gray background color with some padding */
            body {
                font-family: Arial;
                padding: 20px;
                background: #f1f1f1;
            }

            /* Create two unequal columns that floats next to each other */
            /* answer sheet */
            .leftcolumn {   
                float: left;
                width: 80%;
            }

            /* remaining time */
            .rightcolumn {
                float: right;
                width: 20%;
            }

            /* Add a card effect for articles */
            .card {
                background-color: white;
                padding: 20px;
                margin-top: 20px;
                margin-right: 15px;
                margin-left: 15px;
            }

            /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 800px) {
                .rightcolumn, .leftcolumn {   
                    width: 100%;
                    padding: 0;
                }
            }

            /*download button*/
            .btn {
                background-color: DodgerBlue;
                border: none;
                color: white;
                padding: 12px 30px;
                cursor: pointer;
                font-size: 20px;
                margin-left: 1000px;
                margin-top: 20px;
            }

            /* Darker background on mouse-over */
            .btn:hover {
                background-color: RoyalBlue;
            }
            p{
                font-size: xx-large;
            }

        </style>
        <style>
            .button{
                width:25%;
                border: none;
                border-radius: 4px;
                color: white;
                display: block;
                padding: 12px;
                font-size: 16px;
                background-color: cornflowerblue;

            }
            .button:hover{
                background-color: #2691d9;
            }
        </style> 
    </head>
    <body>

        <% if (session.getAttribute("sname") != null) {
                Registration reg = new Registration(session);
                pstudent s = reg.getpsUserDetails();

        %>


        <div class="rightcolumn">
            <div class="card" >
                <h3>Remaining time</h3>
                <p id="demo"></p>

                <script>

                    // Set the date we're counting down to
                    var countDownDate = new Date("june 3, 2021 15:58:00").getTime();

                    // Update the count down every 1 second
                    var x = setInterval(function () {

                        // Get today's date and time
                        var now = new Date().getTime();

                        // Find the distance between now and the count down date
                        var distance = countDownDate - now;

                        // Time calculations for hours, minutes and seconds
                        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                        // Output the result in an element with id="demo"
                        document.getElementById("demo").innerHTML = hours + "h : " + minutes + "m : " + seconds + "s ";

                        // If the count down is over, write some text 
                        if (distance < 0) {
                            clearInterval(x);
                            document.getElementById("demo").innerHTML = "Internals OVER";
                        }
                    }, 1000);
                </script>
                <h2>Profile</h2>


                <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {%>
                Name: <%=session.getAttribute("sname")%><%}%>
                <br>
                <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {%>
                USN: <%=session.getAttribute("sid")%><%}%>




                <h4>Subject: JAVA</h4></div>
            <br><br><br><br><br>

        </div>
        <%}%>

        <form method="post" action="answer">
            <div class="row">
                <div class="leftcolumn">
                    <div class="card">
                        <center><h2>MCQ</h2></center>


                        <div>
                            

                            <div class="form-group">  

                                <div>
                                    <label class="radio-inline">  <input type="radio" id="op" name="crctop"  onchange="v('low')">Allow any browser</label><br>

                                    <label class="radio-inline" >  <input type="radio" id="op" name="crctop" onchange="v('high')" >Require high-security </label><br>

                                    <label class="radio-inline" >  <input type="radio" id="op" name="crctop" onchange="v('high')" >Require high-security mode</label><br>

                                    <label class="radio-inline" >  <input type="radio" id="op" name="crctop" onchange="v('high')" > high-security mode</label><br>
                                    <label for="security" class="error"></label>
                                    <input type="hidden" name="esecurity">
                                </div>
                            </div>
                        </div>

                      

                        <button class="btn" type="submit" name="mcqanswer" >Submit</button>
                    </div>
                    <br>


                </div>

            </div>
        </form>


    </body>
</html>
