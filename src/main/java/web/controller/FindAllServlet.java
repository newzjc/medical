package web.controller;

import pogo.Medical;
import service.Impl.UserServiceImpl;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindAllServlet")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取需要修改user的id
        String id = request.getParameter("id");

        UserService service=new UserServiceImpl();
        //UserS userS = service.find(id);
        Medical medical = service.findM(id);

        request.setAttribute("users",medical);
        //转发只是一次请求，一般用于回显客户端的数据，可以使用request来设置共享数据
        //一般要加虚拟目录req.getContextPath()
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
