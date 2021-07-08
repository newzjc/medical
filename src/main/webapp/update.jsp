<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <%--  <base href="<%=basePath%>"/>--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<script>
    function fun() {
        var nid = document.getElementById("nid");
        if (nid.nodeValue.trim()) {
            alert("不能为空");
        }
    }
</script>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">更新</h3>
    <form action="${pageContext.request.contextPath}/UpdateServlet" method="post">
        <tr class="form-group">
            <td><label for="nid">职工号：</label></td>
            <td><input type="text" class="form-control" name="id" id="nid" value="${users.id}" readonly/></td>
        </tr>
        <tr class="form-group">
            <td><label for="br">部门：</label></td>
            <td><select class="form-control" name="branch" id="br">
                <option>${users.branch}</option>
                <option>草药</option>
                <option>真相</option>
                <option>锦鲤</option>
            </select>
            </td>
        </tr>
        <tr class="form-group">
            <td><label for="name">姓名：</label></td>
            <td><input type="text" class="form-control" id="name" name="name" value="${users.name}" readonly/></td>
        </tr>
        <tr class="form-group">
            <td><label for="out">校外门诊：</label></td>
            <td><input type="text" class="form-control" id="out" name="outs" value="${users.outs}"/></td>
        </tr>
        <tr class="form-group">
            <td><label for="in">校内门诊：</label></td>
            <td><input type="text" class="form-control" id="in" name="ins" value="${users.ins}"/></td>
        </tr>
        <tr class="form-group">
            <td><label for="hexp">住院费：</label></td>
            <td><input type="text" class="form-control" id="hexp" name="hexp" value="${users.hexp}"/></td>
        </tr>
        <tr class="form-group">
            <td><label for="sons">子女医疗费：</label></td>
            <td><input type="text" class="form-control" name="sons" id="sons" value="${users.sons}"/></td>
        </tr>
        <input type="hidden" name="total" value="${users.total}">
        <input type="hidden" name="balance" value="${users.balance}">
        <input type="hidden" name="sonst" value="${users.sonst}">
        <input type="hidden" name="norm" value="${users.norm}">
        <input type="hidden" name="norms" value="${users.norms}">
        <tr class="form-group" style="text-align: center">
            <td><input class="btn btn-primary" type="submit" value="提交"/></td>
            <td><input class="btn btn-default" type="reset" value="重置"/></td>
            <td><input class="btn btn-default" type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
        </tr>
    </form>
</div>
</body>
</html>