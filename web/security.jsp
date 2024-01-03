<%-- 
    Document   : security
    Created on : Aug 11, 2021, 11:47:14 PM
    Author     : niranjanprasad M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Camera Security</title>
    </head>
    <body>
<!--        <video autoplay loop id="bbgVid">
<source src="start/settings/privacy/camera" type="video/mp4">
<source src="style/mpVideos/mpv2.mp4" type="video/mp4">
</video>-->


<center><video id="video" width="640" height="480" autoplay></video></center>

<script>
    var video = document.getElementById('video');
if(navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
 navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
 video.src = window.URL.createObjectURL(stream);
 video.play();
 });
}
</script>
    </body>
</html>
