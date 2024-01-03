<%-- 
    Document   : sturesults
    Created on : Jun 14, 2021, 11:23:36 AM
    Author     : niranjanprasad M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        
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
                width: 30%; 
                margin: auto;
                float: top;
                text-align: center;
                box-shadow:1px 1px 10px grey; 
                border-radius: 5px;
            }
            .jumbotron{
                box-shadow:1px 1px 10px grey; 
                border-radius: 5px;
                
            }
        </style>
        
        <style>
            .errmsg{
                background: green;
                padding: 6px;
                width: 50%;
                color: white;
                font-weight: bold;
            }
            .jumbotron{
                background-color: white;
            }
            /*        #search
                    {
                        width: 50%; 
                    }*/

        </style>
    </head>
    <body>
        
        <div class="header">
            <h2> "MY RESULTS" </h2>
        </div>
        
        <center>
       
             <br>
        
        
        
        
        <div class="container ">
            <div class="jumbotron">
<!--                <font color="black" size="6" style="margin:2px;">
                Unit test or Individual test results 
                </font>-->
                <!--                 <input class="form-control" id="search" type="text" placeholder="Search..">-->
                <p style="float:left;">USN : 4MG17CS018</p>
                
                <table class="table" style="margin-top:-20px;">
                    <thead>
                        <tr style="background-color: lightblue;">
                    <br>
                    <th>Slno</th>
                    <th>SEM</th>
                    <th>Subject Code</th>
                    <th>Subject Name</th>
                    <th>Marks</th>
                    <th>Result</th>
                                 
                    
                    
                    
                    </tr>
                    <tr>
                    <td>1.</td>
                    <td>7th</td>
                    <td>17CS71</td>
                    <td>Web Technology</td>
                    <td>98</td>
                    <td>P</td>
                    </tr>
                    
                    <tr>
                    <td>2.</td>
                    <td>7th</td>
                    <td>17CS72</td>
                    <td>Adavanced Computer Architecture</td>
                    <td>92</td>
                    <td>P</td>
                    </tr>
                    
                    <tr>
                    <td>3.</td>
                    <td>7th</td>
                    <td>17CS73</td>
                    <td>Machine Learning</td>
                    <td>89</td>
                    <td>P</td>
                    </tr>
                    
                    <tr>
                    <td>4.</td>
                    <td>7th</td>
                    <td>17CS742</td>
                    <td>Cloud Computing</td>
                    <td>79</td>
                    <td>P</td>
                    </tr>
                    
                    <tr>
                    <td>5.</td>
                    <td>7th</td>
                    <td>17CS754</td>
                    <td>Storage Area Network</td>
                    <td>85</td>
                    <td>P</td>
                    </tr>
                    
                    
                    </thead>
<!--                    <tbody id="table">
                       
                        <tr>
                            
                            
                            <td>
                                <a class="btn btn-success" href ="fapprove?slno=">Approve</a>
                                <a class="btn btn-danger" href ="fdelete?slno=">Delete</a>

                            </td>
                        </tr> 

                        
                    </tbody>-->
                </table>
            </div>
        </div>                      
    </center>
        
        
    </body>
</html>
