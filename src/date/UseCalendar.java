package date;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther lujieni
 * @Date 2020/5/26
 */
public class UseCalendar {

    @Test
    public void use(){
        Date now = new Date();
        System.out.println(now);
        Calendar instance = Calendar.getInstance();
        instance.setTime(now);
        instance.add(Calendar.SECOND,-1);
        System.out.println(instance.getTime());
    }

}
