package test;

/**
 * @Description: 枚举测试
 * @author: Arnold
 * @since: 2019/4/2 19:42
 * @version: v1.0.0
 */
public enum ee {
    a("tongtong",22);
    private String name;
    private int age;
     ee(String name ,int age){
        this.age=age;
        this.name=name;
    }
    public void dd(){
        if(a==this)
            System.out.println("0000000000");
        System.out.println(this.name);
    }


    public static void main(String[] args) {
       a.dd();

    }
}
