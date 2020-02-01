package vip.abatt.abatt.unit06;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author:YANKAI_1101
 * Date:2020/1/31
 * Time:17:07
 * 功能：lambda表达式
 **/
public class App04 {
    public static void main(String[] args) {
        // lambda表达式
        String[] ages = new String[]{"Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus"};
        Arrays.sort(ages); // [Jupiter, Mars, Mercury, Saturn, Uranus, Venus]
        //[Mars, Venus, Saturn, Uranus, Jupiter, Mercury]
        Arrays.sort(ages, (first, second) -> first.length() - second.length());

        // 打印Timer中的 event
        Timer timer1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println(event);
            }
        });
        Timer timer2 = new Timer(1000, (event) -> System.out.println(event));
        Timer timer3 = new Timer(1000, event -> System.out.println(event));
        Timer timer4 = new Timer(1000, System.out::println); // 方法引用

        // 通过 lambda 表达式，构造Person列表
        List<String> names = Arrays.asList("张三", "李四", "王五");
        Stream<Person> stream = names.stream().map(Person::new); // new Person(name); 构造器引用
        List<Person> people = stream.collect(Collectors.toList());


        // 延迟执行，只有当thread调用start()方法时;
        Thread thread = new Thread(() -> {
            System.out.println("run...");
        });
        thread.start();
    }


}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                '}';
    }
}


