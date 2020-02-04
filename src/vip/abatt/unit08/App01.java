package vip.abatt.unit08;

import java.util.ArrayList;

/**
 * Author:YANKAI_1101
 * Date:2020/2/4
 * Time:13:47
 * 功能：证明Java类型的类型擦除
 * Java的泛型是伪泛型，这是因为Java在编译期间，所有的泛型信息都会被擦掉，正确理解泛型概念的首要前提是理解类型擦除。
 * Java的泛型基本上都是在编译器这个层次上实现的，在生成的字节码中是不包含泛型中的类型信息的，使用泛型的时候加上类型参数，
 * 在编译器编译的时候会去掉，这个过程成为类型擦除。
 **/
public class App01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);

        System.out.println(list.getClass() == list2.getClass()); // true
    }
}
