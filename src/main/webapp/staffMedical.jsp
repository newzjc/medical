<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">医疗费用信息表</h3>
   <%-- <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/ByStaffServlet" method="post">
            <div class="form-group">
                <label for="staff_id">职工号</label>
                <input type="text" class="form-control" id="staff_id" required name="id">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>--%>
    <div id="sub" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="alert-info">
                <th>校外门诊费</th>
                <th>校内诊费</th>
                <th>住院费</th>
                <th>子女医疗费</th>
                <th>已报销总额</th>
                <th>可报销余额</th>
                <th>子女总额</th>
            </tr>
            <tr>
                <td>${medical.outs}</td>
                <td>${medical.ins}</td>
                <td>${medical.hexp}</td>
                <td>${medical.sons}</td>
                <td>${medical.total}</td>
                <td>${medical.balance}</td>
                <td>${medical.sonst}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
