package reflect.imooc;

import com.jia.vo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 使用反射拿到所有.类型
 * @author: Arnold
 * @since: 2019/4/4 11:58
 * @version: v1.0.0
 */
public class ReflectAllTest {

    public static void getAllMessage(Object obj) {
        Class clazz = obj.getClass();
        //1.获得类的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("方法名字:" + declaredMethod.getName());
            Class<?> returnType = declaredMethod.getReturnType();
            String name = returnType.getName();
            System.out.println("    方法返回值类型:" + name);
            //方法参数
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            System.out.println("    方法参数:");
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("        参数:" + parameterType.getName());
            }
            System.out.println();


            //2.获取属性
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Class<?> type = declaredField.getType();
                System.out.println("    "+type.getSimpleName()+"    "+declaredField.getName());
                System.out.println();

            }

            //3.获取构造方法
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor.getName());
            }
        }





    }

    public static void main(String[] args) {
        User user=new User();
        ReflectAllTest.getAllMessage(user);
    }
}
