package vip.abatt.unit12;

/**
 * Author:YANKAI_1101
 * Date:2020/2/10
 * Time:11:48
 * 功能：中断线程测试
 * 线程中断状态,默认状态false。通过Thread.currentThread().isInterrupted()获取
 * thread.interrupt(); 线程中断状态会设为 true。
 * MyThread.interrupted();  静态方法 测试当前线程是否被打断，线程中断状态会设为 false
 **/
public class InterruptThreadTest {
    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();

        // 1s 后发送中断请求，线程中断状态会设为 true
        Thread.sleep(1000);
        thread.interrupt();

        //...
        //do something...
        //do something...
        //do something...
        //线程已经中断...
    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            // Thread.currentThread().isInterrupted() == false
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("do something...");
            }
            System.out.println("线程已经中断...");
        }
    }
}
