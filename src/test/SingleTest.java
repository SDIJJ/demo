package test;

/**
 * @Description: 基于静态内部类的单例模式
 * @author: Arnold
 * @since: 2019/4/2 20:54
 * @version: v1.0.0
 */
public class SingleTest {
    private SingleTest(){
        if(InnerClass.instance!=null)
          throw new  RuntimeException("非法使用构造器");
    }
    static class InnerClass{
        private final static SingleTest instance=new SingleTest();
    }
    public static SingleTest getInstance(){
        return InnerClass.instance;
    }

    public static void main(String[] args) throws Exception{

            Class<SingleTest> clazz= (Class<SingleTest>) Class.forName("com.jia.utils.test.SingleTest");
            clazz.newInstance();
    }
}
