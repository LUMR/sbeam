<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-8
  Time: 下午3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
    <script src="/js/ajax.js">
        var NameNotExist = false;
    </script>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp" %>
<%--register--%>
<div class="contact">
    <div class="container">
        <h2> 注 册 </h2>
        <div style="width: 50%;margin: 0 auto;">
            <div class="alert alert-warning" role="alert">
                <strong id="message">${message}</strong>
            </div>
            <h4>用 户 信 息 ：</h4>
            <sf:form action="/user/register" modelAttribute="user" onsubmit="return NameNotExist">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon" id="sizing-addon1">用户名</span>
                    <input type="text" name="name" class="form-control" placeholder="Username" onchange="checkName(this)" required aria-describedby="sizing-addon1">
                    <span class="label label-warning"><sf:errors path="name"/></span>
                </div>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon" id="sizing-addon2">密 码</span>
                    <input type="password" name="password" class="form-control" placeholder="Password" required="required" aria-describedby="sizing-addon2">
                    <span class="label label-warning"><sf:errors path="password"/></span>
                </div>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon" id="sizing-addon3">密 码</span>
                    <input type="password" required="required" class="form-control" placeholder="Password Again" aria-describedby="sizing-addon3">
                </div>
                <button type="submit" class="btn1 btn-1 btn-1b">注册</button>
            </sf:form>
        </div>
    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
