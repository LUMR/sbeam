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

    <div class="container">
        <%--信息--%>
        <div class="col-lg-3 content-left" role="alert">
            <span class="label label-success">${sessionScope.user.messages[0]}</span>
        </div>
        <div class="clearfix"></div>
        <%--用户信息--%>
        <div class="col-md-5 content-left">
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
        <div class="col-lg-3 colcontent-right">
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th>用户头像</th>
                </tr>
                </thead>
                <tr>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                </tr>
            </table>
            <div class="clearfix"></div>
        </div>
        <div class="col-lg-4 content-right">
            <div class="list-group list-group-alternate" style="margin: 20px auto;">
                <a href="/user/recharge" class="list-group-item">
                    <span class="badge badge-success">$&nbsp;${sessionScope.user.money}</span>
                    <i class="ti ti-eye"></i> 充值
                </a>
                <a href="#" class="list-group-item">
                    <span class="badge badge-primary">&nbsp;&nbsp;</span>
                    <i class="ti ti-email"></i>修改信息
                </a>
                <a href="#" class="list-group-item">
                    <span class="badge badge-warning">${sessionScope.user.games.size()}</span>
                    <i class="ti ti-eye"></i> 游戏库
                </a>
                <a href="#" class="list-group-item">
                    <span class="badge">20</span>
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
