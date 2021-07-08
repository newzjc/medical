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
    <script>
        <c:if test="${pb.totalCount ==0}">
        window.alert("没有查到所需信息");
        </c:if>

        function updateUser(id) {
            location.href = "${pageContext.request.contextPath}/FindAllServlet?id=" + id;
        }

        function deleteUser(id) {
            if (confirm("您确定要删除吗")) { //返回boolean值
                //是的话就返回
                location.href = "${pageContext.request.contextPath}/DeleteServlet?id=" + id;
            }
        }

        function selectAll(obj) {
            $(".All").prop("checked", obj.checked);
        }

         window.onload = function () {
        document.getElementById("deleteStaff").onclick = function () {
            var flag = false;
            let cbs = document.getElementsByName("sid");
            for (let i = 0; i < cbs.length; i++) {
                if (cbs[i].checked) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                alert("未勾选");
            } else {
                if (confirm("您确定要删除吗")) {
                    document.getElementById("sub").submit();
                }
            }
        }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">医疗费用信息核对表</h3>
    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/ByAdminPageServlet" method="post">
            <div class="form-group">
                <label for="staff_id">职工号</label>
                <input type="text" class="form-control" id="staff_id" name="id">
            </div>
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right">
        <tr>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加职工</a>
            <a class="btn btn-primary" href="javascript:void(0);" id="deleteStaff">删除职工</a>
        </tr>

    </div>
    <form action="${pageContext.request.contextPath}/DeletesServlet" id="sub" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="info">
                <th><input type="checkbox" onclick="selectAll(this)"></th>
                <th>编号</th>
                <th>部门</th>
                <th>姓名</th>
                <th>校外门诊费</th>
                <th>校内诊费</th>
                <th>住院费</th>
                <th>子女医疗费</th>
                <th>报销总额</th>
                <th>报销余额</th>
                <th>子女报销总额</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="staff" varStatus="s">
                <tr>
                    <td ><input type="checkbox" name="sid" value="${staff .id}" class="All"></td>
                    <td>${s.count}</td>
                    <td>${staff.branch}</td>
                    <td>${staff.name}</td>
                    <td>${staff.outs}</td>
                    <td>${staff.ins}</td>
                    <td>${staff.hexp}</td>
                    <td>${staff.sons}</td>
                    <td>${staff.total}</td>
                    <td>${staff.balance}</td>
                    <td>${staff.sonst}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="javascript:updateUser(${staff.id});">核算更新</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${staff.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pb.currentPage !=1}">
            <li>
                </c:if>
                <c:if test="${pb.currentPage == 1}">
            <li class="disabled">
                </c:if>
                <a href="${pageContext.request.contextPath}/ByAdminPageServlet?currentPage=${pb.currentPage-1}&rows=7"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${pb.totalPage}" var="i">

                <c:if test="${pb.currentPage == i}">
                    <li class="active">
                </c:if>
                <c:if test="${pb.currentPage!= i}">
                    <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/ByAdminPageServlet?currentPage=${i}&rows=7">${i}</a></li>
            </c:forEach>

            <c:if test="${pb.currentPage >= pb.totalPage}">
            <li class="disabled">
                </c:if>

                <c:if test="${pb.currentPage < pb.totalPage}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/ByAdminPageServlet?currentPage=${pb.currentPage+1}&rows=7"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px; margin-left: 10px">
                共${pb.totalCount}条记录, 共${pb.totalPage}页
            </span>
        </ul>
    </nav>
</div>
</body>
</html>
