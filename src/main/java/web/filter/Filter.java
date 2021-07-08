package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//  /login.jsp, 具体目录
//  /test/*, 在test虚目录下的所有资源
//  *.jsp, 所有后缀为jsp的资源
//  /* 表示访问所有资源前都会执行该过滤器
//@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 服务器启动后会创建doFilter对象,之后调用init对象，只调用一次init,
     * 在服务器关闭后会销毁Filter对象,正常关闭会调用destroy对象,只调用一次，非正常关闭不会执行
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器被执行了");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
