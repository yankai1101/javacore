package vip.abatt.unit09;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Author:YANKAI_1101
 * Date:2020/2/9
 * Time:20:45
 * 功能：散列集
 **/
public class HashSetTest {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(5);
        hashtable.put("id", "1101");
        hashtable.put("name", "yk");
        hashtable.put("age", 24);
        System.out.println(hashtable); // {name=yk, age=24, id=1101}


        // 不关心集合中的元素的顺序才使用HashSet
        HashSet<String> hashSet = new HashSet<>(5);
        hashSet.add("id");
        hashSet.add("name");
        hashSet.add("age");
        System.out.println(hashSet); //[name, id, age]
    }
}
