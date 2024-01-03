<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>question descriptive</title>
        <script src="https://cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
        <script src="https://pagecdn.io/lib/ckeditor/4.13.0/ckeditor.js" ></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <style>
/*            .button-1{

                width:25%;
                border: none;
                border-radius: 20px;
                color: white;
                display: block;
                padding: 12px;
                font-size: 16px;
                background-color: cornflowerblue;
            }*/
            .button-1:hover{
                background-color: #2691d9;
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
 
        <%@include file="dashboardheader.jsp"%>
        <br><br>
        
        <% if (request.getAttribute("status") != null) {%>
        <div id="msg">  <%= request.getAttribute("status")%></div>
        <%}%>
        <br> <br>
        <div class="container" >
            <div class="row col-md-9 col-md-offset-2">
                <!--<div class="panel panel-primary">-->
                <form id='main' method="post" action="Register">
                    <h1>Create Question</h1>
                    <div>

                        <textarea name="aque" id="aque" ></textarea>
                        <script>

                            CKEDITOR.replace('aque');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.
                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');

                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('aque', {
                                extraPlugins: 'abbr'
                            });
                        </script>
                    </div>
 
                    <br><br>
                    <button class="btn btn-success" type="submit" id="aquestion" name="aquestion" >Next</button> 
                    <br><br><br>
                 </form>
            </div>

            <script>
//               var qcount=0;
//                function Next() {
//                    $.ajax({
//                        type: 'post',
//                        url: 'questionser',
//                        dataType: 'json',
//                        data: 'question=question&que=' + CKEDITOR.instances.que.getData() ,
//                        success: function (data) {
//                            if (data.status == "Inserted") {
//                               
//                                CKEDITOR.instances.question;
//       
//                            }
//                        }
//
//                    });
                     jQuery(document).ready(function ($) {
                $("#main").validate({
                    rules: {
                        aque: {
                            required: true,
        
                            minlength: 10,
                            maxlength: 1000
                        }
                    },
                    messages: {
                        aque: {
                            required: "Please enter your question",
                            minlength: "Question must be atleast 10 characters long",
                            maxlength:"Question must be less than 1000 characters"
                        }
                    }
                });
            });
         
                }
            </script>
        </div>
        <br>         

        <%@include file="footer.jsp"%>
    </body>
</html>