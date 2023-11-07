<%-- 
    Document   : attendance_report
    Created on : Oct 10, 2023, 10:47:31 PM
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
        <h1>Attendance Report</h1>
        <table>
            <tr>
                <th>Student</th>
                <th>Absent so far</th>
                    <c:forEach items="${requestScope.ses}" var="s">
                    <th>
                        <fmt:formatDate value="${s.date}" pattern="dd/MM" var="formattedDate" />
                        <p>${formattedDate}</p>
                        <fmt:formatDate value="${s.date}" pattern="EEEE" var="formattedDate" />
                        <p>${formattedDate}</p>
                    </th>
                </c:forEach>
            </tr>
            <c:forEach items="${requestScope.students}" var="st">
                <tr>
                    <td>${st.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${st.report.percentage > 20}">
                                <span style="color: red;">${st.report.percentage}%</span>
                            </c:when>
                            <c:otherwise>
                                <span>${st.report.percentage}%</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <c:forEach var="a" items="${st.atts}">
                        <td>
                            <c:if test="${a.session.isAtt}">
                                <c:if test="${!a.status}">
                                    <span class="auto-style1">A</span>
                                </c:if>
                                <c:if test="${a.status}">
                                    <span class="auto-style2">P</span>
                                </c:if>
                            </c:if>
                            <c:if test="${!a.session.isAtt}">
                                Not Yet
                            </c:if>
                        </td>

                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
