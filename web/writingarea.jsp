<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Writing Area</title>
        <script src="https://cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
        <script src="https://pagecdn.io/lib/ckeditor/4.13.0/ckeditor.js" ></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <style>
            .button{
                width:25%;
                border: none;
                border-radius: 4px;
                color: white;
                display: block;
                padding: 12px;
                font-size: 16px;
                background-color: cornflowerblue;

            }
            .button:hover{
                background-color: #2691d9;
            }
        </style> 
    </head>
    <body>
        <br>
<!--        <div class="container" >
            <div class="row col-md-9 col-md-offset-2">
                <div class="panel panel-primary">-->
                   <div>

                        <textarea name="que" id="que" ></textarea>
                        <script>

                            CKEDITOR.replace('que');
                            // Enable local "abbr" plugin from /myplugins/abbr/ folder.
                            //                        CKEDITOR.plugins.addExternal('abbr', '/myplugins/abbr/', 'plugin.js');

                            // extraPlugins needs to be set too.
                            CKEDITOR.replace('que', {
                                extraPlugins: 'abbr'
                            });
                        </script>
                   </div>
               
        

                   
    </body>
</html>