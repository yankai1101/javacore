package vip.abatt.unit12;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:YANKAI_1101
 * Date:2020/2/10
 * Time:10:18
 * 功能：
 **/
public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }


    public void transfer(int from, int to, double amount) {
        accounts[from] -= amount;
        accounts[to] += amount;
        System.out.print(Thread.currentThread());
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        System.out.printf(" Total Balance:%10.2f%n", getTotalBalance());
    }

    public double getTotalBalance() {
        lock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            lock.unlock();
        }
    }

    private ReentrantLock lock;
    private Condition condition;

    public void transferLock(int from, int to, double amount) {
        lock.lock();
        try {
            // 如果转账用户的金额小于转账金额，等待
            while (accounts[from] < amount)
                condition.await();
            transfer(from, to, amount);
            condition.signalAll(); // 通知解除等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public double getTotalBalanceLock() {
        lock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            lock.unlock();
        }
    }

    public synchronized void transferSynchronized(int from, int to, double amount) {
        try {
            // 如果转账用户的金额小于转账金额，等待
            while (accounts[from] < amount)
                wait();
            transfer(from, to, amount);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized double getTotalBalanceSync() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }


    public int size() {
        return accounts.length;
    }
}
