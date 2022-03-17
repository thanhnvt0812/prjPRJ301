<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1 style="border: 1px solid greenyellow; padding-left: 580px; background: white; height:100px; padding-top: 50px; font-size: 50px ">FPT Education</h1>
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
                <div style="margin-top:20px;">
                    <ul>
                        <c:forEach items="${listStdSubAttendance}" var="listStdSubAttendance">
                            <li>
                                <a href="studentAttendance?subjectCode=${listStdSubAttendance.subjectCode}&&className=${listStdSubAttendance.className}" style="text-decoration: none; font-weight: bold; color: brown">
                                    ${listStdSubAttendance.subjectCode} - ${listStdSubAttendance.subjectName}
                                    at class ${listStdSubAttendance.className} (Start ${listStdSubAttendance.dates})
                                </a>

                            </li>
                        </c:forEach>

                    </ul>
                </div>
            </div>

            <div class="bodyform-right">
                <div class="tableAttendance">
                    <table border="1">
                        <thead>
                            <tr style="background-color: background">
                                <th>DATE</th>
                                <th>SLOT</th>
                                <th>LECTURER</th>
                                <th>CLASS</th>
                                <th>ATTENDANCE STATUS</th>
                                <th>NOTES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listStdSubAttendanceDetail}" var="listStdSubAttendanceDetail">
                                <tr>
                                    <th>${listStdSubAttendanceDetail.dates}</th>
                                    <th>${listStdSubAttendanceDetail.id}</th>
                                    <th>${listStdSubAttendanceDetail.username}</th>
                                    <th>${listStdSubAttendanceDetail.className}</th>
                                    <th>
                                        <c:if test="${listStdSubAttendanceDetail.statusAttend==1}">
                                            <p style="color: greenyellow">Attend</p> 
                                        </c:if>
                                        <c:if test="${listStdSubAttendanceDetail.statusAttend==0}">
                                            <p style="color: red">Absent</p>
                                        </c:if>
                                        <c:if test="${listStdSubAttendanceDetail.statusAttend==2}">
                                            <p>Future</p>
                                        </c:if>
                                    </th>
                                    <th>${listStdSubAttendanceDetail.notes}</th>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>


            </div>
        </div>
    </body>
</html>
