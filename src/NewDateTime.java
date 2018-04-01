import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @description:
 * @author:panguangyi
 * @date: 2018-3-12
 */
public class NewDateTime {
    public static void main(String [] args){
        //1.获取本地日期 格式默认yyyy-mm-dd 可使用DateTimeFormatter转换格式
        String oldDateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//旧方法
        LocalDate today = LocalDate.now();
        System.out.println("LocalDate now is:" + today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        //2.分别获取年、月、日
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year: %d Month: %d Day: %d\n",year,month,day);
        //3.比较两个日期
        LocalDate today2 = LocalDate.of(2018,3,13);
        if(today.equals(today2)){
            System.out.println("today equals today2");
        }
        if(today.isBefore(today2)){
            System.out.println(today + "早于" + today2);
        }
        if(today2.isAfter(today)){
            System.out.println(today + "晚于" + today2);
        }

        //4.获取本地时间 默认格式HH:mm:ss.nnn
        LocalTime time = LocalTime.now().withNano(0); //将毫秒取值0
        System.out.println("LocalTime now is:" + time);

        //5.获取当前日期+时间 默认格式yyyy-MM-dd HH:mm:SS.nnn 可使用DateTimeFormatter转换格式
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("转换后的日期时间格式:" + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS")));

        //6.返回指定的某个日期
        LocalDate specifiedDate = LocalDate.of(2018,3,13);
        System.out.println("指定日期:" + specifiedDate);

        //7.返回指定的某个时间
        LocalTime specifiedTime = LocalTime.of(15,40,30);
        System.out.println("指定时间:" + specifiedTime);

        //8.获取该月共有几天
        int lengthOfMonth = today.lengthOfMonth();
        System.out.printf("该月有%d天\n",lengthOfMonth);

        //9.获取星期几
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println(dayOfWeek);

        //10.日期计算
        LocalDate tomorrow = today.plusDays(1);
        LocalDate preWeekDate = today.minusWeeks(1);
        LocalDate nextMonthDate = today.plusMonths(1);
        System.out.println("明天日期:" + tomorrow);
        System.out.println("上一周日期:" + preWeekDate);
        System.out.println("下个月日期:" + nextMonthDate);
        //11.带时区的完整时间，它根据UTC/格林威治时间来进行时区调整
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        //12.获取时间戳
        Instant timestamp = Instant.now();
        System.out.println(timestamp);

        long currentTimeMillis = Clock.systemUTC().millis();
        System.out.println(currentTimeMillis);
        System.out.println(System.currentTimeMillis());


    }
}
