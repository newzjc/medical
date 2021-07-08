<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div align="center">
    <c:if test="${xx==null}">
        您尚未登录<a href="login.jsp">点击登录</a>
    </c:if>

    <c:if test="${xx==1}">
        <div style="float: right;font-size: 25px;margin: 20px">
                ${user.id}管理员,欢迎您
        </div>
        <a href="${pageContext.request.contextPath}/ByAdminPageServlet"  style="text-decoration:none;font-size:33px">查询职工医疗费信息</a>
    </c:if>
    <c:if test="${xx==0}">
        <div style="float: right;font-size: 25px;margin: 20px" >
                ${user.id}职工,欢迎您
        </div>
        <a href="${pageContext.request.contextPath}/ByStaffServlet?id=${user.id}"  style="text-decoration:none;font-size:33px">查询医疗费用信息</a>
    </c:if>
</div>
</body>
</html>
