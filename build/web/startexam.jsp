<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.1.3/js/fileinput.min.js "></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Start exam</title>
    </head>
    <body>
        <style>



            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                padding-top: 100px; /* Location of the box */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            }

            /* Modal Content */
            .modal-content {
                background-color: #fefefe;
                margin: auto;
                padding: 20px;
                border: 1px solid #888;
                height: 30%;
                width: 30%;
            }

            /* The Close Button */
            .close {
                color: #aaaaaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: #000;
                text-decoration: none;
                cursor: pointer;
            }
            .errmsg{
                background: green;
                padding: 6px;
                width: 50%;
                color: white;
                font-weight: bold;
            }
            .error{   
                color:red;
            }
        </style>

        <script>
            jQuery(document).ready(function ($) {
                $("#fform").validate({
                    rules: {
                        subcode: {
                            required: true,
                            minlength: 6,
                            maxlength: 10


                        },
                        messages: {
                            subcode: {
                                required: "Please enter subject code",
                                minlength: "the code must be atleast 6 characters long",
                                maxlength: "the code must be less than 10 characters"
                            }
                        }
                    }
                });
            });
        </script>

        <%@include file="dashboardheader.jsp"%>
        <br><br><br>
        <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%>
        <br>

        <form method="post" id="fform" action="Register" enctype="multipart/form-data"> 
            <div class="container">
                <div class="row col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                            <h2 style="text-align:center">Start Exam</h2>
                        </div>

                        <div class="panel-body">
                            <div class="form-group">
                                <label>Subject code</label>
                                <input  class="form-control" type="text"  id="subcode" name="subcode" placeholder="Enter Subject Code" autocomplete="off" /> <br>
                            </div>
                            <br><br>
                            <!--!-- Trigger/Open The Modal -->
                            <button id="myBtn" class="btn btn-primary" >Next</button>


                            <div id="myModal" class="modal">
                                <% if (request.getAttribute("host") != null) {%>
                                <!-- Modal content -->
                                <div class="modal-content " style="text-align:center;">
                                    <span class="close">&times;</span>
                                    <b><label style="font-size:24px;font-family:cursive;">Good Luck ! </label></b><br>
                                    <br><br>
                                    <button id="myBtn" class="btn btn-primary" style="width:30%;border-radius:20px;font-size:20px;">Start</button>

                                </div>
                                <%}%>

                            </div>

                            <script>
                                // Get the modal
                                var modal = document.getElementById("myModal");

                                // Get the button that opens the modal
                                var btn = document.getElementById("myBtn");

                                // Get the <span> element that closes the modal
                                var span = document.getElementsByClassName("cl.ose")[0];

                                // When the user clicks the button, open the modal 
                                btn.onclick = function () {
                                    modal.style.display = "block";
                                }

                                // When the user clicks on <span> (x), close the modal
                                span.onclick = function () {
                                    modal.style.display = "none";
                                }

                                // When the user clicks anywhere outside of the modal, close it
                                window.onclick = function (event) {
                                    if (event.target == modal) {
                                        modal.style.display = "none";
                                    }
                                }
                            </script>



                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>  
