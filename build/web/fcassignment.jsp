<!DOCTYPE html>
<html>
    <head>
        <title>Exam </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <style>
            *{
                margin:0;
                padding: 0;
            }
            .panel-heading{
                box-shadow: 0px 3px 4px -1px rgba(8,6,4,5);
            }
            .panel-body{
                box-shadow: 0px 2px 5px 0px rgba(8,6,9,7);
            }
            .switch {
                position: relative;
                display: inline-block;
                width: 50px;
                height: 23px;
            }
            .switch input { 
                opacity: 0;
                width: 0;
                height: 0;
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
                border-radius: 20px;
                color: white;
                display: block;
                padding: 12px;
                font-size: 16px;
                background-color: cornflowerblue;
            }
            .button-1:hover{
                background-color: #2691d9;
            }
            .error{   
                color:red;
            }
            /*            input{
                            display: block;
                        }*/
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

        <% if (request.getAttribute("status") != null) {%>
        <div id="msg">  <%= request.getAttribute("status")%></div>
        <%}%>
        <br><br>
        <script>
            
            jQuery.validator.addMethod("checkname", function (value, element) {
                return /^[A-Za-z\s]+$/i.test(value);
            });
            
      
            jQuery(document).ready(function ($) {
                $("#main").validate({
                    rules: {
                        asgntitle: {
                            required: true,
                            minlength: 3,
                            maxlength: 30

                        },
                        asubjectname: {
                            required: true,
                            checkname: true,
                            minlength: 3,
                            maxlength: 50

                        },
                        asemester: {
                            required: true
                            
                        },
                        asgnpattern: {
                            required: true
                        }
                      
                    },
                    messages: {
                        asgntitle: {
                            required: "Please enter assignment title",
                            minlength: "Assignment title must be atleast 3 characters long",
                            maxlength:"Assignment title must be less than 30 characters"
                        },
                        asubjectname: {
                            required: "Please enter subject name",
                            checkname: "Please enter a valid subject name",
                            minlength: "Subject name must be atleast 3 characters long",
                            maxlength:"Subject name must be less than or equal to 50 characters"

                        },
                        asemester: {
                            required: "Please select semester"
                           
                        },
                        asgnpattern: {
                            required: "Please select assignmentpattern"
                            
                        }
                       
                    }

                });
            });
       
        </script>
        <!--create exam section-->
        <form method="post" id="main" action="Register" >
            <div class="container" >
                <div class="row col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                            <h2 style="text-align:center">Create New Assignment</h2>
                        </div>
                        <div class="panel-body"> 
                            <div class="form-group">
                                <label>Assignment Title</label>
                                <input  class="form-control" type="text"  id="asgntitle" name="asgntitle" placeholder="ex:Assignment_1" autocomplete="off" /> <br>
                            </div>
                            <div class="form-group">
                                <label>Subject Name</label>
                                <input  class="form-control" type="text"  id="asubjectname" name="asubjectname" placeholder="Enter the subject name" autocomplete="off" /> <br>
                            </div>
                            <div class="form-group"  >
                                <label>Semester</label><br>
                                <select class="dropdown" id="asemester" name="asemester">
                                    <option value="" >Select semester</option>
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
                            <div class="form-group"  >
                                <label>Assignment Pattern</label><br>
                                <select class="dropdown" id="asgnpattern" name="asgnpattern">
                                    <option value="" >Select Type</option> 
                                    <option id="adoc" name="adoc" value="adoc"> Upload PDF</option>
                                    <option id="aque" name="aque" value="aque"> Write Assignment questions</option>


                                </select>
                            </div><br>

                        </div>
                    </div>
                </div>
            </div><br>

            <!--Student workspace-->
<!--            <div class="container">
                <div class="row col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                            <h2 style="text-align:center">Student workspace</h2>
                        </div>
                        <div class="panel-body">

                            <div class="form-group">
                                <label>Writing area</label>
                                <label class="switch">
                                    <input type="checkbox" id="writingarea" name="writingarea">
                                    <span class="slider round"></span>
                                </label><br><br>
                                <label>Drawing tool</label>
                                <label class="switch" >
                                    <input type="checkbox" id="drawingtool" name="drawingtool">
                                    <span class="slider round"></span>
                                </label><br><br>
                                <label>Scan handwritten work with webcam
                                </label>
                                <label class="switch">
                                    <input type="checkbox" id="scan" name="scan">
                                    <span class="slider round"></span>
                                </label><br>
                            </div>

                        </div>
                    </div>
                </div>
            </div><br>-->
<!--            <div class="container">
                <div class="row col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                            <h2 style="text-align:center">Security</h2>
                        </div>
                        <div class="panel-body">
                                                       <div class="form-group">  
                                                            
                                                            <div>
                                                                <label class="radio-inline">  <input type="radio" id="security" name="security"  onchange="v('low')">Allow any browser</label><br><br>
                            
                                                                <label class="radio-inline" >  <input type="radio" id="security" name="security" onchange="v('high')" >Require high-security mode</label>
                            
                                                                <label for="security" class="error"></label>
                                                                <input type="hidden" name="esecurity">
                            </div>
                                                            </div>
                            <div class="form-group">  
                                <label>Security</label>
                                <div>
                                    <label class="radio-inline">  <input type="radio" id="security" name="security"  onchange="v('low')">Allow any browser</label>

                                    <label class="radio-inline" >  <input type="radio" id="security" name="security" onchange="v('high')" >Require high-security mode</label><br>

                                    <label for="security" class="error"></label>
                                    <input type="hidden" name="esecurity">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div> -->
        <div class="container">
            <div class="row col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-body" style="height: 100px; padding: 30px;">

                        <center>
                            <div class="form-group">
                                <button class="button-1" type="submit" name="fcassignment">Create the Assignment</button>
                            </div>
                        </center>

                    </div>
                </div>
            </div>
        </div>
    </form>

    <script type="text/javascript">

//            function test() {
//
//                if (document.form.choice.value = 'wa') {
//
//                    window.open('question.jsp', '_self');
//
//                    return true;
//                }
//            }
//            function test1() {
//                if (document.form.choice.value = 'mc') {
//
//                    window.open('mcq.jsp', '_self');
//
//                    return true;
//                }
//            }
//            function upload() {
//                if (document.form.choice.value = 'pdf') {
//
//                    open.(input type = "file");
//                            return true;
//                }
//            }
    </script>

</body>
</html>