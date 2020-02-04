package vip.abatt.unit08;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Author:YANKAI_1101
 * Date:2020/2/3
 * Time:12:54
 * 功能：泛型程序设计
 **/
public class PairTest01 {
    public static void main(String[] args) {
        // 测试一，普通String
        String[] words = {"had", "Mary", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst()); // Mary
        System.out.println(mm.getSecond()); // little

        // 测试二，泛型测试
        LocalDate[] birthdays = {
                LocalDate.of(1996, 2, 4),
                LocalDate.of(1991, 2, 4),
                LocalDate.of(2020, 1, 4),
                LocalDate.of(2020, 1, 5)
        };
        Pair<LocalDate> localDatePair = ArrayAlg.minmax2(birthdays);
        System.out.println(localDatePair.getFirst()); // 1991-02-04
        System.out.println(localDatePair.getSecond()); // 2020-01-05
    }
}

class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    public static <T extends Comparable> Pair<T> minmax2(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    public static <T extends Comparable & Serializable> T method(T[] a) {
        return null;
    }

    public static <T extends Comparable<? super T>> T method2(T[] a) {
        return null;
    }


}
