package test;

import java.io.*;

/**
 * @Description: 序列化测试
 * @author: Arnold
 * @since: 2019/4/2 21:18
 * @version: v1.0.0
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception{
        Tong tong = new Tong("tongtong", 22);
        new ObjectOutputStream(new FileOutputStream(new File("D:/tong.txt"))).writeObject(tong);
        Tong myTong= (Tong) new ObjectInputStream(new FileInputStream(new File("D:/tong.txt"))).readObject();
        System.out.println(myTong);
    }

}

class Tong implements Serializable{


    public  String name;
    public  int age;
    public Tong(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tong{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
