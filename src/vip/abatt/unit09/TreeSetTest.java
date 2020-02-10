package vip.abatt.unit09;

import java.util.TreeSet;

/**
 * Author:YANKAI_1101
 * Date:2020/2/9
 * Time:21:02
 * 功能：树集
 **/
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Bob");
        treeSet.add("Amy");
        treeSet.add("Carl");

        System.out.println(treeSet); // [Amy, Bob, Carl]
        System.out.println(treeSet.first()); // Amy
        System.out.println(treeSet.last()); // Carl
    }
}
