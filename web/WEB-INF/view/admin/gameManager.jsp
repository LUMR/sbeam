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
        <%--信息--%>
        <div class="col-md-3 content-left" role="alert">
            <span class="label label-success">${sessionScope.user.messages[0]}</span>
        </div>
        <div class="clearfix"></div>
        <%--游戏信息--%>
        <div class="col-md-4 content-left">
            <h2>按类型分类</h2>
            <div class="list-group list-group-alternate" style="margin: 20px auto;">
                <c:forEach items="${categories}" var="category">
                    <a href="/admin/game?cid=${category.id}" class="list-group-item">
                        <span class="badge badge-success"></span>
                        <i class="ti ti-eye"></i> ${category.name}
                    </a>
                </c:forEach>
            </div>
            <div class="clearfix"></div>
            <h2>按平台分类</h2>
            <div class="list-group list-group-alternate" style="margin: 20px auto;">
                <c:forEach items="${platforms}" var="platform">
                    <a href="/admin/game?pid=${platform.id}" class="list-group-item">
                        <span class="badge badge-success"></span>
                        <i class="ti ti-eye"></i> ${platform.name}
                    </a>
                </c:forEach>
            </div>
        </div>

        <div class="col-md-8 colcontent-right">
            <c:forEach items="${games}" var="game" varStatus="status">
                <c:if test="${status.count%4==0}"><div class="gallery-1"></c:if>
                <div class="col-md-4 gallery-grid">
                    <a class="example-image-link" href="/images/g2.jpg" data-lightbox="example-set">
                        <img class="example-image" src="/images/g2.jpg" alt=""/>
                    </a>
                    <a href="/library/game/${game.id}" class="list-group-item">
                        <span class="badge badge-primary">${game.category.name}</span>
                        <span class="badge badge-warning">${game.platform.name}</span>
                        <span class="badge badge-success">$${game.price}</span>
                        <i class="ti ti-headphone-alt"></i>${game.name}
                    </a>
                </div>
                <c:if test="${status.count%4==0}">
                    <div class="clearfix"></div>
                    </div>
                </c:if>
            </c:forEach>
            <div class="clearfix"></div>
        </div>

        <div class="clearfix"></div>
    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
