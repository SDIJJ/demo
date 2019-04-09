package test;

/**
 * @Description: 测试优先队列
 * @author: Arnold
 * @since: 2019/3/6 21:35
 * @version: v1.0.0
 */
public class PriorityQueueTest {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student();
        int age=1;
        String name=new String("tongtong");
        s1.age = age;
        s1.name = name;
        System.out.println(s1);

        Student s2 = (Student) s1.clone();
        System.out.println(s2);
       s1.name="123";

        s1.age=2;
        System.out.println(s1);
        System.out.println(s2);


    }
}

class Student implements Cloneable {
    int age;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

