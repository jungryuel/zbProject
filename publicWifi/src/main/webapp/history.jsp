<%--
  Created by IntelliJ IDEA.
  User: jungrule
  Date: 2023-01-12
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.historyDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>히스토리 정보</title>
    <style>
        table, td, th {
            border: 1px solid lightgrey;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 8px;
        }
        td, th {
            padding: 8px;
        }
        th {
            background-color: #26ab71;
            color: aliceblue;
            font-size: 80%;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>위치 히스토리 목록</h1>
<p></p>
<a href="index.jsp">홈</a> <span>|</span>
<a href="history.jsp">위치 히스토리 목록</a> <span>|</span>
<a href="/loadWifi">Open API 와이파이 정보 가져오기</a>
<%
DB dataBase = new DB();
String delIdx = request.getParameter("delIdx");
if (delIdx != null) {
dataBase.deleteHistory(delIdx);
}
%>
<table>
        <tr>
            <th>ID</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>조회일자</th>
            <th>비고</th>
        </tr>
    <%
        if() {%>
    <tr>
        <td colspan="5">
            저장 된 기록이 없습니다.
        </td>
    </tr>
</table>

</body>
</html>
