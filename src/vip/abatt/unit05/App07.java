package vip.abatt.unit05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author:yankai1101
 * Desc: 反射用法
 * xx.setAccessible(true); 设置该对象可访问
 **/
public class App07 {
    public static void main(String[] args) throws Exception {
        // 反射
        Class clazz = Student.class;
        Student instance = (Student) clazz.newInstance();

        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        String name = (String) field.get(instance);
        System.out.println("私有属性：name = " + name); // 私有属性：name = YK

        // 执行 setAge方法
        Method setAge = clazz.getDeclaredMethod("setAge", int.class);
        setAge.setAccessible(true);
        Object invoke = setAge.invoke(instance, 20);
        System.out.println("私有方法：setAge的返回值 = " + invoke); // 私有方法：setAge的返回值 = null

        // 执行 setAge方法
        Method getAge = clazz.getDeclaredMethod("getAge", null);
        getAge.setAccessible(true);
        int age = (int) getAge.invoke(instance, null);
        System.out.println("私有方法：getAge的返回值 = " + age); // 私有方法：getAge的返回值 = 20
    }
}

class Student {
    private String name = "YK";
    private int age;

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}