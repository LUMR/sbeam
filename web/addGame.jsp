<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/11
  Time: 上午12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${sessionScope.user.messages[0]}

<sf:form modelAttribute="game" method="post" action="/admin/game/add" enctype="multipart/form-data">
    name:<sf:input path="name"/>


    category:<sf:select path="categoryId">
    <c:forEach items="${categories}" var="category">
        <sf:option value="${category.id}">${category.name}</sf:option>
    </c:forEach>
</sf:select>

pat:<sf:select path="platformId">
    <c:forEach items="${platforms}" var="category">
        <sf:option value="${category.id}">${category.name}</sf:option>
    </c:forEach>
</sf:select>

price:<sf:input path="price"/>

    <input type="file" name="files">
    <input type="file" name="files">
    <input type="file" name="files">

descri:<sf:textarea path="description"/>

<input type="submit" value="go">
</sf:form>
</body>
</html>
