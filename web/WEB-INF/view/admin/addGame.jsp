<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-10
  Time: 下午2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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

        <div class="col-lg-3 content-left">
            <sf:form modelAttribute="game" action="/admin/game/add" method="post" enctype="multipart/form-data">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th colspan="2">游戏信息</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>游戏名称:</td>
                        <td><sf:input path="name"/></td>
                    </tr>
                    <tr>
                        <td>游戏类型</td>
                        <td>
                            <sf:input path="categoryId"/>
                        </td>
                    </tr>
                    <tr>
                        <td>游戏所在平台</td>
                        <td>
                            <sf:input path="platformId"/>
                        </td>
                    </tr>
                    <tr>
                        <td>游戏售价</td>
                        <td><sf:input path="price"/></td>
                    </tr>
                    <tr>
                        <td>上架时间</td>
                        <td><sf:input path="pubdate"/></td>
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
            </sf:form>
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
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                    <td><img src="${sessionScope.user.header.src}" class="img-thumbnail"/></td>
                </tr>
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
