package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/6 23:00
 * @version: v1.0.0
 */
class Teacher implements Cloneable {
    private String name;
    private SS SS;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SS getSS() {
        return SS;
    }

    public void setSS(SS SS) {
        this.SS = SS;
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", SS=" + SS + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SS s1 = new SS();
        s1.setAge(20);
        s1.setName("张三");

        Teacher teacher1 = new Teacher();
        teacher1.setName("小赵老师");
        teacher1.setSS(s1);
        //为什么会出现以下结果, Teacher中的clone方法
        Teacher teacher2 = (Teacher) teacher1.clone();
        SS s2 = teacher2.getSS();
        s2.setName("李四");
        s2.setAge(30);
        System.out.println("teacher1:" + teacher1);
        System.out.println("teacher2:" + teacher2);

    }


}

class SS{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SS{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
