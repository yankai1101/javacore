package vip.abatt.unit09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Author:YANKAI_1101
 * Date:2020/2/5
 * Time:10:34
 * 功能：测试散列表
 **/
public class SetTest {
    private static List<String> words = Arrays.asList("a", "b", "c", "d", "e", "f");

    public static void main(String[] args) {
        var words01 = new HashSet<String>(); // 构造空散列集
        var words02 = new HashSet<String>(words); // 构造散列集，并将集合中的所有元素天交到这个散列集中
        var words03 = new HashSet<String>(4); // 构造指定容量（桶数）的散列集
        var words04 = new HashSet<String>(4, 0.5f); // 构造指定容量（桶数）的散列集,填装因子0.0-1.0之间

        // a b c d e f
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext())
            System.out.printf("%s ", iterator.next());
    }
}