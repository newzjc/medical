package dao.Impl;

import dao.UsersDao;
import pogo.Staff;
import pogo.UserS;
import pogo.Medical;
import util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UsersImpl implements UsersDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    /**
     * 查询users表的全部信息
     *
     * @return
     */
    @Override
    public List<UserS> findAll() {
        String sql = "select *from users";
        List<UserS> userS = template.query(sql, new BeanPropertyRowMapper<UserS>(UserS.class));
        return userS;
    }

    /**
     * 添加新的信息,id是自增的
     *
     * @param userS
     */
    @Override
    public void addUser(UserS userS) {
        String sql = "insert into users values(null ,?,?,?,?,?,?)";
        template.update(sql, userS.getName(), userS.getSex(), userS.getAge(), userS.getAddress(), userS.getQq(), userS.getEmail());
    }

    /**
     * 添加职工医疗费信息
     *
     * @param staff
     */
    @Override
    public void addStaff(Staff staff) {
        String sql = "insert into staff values(?,?,?,null ,null ,null ,null ,?)";
        template.update(sql, staff.getId(), staff.getBranch(), staff.getName(), staff.getPassword());
    }

    /**
     * 删除职工
     *
     * @param id
     */
    @Override
    public void deleteStaff(int id) {
        String sql = "delete from staff where id=?";
        template.update(sql, id);
    }

    /**
     * 回显medical
     * @param id
     * @return
     */
    @Override
    public Medical findMedical(int id) {
        String sql = "select * from medical where id =?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Medical>(Medical.class), id);
    }

    /**
     * 更新medical表
     *
     * @param medical
     */
    @Override
    public void updateM(Medical medical) {
        String sql = "update medical set branch=?,outs=?,ins=?,hexp=?,total=?,balance=?,sons=?,sonst=? where id=?";
        template.update(sql, medical.getBranch(), medical.getOuts(), medical.getIns(), medical.getHexp(),
                medical.getTotal(),
                medical.getBalance(), medical.getSons(), medical.getSonst(), medical.getId());
    }

    /**
     * 查询1staff用户
     * @param _staff
     * @return
     */

    @Override
    public Staff findStaff(Staff _staff) {
        try {
            String sql = "select * from staff where id=? and password=?";
            Staff staff = template.queryForObject(sql, new BeanPropertyRowMapper<Staff>(Staff.class), _staff.getId(), _staff.getPassword());
            return staff;
        } catch (DataAccessException e) {
            e.printStackTrace(); //后期记录日志
        }
        return null;
    }

    /**
     * 添加medical信息
     *
     * @param medical
     */
    @Override
    public void addMedical(Medical medical) {
        String sql = "insert into medical values(null,?,?,?,null ,null ,null ,null ,null ,null ,null,?,?)";
        template.update(sql, medical.getId(), medical.getBranch(), medical.getName(), medical.getNorm(), medical.getNorms());
    }

    @Override
    public void deleteMedical(int id) {
        String sql = "delete from medical where id=?";
        template.update(sql, id);
    }

    /**
     * 通过id删除此id的信息
     *
     * @param id
     */
    @Override
    public void deleteUser(int id) {
        String sql = "delete from users where id=?";
        template.update(sql, id);
    }

    /**
     * 通过id修改此id的相关信息
     *
     * @param userS
     */
    @Override
    public void updateUser(UserS userS) {
        String sql = "update users set name=?,sex=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql, userS.getName(), userS.getSex(), userS.getAge(), userS.getAddress(), userS.getQq(), userS.getEmail(), userS.getId());
    }

    /**
     * 更新前通过id回显此id的信息，已确认是否更新
     *
     * @param id
     * @return
     */
    @Override
    public UserS findUser(int id) {
        String sql = "select * from users where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<UserS>(UserS.class), id);
    }

    /**
     * 查询users表的总记录数
     *
     * @param condition
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from users where 1=1 ";
        //sql 拼接 字符串拼接
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> ps = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        //key为客户端提交的name的值
        for (String key : keySet) {
            String value = condition.get(key)[0];
            //如果提交的参数中含有这些，就直接跳过此次循环
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            if (value != null && !"".equals(value)) {
                //判断value是否有值,有才拼接
                ssql.append(" and " + key + " like ?");
                ps.add("%" + value + "%");
            }
        }
        System.out.println(ssql.toString());
        System.out.println(ps);
        return template.queryForObject(ssql.toString(), Integer.class, ps.toArray());
    }

    /**
     * 分页查询每页的记录，开始索引为start，每页的记录数为rows,带有模糊查询
     *
     * @return
     */
    @Override
    public List<UserS> findPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from users where 1 = 1 ";
        //sql 拼接 字符串拼接
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> ps = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        //key为客户端提交的name的值
        for (String key : keySet) {
            String value = condition.get(key)[0];
            //如果提交的参数中含有这些，就直接跳过此次循环
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //判断value是否有值
            if (value != null && !value.equals("")) {
                //有值才拼接sql
                ssql.append(" and " + key + " like ? ");
                ps.add("%" + value + "%"); // ? 的值就是 value
            }
        }
        //添加分页的查询
        ssql.append(" limit ?,? ");
        ps.add(start);
        ps.add(rows);
        return template.query(ssql.toString(), new BeanPropertyRowMapper<UserS>(UserS.class), ps.toArray());
    }

    /**
     * @param condition
     * @return
     */
    @Override
    public int findTotalCountM(Map<String, String[]> condition) {
        String sql = "select count(*) from medical where 1=1 ";
        //sql 拼接 字符串拼接
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> ps = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        //key为客户端提交的name的值
        for (String key : keySet) {
            String value = condition.get(key)[0];
            //如果提交的参数中含有这些，就直接跳过此次循环
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            if (value != null && !"".equals(value)) {
                //判断value是否有值,有才拼接
                ssql.append(" and " + key + " like ?");
                ps.add("%" + value + "%");
            }
        }
        System.out.println(ssql.toString());
        System.out.println(ps);
        return template.queryForObject(ssql.toString(), Integer.class, ps.toArray());
    }

    @Override
    public List<Medical> findPageM(int start, int rows, Map<String, String[]> condition) {
        String sql = "select *from medical where 1 = 1";
        //sql 拼接 字符串拼接
        StringBuilder ssql = new StringBuilder(sql);
        ArrayList<Object> ps = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        //key为客户端提交的name的值
        for (String key : keySet) {
            String value = condition.get(key)[0];
            //如果提交的参数中含有这些，就直接跳过此次循环
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //判断value是否有值
            if (value != null && !value.equals("")) {
                //有值才拼接sql
                ssql.append(" and " + key + " like ? ");
                ps.add("%" + value + "%"); // ? 的值就是 value
            }
        }
        //添加分页的查询
        ssql.append(" limit ?,? ");
        ps.add(start);
        ps.add(rows);
        return template.query(ssql.toString(), new BeanPropertyRowMapper<Medical>(Medical.class), ps.toArray());
    }
}
