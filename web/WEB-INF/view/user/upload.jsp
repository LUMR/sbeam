<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/5/9
  Time: 下午11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>get:${message}</h1>
<sf:form modelAttribute="file">
    <ul>
        <li>${file.name}</li>
        <li>${file.contentType}</li>
        <li>${file.originalFilename}</li>
        <li>${file}</li>
    </ul>
</sf:form>
</body>
</html>
