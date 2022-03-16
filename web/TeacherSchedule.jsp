<%-- 
    Document   : TeacherSchedule
    Created on : Jul 19, 2021, 4:41:12 PM
    Author     : Admin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            </div>
            <div class="bodyform-right">
                <div class="tableSchedule">
                    <table>
                        <thead>
                            <tr>
                                <th rowspan="2" >
                                    <form action="teacherSchedule" method="GET" >
                                        <select name="selectedDateWeek" onchange="this.form.submit()">
                                            <c:forEach items="${listWeeks}" var="listWeeks">

                                                <option value="${listWeeks.id}">
                                                    <fmt:formatDate value="${listWeeks.weekStart}" pattern="dd-MM-yyyy" /> TO
                                                    <fmt:formatDate value="${listWeeks.weekEnd}" pattern="dd-MM-yyyy" /></option>

                                            </c:forEach>
                                        </select>
                                    </form>

                                </th>
                                <th><p>Monday</p></th>
                                <th><p>Tuesday</p></th>
                                <th><p>Wednesday</p></th>
                                <th><p>Thursday</p></th>
                                <th><p>Friday</p></th>
                                <th><p>Saturday</p></th>
                                <th><p>Sunday</p></th>
                            </tr>
                            <tr>
                                <c:forEach items="${listDates}" var="listDates">

                                    <th>
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
                                    <th>
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
    </body>
</html>
