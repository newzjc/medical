package web.controller;

import pogo.Admin;
import pogo.Staff;
import service.AdminService;
import service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //先获取验证码判断
        String code = req.getParameter("code");
        String x = req.getParameter("x");
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        //忽略大小写比较验证码
        if (!checkcode_server.equalsIgnoreCase(code)) {
            //验证码错误时直接转发给登录页面,
            if ("".equals(code)) {
                req.setAttribute("login_msg", "验证不为空");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
            req.setAttribute("login_msg", "验证码错误");
            req.getRequestDispatcher( "/login.jsp").forward(req, resp);
        } else {
            //判断是管理员还是职工登录
            if ("admin".equals(x)) {
                String id = req.getParameter("id");
                String password = req.getParameter("password");
                //3.封装user对象,并与数据库校验
                AdminService serviceL = new AdminService();
                Admin user = new Admin(id, password);
                Admin admin = serviceL.getAdmin(user);
                //5.判断user
                if (admin == null) {
                    //登录失败时用的是转发，直接使用request域来存储数据
                    req.setAttribute("login_msg", "账号或密码错误");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } else {
                    //登录成功时需使用session来存储数据,所以使用重定向来跳转
                    //重定向到index.jsp
                    session.setAttribute("user", admin);
                    session.setAttribute("xx", 1);
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                }
                //此处是职工登录
            } else if ("staff".equals(x)) {
                String id = req.getParameter("id");
                String password = req.getParameter("password");
                UserServiceImpl service = new UserServiceImpl();
                Staff user = new Staff(id, password);
                Staff staff = service.findS(user);

                //5.判断user
                if (staff == null) {
                    //登录失败时用的是转发，直接使用request域来存储数据
                    req.setAttribute("login_msg", "账号或密码错误");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);

                } else {
                    //登录成功时需使用session来存储数据,所以使用重定向来跳转
                    //重定向到index.jsp
                    session.setAttribute("user", staff);
                    session.setAttribute("xx", 0);
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                }
            } else {
                req.setAttribute("login_msg", "没有选择登录身份");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
