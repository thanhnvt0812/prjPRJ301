<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>      
        <style >
            body{
                background-image:url('img/nha-alpha.jpg');
                background-size: 1600px 800px;
            }
        </style>
    </head>
    <body >
        <div>
<!--            <div style="border: 1px solid lightskyblue; color:blue ; background: lightskyblue">-->
            <div>
<!--                <h1 style="border: 1px solid lightskyblue; padding-left: 620px; background: white; height:100px; padding-top: 50px; font-size: 50px " >FPT University</h1>-->
                <h1 style="color: orange; padding-left: 580px; height:100px; padding-top: 50px; font-size: 50px " >FPT University</h1>
            </div>
            <div style="background-color: whitesmoke; border: 1px solid black;padding-left: 50px;  margin-top: 100px; width: 300px; margin-left: 570px ">
                <h1>${mess}</h1>
                <form action="" method="POST" >
                    <p>UserName: <input type="text" name="username" value = "" placeholder="Username">
                    <p>Password: <input style="margin-left: 8px" type="password" name="password" value = "" placeholder="Password">
                        <br>
                        <br>
                        <select name="selectedRole" >
                            <option value="0">-Role-</option>
                            <option value="1">Teacher</option>
                            <option value="2">Student</option>
                            <option value="3">Admin</option>
                        </select>
                    <p style="padding-left: 120px"><input type="Submit" value="Login">
                </form>
            </div>
        </div>
    </body>
</html>
