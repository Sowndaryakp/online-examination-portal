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
            .slider {
                position: absolute;
                cursor: pointer;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: #ccc;
                -webkit-transition: .4s;
                transition: .4s;
            }
            .slider:before {
                position: absolute;
                content: "";
                height: 21px;
                width: 21px;
                left: 1px;
                bottom: 1.2px;
                background-color: white;
                -webkit-transition: .4s;
                transition: .4s;
            }
            input:checked + .slider {
                background-color: #2196F3;
            }
            input:focus + .slider {
                box-shadow: 0 0 1px #2196F3;
            }
            input:checked + .slider:before {
                -webkit-transform: translateX(26px);
                -ms-transform: translateX(26px);
                transform: translateX(26px);
            }
            /* Rounded sliders */
            .slider.round {
                border-radius: 34px;
            }
            .slider.round:before {
                border-radius: 50%;
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
        </style>

    </head>
    <body>
        <br><br>
        <!--create exam section-->
        <form method="post"  action="Register" >
        <div class="container" >
            <div class="row col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                        <h2 style="text-align:center">Create New Exam</h2>
                    </div>
                    <div class="panel-body"> 
                            <div class="form-group">
                                <label>Exam Title</label>
                                <input  class="form-control" type="text"  id="examtitle" name="examtitle" placeholder="Enter the Title to an Exam" autocomplete="off" /> <br>
                            </div>
                            <div class="form-group">
                                <label>Subject Name</label>
                                <input  class="form-control" type="text"  id="subjectname" name="subjectname" placeholder="Enter the subject name" autocomplete="off" /> <br>
                            </div>
                            <div class="form-group"  >
                                <label>Semester</label><br>
                                <select class="dropdown" id="semester" name="semester">
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
                                <label>Exam Pattern</label><br>
                                <select class="dropdown" id="exampattern" name="exampattern">
                                    <option value="" >Select Type</option> 
                                    <option name="pdf" id="pdf"> Upload PDF</option>
                                    <option name="write" id="write"> Write exam questions</option>
                                    <option name="mcq" id="mcq" onclick=""> Multiple choice </option>
                                    
                                    
                                </select>
                                <input type="hidden" name="noq" id="noq" >No Of Question
                            </div><br>
                        
                    </div>
                </div>
            </div>
        </div><br>
        <!--Exam pattern-->
<!--        <div class="container">
            <div class="row col-md-9 col-md-offset-2">
                <div class="panel panel-primary">
                    <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                        <h2 style="text-align:center">Exam Pattern</h2>
                    </div>
                    <div class="panel-body">
                        <form name="form" method="post" id="eform" action="exam" enctype="multipart/form-data"> 
                            <div class="form-group">
                                <div>
                                    <label class="radio-inline"> 


                                        <input type="radio" id="file"  name="choice" onclick="type='file'">Upload PDF file 

                                        

                                    </label>
                                    <br><br>
                                    <label class="radio-inline" > 
                                                                                <input type="radio" onClick="test()" name="choice" value="wa"> Write exam questions</label><br>
                                    <br>
                                    <label class="radio-inline" > 
                                        <input type="radio" onClick="test1()" name="choice" value="mc" onchange="v('question')" >Multiple choice</label><br>
                                   

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><br>-->
        
        <!--Student workspace-->
        <div class="container">
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
<!--                                                                <label>Calculator</label>
                                                                <label class="switch">
                                                                    <input type="checkbox">
                                                                    <span class="slider round"></span>
                                                                </label>
                                                                <br><br>-->
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
        </div><br>
        <div class="container">
            <div class="row col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading" style="height: 60px; padding: 0.1px;">
                        <h2 style="text-align:center">Security</h2>
                    </div>
                    <div class="panel-body">
             
                            <div class="form-group">

                                <div>
                                    <label class="radio-inline">  <input type="radio" id="low" name="security"  onchange="v('low')">Allow any browser</label>
                                </div><br>
                                <div>
                                    <label class="radio-inline">  <input type="radio" id="high" name="security"  onchange="v('high')" >Require high-security mode</label>
                                </div>
                                <label for="security" class="error"></label>
                                    <input type="hidden" name="security">
                            </div>
                           <div class="form-group">  
                                
                                <div>
                                    <label class="radio-inline">  <input type="radio" id="security" name="security"  onchange="v('low')">Allow any browser</label><br><br>

                                    <label class="radio-inline" >  <input type="radio" id="security" name="security" onchange="v('high')" >Require high-security mode</label>

                                    <label for="security" class="error"></label>
                                    <input type="hidden" name="esecurity">
                                </div>
                            </div>
                        
                    </div>
                </div>
            </div>
        </div> 
        <div class="container">
            <div class="row col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-body" style="height: 100px; padding: 30px;">
                     
                            <center>
                                <div class="form-group">
                                    <button class="button-1" type="submit" name="createexam">Create the exam</button>
                                </div>
                            </center>
                        
                    </div>
                </div>
            </div>
        </div>
         </form>
       
        <script type="text/javascript">
              function v(val) {
                $("input[name=esecurity]").val(val);

            }
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
