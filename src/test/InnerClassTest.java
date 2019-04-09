package test;

/**
 * @Description: 静态内部类加载过程测试
 * @author: Arnold
 * @since: 2019/4/2 20:43
 * @version: v1.0.0
 */
public class InnerClassTest {
    static{
        System.out.println("加载外部类");
    }
    static class InnerClass{
        public InnerClass(){}
        static{
            System.out.println("加载内部类");
            }
            static void innerMethod(){
                System.out.println("内部类静态方法");
            }

        static int a;
    }

    public static void main(String[] args) {
        InnerClass.a=100;
    }
}
