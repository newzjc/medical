package web.controller;

import pogo.Medical;
import pogo.Staff;
import service.Impl.UserServiceImpl;
import service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        //封装数据
        //UserS userS = new UserS();
        Staff staff = new Staff();
        Medical medical = new Medical();
        try {
            BeanUtils.populate(staff,map);
            BeanUtils.populate(medical,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service=new UserServiceImpl();
        //service.add(userS);
        service.addStaff(staff);
        service.addMedical(medical);

        response.sendRedirect(request.getContextPath()+"/ByAdminPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
