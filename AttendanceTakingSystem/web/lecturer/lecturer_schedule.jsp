<%-- 
    Document   : lecturer_schedule
    Created on : Oct 10, 2023, 9:23:37 PM
    Author     : nghia
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <h1>Weekly Timetable</h1>
        <form action="schedule" method="GET">
            From <input type="date" name="from" value="${requestScope.from}"/> <br/>
            To <input type="date" name="to" value="${requestScope.to}"/>
            <input type="hidden" value="${param.id}" name="id"/>
            <input type="submit" value="View"/>
        </form>
        <table border="1px">
            <tr>
                <th></th>
                <c:forEach items="${requestScope.dates}" var="d">
                    <th>
                        <fmt:formatDate value="${d}" pattern="dd/MM" var="formattedDate" />
                        <p>${formattedDate}</p>
                        <fmt:formatDate value="${d}" pattern="EEEE" var="formattedDate" />
                        <p>${formattedDate}</p>
                    </th>
                </c:forEach>
            </tr>
            <c:forEach items="${requestScope.slots}" var="s">
                <tr>
                    <td>${s.description}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="ses">
                                <c:if test="${ses.time.id eq s.id and ses.date eq d}">
                                    ${ses.group.name}-${ses.subject.name}-${ses.room.rid}
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>  
            </c:forEach>
        </table>
    </body>
</html>
