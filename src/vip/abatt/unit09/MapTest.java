package vip.abatt.unit09;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author:YANKAI_1101
 * Date:2020/2/9
 * Time:21:08
 * 功能：HashMap稍微快一些，TreeMap是有序的，LinkedhashMap是最近最少使用的。
 **/
public class MapTest {
    public static void main(String[] args) {
        // HashMap稍微快一些
        HashMap<String, Object> hashMap = new HashMap<>(5);
        hashMap.put("name", "闫小凯");
        hashMap.put("age", "二十四");
        hashMap.put("sex", "男");
        System.out.println(hashMap); // {name=闫小凯, age=二十四, sex=男}

        // TreeMap是有序的
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(21, "张三");
        treeMap.put(25, "李四");
        treeMap.put(24, "王五");
        treeMap.put(20, "赵六");
        System.out.println(treeMap); // {20=赵六, 21=张三, 24=王五, 25=李四}

        // linkedHashMap每次调用get和put时，受到影响的项将从当前位置删除，并在添加到结尾
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap(3,0.75f,true);
        linkedHashMap.put(22, "李四");
        linkedHashMap.put(21, "张三");
        linkedHashMap.put(23, "王五");


        System.out.println("\n" + linkedHashMap); // {22=李四, 21=张三, 23=王五}
        linkedHashMap.get(21);
        System.out.println(linkedHashMap); // {22=李四, 23=王五, 21=张三}
        linkedHashMap.get(22);
        System.out.println(linkedHashMap); // {23=王五, 21=张三, 22=李四}
    }
}
