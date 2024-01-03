<%-- 
    Document   : newradio
    Created on : Oct 30, 2020, 3:47:16 PM
    Author     : niranjanprasad M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
    </head>
    <body>
        <input type="radio" class="selectfileclass" name="file" id="xml" value="xml" />XML<br />
<input type="radio" class="selectfileclass" name="file" id="html" value="html" />HTML<br />
<input type="radio" class="selectfileclass" name="file" id="json" value="json" />JSON<br />

<span class="btn btn-default btn-file btn-primary">Browse<input type="file" id="ImportFile" accept=".xml" data-bind="event: { change: $root.Browse }"></span>
        <script>
       $('.selectfileclass').change(function() {
  $('#ImportFile').attr("accept", "." + $(this).val())
})
</script>
    </body>
</html>
