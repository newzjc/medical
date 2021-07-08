package web.controller;

import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeletesServlet")
public class DeletesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String[] ids = request.getParameterValues("sid");
        UserService service=new UserServiceImpl();
        service.deletes(ids);
        //重定向是两次请求，且不能用request来设置共享数据 （session），一般用于服务器之间的跳转

        response.sendRedirect(request.getContextPath()+"/ByAdminPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
