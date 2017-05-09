<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/9
  Time: 下午4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改分类</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp" %>

<%--content--%>
<div class="content">

    <div class="container">
        <%--分类管理--%>
        <h2 class="h2">分类信息</h2>
        <div class="list-group list-group-alternate">
            <sf:form modelAttribute="category" action="/admin/category/add" method="post" cssClass="news-ltr">
                <div class="input-group input-group-lg">
                    <input type="number" value="" hidden />
                    <span class="input-group-addon" id="sizing-addon1">名字</span>
                    <input type="text" name="name" value="${category.name}" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
                </div>
                <input type="submit" value="保存">
            </sf:form>
            <div class="alert alert-warning" role="alert">
                <strong>${message}</strong>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
