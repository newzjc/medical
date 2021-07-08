package service;


import pogo.Medical;
import pogo.PageBean;
import pogo.Staff;
import pogo.UserS;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<UserS> findAll();

    void add(UserS userS);

    void addStaff(Staff staff);

    void delete(String id);

    void update(UserS userS);

    UserS find(String id);

    Medical findM(String id);

    void deletes(String[] ids);

    PageBean<UserS> findPage(String currentPage, String rows, Map<String, String[]> condition);

    PageBean<Medical> findPageM(String currentPage, String rows, Map<String, String[]> condition);

    void updateM(Medical medical);

    Staff findS(Staff staff);

    void addMedical(Medical medical);
}