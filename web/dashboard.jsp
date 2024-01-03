<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">  
        <title>Dash board</title>
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


        <style>
            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
            *{
                margin: 0;
                padding: 10;
                user-select: none;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            .btn{
                position: absolute;
                top: 130px;
                left: 5px;
                height: 45px;
                width: 45px;
                text-align: center;        
                /*            border-radius: 3px;*/
                cursor: pointer;
                transition: left 0.4s ease;
            }
            .btn.click{
                left: 260px;
            }
            .btn span{
                color: black;
                font-size: 18px;
                line-height: 2px;
            }
            .btn.click span:before{
                content: '\f00d';
            }
            .sidebar{
                position: fixed;
                width: 250px;
                height: 100%;
                left: -250px;
                background: #1b1b1b;
                transition: left 0.4s ease;
            }
            .sidebar.show{
                left: 0px;
            }
            .sidebar .text{
                color: white;
                font-size: 25px;
                font-weight: 600;
                line-height: 65px;
                text-align: center;
                /*            background: #353535;*/
                background: rgba(0,0,0,0.5);
                letter-spacing: 1px;
            }
            nav ul{
                background: #353535;
                height: 121%;
                width: 100%;
                list-style: none;
            }
            nav ul li{
                line-height: 60px;
                border-top: 1px solid rgba(255,255,255,0.1);
            }
            nav ul li:last-child{
                border-bottom: 1px solid rgba(255,255,255,0.05);
            }
            nav ul li a{
                position: relative;
                color: white;
                text-decoration: none;
                font-size: 18px;
                padding-left: 40px;
                font-weight: 500;
                display: block;
                width: 100%;
                border-left: 3px solid transparent;
            }
            nav ul li.active a{
                color: cyan;
                background: #353535;
                background: rgba(0,0,0,0.5);
                border-left-color: cyan;
            }
            nav ul li a:hover{
                background: grey;
            }
            nav ul ul{
                position: static;
                display: none;
            }
            nav ul .feat-show.show{
                display: block;
            }
            nav ul .serv-show.show1{
                display: block;
            }
            nav ul ul li{
                line-height: 42px;
                border-top: none;
            }
            nav ul ul li a{
                font-size: 17px;
                color: #e6e6e6;
                padding-left: 80px;
            }
            nav ul li.active ul li a{
                color: #e6e6e6;
                background: #1b1b1b;
                border-left-color: transparent;
            }
            nav ul ul li a:hover{
                color: cyan!important;
                background: grey!important;
            }
            nav ul li a span{
                position: absolute;
                top: 50%;
                right: 5px;
                transform: translateY(-50%);
                font-size: 22px;
                transition: transform 0.4s;
            }
            nav ul li a span.rotate{
                transform: translateY(-50%) rotate(-180deg);
            }
            .content{
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                color: #202020;
                z-index: -1;
                text-align: center;
            }
            .content .header{
                font-size: 45px;
                font-weight: 600;
            }
            header h4{
                font-size: 70px;
            }
            nav .sidebar ul:hover{
                color: cyan;
            }
            .errmsg{
                background: lightgreen;
                padding: 6px;
                width: 40%;
                color: white;
                font-weight: bold;
                margin-left: 500px;
                padding-left: 50px;
            }
            .error{   
                color:red;
            }

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
                margin: 10% auto 10% auto; /* 10% from the top, 10% from the bottom and centered */
                border: 1px solid #888;
                width: 40%; /* Could be more or less, depending on screen size */
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
        <%@include file="dashboardheader.jsp" %>
        <br>
        <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%><br>
        <div class="btn">
            <span class="fas fa-bars"></span>
        </div>
        <!--admin-->
        <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("admin")) {%>
        <nav class="sidebar">


            <ul>
                <!--<li class="active"><a href="#">Dashboard</a></li>-->
                <!--<li><a href="#">Profile</a></li>-->
                <li style="height:2%;background-color: grey;"></li>
               <li><a href="phoddetails.jsp">HODs Details</a></li>
                <li><a href="pfacultydetails.jsp">Faculty Details</a></li>
               <li><a href="pstudentdetails.jsp">Students Details</a></li>
                <!--                <li>
                
                                    <a href="#" class="feat-btn">Exam
                                        <span class="fas fa-caret-down first"></span>
                                    </a>
                                    <ul class="feat-show">
                                        <li><a href="exam.jsp">Create Exam</a></li>
                                        <li><a href="#">View Exam</a></li>
                                        <li><a href="#">Evaluation</a></li>                        
                                    </ul>
                                </li>-->
                <li>

                    <a href="#" class="serv-btn">Requests
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="serv-show">
                        <!--                        <li><a href="frequest.jsp">Faculty</a></li>
                                                <li><a href="srequest.jsp">Student</a></li>-->
                        <li><a href="hrequset.jsp">HOD</a></li>
                        <li><a href="prequest.jsp">Principal</a></li>
                       
                    </ul>
                </li>
            </ul>

        </nav>
        <%}%>
        <!--principal-->
        <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("principal")) {%>
        <nav class="sidebar">


            <ul>
                <!--<li class="active"><a href="#">Dashboard</a></li>-->
                <li style="height:2%;background-color: grey;"></li>
                <li><a href="pprofile.jsp">Profile</a></li>
                <li><a href="phoddetails.jsp">Hod Details</a></li>
                 <li><a href="pfacultydetails.jsp">Faculty Details</a></li>
<!--                <li>

                    <a href="#" class="feat-btn">Faculty
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="feat-show">
                        <li><a href="pfacultydetails.jsp">Faculty Details</a></li>
                        <li><a href="#">Exam Details</a></li>
                    </ul>
                </li>-->
                <li><a href="pstudentdetails.jsp">Students Details</a></li>
                <li><a href="hostedexam.jsp">Exam Details</a></li>
                <li><a href="hrequset.jsp">HOD Request</a></li>

            </ul>

        </nav>
        <%}%>
        <!--hod-->
        <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("hod")) {%>
        <nav class="sidebar">


            <ul>
                <!--<li class="active"><a href="#">Dashboard</a></li>-->
                <li style="height:2%;background-color: grey;"></li>
                <li><a href="hprofile.jsp">Profile</a></li>

                <li><a href="pfacultydetails.jsp">Faculty Details</a></li>
                <li><a href="pstudentdetails.jsp">Students Details</a></li>
                <li><a href="hostedexam.jsp">Exam Details</a></li>
<!--                <li>

                    <a href="H_exam_list.jsp" class="feat-btn">Exam
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="feat-show">
                        <li><a href="#">Alloted Faculties</a></li>
                        <li><a href="#">Attended Students</a></li>
                    </ul>
                </li>-->
                <li>

                    <a href="#" class="serv-btn">Requests
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="serv-show">
                        <li><a href="frequest.jsp">Faculty</a></li>
                        <li><a href="srequest.jsp">Student</a></li>
                    </ul>
                </li>

            </ul>

        </nav>
        <%}%>
        <!--faculty-->
        <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("faculty")) {%>
        <nav class="sidebar">

            <ul>
                <!--<li class="active"><a href="#">Dashboard</a></li>-->
                <li style="height:2%;background-color: grey;"></li>
                <li><a href="fprofile.jsp">Profile</a></li>
                <li><a href="pstudentdetails.jsp">Student Details</a></li>
                <li>

                    <a href="#" class="feat-btn">Exam
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="feat-show">
                        <li><a href="createexam.jsp">Create Exam</a></li>
                        <li><a href="pending_exam.jsp">Pending Exam</a></li>
                        <li><a href="hostedexam.jsp">Hosted Exam</a></li>
<!--                        <li><a href="#S">Security</a></li>-->
                        
                        <li><a href="Ev_table.jsp">Evaluation</a></li>                        
                    </ul>
                </li>
                <li>
                    <a href="#" class="serv-btn">Assignment
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="serv-show">
                        <li><a href="fcassignment.jsp">Create Assignment</a></li>
                        <li><a href="asgn_evaluation.jsp">View And Evaluate</a></li>
<!--                        <li><a href="#">Assignment Status</a></li>                        -->
                    </ul>
                </li>
                <li><a href="fac_results.jsp">Results</a></li>



            </ul>

        </nav>
        <%}%>
        <!--student-->
        <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {%>
        <nav class="sidebar">

            <ul>
                <!--<li class="active"><a href="#">Dashboard</a></li>-->
                <li style="height:2%;background-color: grey;"></li>
                <li><a href="sprofile.jsp">Profile</a></li>

                <li>

                    <a href="#" class="feat-btn">Exam
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="feat-show">
<!--                        <li><a href="#" onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;" class="w3-button w3-bar-item">View Hosted Exam</a></li>-->
                        <li><a href="H_exam_list.jsp">View Hosted Exam</a></li>
                        
                        <li><a href="sturesults.jsp">View Result</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="serv-btn">Assignment
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="serv-show">
                        <li><a href="hosted_asgn.jsp">Hosted List</a></li>
<!--                        <li><a href="sassignment.jsp">Upload</a></li>-->
<!--                        <li><a href="swassignment.jsp">Write</a></li>                                            -->
                    </ul>
                </li>


            </ul>

        </nav>

        
        

        <%}%>
        <div class="content">
            <div class="header">

                <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("admin")) {%>
                <h4>welcome <%=session.getAttribute("username")%></h4><%}%>

                <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("principal")) {%>
                <h4>welcome <%=session.getAttribute("pname")%></h4><%}%>

                <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("faculty")) {%>
                <h4>welcome <%=session.getAttribute("fname")%></h4><%}%>
                <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("hod")) {%>
                <h4>welcome <%=session.getAttribute("hname")%></h4><%}%>
                <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {%>
                <h4>welcome <%=session.getAttribute("sname")%></h4><%}%>


            </div>
        </div>
        <%@include file="footer.jsp" %>
        <script>
            $('.btn').click(function () {
                $(this).toggleClass("click");
                $('.sidebar').toggleClass("show");
            });
            $('.feat-btn').click(function () {
                $('nav ul .feat-show').toggleClass("show");
                $('nav ul .first').toggleClass("rotate");
            });
            $('.serv-btn').click(function () {
                $('nav ul .serv-show').toggleClass("show1");
                $('nav ul .second').toggleClass("rotate");
            });
            $('nav ul li').click(function () {
                $(this).addClass("active").siblings().removeClass("active");
            });
        </script>

        


    </body>
</html>
</body>
</html>
