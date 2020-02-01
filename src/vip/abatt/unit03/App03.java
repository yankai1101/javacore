package vip.abatt.unit03;

/**
 * Author:yankai1101
 * Desc: 基本数据类型
 */
public class App03 {
    /* byte类型 */
    private byte mbyte = 127;

    /* short类型 */
    private short mshort = 1;

    /* int 类型 */
    private int mint = 10;

    /* long类型 */
    private long mlong = 100L;

    /* float 类型，以f或F结尾 */
    private float mfloat = 12.80F;

    /* double类型，已d或D结尾 */
    private double mdouble = 127.00D;

    /* char 类型 */
    private char mchar = 'A';

    /* boolean 类型 */
    private boolean mboolean = true;

    /* 声明常量，大写 */
    private final int TAG = 0;

    public static void main(String[] args) {
        // 0.125 = 2的-3次方，使用 p表示指数,指数采用十进制，指数的技术是2
        double d = 0X1.0p-3;
        System.out.println(d); // 0.125

        // JDK7 以后，二进制可以加下划线
        int bin = 1101_1102;
        System.out.println(bin); // 11011102

    }
}
