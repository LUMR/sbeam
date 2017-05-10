<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-10
  Time: 下午2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${game.name}</title>
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
            <table class="table table-hover">
                <thead>
                <tr>
                    <th colspan="2">游戏信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>游戏名称:</td>
                    <td>${game.name}</td>
                </tr>
                <tr>
                    <td>游戏类型</td>
                    <td>${game.category.name}</td>
                </tr>
                <tr>
                    <td>游戏所在平台</td>
                    <td>${game.platform.name}</td>
                </tr>
                <tr>
                    <td>游戏售价</td>
                    <td>$:${game.price}</td>
                </tr>
                <tr>
                    <td>上架时间</td>
                    <td>${game.pubdate}</td>
                </tr>
                <tr>
                    <td>销量</td>
                    <td>${sales}</td>
                </tr>
                </tbody>
            </table>
            <div class="clearfix"></div>
            <div class="list-group list-group-alternate" style="margin: 20px auto;">
                <c:if test="${sessionScope.user.isadmin == 1}">
                <a href="/library/game/${game.id}/buy" class="list-group-item">
                    <span class="badge badge-danger"></span>
                    <i class="ti ti-eye"></i> 修改游戏
                </a>
                </c:if>
                <a href="/library/game/${game.id}/buy" class="list-group-item">
                    <span class="badge badge-success">$&nbsp;${game.price}</span>
                    <i class="ti ti-eye"></i> 买买买
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
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th>游戏截图</th>
                </tr>
                </thead>
                <tr>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                </tr>
                <tr>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                </tr>
                <tr>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                </tr>
            </table>
            <div class="clearfix"></div>
        </div>

        <div class="clearfix"></div>
    </div>
</div>

<script src="/js/lightbox-plus-jquery.min.js"></script>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
