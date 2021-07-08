package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //真实对象
        Lenovo lenovo = new Lenovo();

        //动态代理增强真实对象
        /*
        参数：
         类加载器：getClassLoader()
         接口数组：getInterfaces()
         处理器去：InvocationHandler()
         */
        Computer lenovoProxy = (Computer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {

            /**
             *  代理对象所有的方法都会调用执行该方法
             * @param proxy  代理对象
             * @param method 代理对象调用真实对象的方法时, 方法被封装成一个method对象
             * @param args   代理对象调用真实对象的方法时, 传递的实际参数列表
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*System.out.println("方法执行了");
                System.out.println(method.getName());// sale
                System.out.println(args[0]); //3800
                return null;*/
                /*
                利用反射，调用真实对象
                 */
                if ("sale".equals(method.getName())) {
                    double money = (double) args[0];
                    //增强参数列表
                    money = money * 0.8;
                  String obj = (String) method.invoke(lenovo, money);
                  //增强返回值
                   obj= obj+"鼠标";
                    System.out.println(obj);
                   return obj;
                } else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        //1真实对象调用方法
        /*
        lenovo.sale("4000"); 花了4000元买了电脑
        lenovo.show("机器人");
         */
        //2代理对象调用真实对象方法时, 会封装该方法到method, 参数封装到args
        lenovoProxy.sale(4000);
        lenovoProxy.show("菜刀");
    }
}
