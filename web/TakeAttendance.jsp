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
                background-image:url('img/nha-alpha.jpg');
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
                <div class="watch">
                    <a class="btn btn-primary" href="teacherSchedule" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;">Watch my Schedule</a>
                    <br>    
                    <a class="btn btn-primary" href="takeAttendance" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;margin-top: 10px;">Take Attendance</a>
                </div>
                <div style="margin-top:20px;">
                    <ul>
                        <c:forEach items="${listSubAttendance}" var="listSubAttendance">
                            <li>
                                <a href="takeAttendance?subjectCode=${listSubAttendance.subjectCode}&&className=${listSubAttendance.className}&&startTime=${listSubAttendance.startTime}&&endTime=${listSubAttendance.endTime}" style="background-color: white">
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
                                <tbody style="background-color: whitesmoke">
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
                            <input class="btn btn-primary" type="submit" value="Save" style="margin-top: 10px">
                        </div>
                    </form>



                </div>
            </div>
        </div>
    </body>
</html>
