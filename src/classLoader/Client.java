package classLoader;


/**
 * @Description: 自定义类加载器测试类
 * @author: Arnold
 * @since: 2019/4/13 15:55
 * @version: v1.0.0
 */
public class Client {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader=new MyClassLoader("c://Users/JIA/Desktop","tongtong");
        Class clazz=loader.findClass("Test");
        clazz.newInstance();
    }
}
