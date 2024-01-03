<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Principal Registration Form</title>
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
          <div class="logo-text" ><h3 ><b> G.MADEGOWDA INSTITUTE OF TECHNOLOGY</b></h3> </div>
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
                $("#pform").validate({
                    rules: {
                        pname: {
                            required: true,
                            checkname: true,
                            minlength: 3,
                            maxlength: 30

                        },
                        pid: {
                            required: true,
                            maxlength: 10

                        },
                        pphone: {
                            required: true,
                            checkphone: true
                            
                        },
                        pemail: {
                            required: true,
                            checkemail: true
                        },
                       
                        pdob: {
                            required: true

                        },
                        pgender: {
                            required: true,
                        },
                        paadhaar: {
                            required: true,
                            checkaadhaar: true,
                           
                        },
                        ppan: {
                            required: true,
                            minlength: 10,
                            maxlength: 10

                        },
                        paddress: {
                            required: true,
                            minlength: 10,
                            maxlength: 60
                        },
                        pphoto: {
                            required: true
                        },
                        pcid: {
                            required: true
                        },
                        ppwd: {
                            required: true,
                            minlength: 6
                        },
                        pcpwd: {
                            required: true,
                            minlength: 6,
                            equalTo: "#ppwd"

                        }
                    },
                    messages: {
                        pname: {
                            required: "Please enter your name",
                            checkname: "Please enter a valid name",
                            minlength: "Your name must be atleast 3 characters long",
                            maxlength:"Your name must be less than 30 characters"
                        },
                        pid: {
                            required: "Please enter your id number",
                            maxlength:"Your id number must be less than or equal to 10 characters"

                        },
                        pphone: {
                            required: "Please enter your phone number",
                            checkphone: "Please enter the  10 digit number",
                           
                        },
                        pemail: {
                            required: "Please enter your email",
                            checkemail: "Please enter a valid email id"
                        },
                       
                        pdob: {
                            required: "Please enter your date of birth"

                        },
                        pgender: {
                            required: "Please select your gender"
                        },
                        paadhaar: {
                            required: "Please enter your Aadhaar number ",
                            checkaadhaar: "Please enter the 12 digit aadhaar number "
                           
                            
                        },
                        ppan: {
                            required: "Please enter your PAN card number ",
                             minlength: "Please enter a valid PAN card number ",
                            maxlength: "More than 10 characters"
                        },
                        paddress: {
                            required: "Please enter your address",
                            minlength: "Your address must be atleast 10 characters long",
                            maxlength: "More than 60 characters"
                        },
                        pphoto: {
                            required: "Please upload your photo"
                        },
                        pcid: {
                            required: "Please upload your college id"
                        },
                        ppwd: {
                            required: "Please enter password",
                            minlength: "Please enter the password greater than or equal to  6"

                        },
                        pcpwd: {
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

                        <h2 style="text-align:center">Principal Registration Form</h2>

                    </div>
                    <div class="panel-body">
 

                        <form method="post" id="pform" action="Register" enctype="multipart/form-data"> 

                            <div class="form-group">
                                <label>Principal Name</label>
                                <input  class="form-control" type="text"  id="pname" name="pname" placeholder="Enter your name" autocomplete="off" /> <br>
                            </div>

                            <div class="form-group">
                                <label>Principal ID</label>
                                <input  class="form-control" type="text" id="pid" name="pid" placeholder="Enter your ID " autocomplete="off" /> <br>
                            </div>

                            <div class="form-group">
                                <label>Phone Number</label>
                                <input  class="form-control" type="tel" id="pphone" name="pphone" placeholder="Enter your phone number"autocomplete="off"/><br>
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <input  class="form-control" type="email" id="pemail" name="pemail" placeholder="Enter your email address" autocomplete="off" /><br>
                            </div>

                           <div class="form-group">
                                <label>Date of Birth</br></label>
                                <input  class="form-control" type="date" id="pdob" name="pdob" autocomplete="off" /> <br>
                            </div> 


                            <div class="form-group">  
                                <label>Gender</label>
                                <div>
                                    <label class="radio-inline">  <input type="radio" id="pgender" name="pgender"  onchange="v('male')">Male</label>

                                    <label class="radio-inline" >  <input type="radio" id="pgender1" name="pgender" onchange="v('female')" >Female</label><br>

                                    <label for="pgender" class="error"></label>
                                    <input type="hidden" name="gender">
                                </div>
                            </div>


                            <div class="form-group">
                                <label>Aadhaar Number</label>
                                <input  class="form-control" type="tel" id="paadhaar" name="paadhaar" placeholder="Enter your Aadhaar No." autocomplete="off"/> <br>
                            </div>

                            <div class="form-group">
                                <label>PAN Card </label>
                                <input  class="form-control" type="text" id="ppan" name="ppan" placeholder="Enter your PAN No." autocomplete="off"/> <br>
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <textarea rows="2" cols="68" class="form-control" type="text" id="paddress" name="paddress" placeholder="Enter your address" autocomplete="off"></textarea> <br>

                            </div>

                            <div class="form-group">
                                <label>Upload Your Photo</label>
                                <input type="file"  name="pphoto" autocomplete="off">
                            </div><br>

                            <div class="form-group">
                                <label>Upload Your College ID</label>
                                <input type="file" name="pcid" autocomplete="off" >
                            </div><br>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" id="ppwd" name="ppwd" placeholder="Enter your password"autocomplete="off" /><br>
                            </div>

                            <div class="form-group">
                                <label>Confirm Password</label>
                                <input  class="form-control" type="password" id="pcpwd" name="pcpwd" placeholder="Confirm your password" autocomplete="off" /><br>
                            </div>



                            <div class="form-group">
                                <button class="button-1" type="submit" name="pregister" value="sdgsdfg1"> Register</button>
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