package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/13 17:00
 * @version: v1.0.0
 */
public class executeOrder {
    public static void main(String[] args) {
        new Sub();
    }
}

class Super{
    {
        System.out.println("父类非静态块");
    }
    public Super(){
        System.out.println("父类构造器");
    }
    static {
        System.out.println("父类静态块");
    }
}

class Sub extends Super{
    {
        System.out.println("子类非静态块");
    }
    public Sub(){
        System.out.println("子类构造器");
    }
    static {
        System.out.println("子类静态块");
    }
}
