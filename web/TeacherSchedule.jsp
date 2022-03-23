<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <!--        <div style="border: 1px solid greenyellow; color: blue; background: greenyellow">-->
        <!--        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">-->
        <div>
            <header>
                <!--                <h1 style="border: 1px solid greenyellow; padding-left: 580px; background: white; height:100px; padding-top: 50px; font-size: 50px ">FPT Education</h1>-->
                <h1 style="padding-left: 580px; height:100px; padding-top: 50px; font-size: 50px; color: orange ">FPT Education</h1>
            </header>
        </div>
        <!--        </nav>-->
        <div style="border: 0px solid black; padding-top: 50px">
            <h1 style="font-size: 35px; background-color: gainsboro; padding-left: 550px">Xin chào ${sessionScope.username}</h1>
            <a href="logout" style="padding-left: 1350px; text-decoration: none; font-size: 20px; font-weight: bold">Logout</a>
        </div>
        <div class="bodyform">
            <div class="bodyform-left">
                <div class="watch">
                    <!--                    <a href="teacherSchedule" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;">Watch my Schedule</a>-->
                    <a class="btn btn-primary" href="teacherSchedule" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;">Watch my Schedule</a>
                    <br>    
                    <!--                    <a href="takeAttendance" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;">Take Attendance</a>-->
                    <a class="btn btn-primary" href="takeAttendance" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;margin-top: 10px;">Take Attendance</a>
                </div>
            </div>
            <div class="bodyform-right">
                <div class="tableSchedule">
                    <table style="background-color: whitesmoke">
                        <thead>
                            <tr class="table-secondary">
                                <th rowspan="2" style="background: #6B90DA">
                                    <form action="teacherSchedule" method="GET" >
                                        <select name="selectedDateWeek" onchange="this.form.submit()">
                                            <c:forEach items="${listWeeks}" var="listWeeks">
                                                <option value="${listWeeks.id}">
                                                    <fmt:formatDate value="${listWeeks.weekStart}" pattern="dd-MM-yyyy" /> TO
                                                    <fmt:formatDate value="${listWeeks.weekEnd}" pattern="dd-MM-yyyy" />
                                                </option>

                                            </c:forEach>
                                        </select>
                                    </form>

                                </th>
                                <th style="background: #6B90DA"><p>Monday</p></th>
                                <th style="background: #6B90DA"><p>Tuesday</p></th>
                                <th style="background: #6B90DA"><p>Wednesday</p></th>
                                <th style="background: #6B90DA"><p>Thursday</p></th>
                                <th style="background: #6B90DA"><p>Friday</p></th>
                                <th style="background: #6B90DA"><p>Saturday</p></th>
                                <th style="background: #6B90DA"><p>Sunday</p></th>
                            </tr>
                            <tr>
                                <c:forEach items="${listDates}" var="listDates">

                                    <th style="background-color: lightblue">
                                        <p>
                                            <fmt:formatDate value="${listDates.dateTime}" pattern="dd-MM-yyyy" /> 
                                        </p> 

                                    </th>

                                </c:forEach>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listSlot}" var="listSlot">

                                <tr>
                                    <th style="background-color: lightgray">
                                        ${listSlot.slotName}
                                        <br>
                                        <fmt:formatDate type="time" timeStyle="short" value="${listSlot.slotStart}" /> - 
                                        <fmt:formatDate type="time" timeStyle="short" value="${listSlot.slotEnd}" />
                                    </th>
                                    <c:forEach items="${listDates}" var="listDates"> 
                                        <c:set var = "check" value = "0"/>
                                        <c:forEach items="${listTchSchdDetail}" var="listTchSchdDetail" >
                                            <c:if test="${listTchSchdDetail.dates == listDates.dateTime && listTchSchdDetail.slotName == listSlot.slotName}">
                                                <td>
                                                    ${listTchSchdDetail.subjectCode} at ${listTchSchdDetail.className}</p>

                                                </td>
                                                <c:set var = "check" value = "1"/>
                                            </c:if> 
                                        </c:forEach>
                                        <c:if test="${check eq 0}">  <td> </td></c:if>
                                    </c:forEach>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>


                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
