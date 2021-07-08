package web.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest  req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        //HttpServletResponse response=(HttpServletResponse) resp;
        String uri = request.getRequestURI(); //获取网页访问路径
        if(uri.contains("/login.jsp")||uri.contains("/LoginServlet")||uri.contains("/CheckCodeServlet")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/css/")){
            //若路径包含以上, 访问者正想登录, 就放行
            chain.doFilter(req,resp);
        }else {
            //若不包含, 进入判断, 是否登录
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //有数据, 说明已经登录了, 放行
                chain.doFilter(req,resp);
            }else {
                //没有登录, 转发到login.jsp
                request.setAttribute("login_msg","您尚未登录");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }
    @Override
    public void destroy() {

    }
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
