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
        <div>
            <sf:form modelAttribute="user" action="/user/details/update" method="post" cssClass="news-ltr">
                <div class="col-md-5 content-left">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th colspan="2">用户信息</th>
                        </tr>
                        </thead>
                    </table>
                    <div class="input-group input-group-lg">
                        <input type="number" value="${user.id}" hidden/>
                        <span class="input-group-addon" id="sizing-addon1">名字</span>
                        <input type="text" name="name" value="${user.name}" class="form-control" placeholder="Username"
                               aria-describedby="sizing-addon1">
                    </div>
                    <button type="submit" class="btn1 btn-1 btn-1b">保存</button>
                    <button class="btn1 btn-1 btn-1b">上传头像</button>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-6 content-right">
                    <table class="table table-responsive">
                        <thead>
                        <tr>
                            <th>用户头像</th>
                        </tr>
                        </thead>
                        <tr>
                            <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                        </tr>
                    </table>
                    <input type="file" class="">
                    <div class="clearfix"></div>
                </div>

            </sf:form>
            <div class="clearfix"></div>
        </div>
            <div class="alert alert-warning" role="alert">
                <strong>${message}</strong>
            </div>
        </div>
        <div class="clearfix"></div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
