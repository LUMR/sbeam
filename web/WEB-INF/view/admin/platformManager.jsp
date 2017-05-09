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
        <%--分类管理--%>
        <h2 class="h2">平台列表</h2>
        <div class="content-left col-md-6">
            <div class="list-group list-group-alternate">
                <c:forEach items="${platforms}" var="platform">
                    <a href="/admin/platform/${platform.id}" class="list-group-item"><span
                            class="badge">&nbsp;&nbsp;</span>
                        <i class="ti ti-email"></i>
                            ${platform.name} </a>
                </c:forEach>
            </div>
            <div class="clearfix"></div>
        </div>
        <a href="/admin/platform/add"><button class="btn1 btn-1 btn-1b">增加新的平台</button> </a>
    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
