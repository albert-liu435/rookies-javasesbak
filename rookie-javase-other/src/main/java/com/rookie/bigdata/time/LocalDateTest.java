package com.rookie.bigdata.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName LocalDateTest
 * @Description LocalDateTest
 * @Author
 * @Date 2020/4/29 17:36
 * @Version 1.0
 */
public class LocalDateTest {

    public static void main(String[] args) {
        //获取当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println("MIN:"+LocalDate.MIN);
        System.out.println("MAX"+LocalDate.MAX);

        //获取2020年4月23日
        LocalDate date=LocalDate.of(2020, Month.APRIL,23);
        System.out.println(date);

//        //LocalDate date1 = LocalDate.now();
//        LocalDate date1=LocalDate.of(2020, Month.FEBRUARY,5);
//        LocalDate date2 = LocalDate.of( 2020,2,5);
//        int i = date1.compareTo(date2);
//        System.out.println(i);
//        if(date1.equals(date2)){
//            System. out.println("时间相等");
//        } else{
//            System. out.println("时间不等");
//        }


//        LocalDate date1 = LocalDate.now();
//        date.toString();
//        LocalDate date2 = LocalDate.of( 2018,2,6);
//        MonthDay birthday = MonthDay.of(date2.getMonth(),date2.getDayOfMonth());
//        MonthDay currentMonthDay = MonthDay. from(date1);
//        if(currentMonthDay.equals(birthday)){
//            System. out.println("是你的⽣⽇");
//        } else{
//            System. out.println("你的⽣⽇还没有到");
//        }


//        LocalTime time = LocalTime.now();
//        System.out.println( "获取当前的时间,不含有⽇期:"+time);


        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours( 3);
        System.out.println( "三个⼩时后的时间为:"+newTime);


        LocalDate today = LocalDate.now();
        System.out.println( "今天的⽇期为:"+today);
        LocalDate nextWeek = today.plus( 1, ChronoUnit.WEEKS);
        System.out.println( "⼀周后的⽇期为:"+nextWeek);
    }

}
