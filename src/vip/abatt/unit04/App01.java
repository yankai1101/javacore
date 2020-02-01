package vip.abatt.unit04;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * Author:yankai1101
 * Desc:
 * 当前日期是当前周的周几: localDate.getDayOfWeek().getValue();
 * 当前日期是当前月的几号: localDate.getDayOfMonth();
 * 月初日期：LocalDate localDate = localDate.with(TemporalAdjusters.firstDayOfMonth())
 * 月末日期：LocalDate localDate = localDate.with(TemporalAdjusters.lastDayOfMonth())
 **/
public class App01 {
    public static void main(String[] args) {
        // 获取当前日期 2020-01-21
        LocalDate localDate = LocalDate.now();

        // 获取月初是星期几：1 周一；7 周日
        int weekNum = localDate.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();
        // 获取当前月总天数
        int monthNum = localDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();

        System.out.println("一\t二\t三\t四\t五\t六\t日");
        // flag：若 flag % 7 == 0，则换行
        int flag = 0;
        for (int i = 1; i < weekNum; i++) {
            flag++;
            System.out.print("\t");
        }

        for (int i = 1; i <= monthNum; i++) {
            if (flag % 7 == 0) {
                System.out.println();
            }
            System.out.print(i + "\t");
            flag++;
        }
    }
}
