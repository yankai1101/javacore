package vip.abatt.unit12;

/**
 * Author:YANKAI_1101
 * Date:2020/2/11
 * Time:12:16
 * 功能：未加锁时，Bank
 **/
public class UnsynchBankTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(10, 1000);

        for (int i = 0; i < 10; i++) {
            int from = i;
            Runnable task = () -> {
                try {
                    while (true) {
                        int to = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(from, to, amount);// 未同步方法
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(task);
            thread.start();
        }
        //Thread[Thread-9,5,main]    235.67 from 9 to 0 Total Balance:  10000.00
        //Thread[Thread-5,5,main]    763.25 from 5 to 5 Total Balance:   9720.14
        //...总余额减少
    }
}
