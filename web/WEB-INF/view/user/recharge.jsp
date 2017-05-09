<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/9
  Time: 上午11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/model/header.jsp" %>
<%--content--%>
<div class="content">
    <div class="container">
        <div class="col-md-5 content-left">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th colspan="2">充值用户信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>用户ID</td>
                    <td>${sessionScope.user.id}</td>
                </tr>
                <tr>
                    <td>用户名</td>
                    <td>${sessionScope.user.name}</td>
                </tr>
                <tr>
                    <td>注册日期</td>
                    <td>${sessionScope.user.registerDate}</td>
                </tr>
                </tbody>
            </table>
            <div class="clearfix"></div>
        </div>
        <div class="col-md-5 content-right">
            <form class="contact-form" action="/user/recharge" method="post">
                <div class="input-group">
                    <input type="number" name="money" class="form-control" placeholder="请输入要充值的金额$">
                    <span class="input-group-btn">
							<button type="submit" class="btn btn-default" type="button">一键充值</button>
						</span>
                </div>
            </form>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>

</body>
</html>
