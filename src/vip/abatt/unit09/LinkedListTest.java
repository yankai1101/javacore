package vip.abatt.unit09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Author:YANKAI_1101
 * Date:2020/2/4
 * Time:13:52
 * 功能：队列-->链表实现方式
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        // 添加3个元素
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        iterator.hasNext(); // 是否有下一个
        Integer first = iterator.next(); // 下一个
        Integer second = iterator.next();
        // 删除第2个元素
        iterator.remove();

        // 支持反向遍历的 iterator
        ListIterator<Integer> listIterator = list.listIterator();
        listIterator.hasPrevious(); // 是否有上一个
        Integer last = listIterator.previous(); // 上一个
        listIterator.nextIndex(); // 返回下一次调用next方法时所返回元素的整数索引
        listIterator.previousIndex(); //
    }
}
