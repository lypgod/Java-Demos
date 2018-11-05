package com.lypgod.Java_8_The_Missing_Tutorial.C06_Date_Time_API;

import java.nio.file.attribute.FileTime;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeTest {
    private void testDate() {
        Date date = new Date(12, 12, 12);
        System.out.println(date);
    }

    private void testLocalDateTime() {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("Month: " + month
                + "; day: " + day
                + "; seconds: " + seconds
        );

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    private void testLocalDateTime2() {
        LocalDateTime date = LocalDateTime.of(1091, 2, 3, 12, 55);
        System.out.println(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        // 计算某个月的第一个周二
        LocalDate date1 = LocalDate.of(2018, 11, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(date1);

        // 创建自己的校正
        LocalDate date2 = LocalDate.of(2018, 11, 1).with(TemporalAdjusters.ofDateAdjuster(localDate -> localDate.withYear(1000)));
        System.out.println(date2);

        DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
    }


    private void testLocalDateTimeConvertDate() {
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        instant = date.toInstant();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        GregorianCalendar calendar = GregorianCalendar.from(zonedDateTime);
        zonedDateTime = calendar.toZonedDateTime();

        Timestamp timestamp = Timestamp.from(instant);
        instant = timestamp.toInstant();

        LocalDateTime localDateTime = LocalDateTime.now();
        timestamp = Timestamp.valueOf(localDateTime);
        localDateTime = timestamp.toLocalDateTime();

        LocalDate localDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        localDate = sqlDate.toLocalDate();

        LocalTime localTime = LocalTime.now();
        Time sqlTime = Time.valueOf(localTime);
        localTime = sqlTime.toLocalTime();

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        DateFormat format = (DateFormat) formatter.toFormat();

        ZoneId zoneId = ZoneId.systemDefault();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        zoneId = timeZone.toZoneId();

        FileTime fileTime = FileTime.from(instant);
        instant = fileTime.toInstant();
    }

    public static void main(String[] args) {
        new DateTimeTest().testLocalDateTime2();
    }
}