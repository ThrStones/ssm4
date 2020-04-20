<%--
  Created by IntelliJ IDEA.
  User: ThrStones
  Date: 2020/4/16
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3><a href="insertHtml">跳转新增页面</a></h3>
<h1>list</h1>
<c:forEach items="${testBeanList}" var="testBean">
    ${ testBean.name }--<a href="delete?id=${ testBean.id }">删除</a>--<a href="queryById?id=${ testBean.id }">修改</a><br/>
</c:forEach>
<c:if test="${pageNum>1}">
    <a href="queryAllByPages?pageNum=${pageNum-1}">上一页</a>
</c:if>
<c:if test="${pageNum<totalPages}">
    <a href="queryAllByPages?pageNum=${pageNum+1}">下一页</a>
</c:if>
共${totalPages}页
</body>
</html>
