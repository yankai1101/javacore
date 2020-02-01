package vip.abatt.unit07;


/**
 * Author:YANKAI_1101
 * Date:2020/2/1
 * Time:13:03
 * 功能：断言
 **/
public class App02 {
    public static void main(String[] args) throws InterruptedException {
        // 断言总是禁用的。
        // 开启断言 java -ea App02 或者 在VM option中设置 -ea

        int x = 3;
        // 写法1
        assert x < 5; // 若为false，抛出 java.lang.AssertionError

        // 写法2
        assert x > 5 : "error message"; //  若为false，抛出 java.lang.AssertionError 并传递 error message
    }
}
