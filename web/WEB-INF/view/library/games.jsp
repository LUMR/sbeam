<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-10
  Time: 下午12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游戏库</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp" %>
<%--content--%>
<div class="gallery">
    <div class="container">
        <h2>游戏库</h2>
        <div class="gallery-bottom">
            <c:forEach items="${games}" var="game" varStatus="status">
                <c:if test="${status.count%4==1}"><div class="gallery-1"></c:if>

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
        </div>
    </div>
</div>
<script src="js/lightbox-plus-jquery.min.js"></script>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>