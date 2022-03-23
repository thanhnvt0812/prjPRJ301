
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
                            <br>
                            <li><a class="btn btn-primary" href="CreateStudent.jsp" role="button" style="border: 0px solid black; font-size: 15px; font-weight: bold; text-decoration: none;">Create Student</a>
                            </li>
                        </ul>
                    </div>
                    <a class="btn btn-primary" href="teacherInformation" role="button" style="border: 0px solid black; font-size: 20px; font-weight: bold; text-decoration: none;margin-top: 10px;">Watch Teacher Information</a>
                </div>

                <div class="bodyform-right">
                    <div class="tableAttendance" style="padding-left: 300px; margin-top: -200px">
                        <form action="teacherInformation" method="POST">
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th style="background: #6B90DA">ID</th>
                                        <th style="background: #6B90DA">Name</th>
                                        <th style="background: #6B90DA"></th>
                                        <th style="background: #6B90DA"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listTeacher}" var="listTeacher">
                                        <tr style="background: whitesmoke">
                                            <td>${listTeacher.id}</td>
                                            <td>${listTeacher.name}</td>
                                            <td><a class="btn btn-primary" href="UpdateTeacher.jsp?teacherID=${listTeacher.id}" role="button" style="border: 0px solid black; font-size: 10px; font-weight: bold; text-decoration: none;">Update</a></td>
                                            <td><a class="btn btn-primary" href="deleteTeacher?teacherID=${listTeacher.id}" onclick="showMess(${listTeacher.id})" role="button" style="border: 0px solid black; font-size: 10px; font-weight: bold; text-decoration: none;">Delete</a></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>

                        </form>


                    </div>


                </div>

            </div>
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
             <li><a class="btn btn-primary" href="CreateStudent.jsp" role="button" style="border: 0px solid black; font-size: 15px; font-weight: bold; text-decoration: none;">Create Student</a>
                            </li>

    </body>
    <script>
        function showMess(id){
            var option = confirm('Do you want to delete?')
            if(option === true ){
                window.location.href = 'deleteStudent?studentID='+id;
            }
        }
    </script>
</html>
