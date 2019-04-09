package test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description: Calendar 测试
 * @author: Arnold
 * @since: 2019/3/23 20:30
 * @version: v1.0.0
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int i = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);
        c.add(Calendar.YEAR,1);



    }
}
