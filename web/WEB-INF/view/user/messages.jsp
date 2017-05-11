<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/9
  Time: 下午4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分类管理器</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp" %>

<%--content--%>
<div class="content">

    <div class="container">
        <a href="/user/details"><button class="btn1 btn-1 btn-1b">返回主管理页面</button> </a>
        <%--分类管理--%>
        <h2 class="h2">消息列表</h2>
        <div class="content-left col-md-6">
            <div class="list-group list-group-alternate">
                <c:forEach items="${sessionScope.user.messages}" var="message">
                    <a href="" class="list-group-item"><span
                            class="badge"></span>
                        <i class="ti ti-email"></i>
                            ${message} </a>
                </c:forEach>
            </div>
            <div class="clearfix"></div>
        </div>

    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
