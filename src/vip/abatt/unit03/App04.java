package vip.abatt.unit03;

import java.util.Date;
import java.util.Scanner;

/**
 * Author:yankai1101
 * Desc: 文件输入、文件输出
 * 格式化输出
 **/
public class App04 {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一行信息：");

        if (in.hasNext()) {
            System.out.println(in.nextLine());
        }

        // JDK8：字符串连接
        System.out.println(String.join("-", "a", "b", "c"));// a-b-c

        // 字符串格式化
        System.out.println(String.format("hello:%s age:%d", "yk", 24)); //hello:yk age:24

        // 日期格式化
        System.out.printf("%tc", new Date()); // 星期日 一月 19 17:29:22 CST 2020

    }
}
