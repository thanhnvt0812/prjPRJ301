<%-- 
    Document   : studetnManager
    Created on : Jul 15, 2021, 12:26:44 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="cssStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div style="border: 1px solid greenyellow; color: blue; background: greenyellow">
            <header>
                <h1 style="border: 1px solid greenyellow; padding-left: 580px; background: white; height:100px; padding-top: 50px; font-size: 50px ">FBT Education</h1>
            </header>
        </div>
        <div style="border: 0px solid black">
            <h1 style="font-size: 45px; background-color: gainsboro; padding-left: 550px">Xin chào ${sessionScope.username}</h1>
            <a href="logout" style="padding-left: 1350px; text-decoration: none; font-size: 20px; font-weight: bold">Logout</a>
        </div>
        <div class="bodyform">
            <div class="bodyform-left">
                <div class="watch" >
                    <a href="studentSchedule" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none; ">Watch my Schedule</a>
                    <br>
                    <a href="studentAttendance" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none; ">Watch my Attendance</a>
                </div>
            </div>
            <div class="bodyform-right">

            </div>
        </div>
        <!--<a href="/watchSchedule">Watch my Schedule</a>
        <br>
        <a href="/watchAttendance">Watch my Attendance</a> -->

    </body>
</html>
