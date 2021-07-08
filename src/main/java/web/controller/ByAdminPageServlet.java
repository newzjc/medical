package web.controller;

import pogo.Medical;
import pogo.PageBean;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ByAdminPageServlet")
public class ByAdminPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //多条件查询会有中文提交
        request.setCharacterEncoding("utf-8");
        //获取当前所在的页数和每页的显示数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //若没有默认设置为1和5
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "7";
        }
        //多条件查询时会有很多条件提交，把数据分装到map中
        Map<String, String[]> condition = request.getParameterMap();
        UserService service = new UserServiceImpl();
        //在service业务逻辑层中分装方法,该方法包含获取当前currentPage和rows，sql的多条件
        //PageBean<UserS> pb = service.findPage(currentPage, rows,condition);
        PageBean<Medical> pb = service.findPageM(currentPage, rows, condition);

        //转发时是一次请求，可以用request共享数据
        request.setAttribute("pb", pb);

        request.getRequestDispatcher("/adminMedical.jsp").forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
