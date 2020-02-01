package vip.abatt.unit05;

import java.lang.reflect.InvocationTargetException;

/**
 * Author: yankai1101
 * Desc: 反射
 **/
public class App04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        A a = new A(24);

        System.out.println(a.getClass().getName()); // vip.abatt.unit05.A

        // 使用反射 得到A对象的实例
        Class<?> clazz = Class.forName("vip.abatt.unit05.A");
        A instance = (A) clazz.getConstructor(int.class).newInstance(25);
        System.out.println(instance); // {"age":25}
    }
}

class A {
    private int age = 0;

    public A(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\"age\":" + age + "}";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}