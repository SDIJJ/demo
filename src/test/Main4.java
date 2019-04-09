package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/23 19:36
 * @version: v1.0.0
 */
public class Main4 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 1900; i <=2018 ; i++) {
            String str=String.valueOf(i);

            Date date=df.parse(str+"-6-6");
            if(getWeekOfDate(date).equals("星期六"))
                System.out.print(i+",");
            
        }

    }

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
