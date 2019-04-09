package reflect;


import java.lang.annotation.*;
import java.lang.reflect.Field;


/**
 * 通过反射获取注解信息
 *
 * @author 尚学堂高淇
 */
public class Demo05 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.bjsxt.test.annotation.SxtStudent");
            //获得类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
            //获得类的指定的注解
            SxtTable st = (SxtTable) clazz.getAnnotation(SxtTable.class);
            System.out.println(st.value());

            //获得类的属性的注解
            Field f = clazz.getDeclaredField("studentName");
            SxtField sxtField = f.getAnnotation(SxtField.class);
            System.out.println(sxtField.columnName() + "--" + sxtField.type() + "--" + sxtField.length());

            //根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成相关的表

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface SxtField {
    String columnName();

    String type();

    int length();
}


@SxtTable("tb_student")
class SxtStudent {

    @SxtField(columnName = "id", type = "int", length = 10)
    private int id;
    @SxtField(columnName = "sname", type = "varchar", length = 10)
    private String studentName;
    @SxtField(columnName = "age", type = "int", length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}


@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SxtTable {
    String value();
}