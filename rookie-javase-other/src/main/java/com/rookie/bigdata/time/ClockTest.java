package com.rookie.bigdata.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName ClockTest
 * @Description ClockTest
 * @Author
 * @Date 2020/4/29 18:03
 * @Version 1.0
 */
public class ClockTest {

    public static void main(String[] args) {
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System. out.println("Clock : " + clock.millis());
// Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System. out.println("Clock : " + defaultClock.millis());

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of( 2020,4,30);
        if(tomorrow.isAfter(today)){
            System.out.println( "之后的⽇期:"+tomorrow);
        }
        LocalDate yesterday = today.minus( 1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println( "之前的⽇期:"+yesterday);
        }


        ZoneId america = ZoneId.of( "America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println( "Current date and time in a particular timezone : " + dateAndTimeInNewYork);
    }
}
