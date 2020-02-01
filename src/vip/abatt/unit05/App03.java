package vip.abatt.unit05;

/**
 * Author:yankai1101
 * Desc: 使用 Integer 类进行进制转换
 **/
public class App03 {
    public static void main(String[] args) {
        System.out.println(Integer.toString(13, 2)); // 十进制13 -> 2进制   1101
        System.out.println(Integer.toString(13, 8)); // 十进制13 -> 8进制   15
        System.out.println(Integer.toString(13, 10)); // 十进制13 -> 10进制 13
        System.out.println(Integer.toString(13, 16));// 十进制13 -> 16进制  d
    }
}