
<%@page import="Entity.TeacherInfor"%>
<%@page import="java.util.*"%>
<%@page import="Entity.Student"%>
<%@page import="Dao.DAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                    <a class="btn btn-primary" href="studentInformation" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;">Watch Student Information</a>
                    <br>  
                    <div style="margin-top:20px;">
                        <ul>
                            <c:forEach items="${listClass}" var="listClass">
                                <li>
                                    <a href="studentInformation?className=${listClass.className}" style="background-color: white">
                                        ${listClass.className}
                                    </a>

                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                    <a class="btn btn-primary" href="teacherInformation" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;margin-top: 10px;">Watch Teacher Information</a>
                </div>
                <div class="bodyform-right">

                    <%
                        DAO dao = new DAO();
                        TeacherInfor std = new TeacherInfor();
                        String teacherID = request.getParameter("teacherID");
                        int id  = Integer.parseInt(teacherID);
                        TeacherInfor teacherInfor = dao.getTeacherInfor(id);
                        request.setAttribute("teacherInfor", teacherInfor);
                    %>
                    <div class="tableAttendance" style="padding-left: 300px; margin-top: -100px">
                        <form action="updateTeacher" method="POST">
                            <table border="0" style="background-color: whitesmoke">
                                <tbody>
                                    <tr>
                                        <th style="background: #6B90DA">ID: </th>
                                        <td><input type="text" name="id" value="${teacherInfor.id}" readonly/></td>
                                    </tr>
                                    <tr>
                                        <th style="background: #6B90DA">Full Name: </th>
                                        <td><input type="text" name="name" value="${teacherInfor.name}" /></td>
                                    </tr>
                                    <tr>
                                        <th style="background: #6B90DA">Username: </th>
                                        <td><input type="text" name="username" value="${teacherInfor.username}" readonly="" /></td>
                                    </tr>
                                    <tr>
                                        <th style="background: #6B90DA">Email Address: </th>
                                        <td><input type="text" name="email" value="${teacherInfor.email}" /></td>
                                    </tr>
                                    <tr>
                                        <th style="background: #6B90DA">Gender: </th>
                                        <td>
                                            <input type="radio" name="gender" value="1" ${teacherInfor.gender == true ? "checked":""}/>Male
                                            <input type="radio" name="gender" value="0" ${teacherInfor.gender == false ? "checked":""}/>Female
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="background: #6B90DA">Date of Birth: </th>
                                        <td><input type="text" name="dob" value="${teacherInfor.dob}" /></td>
                                    </tr>


                                </tbody>
                            </table>
                            <input class="btn btn-primary" type="submit" value="Update" style="margin-top: 10px">
                        </form>



                    </div>


                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


    </body>
</html>
