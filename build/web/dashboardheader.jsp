<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scaled=1, shrink-to-fit=no">
        <title>home page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>-->
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap');
            *{
                margin: 0;
                padding: 0; 
                box-sizing: border-box;
                font-family: "Josafin Slab",serif;
            }
            nav{
                width: 100%; height: 15vh;
                background: rgba(0,0,0,0.7);
                color: white; 
                display: flex; 
                justify-content: space-between;
                align-items: center;
                text_transform: uppercase;
            }
             .logo{
               margin: 0px;
/*               margin-top: 5px;*/
                
            }
            nav .logo-text{
                width: 25%; 
                text-align: center;
                position: relative;
                margin-left: 20px;
            }
            nav .menu{
                width: 70%; 
                height: 5vh;
                font-size: 24px;
                display: flex; 
                justify-content: flex-end;               
            } 
            nav .menu a{
                width: 15%;
                text-decoration: none;                
                color: white;
                font-weight: bold;
                
            }
            nav .menu a:hover{
                color: cyan;
            }

            main{
                width: 100%;
                height: 85vh;
                display: flex;
                justify-content: center;
                align-items: center; 
                color:white;
            }
            .btn,.btn-success{
                margin-right: 20px;
              
            }
            </style>
    </head>
    <body>
    
        <nav>
            <div class="logo"><img src='images/GMIT-logo.jpg' style='width:120px;height:100px'></div>
            <div class="logo-text" ><h2 style="font-size:25px;"><b> G.MADEGOWDA INSTITUTE OF TECHNOLOGY</b> </h2> </div>
            <div class="menu">                                              
                 <a href="dashboard.jsp">Home</a>
                 <a href="Register?logout=yes">Logout
                 </a>
                 <a href="#">   
                      <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("admin")) {%>
                <%=session.getAttribute("username")%><%}%>
                     
                     <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("principal")) {%>
                <%=session.getAttribute("pname")%><%}%>
                
                 <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("hod")) {%>
                <%=session.getAttribute("hname")%><%}%>
                
                 <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("faculty")) {%>
                <%=session.getAttribute("fname")%><%}%>
                
                 <% if (session.getAttribute("type") != null && session.getAttribute("type").equals("student")) {%>
                <%=session.getAttribute("sname")%><%}%>
                
                </a>
            </div>
        </nav>  
                <br><br>
<!--                 <a class="btn btn-success" style="float: right;" href ="dashboard.jsp">BACK</a>-->
    </html>
</body>