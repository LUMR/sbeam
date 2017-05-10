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
        <div class="col-lg-3 content-left" role="alert">
            <span class="label label-success">${sessionScope.user.messages[0]}</span>
        </div>
        <div class="clearfix"></div>
        <%--游戏信息--%>
        <div class="col-md-4 content-left">
            <div class="list-group list-group-alternate" style="margin: 20px auto;">
                <a href="/library/game/${game.id}/buy" class="list-group-item">
                    <span class="badge badge-success">$&nbsp;${game.price}</span>
                    <i class="ti ti-eye"></i> 增加游戏
                </a>
                <a href="/library/game/${game.id}/add" class="list-group-item">
                    <span class="badge badge-primary">&nbsp;&nbsp;</span>
                    <i class="ti ti-email"></i>加入购物车
                </a>
                <a href="/library/game/${game.id}/reviews" class="list-group-item">
                    <span class="badge badge-warning">${game.reviews.size()}</span>
                    <i class="ti ti-eye"></i> 游戏评论数
                </a>
                <a href="#" class="list-group-item">
                    <span class="badge">${sessionScope.user.messages.size()}</span>
                    <i class="ti ti-comments"></i>消息
                </a>
            </div>
        </div>

        <div class="col-md-8 colcontent-right">
            <c:forEach items="${games}" var="game" varStatus="status">
                <c:if test="${status.count%4==0}"><div class="gallery-1"></c:if>
                <div class="col-md-3 gallery-grid">
                    <a class="example-image-link" href="images/g2.jpg" data-lightbox="example-set">
                        <img class="example-image" src="images/g2.jpg" alt=""/>
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
