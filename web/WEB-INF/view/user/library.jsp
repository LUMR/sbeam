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
        <%--游戏管理--%>
        <h2 class="h2">拥有的游戏</h2>
        <div class="content-left col-md-6">
            <div class="list-group list-group-alternate">
                <c:forEach items="${gameLibrary}" var="game">
                    <a href="/library/${game.id}" class="list-group-item"><span
                            class="badge"></span>
                        <i class="ti ti-email"></i>
                            ${game.name} </a><button class="btn1 btn-1 btn-1b" onclick="
                              if (confirm('确定删除吗？')){
                                  window.location='/user/library/${game.id}/delete';
                              };
                            ">删除</button>
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
