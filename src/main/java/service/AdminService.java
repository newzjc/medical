package service;

import dao.AdminDao;
import pogo.Admin;

public class AdminService {
    public Admin getAdmin(Admin admin) {
       AdminDao dao = new AdminDao();
        return dao.login(admin);
    }
}
