package dao;

import pogo.Staff;
import pogo.UserS;
import pogo.Medical;

import java.util.List;
import java.util.Map;

public interface UsersDao {
    List<UserS> findAll();

    void addUser(UserS userS);

    void deleteUser(int parseInt);

    void updateUser(UserS userS);

    UserS findUser(int parseInt);

    int findTotalCount(Map<String, String[]> condition);

    List<UserS> findPage(int start, int rows, Map<String, String[]> condition);

    int findTotalCountM(Map<String, String[]> condition);

    List<Medical> findPageM(int start, int rows, Map<String, String[]> condition);

    void addStaff(Staff staff);

    void deleteStaff(int parseInt);

    Medical findMedical(int parseInt);

    void updateM(Medical medical);

   Staff findStaff(Staff staff);

    void addMedical(Medical medical);

    void deleteMedical(int parseInt);
}