<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scaled=1, shrink-to-fit=no,text/html; charset=UTF-8">
        <title>home page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap');
            *{
                margin: 0;
                padding: 0; 
                box-sizing: border-box;
                font-family: "Josafin Slab",serif;
            }
            main{

                height: 90vh;
                background-image: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.1)),url('images/GMIT001.jpg');
                background-repeat: no-repeat;
                background-size: cover;
            }
            nav{
                width: 100%; height: 15vh;
                background: rgb(0 0 0 / 58%);
                color: white; 
                display: flex; 
                justify-content: space-between;
                align-items: center;
                text_transform: uppercase;
            }
            .logo{
                margin: 0px;
                margin-top: 5px;

            }
            nav .logo-text{
                width: 25%; 
                text-align: center;
                position: relative;
                padding-left: 10px;
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
                border-radius: 10px;
            }
            /*            nav .menu a:hover{
                            color: cyan;
                        }*/
            ul{
                list-style-type: none;
                margin: 0;
                padding:0;
                /*                overflow:hidden;*/
                font-family: cursive;
                text-align: center;
            }
            .li{
                float: left;
            }
            li a.dropbtn{
                display: initial;
                color: white;
                text-align: justify;
                padding: 15px 24px;
                text-decoration: none;
            }
            li a:hover {
                background-color: lightblue;
            }
            li .dropdown{

                display: inline-block;
            }
            .dropdown-content{
                display: none;
                position: absolute;
                background-color: grey;
                min-width: 16px;
                z-index: 1;
                border-radius: 10px;
            }
            .dropdown-content a{
                color:black;               
                padding: 10px 30px;
                text-decoration: none;
                display: table;
                text-align: left;
            }

            .dropdown:hover
            .dropdown-content{
                display: block;
            }
            .dropdown-content a{
                width: 100% !important;
            }
            main{
                width: 100%;
                height: 85vh;
                display: flex;
                justify-content: center;
                align-items: center; 
                color:white;
            }          
            section h5{
                margin: -250px 10px 20px 0;
                font-size: 55px;
                font-weight: 400;
                text-shadow: 2px 1px 5px black;
                text-transform: uppercase;

            }

            section p{
                margin: 30px 300px 40px 0;
                font-size: 25px;
                font-weight: bold;
                text-align: right;
                color: white;
                word-spacing: 2px;
                margin-bottom: 25px;
                text-shadow: 1px 1px 1px black;
            }
            .footer {

                position: static;
                width: 100% ;
                height: 30px;
                background-color: #353535;
                color: white;
                text-align: center;
                /*                bottom: -20;*/
                padding: 35px 50px;
                padding-top: 0px;
                padding-right: 50px;
                /*                padding-bottom: 1;*/
                padding-left: 20px;

            }   
        </style>
    </head>
    <body>

        <nav>
            <div class="logo"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px;margin-left: 2px;margin-top: -1px;'></div>
            <div class="logo-text" ><h1 > G.MADEGOWDA INSTITUTE OF TECHNOLOGY </h1> </div>
            <div class="menu">                                              
                <a href="index.jsp">Home</a>
                <a href="http://gmitmandya.in">About us</a>
                <ul>
                    <li class="dropdown" >
                        <a href="#" class="dropbtn">Login as <i class="fa fa-caret-down"></i></a>
                        <div class="dropdown-content">
                            <a href="plogin.jsp">Principal</a>
                            <a href="hlogin.jsp">HOD</a>
                            <a href="flogin.jsp">Faculty</a>
                            <a href="slogin.jsp">Student</a>
                        </div>
                    </li>
                </ul>
                <a href="admin_login.jsp"> Admin </a>
            </div>
        </nav>
        <div>   
            <main>  
                <section>

                    <h5 > Welcome To Examination Portal </h5>
                    <p>"Education is the most powerful Weapon"</p>
                </section>                          
            </main>
        </div>
        <!--        <div class="footer"><b style="font-size: 20px">
                                        contact us:</b><br>
                                    Phone: 08232-235676 / 5566<br>
                                    Email:principalgmit@gmail.com<br>
                                    <br>
        
                        <small>
                            © 2020 GMIT | A project by G.madegowda institute of technology
                        </small>
                </div>  -->
        <%@include file="footer.jsp"%>
</html>
</body>
