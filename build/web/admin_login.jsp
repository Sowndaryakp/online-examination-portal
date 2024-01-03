<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scaled=1.0">
        <title>admin login page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap');
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                user-select: none;
                color: white;
            }
            .bg-img{
                background: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.5)),url('images/gmit_Hbg.jpg');
                height: 100vh;
                background-size: cover;
                background-position: center; 
            }
            nav{
                width: 100%; height: 14vh;
                background: rgb(0 0 0 / 58%);
                color: white; 
                display: flex; 
                justify-content: space-between;
                align-items: center;
                text_transform: uppercase;
            }
            /*            nav .logo{
                           align:center;
                            
                        }*/
            nav .logo-text{
                width: 25%; 
                text-align: center;
                position: relative;
            }
            nav .menu{
                width: 70%; 
                height: 5vh;
                font-size: 20px;
                display: flex; 
                justify-content: flex-end;               
            } 
            nav .menu a{
                width: 10%;
                text-decoration: none;                
                color: white;
                font-weight: bold;
            }
            .content{
                position: absolute;
                top: 50%;
                left: 50%;
                z-index: 999;
                text-align: center;
                padding: 60px 32px;
                width: 370px;
                transform: translate(-50%,-50%);
                background: rgba(255,255,255,0.04);
                box-shadow: -1px 4px 28px 0px rgba(50,6,9,7);
                border-radius: 30px;
            }
            .content header{
                color: white;
                font-size: 33px;
                font-weight: 600;
                margin: 0 0 35px 0;
                font-family: 'Montserrat',sans-serif;
            }
            .field{
                position: relative;
                height: 45px;
                width: 100%;
                display: flex;
                background: rgba(255,255,255,0.94);
                border-radius: 10px;
            }
            .field space{
                color: #3498db;
                width: 40px;
                line-height: 45px;
            }
            .field input{
                height: 100%;
                width: 100%;
                background: transparent;
                border: none;
                outline: none;
                color: #222;
                font-size: 16px;
                font-family: 'Poppins',sans-serif;
            }
            .space{
                margin-top: 16px;
            }
            .show{
                position: absolute;
                right: 13px;
                font-size: 13px;
                font-weight: 700;
                color: #222;
                display: none;
                cursor: pointer;
                font-family: 'Montserrat',sans-serif;
            }
            .pass-key:valid ~ .show{
                display: block;
            }
            .pass{
                text-align: left;
                margin: 10px 0;
            }
            .pass a{
                color: white;
                text-decoration: none;
                font-family: 'Poppins',sans-serif;
            }
            .pass:hover a{
                text-decoration: underline;
            }
            .field input[type="submit"]{
                background: linear-gradient(360deg,transparent,#3498db);
                border: 1px solid #2691d9;
                color: white;
                font-size: 18px;
                letter-spacing: 1px;
                font-weight: 600;
                cursor: pointer;
                font-family: 'Montserrat',sans-serif;
            }
            .login{
                color: white;
                margin: 20px 0;
                font-family: 'Poppins',sans-serif;
            }
            a{
                color: yellow;
                text-decoration: blink;
            }
            .footer {

                position: absolute;
                width: 100%;
                background-color: #353535;
                color: white;
                text-align: center;
                bottom: -110;
                padding: 35px 50px;
                padding-top: 0px;
                padding-right: 50px;
                padding-bottom: -0;
                padding-left: 20px;

            }   
        </style>
    </head>
    <body>
        <nav>
            <div class="logo"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px;margin-left: 2px;margin-top: -1px;'></div>
             <div class="logo-text" ><h1 > G.MADEGOWDA INSTITUTE OF TECHNOLOGY </h1> </div>
            <div class="menu">                                              
                <a href="index.jsp">Home</a>
                <a href="http://gmitmandya.in">About us</a> 
            </div>
        </nav>
        <div class="bg-img">
            <div class="content">
                <header>ADMIN LOGIN</header>
                <form method="POST" id="adminlogin" action="Register">
                    <div class="field">
                        <input type="text" name="username" style="padding:10px;"   required placeholder="Username">
                    </div>
                    <div class="field space">
                        <input type="password" class="pass-key" name="password" style="padding:10px;" required placeholder="Password">
                        <!--            <span class="show">SHOW</span>-->
                    </div>
                    <div class="pass">
                        <a href="#">Forgot Password?</a>
                    </div>
                    <div class="field">
                        <input type="submit" name="adminlogin" value="LOGIN">
                    </div><br><br><br><br>

                </form>
                <div class="login">
                </div>
            </div>
        </div>
        <!--<script>
             showBtn.addEventListener('click', function(){
               if(pass_field.type === "password"){
                 pass_field.type = "text";
                 showBtn.textContent = "HIDE";
                 showBtn.style.color = "#3498db";
               }else{
                 pass_field.type = "password";
                 showBtn.textContent = "SHOW";
                 showBtn.style.color = "#222";
               }
              });
            </script>-->
         <%@include file="footer.jsp"%>    
    </body>
</html>
