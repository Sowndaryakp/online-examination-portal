<%@page import="model.MCQ"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>MCQ</title>
        <script src="https://cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
        <script src="https://pagecdn.io/lib/ckeditor/4.13.0/ckeditor.js" ></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <style>
            h3{
                font-size: 18px;
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
<!--       <script>
            jQuery(document).ready(function ($) {
                $("#fform").validate({
                    rules: {
                        question: {
                            required: true,
        
                            minlength: 10,
                            maxlength: 1000
                        },
                        op1: {
                            required: true
                        

                        },
                        op2: {
                            required: true
                        },
                        op3: {
                            required: true
                          
                        },
                        op4: {
                            required: true
                        },
                        crctans: {
                            required: true
                        }
                    },
                    messages: {
                        question: {
                            required: "Please enter your question",
                            minlength: "Question must be atleast 10 characters long",
                            maxlength:"Question must be less than 1000 characters"
                        },
                        op1: {
                            required: "Please enter your option 1"
                        },
                        op2: {
                            required: "Please enter your option 2"
                        },
                        op3: {
                            required: "Please enter your option 3"
                        },
                        op4: {
                            required: "Please enter your option 4"
                        },
                        crctans: {
                            required: "Please select your crctans"
                        }
                    }
                });
            });
        </script>-->

        
        <% if (request.getAttribute("status") != null) {%>
        <div id="msg">  <%= request.getAttribute("status")%></div>
        <%}%>
        
        <% MCQ m = new MCQ(session);
            int noofque = m.FetchLastSet(request.getParameter("examid"));
            

        %>

        <br> <br>
       
        <div class="container" >
            <div class="row col-md-9 col-md-offset-2">
                <!--<div class="panel panel-primary">-->
                <form id='main'>
                    <h3><b>Question</b></h3>
                    <h4><span><input type="hidden" name="noofque" value="noofque">No of Question Posted <strong id='noofque'>0</strong>
                        </span></h4>
                    <div>

                        <textarea name="question" id="question" ></textarea>
                        <script>

                            CKEDITOR.replace('question');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.
                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');

                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('question', {
                                extraPlugins: 'abbr'
                            });
                        </script>
                    </div>
                    <br><br><br>
                    <h3><b>option 1</b></h3>
                    <div>
                        <textarea name="op1" id="op1"></textarea>
                        <script>

                            CKEDITOR.replace('op1');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.
                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');

                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('op1', {
                                extraPlugins: 'abbr'
                            });
                        </script>
                    </div>
                    <br><br><br>
                    <h3><b>option 2</b></h3>
                    <div>
                        <textarea name="op2" id="op2"></textarea>
                        <script>

                            CKEDITOR.replace('op2');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.


                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('op2', {
                                extraPlugins: 'abbr'
                            });
                        </script>
                    </div>
                    <br><br><br>
                    <h3><b>option 3</b></h3>
                    <div>
                        <textarea name="op3" id="op3"></textarea>
                        <script>

                            CKEDITOR.replace('op3');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.
                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');

                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('op3', {
                                extraPlugins: 'abbr'
                            });
                        </script>
                    </div>
                    <br><br><br>
                    <h3><b>option 4</b></h3>
                    <div>
                        <textarea name="op4" id="op4" ></textarea>
                        <script>

                            CKEDITOR.replace('op4');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.
                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');

                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('op4', {
                                extraPlugins: 'abbr'
                            });
                        </script>
                    </div>
                    <br><br>
                    <h3><b>Correct Option</b></h3>

                    <input type="radio"  name="choice" onclick="setcrctans('1')" >1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio"  name="choice" onclick="setcrctans('2')">2 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio"  name="choice" onclick="setcrctans('3')">3 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio"  name="choice" onclick="setcrctans('4')" >4 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="hidden" name="crctans" id="crctans" value="">
                    <input type="hidden" name="examid" id="examid" value="<%=request.getParameter("examid")%>">
                    <br><br>
                    <button class="btn btn-success" type="button" id="next" onclick="Next();">Next</button> 
                    <!--<button class="btn btn-success" type="button" id="submit" onclick="Submit();">Submit</button>-->
                    <br><br><br>
                 </form>
            </div>

            <script>
                
                function setcrctans(va) {
                    $("#crctans").val(va);
                }
               var qcount=0;
                function Next() {
                    
                    $.ajax({
                        type: 'post',
                        url: 'mcqser',
                        dataType: 'json',
                        data: 'mcq=mcq&question=' + CKEDITOR.instances.question.getData() + '&&op1=' + CKEDITOR.instances.op1.getData() + '&&op2=' + CKEDITOR.instances.op2.getData() + '&&op3=' + CKEDITOR.instances.op3.getData() + '&&op4=' + CKEDITOR.instances.op4.getData() + '&crctans=' + $("#crctans").val() + '&examid=' + $("#examid").val(),
                        success: function (data) {
                            if (data.status == "Inserted") {
                                $("#noofque").text(++qcount);
                                CKEDITOR.instances.question.setData("");
                                CKEDITOR.instances.op1.setData("");
                                CKEDITOR.instances.op2.setData("");
                                CKEDITOR.instances.op3.setData("");
                                CKEDITOR.instances.op4.setData("");
                            }
                            if(qcount==<%=noofque%>){
                                window.location.href="dashboard.jsp";
                            }
                        }

                    });
                     jQuery(document).ready(function ($) {
                $("#main").validate({
                    rules: {
                        question: {
                            required: true,
        
                            minlength: 10,
                            maxlength: 1000
                        },
                        op1: {
                            required: true
                        

                        },
                        op2: {
                            required: true
                        },
                        op3: {
                            required: true
                          
                        },
                        op4: {
                            required: true
                        },
                        crctans: {
                            required: true
                        }
                    },
                    messages: {
                        question: {
                            required: "Please enter your question",
                            minlength: "Question must be atleast 10 characters long",
                            maxlength:"Question must be less than 1000 characters"
                        },
                        op1: {
                            required: "Please enter your option 1"
                        },
                        op2: {
                            required: "Please enter your option 2"
                        },
                        op3: {
                            required: "Please enter your option 3"
                        },
                        op4: {
                            required: "Please enter your option 4"
                        },
                        crctans: {
                            required: "Please select your crctans"
                        }
                    }
                });
            });
         
                }
            </script>
        </div>
                   

        <%@include file="footer.jsp"%>
    </body>
</html>