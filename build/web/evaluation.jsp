<%-- 
    Document   : evaluation
    Created on : Jun 11, 2021, 3:16:19 PM
    Author     : niranjanprasad M
--%>

<!DOCTYPE html>
<%@page import="model.pstudent"%>
<%@page import="model.Registration"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <style>
            * {
                box-sizing: border-box;
            }

            /* Add a gray background color with some padding */
            body {
                font-family: Arial;
                padding: 10px;
                background: #f1f1f1;
            }

            .header{   
                background-color: white;
                padding:10px;
                width: 100%; 
                margin: auto;
                float: top;
                text-align: center;
                box-shadow:1px 1px 10px grey; 
                border-radius: 5px;
            }
            .containerleft{
                background-color: white;
                padding:10px;
                width: 68%;
                margin-top: 20px;
                border-radius: 5px;
                box-shadow:1px 1px 10px grey; 
            }
            .studetails{
                padding: 0px 10px 0px 30px;
            }


            .pdf{
                width:100%;
                height: 200%;
                height:1100px;

            }

            .containerright{
                background-color: white;
                padding:10px;
                width: 30%;
                float: right;
                margin-top: -1290px;
                box-shadow:1px 1px 10px grey; 
                border-radius: 20px;
            }
            .btn {
                width:150px;
                height: 50px;
                font-size: 20px;
                background-color: lightgreen;
                border-radius: 20px;
                margin-left: 150px;
            }
            .btn:hover{
                background-color:green;
            }
            
            .btnp{
                margin-left: 400px;
            }



        </style>
    </head>



    <body>

        <div class="header">
            <h2> "WELCOME TO EVALUATION" </h2>
        </div>




        <div class="containerleft" >
            <div class="studetails">
            <h4>STUDENT DETAILS</h4>
            <p>NAME : NIRANJAN </p>
            <p>USN : 4MG17CS018</p>
            </div>
            <button type=submit class="btnp" onclick=" window.open('stu_exam_ans/ANSWER.pdf'); return true;"> OPEN PDF in another Window</button>
            <a data-toggle="iframe" data-target="stu_exam_ans/ANSWER.pdf" data-backdrop="static" onclick="fetchpdf('pdf');">PDF</a>
            <br><br>       
            <iframe title="result frame" class="pdf" id="pdf" name="pdf" src="stu_exam_ans/ANSWER.pdf"></iframe>

        </div>







        <div class="containerright">
            <h4 style="text-align: center;">Enter your marks to respective question numbers</h4>

            <label>1.</label>
            <input type="number"><h4 style="text-align:center;">OR</h4>
            <label>2.</label>
            <input><br><br><hr><br>

            <label>3.</label>
            <input><h4 style="text-align:center;">OR</h4>
            <label>4.</label>
            <input><br><br><hr><br>

            <label>5.</label>
            <input><h4 style="text-align:center;">OR</h4>
            <label>6.</label>
            <input><br><br><hr><br>

            <label>7.</label>
            <input><h4 style="text-align:center;">OR</h4>
            <label>8.</label>
            <input><br><br><hr><br>

            <label>9.</label>
            <input><h4 style="text-align:center;">OR</h4>
            <label>10.</label>
            <input><br><br><hr><br>

            <p><a href="dashboard.jsp"><button class="btn">Submit</button></a></p>


        </div>


<!--
<script>
            function fetchpdf(pdf){
                
               var Myiframe = document.getElementById(pdf);
               
               var content = Myiframe.contentWindow.document.body.innerHTML;
               
               
           }
            </script>-->


    </body>
</html>
