package vip.abatt.unit07;

import java.util.Scanner;

/**
 * Author:YANKAI_1101
 * Date:2020/2/1
 * Time:13:03
 * 功能：异常
 **/
public class App01 {
    public static void main(String[] args) {
        // try-catch-finally
        try {
            // some code
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // end...
        }

        // 实现了 AutoCloseable接口的流，使用 try-with-resources 无需手动关闭资源
        try (Scanner in = new Scanner(System.in)) {
            // some code
        }

    }
}
