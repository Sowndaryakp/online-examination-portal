<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Student Registration Form</title>
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

        </style>

    </head>
    <body>
        <nav>
            <div class="logo"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px;margin-left: 2px;margin-top: -1px;'></div>
           <div class="logo-text" ><h3><b> G.MADEGOWDA INSTITUTE OF TECHNOLOGY</b> </h3> </div>
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
                $("#sform").validate({
                    rules: {
                        sname: {
                            required: true,
                            checkname: true,
                            minlength: 3,
                            maxlength: 30

                        },
                        sid: {
                            required: true,
                            maxlength: 10

                        },
                        sphone: {
                            required: true,
                            checkphone: true

                        },
                        semail: {
                            required: true,
                            checkemail: true
                        },
                        sdep: {
                            required: true,
                        },
                        ssem: {
                            required: true,
                        },
                        sdob: {
                            required: true

                        },
                        sgender: {
                            required: true,
                        },
                        saadhaar: {
                            required: true,
                            checkaadhaar: true,
                        },
                        saddress: {
                            required: true,
                            minlength: 10,
                            maxlength: 60
                        },
                        sphoto: {
                            required: true
                        },
                        scid: {
                            required: true
                        },
                        spwd: {
                            required: true,
                            minlength: 6
                        },
                        scpwd: {
                            required: true,
                            minlength: 6,
                            equalTo: "#spwd"

                        }
                    },
                    messages: {
                        sname: {
                            required: "Please enter your name",
                            checkname: "Please enter a valid name",
                            minlength: "Your name must be atleast 3 characters long",
                            maxlength: "Your name must be less than 30 characters"
                        },
                        sid: {
                            required: "Please enter your id number",
                            maxlength: "Your id number must be less than or equal to 10 characters"

                        },
                        sphone: {
                            required: "Please enter your phone number",
                            checkphone: "Please enter the  10 digit number",
                        },
                        semail: {
                            required: "Please enter your email",
                            checkemail: "Please enter a valid email id"
                        },
                        fdep: {
                            required: "Please select your department"
                        },
                        ssem: {
                            required: "Please select your semister"
                        },
                        sdob: {
                            required: "Please enter your date of birth"

                        },
                        sgender: {
                            required: "Please select your gender"
                        },
                        saadhaar: {
                            required: "Please enter your Aadhaar number ",
                            checkaadhaar: "Please enter the  12 digit number ",
                        },
                        saddress: {
                            required: "Please enter your address",
                            minlength: "Your address must be atleast 10 characters long",
                            maxlength: "More than 60 characters"
                        },
                        sphoto: {
                            required: "Please upload your photo"
                        },
                        scid: {
                            required: "Please upload your college id"
                        },
                        spwd: {
                            required: "Please enter password",
                            minlength: "Please enter the password greater than or equal to  6"

                        },
                        scpwd: {
                            required: "Please confirm your password",
                            minlength: "Please enter the password greater than or equal to 6",
                            equalTo: "Password does not match"
                        }

                    }

                });
            });
        </script>
        <style>
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


        <br><br>

        <% if (request.getAttribute("status") != null) {%>
        <div id="msg">  <%= request.getAttribute("status")%></div>
        <%}%>



        <div class="container">
            <div class="row col-md-6 col-md-offset-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">

                        <h2 style="text-align:center">Student Registration Form</h2>

                    </div>
                    <div class="panel-body">


                        <form method="post" id="sform" action="Register" enctype="multipart/form-data"> 

                            <div class="form-group">
                                <label>Student Name</label>
                                <input  class="form-control" type="text"  id="sname" name="sname" placeholder="Enter your name" autocomplete="off" /> <br>
                            </div>

                            <div class="form-group">
                                <label>Student ID</label>
                                <input  class="form-control" type="text" id="sid" name="sid" placeholder="Enter your USN" autocomplete="off" /> <br>
                            </div>

                            <div class="form-group">
                                <label>Phone Number</label>
                                <input  class="form-control" type="tel" id="sphone" name="sphone" placeholder="Enter your phone number" autocomplete="off"/><br>
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <input  class="form-control" type="email" id="semail" name="semail" placeholder="Enter your email address" autocomplete="off" /><br>
                            </div>

                            <div class="form-group"  >
                                <label>Department</label><br>
                                <select class="dropdown" class="form-control" name="sdep">
                                    <option value="" selected="hidden">Select your department</option>
                                    <option> Electrical and Electronics Engineering </option>
                                    <option> Electronics and Communication Engineering </option>
                                    <option> Civil Engineering </option>
                                    <option> Computer Science and Engineering </option>
                                    <option> Mechanical Engineering </option>
                                </select>
                            </div><br>
                            <div class="form-group"  >
                                <label>Semister</label><br>
                                <select class="dropdown" class="form-control" name="ssem">
                                    <option value="" selected="hidden">Select you semister</option>
                                    <option> 8th </option>
                                    <option> 7th </option>
                                    <option> 6th </option>
                                    <option> 5th </option>
                                    <option> 4th </option>
                                    <option> 3rd </option>
                                    <option> 2nd </option>
                                    <option> 1st </option>
                                </select>
                            </div><br>

                            <div class="form-group">
                                <label>Date of Birth</br></label>
                                <input  class="form-control" type="date" id="sdob" name="sdob" autocomplete="off" /> <br>
                            </div> 


                            <div class="form-group">  
                                <label>Gender</label>
                                <div>
                                    <label class="radio-inline">  <input type="radio" id="sgender" name="sgender"  onchange="v('male')">Male</label>

                                    <label class="radio-inline" >  <input type="radio" id="sgender1" name="sgender" onchange="v('female')" >Female</label><br>

                                    <label for="sgender" class="error"></label>
                                    <input type="hidden" name="gender">
                                </div>
                            </div>


                            <div class="form-group">
                                <label>Aadhaar Number</label>
                                <input  class="form-control" type="tel" id="saadhaar" name="saadhaar" placeholder="Enter your Aadhaar No." autocomplete="off"/> <br>
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <textarea rows="2" cols="68" class="form-control" type="text" id="saddress" name="saddress" placeholder="Enter your address" autocomplete="off"></textarea> <br>

                            </div>

                            <div class="form-group">
                                <label>Upload Your Photo</label>
                                <input type="file"  name="sphoto" autocomplete="off">
                            </div><br>

                            <div class="form-group">
                                <label>Upload Your College ID</label>
                                <input type="file" name="scid" autocomplete="off" >
                            </div><br>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" id="spwd" name="spwd" placeholder="Enter your password"autocomplete="off" /><br>
                            </div>

                            <div class="form-group">
                                <label>Confirm Password</label>
                                <input  class="form-control" type="password" id="scpwd" name="scpwd" placeholder="Confirm your password" autocomplete="off" /><br>
                            </div>



                            <div class="form-group">
                                <button class="button-1" type="submit" name="sregister" value="sdgsdfg"> Register</button>
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