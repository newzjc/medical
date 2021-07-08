package pogo;

import java.util.List;

/**
 * 使用泛型T来复用之后若需分页的页面 ,改变对象也可使用该类
 *
 * @param <T>
 */
public class PageBean<T> {
    private int totalCount; //表中的记录数
    private int totalPage;  //总页码
    private List<T> list;      //每页的数据
    private int currentPage; //当前的页码
    private int rows;       //每页的记录数

    public PageBean() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
