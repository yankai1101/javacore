package vip.abatt.unit12;

/**
 * Author:YANKAI_1101
 * Date:2020/2/10
 * Time:8:55
 * 功能：
 **/
public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(4, 1000);

        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = Math.random() * MAX_AMOUNT;
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = Math.random() * MAX_AMOUNT;
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        //Thread[Thread-1,5,main]    745.93 from 2 to 3 Total Balance:   4000.00
        //Thread[Thread-1,5,main]    712.60 from 2 to 3 Total Balance:   4000.00
        //Thread[Thread-0,5,main]    230.62 from 0 to 1 Total Balance:   4000.00
        //Thread[Thread-1,5,main]    384.16 from 2 to 3 Total Balance:   4000.00
        //Thread[Thread-0,5,main]    887.26 from 0 to 1 Total Balance:   4000.00
        // ...
    }
}
