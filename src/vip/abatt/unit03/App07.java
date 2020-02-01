package vip.abatt.unit03;

import java.util.Arrays;

/**
 * Author:yankai1101
 * Desc:数组
 **/
public class App07 {
    public static void main(String[] args) {
        int[] a = {5, 2, 1, 4, 3};
        int[] b = new int[a.length];

        // 数组拷贝
        int[] c = a.clone(); // 5	2	1	4	3
        int[] d = Arrays.copyOf(a, a.length * 2); // 5	2	1	4	3	0	0	0	0	0
        // 拷贝 从下标2开始到下标a.length结束，拷贝a数组
        int[] e = Arrays.copyOfRange(a, 2, a.length); // 1		4	3

        // for 打印数组中的内容
        for (int i = 0; i < c.length; i++) {
            System.out.print(a[i] + "\t");
        }

        System.out.println();
        // for each 打印 d数组
        for (int i : d) {
            System.out.print(i + "\t");
        }

        System.out.println();
        // Arrays.toString打印e数组
        System.out.println(Arrays.toString(e));
    }
}
