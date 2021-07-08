<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
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
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <center><h3>添加职工医疗费信息</h3></center>
    <form action="${pageContext.request.contextPath}/AddServlet" method="post">
        <div class="form-group">
            <label for="staff_id">职工号：</label>
            <input type="text" class="form-control" id="staff_id" name="id" required placeholder="职工号为登录账号">
        </div>
        <tr class="form-group">
            <label for="branch">部门：</label>
            <select id="branch" class="form-control" name="branch" required>
                <option>锦鲤</option>
                <option>草药</option>
                <option>真相</option>
            </select>
        </tr>
        <tr class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" required placeholder="请输入姓名">
        </tr>
        <tr class="form-group">
            <label for="sex">性别：</label>
            <input type="text" class="form-control" id="sex" name="sex" required placeholder="请输入性别">
        </tr>
        <tr class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" required placeholder="请输入年龄">
        </tr>
        <tr class="form-group">
            <label for="password">设置登录密码：</label>
            <input type="text" class="form-control" id="password" name="password" required placeholder="请设置密码">
        </tr>
        <tr class="form-group">
            <label for="norm">年初职工限额：</label>
            <input type="text" class="form-control" id="norm" name="norm" value="5000" readonly>
        </tr>
        <tr class="form-group">
            <label for="norms">年初子女限额：</label>
            <input type="text" class="form-control" name="norms" id="norms" value="2000" readonly>
        </tr>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回" onclick="javascript:history.go(-1)"/>
        </div>
    </form>
</div>
</body>
</html>
