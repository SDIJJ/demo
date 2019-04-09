package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @author: Arnold
 * @since: 2018/12/31 13:50
 * @version: v1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    public int id();
    public String descr() default "123";
}

class TestClass{
    @Test(id=1,descr = "234")
    private String name;

        }
