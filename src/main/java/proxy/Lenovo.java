package proxy;

public class Lenovo implements Computer{
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"元买了电脑");
        return "买了电脑";
    }

    @Override
    public void show(String show) {
        System.out.println("展示"+show);
    }
}
