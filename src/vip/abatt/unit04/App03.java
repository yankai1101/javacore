package vip.abatt.unit04;

import static java.lang.Math.*; // 静态导入包

/**
 * Author:yankai1101
 * Desc:
 **/
public class App03 {
    public static void main(String[] args) {
        new A();

        double pow = pow(1, 2);
        System.exit(0);
    }
}

class A {
    private int p1;
    private int p2;

    public A() {
    }

    public A(int p1, int p2) {
        super();
    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }
}
