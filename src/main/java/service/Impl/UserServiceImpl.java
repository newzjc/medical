package service.Impl;

import dao.Impl.UsersImpl;
import dao.UsersDao;
import pogo.PageBean;
import pogo.Staff;
import pogo.UserS;
import pogo.Medical;
import service.UserService;
import java.util.List;
import java.util.Map;


public class UserServiceImpl implements UserService {
    private UsersDao dao = new UsersImpl();

    /**
     * 查找表的所有信息
     *
     * @return
     */
    @Override
    public List<UserS> findAll() {
        return dao.findAll();
    }

    /**
     * 添加一行新的信息
     *
     * @param userS
     */

    @Override
    public void add(UserS userS) {
        dao.addUser(userS);
    }

    @Override
    public void addStaff(Staff staff) {
        dao.addStaff(staff);
    }

    /**
     * 删除此id的所有信息
     *
     * @param id
     */

    @Override
    public void delete(String id) {
        //dao.deleteUser(Integer.parseInt(id));//放入id
        dao.deleteStaff(Integer.parseInt(id));
        dao.deleteMedical(Integer.parseInt(id));
    }

    /**
     * 更新一个特定id的所有信息
     *
     * @param userS
     */
    @Override
    public void update(UserS userS) {
        dao.updateUser(userS);
    }

    /**
     * 当更新一个id的信息时，回显此id的信息，已确认是否更新
     *
     * @param id
     * @return
     */
    @Override
    public UserS find(String id) {
        return dao.findUser(Integer.parseInt(id));

    }

    @Override
    public Medical findM(String id) {
        return dao.findMedical(Integer.parseInt(id));
    }

    /**
     * 通过id集合，删除这些id的所有信息
     *
     * @param ids
     */
    @Override
    public void deletes(String[] ids) {
        for (String id : ids) {
            //dao.deleteUser(Integer.parseInt(id));
            dao.deleteStaff(Integer.parseInt(id));
            dao.deleteMedical(Integer.parseInt(id));
        }
    }

    /**
     * 通过分页条件查询回显表的所有信息
     *
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    @Override
    public PageBean<UserS> findPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //分页按钮向前点击的判断
        if (currentPage < 1) {
            currentPage = 1;
        }
        //创建新的pageBean对象
        PageBean<UserS> pageBean = new PageBean<>();

        //把页面获取的当前页数放入对象中
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //查询表的总记录数
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        if (totalCount == 0) {
            pageBean.setTotalCount(totalCount);
            return pageBean;
        } else {
            //计算总的页码数
            int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
            pageBean.setTotalPage(totalPage);

            //
            if (currentPage >= totalPage) {
                currentPage = totalPage;
            }
            int start = (currentPage - 1) * rows;
            //计算开始查询的点  c =(a-1)*b  a:点击分页后当前页数   b:每页展示的行数  c:在表中开始查询的起始点


            //通过开始查询点查询 返回当前页数的信息list集合
            List<UserS> list = dao.findPage(start, rows, condition);
            pageBean.setList(list);
            return pageBean;
        }
    }

    /**
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    @Override
    public PageBean<Medical> findPageM(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //分页按钮向前点击的判断
        if (currentPage < 1) {
            currentPage = 1;
        }
        //创建新的pageBean对象
        PageBean<Medical> pageBean = new PageBean<>();

        //把页面获取的当前页数放入对象中
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //查询表的总记录数
        int totalCount = dao.findTotalCountM(condition);
        pageBean.setTotalCount(totalCount);
        if (totalCount == 0) {
            pageBean.setTotalCount(totalCount);
            return pageBean;
        } else {
            //计算总的页码数
            int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
            pageBean.setTotalPage(totalPage);

            //
            if (currentPage >= totalPage) {
                currentPage = totalPage;
            }
            //计算开始查询的点  c =(a-1)*b  a:点击分页后当前页数   b:每页展示的行数  c:在表中开始查询的起始点
            int start = (currentPage - 1) * rows;

            //通过开始查询点查询 返回当前页数的信息list集合
            List<Medical> list = dao.findPageM(start, rows, condition);
            pageBean.setList(list);
            return pageBean;
        }
    }

    @Override
    public void updateM(Medical sme) {
        //通过金额之间的关系设置金额
        sme.setTotal(sme.getOuts() + sme.getIns() + sme.getHexp());
        if (sme.getTotal() > sme.getNorm()) {
            sme.setTotal(sme.getTotal() * 0.9);
            sme.setBalance(0.0);
        }else {
        sme.setBalance(sme.getNorm()-sme.getTotal());
        }
        if (sme.getSons() > sme.getNorms()) {
            sme.setSonst((sme.getSons() - sme.getNorms()) * 0.5 + sme.getNorms());
        }else {
        sme.setSonst(sme.getSons());
        }
        dao.updateM(sme);
    }


    public Staff findS(Staff staff) {
        return dao.findStaff(staff);
    }

    @Override
    public void addMedical(Medical medical) {
        dao.addMedical(medical);
    }
}
