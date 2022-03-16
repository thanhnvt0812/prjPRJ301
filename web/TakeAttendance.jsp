<%-- 
    Document   : TakeAttendance
    Created on : Jul 19, 2021, 5:44:23 PM
    Author     : Admin
--%>

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
                <h1 style="border: 1px solid greenyellow; padding-left: 580px; background: white; height:100px; padding-top: 50px; font-size: 50px ">FBT Education</h1>
            </header>
        </div>
        <div style="border: 0px solid black">
            <h1 style="font-size: 45px; background-color: gainsboro; padding-left: 550px">Xin chào ${sessionScope.username}</h1>
            <a href="logout" style="padding-left: 1350px; text-decoration: none; font-size: 20px; font-weight: bold">Logout</a>
        </div>
        <div class="bodyform">
            <div class="bodyform-left">
                <div class="watch">
                    <a href="teacherSchedule" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;" >Watch my Schedule</a>
                    <br>    
                    <a href="takeAttendance" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;">Take Attendance</a>
                </div>
                <div style="margin-top:20px;">
                    <ul>
                        <c:forEach items="${listSubAttendance}" var="listSubAttendance">
                            <li>
                                <a href="takeAttendance?subjectCode=${listSubAttendance.subjectCode}&&className=${listSubAttendance.className}&&startTime=${listSubAttendance.startTime}&&endTime=${listSubAttendance.endTime}">
                                    ${listSubAttendance.subjectCode} - ${listSubAttendance.subjectName}
                                    at class ${listSubAttendance.className} (Start ${listSubAttendance.dates})
                                </a>

                            </li>
                        </c:forEach>

                    </ul>
                </div>
            </div>
            <div class="bodyform-right">
                <div class="tableSchedule">

                    <form action="takeAttendance" method="post">
                        <div class="table_attendance">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="background: #6B90DA">Roll Number</th>
                                        <th style="background: #6B90DA">Student Name</th>
                                        <th style="background: #6B90DA">Attendance</th>
                                        <th style="background: #6B90DA">Note</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listAttendanceInformations}" var="listAttendanceInformations">
                                        <tr>
                                            <td>${listAttendanceInformations.rollNumber}</td>
                                            <td >${listAttendanceInformations.name}</td>
                                            <td>
                                                <p style="margin-left: 30px">
                                                    Attend<input type="radio" name="attendance${listAttendanceInformations.rollNumber}" ${listAttendanceInformations.status==1?"checked=\"checked\"":""} value="1">
                                                    Absent<input type="radio" name="attendance${listAttendanceInformations.rollNumber}" ${listAttendanceInformations.status==0?"checked=\"checked\"":""} value="0">

                                                </p>
                                            </td>
                                            <td>
                                                <div style="margin-left: 70px;"class="text_note">
                                                    <input style="width: 300px;" type="text" name="note${listAttendanceInformations.rollNumber}" value="${listAttendanceInformations.notes}">
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <input type="submit" value="Save">
                        </div>
                    </form>



                </div>
            </div>
        </div>
    </body>
</html>
