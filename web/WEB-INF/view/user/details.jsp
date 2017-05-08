<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/8
  Time: 下午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp" %>

<%--content--%>
<div class="content">
    <table class="table table-hover">
        <thead>
        <tr>
            <th colspan="2">用户信息</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>用户ID</td>
            <td>${sessionScope.user.id}</td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>${sessionScope.user.name}</td>
        </tr>
        <tr>
            <td>注册日期</td>
            <td>${sessionScope.user.registerDate}</td>
        </tr>
        </tbody>
    </table>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
