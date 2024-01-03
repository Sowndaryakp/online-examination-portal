<%-- 
    Document   : fregister
    Created on : 13 Oct, 2020, 11:01:13 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Faculty Registration Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
             @import url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap');
            *{
                margin:0;
                padding: 0;
                font-family: "Josafin Slab",serif;
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

            select {
                display: block;
                width: 100%;
                height: 34px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-shadow: 0 1px 1px rgba(0,0,0,.075);
            }
            .button-1{
                width:25%;
                border: none;
                border-radius: 4px;
                color: white;
                display: block;
                padding: 12px;
                font-size: 16px;
                background-color: cornflowerblue;

            }
            .button-1:hover{
                background-color: #2691d9;
            }
            .footer {
              
                position: absolute;
                width: 100% !important;
                background-color: #353535;
                color: white;
                text-align: center;
                bottom: -310;
                padding: 35px 50px;
                padding-top: 0px;
                padding-right: 50px;
                padding-bottom: -0;
                padding-left: 20px;
                
            } 
            .container{
                font-size: 17px;
              
            }
            .error{   
                color:red;
            }
            input{
                display: block;
            }
            #msg
            {
                background: red;
                color:black;
                border: 1px solid red;
                width:24%;
                font-weight: bold;
                font-size: 25px;
                padding: 5px;
            }
        </style>

    </head>
    <body>
        <nav>
            <div class="logo"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px;margin-left: 2px;margin-top: -1px;'></div>
           <div class="logo-text" ><h3><b> G.MADEGOWDA INSTITUTE OF TECHNOLOGY</b></h3> </div>
            <div class="menu">                                              
                 <a href="index.jsp">Home</a>
                 <a href="http://gmitmandya.in">About us</a> 
            </div>
        </nav>

        <script>
            function v(val) {
                $("input[name=gender]").val(val);

            }


            //            jQuery.validator.addMethod( name, method [, message ] )
//            
// value---> "current value of the validated element".
//elememt---> " element to be validated ".

            jQuery.validator.addMethod("checkemail", function (value, element) {
                return /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value) || /^[0-9]{10}$/.test(value);
            });
            
              jQuery.validator.addMethod("checkname", function (value, element) {
                return /^[A-Za-z\s]+$/i.test(value);
            });
            
            jQuery.validator.addMethod("checkphone", function (value, element) {
                return /^\d{10}$/.test(value);
            });
            jQuery.validator.addMethod("checkaadhaar", function (value, element) {
                return /^\d{12}$/.test(value);
            });

            jQuery(document).ready(function ($) {
                $("#fform").validate({
                    rules: {
                        fname: {
                            required: true,
                             checkname: true,
                            minlength: 3,
                            maxlength: 30


                        },
                        fid: {
                            required: true,
                            maxlength: 10

                        },
                        fphone: {
                            required: true,
                            checkphone: true
                        },
                        femail: {
                            required: true,
                            checkemail: true
                        },
                        fdep: {
                            required: true
                        },
                        fdob: {
                            required: true

                        },
                        fgender: {
                            required: true
                        },
                        faadhaar: {
                            required: true,
                            checkaadhaar: true
                        },
                        fpan: {
                            required: true,
                             minlength: 10,
                            maxlength: 10

                        },
                         faddress: {
                            required: true,
                            minlength: 10,
                            maxlength: 60
                        },
                        fphoto: {
                            required: true
                        },
                        fcid: {
                            required: true
                        },
                        fpwd: {
                            required: true,
                            minlength: 6
                        },
                        fcpwd: {
                            required: true,
                            minlength: 6,
                            equalTo: "#fpwd"

                        }
                    },
                    messages: {
                        fname: {
                            required: "Please enter your name",
                             checkname: "Please enter a valid name",
                            minlength: "Your name must be atleast 3 characters long",
                            maxlength:"Your name must be less than 30 characters"
                        },
                        fid: {
                            required: "Please enter your id number",
                             maxlength:"Your id number must be less than or equal to 10 characters"

                        },
                        fphone: {
                            required: "Please enter your phone number",
                            checkphone: "Please enter the  10 digit number"
                        },
                        femail: {
                            required: "Please enter your email",
                            checkemail: "Please enter valid email id"
                        },
                        fdep: {
                            required: "Please select your department"
                        },
                        fdob: {
                            required: "Please enter your date of birth"

                        },
                        fgender: {
                            required: "Please select your gender"
                        },
                        faadhaar: {
                            required: "Please enter your Aadhaar number ",
                             checkaadhaar: "Please enter the 12 digit aadhaar number "
                        },
                        fpan: {
                            required: "Please enter your PAN card number ",
                             minlength: "Please enter a valid PAN card number ",
                            maxlength: "More than 10 characters"
                        },
                        faddress: {
                            required: "Please enter your address",
                            minlength: "Your address must be atleast 10 characters long",
                            maxlength: "More than 60 characters"
                        },
                        fphoto: {
                            required: "Please upload your photo"
                        },
                        fcid: {
                            required: "Please upload your college id"
                        },
                        fpwd: {
                            required: "Please enter password",
                            minlength: "Please enter the password greater than or equal to  6."

                        },
                        fcpwd: {
                            required: "Please confirm your password",
                            minlength: "Please enter the password greater than or equal to 6.",
                            equalTo: "Password does not match"
                        }

                    }

                });
            });
        </script>
        


        <br><br>

        <% if (request.getAttribute("status") != null) {%>
        <div id="msg">  <%= request.getAttribute("status")%></div>
        <%}%>



        <div class="container">
            <div class="row col-md-6 col-md-offset-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">

                        <h2 style="text-align:center">Faculty Registration Form</h2>

                    </div>
                    <div class="panel-body">


                        <form method="post" id="fform" action="Register" enctype="multipart/form-data"> 

                            <div class="form-group">
                                <label>Faculty Name</label>
                                <input  class="form-control" type="text"  id="fname" name="fname" placeholder="Enter your name" autocomplete="off" /> <br>
                            </div>

                            <div class="form-group">
                                <label>Faculty ID</label>
                                <input  class="form-control" type="text" id="fid" name="fid" placeholder="Enter your ID" autocomplete="off" /> <br>
                            </div>

                            <div class="form-group">
                                <label>Phone Number</label>
                                <input  class="form-control" type="tel" id="fphone" name="fphone" placeholder="Enter your phone number"autocomplete="off"/><br>
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <input  class="form-control" type="email" id="femail" name="femail" placeholder="Enter your email address" autocomplete="off" /><br>
                            </div>

                            <div class="form-group"  >
                                <label>Department</label><br>
                                <select class="dropdown" class="form-control" name="fdep">
                                    <option value="" selected="hidden">Select your department</option>
                                    <option> Electrical and Electronics Engineering </option>
                                    <option> Electronics and Communication Engineering </option>
                                    <option> Civil Engineering </option>
                                    <option> Computer Science and Engineering </option>
                                    <option> Mechanical Engineering </option>
                                </select>
                            </div><br>


                            <div class="form-group">
                                <label>Date of Birth</br></label>
                                <input  class="form-control" type="date" id="fdob" name="fdob" autocomplete="off" /> <br>
                            </div> 


                            <div class="form-group">  
                                <label>Gender</label>
                                <div>
                                    <label class="radio-inline">  <input type="radio" id="fgender" name="fgender"  onchange="v('male')">Male</label>

                                    <label class="radio-inline" >  <input type="radio" id="fgender1" name="fgender" onchange="v('female')" >Female</label><br>

                                    <label for="fgender" class="error"></label>
                                    <input type="hidden" name="gender">
                                </div>
                            </div>


                            <div class="form-group">
                                <label>Aadhaar Number</label>
                                <input  class="form-control" type="tel" id="faadhaar" name="faadhaar" placeholder="Enter your Aadhaar No." autocomplete="off"/> <br>
                            </div>

                            <div class="form-group">
                                <label>PAN Card</label>
                                <input  class="form-control" type="text" id="fpan" name="fpan" placeholder="Enter your PAN No." autocomplete="off"/> <br>
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <textarea rows="2" cols="68" class="form-control" type="text" id="faddress" name="faddress" placeholder="Enter your address" autocomplete="off"></textarea> <br>

                            </div>

                            <div class="form-group">
                                <label>Upload Your Photo</label>
                                <input type="file"  name="fphoto" autocomplete="off">
                            </div><br>

                            <div class="form-group">
                                <label>Upload Your College ID</label>
                                <input type="file" name="fcid" autocomplete="off" >
                            </div><br>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" id="fpwd" name="fpwd" placeholder="Enter your password"autocomplete="off" /><br>
                            </div>

                            <div class="form-group">
                                <label>Confirm Password</label>
                                <input  class="form-control" type="password" id="fcpwd" name="fcpwd" placeholder="Confirm your password" autocomplete="off" /><br>
                            </div>



                            <div class="form-group">
                                <button class="button-1" type="submit" name="fregister" value="sdgsdfg"> Register</button>
                            </div>
                        </form>


                    </div>

                </div>
            </div>
        </div>
        
                <div class="footer"><b style="font-size: 20px">contact us:</b><br>
            Phone: 08232-235676 / 5566<br>
            Email:principalgmit@gmail.com<br>
            <br>
            
             <small>
                      © 2020 GMIT | A project by Students of GMIT
             </small>
         </div>  
                </body>
                </html>