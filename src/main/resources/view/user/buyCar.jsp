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

        <div class="col-md-5 content-left">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th colspan="2">用户信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>用户名</td>
                    <td>${sessionScope.user.name}</td>
                </tr>
                <tr>
                    <td>钱包</td>
                    <td>$${sessionScope.user.money}</td>
                </tr>
                <tr>
                    <td>总费用</td>
                    <td>${sessionScope.buyCar.total}</td>
                </tr>
                <tr>
                    <td><button type="button" class="btn1 btn-1 btn-1b" onclick="if(confirm('确定结算吗？')){
                            window.location='/user/buyCar/sum';
                    }">结算</button></td>
                </tr>
                </tbody>
            </table>
            <div class="clearfix"></div>
        </div>
        <%--信息--%>
        <div class="col-lg-3 content-left" role="alert">
            <span class="label label-success">${sessionScope.user.messages[0]}</span>
        </div>
        <div class="clearfix"></div>
        <%--游戏管理--%>
        <h2 class="h2">购物车</h2>
        <div class="content-left col-md-6">
            <div class="list-group list-group-alternate">
                <c:forEach items="${buyCar.games}" var="game">
                    <a href="/library/game/${game.id}" class="list-group-item"><span
                            class="badge"></span>
                        <i class="ti ti-email"></i>
                            ${game.name} </a><button class="btn1 btn-1 btn-1b" onclick="
                              if (confirm('确定删除吗？')){
                                  window.location='/user/game/${game.id}/delete';
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
