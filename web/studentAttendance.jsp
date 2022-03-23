<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="cssStyle.css" rel="stylesheet" type="text/css"/>
        <style >
            body{
                background-image:url('img/4301_Ynh-1-TrYYng-YYi-hYc-FPT.jpg');
                background-size: 1730px 900px;
            }
        </style>     
    </head>
    <body>
        <div>
            <header>
                <h1 style="padding-left: 580px; height:100px; padding-top: 50px; font-size: 50px; color: orange ">FPT Education</h1>
            </header>
        </div>
        <div style="border: 0px solid black; padding-top: 50px">
            <h1 style="font-size: 35px; background-color: gainsboro; padding-left: 550px">Xin chào ${sessionScope.username}</h1>
            <a href="logout" style="padding-left: 1350px; text-decoration: none; font-size: 20px; font-weight: bold">Logout</a>
        </div>
        <div class="bodyform">
            <div class="bodyform-left">

                <div class="watch" >
                    <a class="btn btn-primary" href="studentSchedule" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none; ">Watch my Schedule</a>
                    <br>
                    <a class="btn btn-primary" href="studentAttendance" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none; margin-top: 10px; ">Watch my Attendance</a>
                </div>
                <div style="margin-top:20px;">
                    <ul>
                        <c:forEach items="${listStdSubAttendance}" var="listStdSubAttendance">
                            <li>
                                <a href="studentAttendance?subjectCode=${listStdSubAttendance.subjectCode}&&className=${listStdSubAttendance.className}" style="text-decoration: none; font-weight: bold; color: #6B90DA; background-color: white">
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
                            <tr style="background: #6B90DA">
                                <th style="font-size: 14px">DATE</th>
                                <th style="font-size: 14px">SLOT</th>
                                <th style="font-size: 14px">LECTURER</th>
                                <th style="font-size: 14px">CLASS</th>
                                <th style="font-size: 14px">ATTENDANCE STATUS</th>
                                <th style="font-size: 14px">NOTES</th>
                            </tr>
                        </thead>
                        <tbody style="background-color: whitesmoke">
                            <c:forEach items="${listStdSubAttendanceDetail}" var="listStdSubAttendanceDetail">
                                <tr>
                                    <th>${listStdSubAttendanceDetail.dates}</th>
                                    <th>${listStdSubAttendanceDetail.id}</th>
                                    <th>${listStdSubAttendanceDetail.username}</th>
                                    <th>${listStdSubAttendanceDetail.className}</th>
                                    <th>
                                        <c:if test="${listStdSubAttendanceDetail.statusAttend==1}">
                                            <div class="badge bg-primary text-wrap" style="width: 6rem;">
                                                <p style="color: greenyellow ; vertical-align: middle ; text-align: center">Attend</p> 

                                            </div>
                                        </c:if>
                                        <c:if test="${listStdSubAttendanceDetail.statusAttend==0}">
                                            <div class="badge bg-primary text-wrap" style="width: 6rem;">
                                                <p style="color: red; text-align: center; vertical-align: middle">Absent</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${listStdSubAttendanceDetail.statusAttend==2}">
                                            <div class="badge bg-primary text-wrap" style="width: 6rem;">
                                            <p style="color: orange; text-align: center; vertical-align: middle">Future</p>
                                            </div>
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
