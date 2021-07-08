package dao;

import pogo.Admin;
import util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public Admin login(Admin login_admin){
        try {
            String sql = "select *from admin where id=? and password=?";
            Admin user = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),
                    login_admin.getId(),
                    login_admin.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace(); //后期记录日志
        }
        return null;
    }
}
