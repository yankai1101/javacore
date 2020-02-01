package vip.abatt.unit04;

/**
 * Author:yankai1101
 * Desc:
 * Java方法总是采用按值调用。
 **/
public class App02 {
    public static void main(String[] args) {
        User a = new User("a");
        User b = new User("b");

        // a 与 b 交换
        swap(a, b);

        // a 和 b 并没有交换，因为 java是按值调用; 而显示参数 u1 与 u2 交换了
        System.out.println("a:" + a); // a
        System.out.println("b:" + b); // b
    }

    public static void swap(User u1, User u2) { // u1 = a ; u2 = b
        User c = u1;
        u1 = u2;
        u2 = c;
        System.out.println("u1:" + u1); // b
        System.out.println("u2:" + u2); // a
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
