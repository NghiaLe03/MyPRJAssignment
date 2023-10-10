<%-- 
    Document   : take_attendance
    Created on : Oct 10, 2023, 10:23:31 PM
    Author     : nghia
--%>

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
        <form>
            <table>
                <tr>
                    <th>no</th>
                    <th>group</th>
                    <th>code</th>
                    <th>name</th>
                    <th>image</th>
                    <th>comment</th>
                    <th>status</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <input type="text" name="comment" placeholder="Write your comment here">
                    </td>
                    <td>
                        <input type="radio" name="s1" value="absent" checked> <span class="auto-style1">Absent</span>
                        <input type="radio" name="s1" value="present"> <span class="auto-style2">Present</span>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <input type="text" name="comment" placeholder="Write your comment here">
                    </td>
                    <td>
                        <input type="radio" name="s2" value="absent" checked> <span class="auto-style1">Absent</span>
                        <input type="radio" name="s2" value="present"> <span class="auto-style2">Present</span>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <input type="text" name="comment" placeholder="Write your comment here">
                    </td>
                    <td>
                        <input type="radio" name="s3" value="absent" checked> <span class="auto-style1">Absent</span>
                        <input type="radio" name="s3" value="present"> <span class="auto-style2">Present</span>
                    </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <input type="text" name="comment" placeholder="Write your comment here">
                    </td>
                    <td>
                        <input type="radio" name="s4" value="absent" checked> <span class="auto-style1">Absent</span>
                        <input type="radio" name="s4" value="present"> <span class="auto-style2">Present</span>
                    </td>
                </tr>
                <tr>
                    <td>5</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <input type="text" name="comment" placeholder="Write your comment here">
                    </td>
                    <td>
                        <input type="radio" name="s5" value="absent" checked> <span class="auto-style1">Absent</span>
                        <input type="radio" name="s5" value="present"> <span class="auto-style2">Present</span>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
