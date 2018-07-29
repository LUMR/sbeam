<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/8
  Time: 下午10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登陆</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp" %>

<%--content--%>
<div class="contact">
    <div class="container">
        <h2>用 户 信 息 ：</h2>
        <div style="width: 50%;margin: 20px auto;">
            <sf:form action="/user/login" modelAttribute="user">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon" id="sizing-addon1">用户名</span>
                    <input type="text" name="name" class="form-control" placeholder="Username" required="required"
                           aria-describedby="sizing-addon1">
                    <span class="label label-warning"><sf:errors path="name"/></span>
                </div>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon" id="sizing-addon2">密 码</span>
                    <input type="password" name="password" class="form-control" placeholder="Password"
                           required="required"
                           aria-describedby="sizing-addon2">
                    <span class="label label-warning"><sf:errors path="password"/></span>
                </div>
                <button type="submit" class="btn1 btn-1 btn-1b">登陆</button>
            </sf:form>
            <div class="alert alert-warning" role="alert">
                <strong>${message}</strong>
            </div>
        </div>
    </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
