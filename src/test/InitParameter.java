package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/13 16:51
 * @version: v1.0.0
 */
public class InitParameter {
    public static void main(String[] args) {
        System.out.println(new User());
        System.out.println("C : "+new User().getC());
    }
}

class User{

    public User(){
        System.out.println("++++++++++++++");
    }
    private String name;
    private int age;
    private Integer old;

    private boolean flag;
    private double d;
    private float f;
    private long l;

    private char c;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", old=" + old +
                ", flag=" + flag +
                ", d=" + d +
                ", f=" + f +
                ", l=" + l +
                ", c=" + c +
                '}';
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

}
