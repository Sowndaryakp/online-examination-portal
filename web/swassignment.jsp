<%@page import="model.swassignment"%>
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
.containerleft{
                background-color: white;
                padding:10px;
                width: 100%;
                
                margin-top: -120px;
                margin-bottom: -120px;
/*                margin-top: -100px;*/
/*                border-radius: 5px;
                box-shadow:1px 1px 10px grey; */
            }
             .pdf{
                width:100%;
                height: 100%;
                height:500px;
                padding: 0px;

            }
            .header {
                padding: 10px;
                float: left;
                width: 80%;
                font-size: 40px;
                text-align: center;
                background: white;
            }
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
            .leftcolumn {   
                float: left;
                width: 80%;
            }
            @media screen and (max-width: 800px) {
                .rightcolumn, .leftcolumn {   
                    width: 100%;
                    padding: 0;
                }
            }
            .card {
                background-color: white;
                padding: 20px;
                margin-top: 20px;
                margin-right: 15px;
                margin-left: 15px;
            }
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
            .btn:hover {
                background-color: RoyalBlue;
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
      <form method="post" action="swassignmentser">
            <div class="row">
                <div class="leftcolumn">
                    <div class="containerleft" >
                 
            <iframe title="result frame" class="pdf" id="pdf" name="pdf" src="fac_asgn_que/asgn1.pdf"></iframe>

                    </div><br><br>
                    <div class="card">
                        <br>
                        <br>
                        
                        <h2>ANSWER HERE</h2>
                        <textarea name="wasgn" id="wasgn" ></textarea>
                        <script>

                            CKEDITOR.replace('wasgn');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.
                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');

                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('wasgn', {
                                extraPlugins: 'abbr'
                            });
                        </script>


                        <!--                <a class="btn btn-success" href ="#">Submit</a>-->

                        <!--<button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>-->
                        <button class="btn" type="submit" name="swassignment" >Submit</button>
                    </div>
                    <br>


                </div>

            </div>
        </form>
        <br>         

        <%@include file="footer.jsp"%>
    </body>
</html>