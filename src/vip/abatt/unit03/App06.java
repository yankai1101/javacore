package vip.abatt.unit03;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Author:yankai1101
 * Desc: 大数
 * BigInteger
 * BigDecimal
 **/
public class App06 {
    public static void main(String[] args) {
        // 使用静态方法，创建大数(传入Long类型)
        BigInteger big1 = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(big1); // 9223372036854775807

        // 对于更大的数（传入String类型）
        BigInteger big02 = new BigInteger("123456789000000000123456789");
        BigInteger big03 = new BigInteger("123456789000000000");

        // big02 + big03
        System.out.println(big02.add(big03)); //123456789123456789123456789

        // big02 - big03
        System.out.println(big02.subtract(big03)); //123456788876543211123456789

        // big02 * big03
        System.out.println(big02.multiply(big03)); //15241578750190521015241578750190521000000000

        // big02 / big03
        System.out.println(big02.divide(big03)); //1000000000

        // big02 % big03
        System.out.println(big02.mod(big03)); //123456789

    }
}
