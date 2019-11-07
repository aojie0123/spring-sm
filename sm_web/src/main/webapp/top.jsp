<%--
  Created by IntelliJ IDEA.
  User: 雨木科技
  Date: 2019/11/7
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>头部</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>

<body>
<div class="head clearfix">
    <div class="logo"><a href="#"><img src="${pageContext.request.contextPath}/images/logo.png" alt="慕课商城"/></a></div>
    <div class="curr"><span>欢迎您，${STAFF.name}[ <a href="${pageContext.request.contextPath}/logout.do" target="_top">退出</a> ]</span></div>
</div>
</body>
</html>

