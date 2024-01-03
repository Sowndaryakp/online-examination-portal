<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.1.3/js/fileinput.min.js "> </script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>upload PDF Page</title>
    </head>
    <body>
        <style>
            .button-1{
                width:18%;
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

        <%@include file="dashboardheader.jsp"%>
        <br><br><br>
       <% if (request.getAttribute("status") != null) {%>
        <h1 class="errmsg"> <%= request.getAttribute("status")%></h1>
        <%}%>
        <br>
         <script>
         jQuery(document).ready(function ($) {
                $("#pdfform").validate({
                    rules: {
                        doc: {
                            required: true

                        }
                         },
                    messages: {
                        doc: {
                            required: "Please upload question paper"
                          
                        }
                    }
                      });
            });
                    </script>
        <div class="container">
            <div class="row col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                        <h2 style="text-align:center">Upload Assignment  </h2>
                    </div>
                    <div class="panel-body">


                        <form method="post" id="pdfform" action="Register" enctype="multipart/form-data"> 
                            <div class="form-group">
                                <label>Upload file</label>
                                <input type="file" name="sdoc" id="sdoc">
                            </div><br>
                            <center>
                                <div class="form-group">
                                    <button class="button-1" type="submit" name="sassignment" > Finish</button>
                                </div>
                            </center>
                        </form>                
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>  

