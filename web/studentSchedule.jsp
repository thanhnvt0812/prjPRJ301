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
                background-image:url('img/4301_Ynh-1-TrYYng-YYi-hYc-FPT.jpg');
                background-size: 1530px 800px;
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
            </div>
            <div class="bodyform-right">
                <div class="tableSchedule">
                    <table style="background-color: whitesmoke" >
                        <thead>
                            <tr >
                                <th rowspan="2" style="background: #6B90DA">
                                    <form action="studentSchedule" method="GET" >
                                        <select name="selectedDateWeek" onchange="this.form.submit()">
                                            <c:forEach items="${listWeeks}" var="listWeeks">

                                                <option value="${listWeeks.id}">
                                                    <fmt:formatDate value="${listWeeks.weekStart}" pattern="dd-MM-yyyy" /> TO
                                                    <fmt:formatDate value="${listWeeks.weekEnd}" pattern="dd-MM-yyyy" /></option>

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
                                        <c:forEach items="${listStdSchdDetail}" var="listStdSchdDetail" >
                                            <c:if test="${listStdSchdDetail.dates == listDates.dateTime && listStdSchdDetail.slotName == listSlot.slotName}">
                                                <td>
                                                    ${listStdSchdDetail.subjectCode} at ${listStdSchdDetail.className}</p>

                                                    <c:if test="${listStdSchdDetail.status ==1}">
                                                        
                                                            <p style="color: green ;margin-left: 33px">Attended</p>
                                                        
                                                        
                                                    </c:if>
                                                    <c:if test="${listStdSchdDetail.status ==0}">
                                                        <p style="color: red;margin-left: 33px">Absent</p>
                                                    </c:if>
                                                    <c:if test="${listStdSchdDetail.status ==2}">
                                                        <p style="color: red;margin-left: 33px">(Not-yet)</p>
                                                    </c:if>
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
