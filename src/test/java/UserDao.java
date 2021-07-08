import dao.AdminDao;
import org.junit.jupiter.api.Test;
import pogo.Admin;
public class UserDao {
    @Test
    public void testLogin() {
        Admin login_user = new Admin();
        login_user.setId("111");
        login_user.setPassword("111");
        AdminDao dao=new AdminDao();
        Admin user = dao.login(login_user);
        System.out.println(user);
    }
}
