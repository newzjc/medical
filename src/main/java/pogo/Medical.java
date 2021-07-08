package pogo;

import java.util.Date;

public class Medical {
    private Date date;
    private Integer id;
    private String branch;
    private String name;
    private Double outs;
    private Double ins;
    private Double hexp;
    private Double sons;
    private Double total;
    private Double balance;
    private Double sonst;
    private Double norm;
    private Double norms;

    public Medical() {

    }

    public Medical(Date date, Integer id, String branch, String name, Double outs, Double ins, Double hexp, Double sons, Double total, Double balance, Double sonst, Double norm, Double norms) {
        this.date = date;
        this.id = id;
        this.branch = branch;
        this.name = name;
        this.outs = outs;
        this.ins = ins;
        this.hexp = hexp;
        this.sons = sons;
        this.total = total;
        this.balance = balance;
        this.sonst = sonst;
        this.norm = norm;
        this.norms = norms;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOuts() {
        return outs;
    }

    public void setOuts(Double outs) {
        this.outs = outs;
    }

    public Double getIns() {
        return ins;
    }

    public void setIns(Double ins) {
        this.ins = ins;
    }

    public Double getHexp() {
        return hexp;
    }

    public void setHexp(Double hexp) {
        this.hexp = hexp;
    }

    public Double getSons() {
        return sons;
    }

    public void setSons(Double sons) {
        this.sons = sons;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getSonst() {
        return sonst;
    }

    public void setSonst(Double sonst) {
        this.sonst = sonst;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public Double getNorms() {
        return norms;
    }

    public void setNorms(Double norms) {
        this.norms = norms;
    }
}
