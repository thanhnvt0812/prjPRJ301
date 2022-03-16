<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="border: 1px solid greenyellow; color: blue; background: greenyellow">
            <h1 style="border: 1px solid greenyellow; padding-left: 580px; background: white; height:100px; padding-top: 50px; font-size: 50px " >Đăng nhập đêiiii</h1>
        </div>
        <div style="border: 1px solid gainsboro;padding-left: 50px;  margin-top: 100px; width: 300px; margin-left: 570px ">
            <h1>${mess}</h1>
            <form action="" method="POST" >

                <p>UserName: <input type="text" name="username" value = "">
                <p>Password: <input style="margin-left: 8px" type="password" name="password" value = "">
                    <br>
                    <br>
                    <select name="selectedRole" >
                        <option value="0">-Role-</option>
                        <option value="1">Teacher</option>
                        <option value="2">Student</option>
                    </select>
                <p style="padding-left: 120px"><input type="Submit" value="Login">

            </form>
        </div>

    </body>
</html>
