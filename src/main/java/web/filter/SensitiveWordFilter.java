package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.Filter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

//@WebFilter("/*")
public class SensitiveWordFilter implements Filter {

    private ArrayList<String> list = new ArrayList();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            //获取文件的真实路劲
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            //通过真实路劲读取文件(需要注意文件的编码格式)
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //将文件中的每一行添加到list集合中
            String line = null;
            while ((line = br.readLine()) != null) { //一行一行的读取
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        ServletRequest req_proxy = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if ("getParameter".equals(method.getName())) {

                    String values = (String) method.invoke(request, args);
                    if (values != null) {
                        for (String str : list) {
                            if (values.contains(str)) {
                                values = values.replaceAll(str, "***");
                            }
                        }
                    }
                    return values;
                } else {
                    return method.invoke(request, args);
                }
            }
        });
        filterChain.doFilter(req_proxy, response);

    }

    @Override
    public void destroy() {

    }
}
