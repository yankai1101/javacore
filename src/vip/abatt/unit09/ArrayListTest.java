package vip.abatt.unit09;

import java.util.ArrayList;

/**
 * Author:YANKAI_1101
 * Date:2020/2/9
 * Time:20:39
 * 功能：数组列表:ArrayList的优点在于可以顺序存储，随机存取,数据元素与位置相关联，因此查找效率高，索引遍历快，尾部插入与删除的速度与LinkedList的速相差无几
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList.get(2)); // 3
    }
}
