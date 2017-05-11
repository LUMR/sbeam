<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/11
  Time: 下午10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${games}" var="game" varStatus="status">
    <c:if test="${status.count%3==1}"><div class="gallery-1"></c:if>
    <div class="col-md-4 gallery-grid">
        <a class="example-image-link" href="/library/game/${game.id}" data-lightbox="example-set">
            <img class="example-image" src="/images/g2.jpg" alt=""/>
        </a>
        <a href="/library/game/${game.id}" class="list-group-item">
            <span class="badge badge-primary">${game.category.name}</span>
            <span class="badge badge-warning">${game.platform.name}</span>
            <span class="badge badge-success">$${game.price}</span>
            <i class="ti ti-headphone-alt"></i>${game.name}
        </a>
    </div>
    <c:if test="${status.count%3==0}">
        <div class="clearfix"></div>
        </div>
    </c:if>
</c:forEach>
<div class="clearfix"></div>
