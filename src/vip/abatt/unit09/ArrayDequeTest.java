package vip.abatt.unit09;

import java.util.ArrayDeque;

/**
 * Author:YANKAI_1101
 * Date:2020/2/8
 * Time:10:40
 * 功能：双端队列
 **/
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 1-9添加到队列
        for (int i = 1; i < 10; i++) {
            deque.add(i);
        }

        deque.addFirst(0); // 把 0 添加到首个位置
        deque.addLast(10); // 把 10添加到末尾位置

        // 输出 起始位置和末尾位置
        System.out.println(deque.getFirst()); // 0
        System.out.println(deque.getLast()); // 10

        // 0,1,2,3,4,5,6,7,8,9,10,
        deque.forEach(element -> {
            System.out.print(element + ",");
        });
    }
}
