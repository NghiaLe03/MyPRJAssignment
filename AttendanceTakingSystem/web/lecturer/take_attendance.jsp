<%-- 
    Document   : take_attendance
    Created on : Oct 10, 2023, 10:23:31 PM
    Author     : nghia
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Single Activity Attendance</h1>
        <h2>Current Session: ${requestScope.ses.group.name}-${requestScope.ses.subject.name}-${requestScope.ses.room.rid}
            -${requestScope.ses.time.description}</h2> <br/>
        <form action="attendance" method="POST">
            <table border="1px"> 
                <tr>
                    <th>Student</th>
                    <th>Status</th>
                    <th>Description</th>
                    <th>Time</th>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a">
                    <tr>
                        <td>${a.student.name}
                            <input type="hidden" name="stuid" value="${a.student.id}"/>
                        </td>
                        <td>
                            <input type="radio"
                                   <c:if test="${!a.status}">
                                       checked="checked"
                                   </c:if>
                                       name="status${a.student.id}" value="absent"/><span class="auto-style1">Absent</span>
                            <input type="radio"
                                   <c:if test="${a.status}">
                                       checked="checked"
                                   </c:if>
                                       name="status${a.student.id}" value="present"/><span class="auto-style2">Present</span>
                        </td>
                        <td>
                            <input type="text" value="${a.description}"
                                   name="description${a.student.id}"/>
                        </td>
                        <td>${a.datetime}</td>
                    </tr>   

                </c:forEach>
            </table>
            <input type="hidden" value="${requestScope.ses.id}" name="sesid"/>
            <input type="submit" value="Save"/>
        </form>

    </body>
</html>
