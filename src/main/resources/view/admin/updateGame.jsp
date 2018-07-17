<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/11
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${game.name}</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
    <script type="text/javascript" src="/js/ajax.js"></script>
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
        <sf:form modelAttribute="game" action="/admin/game/${game.id}/update" method="post" enctype="multipart/form-data">
            <div class="col-lg-3 content-left">

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th colspan="2">游戏信息</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>游戏名称:</td>
                        <td><input name="name" value="${game.name}" required/></td>
                    </tr>
                    <tr>
                        <td>游戏类型</td>
                        <td>
                            <sf:select path="categoryId">
                                    <sf:option value="${game.category.id}">${game.category.name}</sf:option>
                            </sf:select>
                        </td>
                    </tr>
                    <tr>
                        <td>游戏所在平台</td>
                        <td>
                            <sf:select path="platformId">
                                    <sf:option value="${game.platform.id}">${game.platform.name}</sf:option>
                            </sf:select>
                        </td>
                    </tr>
                    <tr>
                        <td>游戏售价</td>
                        <td><input type="text" name="price" value="${game.price}" required/></td>
                    </tr>
                    <tr>
                        <td>上架时间</td>
                        <td><input type="datetime" name="pubdate" value="${game.pubdate.toLocaleString()}" required/></td>
                    </tr>
                    <tr>
                        <td>游戏描述</td>
                        <td class="contact-form"><sf:textarea path="description"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit" class="btn1 btn-1 btn-1b">提交</button>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <div class="clearfix"></div>
                <div class="list-group list-group-alternate" style="margin: 20px auto;">
                    <a href="/admin/category/add" class="list-group-item">
                        <span class="badge badge-danger"></span>
                        <i class="ti ti-eye"></i> 增加游戏分类
                    </a>
                    <a href="/admin/platform/add" class="list-group-item">
                        <span class="badge badge-success"></span>
                        <i class="ti ti-eye"></i> 增加游戏平台
                    </a>
                    <a href="/admin/game" class="list-group-item">
                        <span class="badge badge-primary"></span>
                        <i class="ti ti-email"></i>返回游戏管理页面
                    </a>
                    <a href="#" class="list-group-item">
                        <span class="badge">${sessionScope.user.messages.size()}</span>
                        <i class="ti ti-comments"></i>消息
                    </a>
                </div>
            </div>

            <div class="col-lg-8 colcontent-right">
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th colspan="3">游戏截图:至少3个图片</th>
                    </tr>
                    </thead>
                    <tr>
                        <td><input type="file" class="input-group-sm" name="files" id="picture1" required/></td>
                        <td><input type="file" class="input-group-sm" name="files" id="picture2" required/></td>
                        <td><input type="file" class="input-group-sm" name="files" id="picture3" required/></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="button" class="btn1 btn-1 btn-1b">上传图片</button>
                        </td>
                        <td>
                            <button type="button" class="btn1 btn-1 btn-1b">上传图片</button>
                        </td>
                        <td>
                            <button type="button" class="btn1 btn-1 btn-1b">上传图片</button>
                        </td>
                    </tr>
                    <c:forEach items="${game.pictures}" varStatus="status" var="picture">
                        <c:if test="${status.count%3==1}"><tr></c:if>
                        <td><img src="${picture.src}" class="img-thumbnail"/></td>
                        <c:if test="${status.count%3==0}"></tr></c:if>
                    </c:forEach>
                </table>
                <div class="clearfix"></div>
            </div>
        </sf:form>

        <div class="clearfix"></div>

    </div>
</div>

<script src="/js/lightbox-plus-jquery.min.js"></script>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
