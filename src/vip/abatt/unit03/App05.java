package vip.abatt.unit03;

/**
 * Author:yankai1101
 * Desc: 条件语句、多重选择语句
 **/
public class App05 {
    public static void main(String[] args) {
        m1(1); // if:1
        m1(2); // else if:2
        m1(3); // else:3

        System.out.println();
        m2("1"); // switch:1
        m2("2"); // switch:2
        m2("3"); // default:3

        System.out.println();
        m3();

        System.out.println();
        m4();
    }

    /**
     * 条件语句
     *
     * @param type
     */
    public static void m1(int type) {
        if (type == 1) {
            System.out.println("if:1");
        } else if (type == 2) {
            System.out.println("else if:2");
        } else {
            System.out.println("else:3");
        }
    }

    /**
     * 多重选择语句
     *
     * @param type
     */
    public static void m2(String type) {
        // Java 7 支持 swith 类型支持 String
        switch (type) {
            case "1":
                System.out.println("switch:1");
                break;
            case "2":
                System.out.println("switch:2");
                break;
            default:
                System.out.println("default:3");
                break;
        }
    }

    /**
     * 循环语句
     */
    public static void m3() {
        int i = 0;
        while (i < 3) {
            i++;
            System.out.println("while:i=" + i); // while:i=1    while:i=2    while:i=3
        }

        int j;
        for (j = 0; j < 3; j++) {
            System.out.println("for:i=" + j); // for:i=0    for:i=1    for:i=2
        }


        int k = 0;
        do {
            k++;
            System.out.println("do while:k=" + k); // do while:k=1    do while:k=2    do while:k=3
        } while (k < 3);
    }

    public static void m4() {
        // continue 跳出本次循环
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                continue;
            System.out.print(i + "\t"); // 1    3    5    7    9
        }

        System.out.println();


        // Java中保留了goto关键字（Java中使用带标签的break：标签必须放在最外层，并且紧跟着一个冒号）。
        int i = 1;
        lable01:
        while (true) { // 第一层循环
            System.out.print(i + "\t"); // 1	2	3	4	5
            if (i % 5 == 0)
                break lable01; // 若 i ==3 ，则跳出第一层循环。
            i++;
        }
        System.out.println("i=" + i); // i=5
    }
}
