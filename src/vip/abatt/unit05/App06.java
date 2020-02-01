package vip.abatt.unit05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author yankai1101
 * Desc: 利用反射，打印出 Integer 类
 **/
public class App06 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.Integer");
        Constructor[] constructors = clazz.getDeclaredConstructors();

        // 打印头信息（修饰符、类全名、父类名、接口数组），比如 public final java.lang.Integer extends java.lang.Number implements java.lang.Comparable {
        printTitle(clazz);

        // 打印所有的属性：比如 public static final int java.lang.Integer.MIN_VALUE;
        printFields(clazz);

        // 打印所有构造器：比如 public java.lang.Integer(java.lang.String) throws java.lang.NumberFormatException{}
        printConstructors(constructors);

        // 打印类中所有的方法
        printMethods(clazz);

        // 打印尾信息
        System.out.println("}");

    }


    /**
     * 打印头信息（修饰符、类全名、父类名、接口数组）
     * 比如 public final java.lang.Integer extends java.lang.Number implements java.lang.Comparable {
     *
     * @param clazz
     */
    private static void printTitle(Class clazz) {
        // 获取 类名，比如 Integer
        String subclassName = clazz.getName();

        // 获取 方法修饰符
        int modifier = clazz.getModifiers(); // 返回一个整数，描述类/域/方法的修饰符，比如 1
        String stringModifier = Modifier.toString(modifier); // 通过 Modifier 中的方法描述这个修饰符，比如 public
        System.out.print(stringModifier + " " + subclassName); // public final Integer

        // 获取 父类全类名 java.lang.Number
        Class superclass = clazz.getSuperclass();
        if (superclass != null) {
            String superclassName = superclass.getName();
            System.out.print(" extends " + superclassName); // extends java.lang.Number
        }

        // 获取 接口 implements java.awt.ItemSelectable ,javax.accessibility.Accessible
        Class[] interfaces = clazz.getInterfaces();
        if (interfaces != null && interfaces.length > 0) {
            System.out.print(" implements ");
            for (int i = 0; i < interfaces.length; i++) {
                System.out.print(i == 0 ? interfaces[i].getName() : " ," + interfaces[i].getName());
            }
        }
        System.out.println(" {");
    }

    /**
     * 打印所有的属性：
     * 比如 public static final int java.lang.Integer.MIN_VALUE;
     *
     * @param clazz
     */
    private static void printFields(Class clazz) {
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("\t" + field.toGenericString() + ";");
        }
        System.out.println();
    }

    /**
     * 打印 构造器
     * 比如 public java.lang.Integer(java.lang.String) throws java.lang.NumberFormatException{}
     *
     * @param constructors
     */
    private static void printConstructors(Constructor[] constructors) {
        for (Constructor constructor : constructors) {
            System.out.println("\t" + constructor + "{}");
        }
        System.out.println();
    }

    /**
     * 打印方法全部方法信息，
     * 比如 public static int java.lang.Integer.compare(int,int){}
     * @param clazz
     */
    private static void printMethods(Class clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("\t" + method.toGenericString() + "{}");
        }
    }
}
