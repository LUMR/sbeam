<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/9
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理界面</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp" %>

<%--content--%>
<div class="content">

    <div class="container">
        <%--信息--%>
        <div class="col-lg-3 content-left" role="alert">
            <span class="label label-success">${sessionScope.user.messages[0]}</span>
            <span class="label label-success">${sessionScope.user.messages[1]}</span>
            <span class="label label-success">${sessionScope.user.messages[2]}</span>
            <span class="label label-success">${sessionScope.user.messages[3]}</span>
        </div>
        <div class="clearfix"></div>
        <%--用户信息--%>
        <div class="col-md-4 content-left">
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
            <div class="clearfix"></div>
        </div>
        <div class="col-lg-8 content-right">
            <div class="list-group list-group-alternate" style="margin: 20px auto;">
                <a href="/admin/category" class="list-group-item">
                    <span class="badge badge-success"></span>
                    <i class="ti ti-eye"></i> 管理分类
                </a>
                <a href="/admin/platform" class="list-group-item">
                    <span class="badge badge-primary"></span>
                    <i class="ti ti-email"></i>管理平台
                </a>
                <a href="/admin/game" class="list-group-item">
                    <span class="badge badge-warning"></span>
                    <i class="ti ti-eye"></i> 管理游戏
                </a>
                <a href="#" class="list-group-item">
                    <span class="badge badge-danger"></span>
                    <i class="ti ti-headphone-alt"></i>精彩瞬间
                </a>
                <a href="/user/messages" class="list-group-item">
                    <span class="badge">${sessionScope.user.messages.size()}</span>
                    <i class="ti ti-comments"></i>消息
                </a>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
