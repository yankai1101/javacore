package vip.abatt.unit12;

/**
 * Author:YANKAI_1101
 * Date:2020/2/10
 * Time:12:59
 * 功能：守护线程测试
 **/
public class DaemonThreadThread {

    public static void main(String[] args) {
        // 计数器线程
        MyThread myThread = new MyThread(1, 10);
        myThread.start();

        // 守护线程
        Thread thread = new Thread(() -> {
            try {
                while (myThread.isRun) {
                    System.out.println("守护线程正在检测....");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true); // 设置线程为守护线程
        thread.start();
    }

    private static class MyThread extends Thread {
        private boolean isRun;
        private int second;
        private int num;

        public MyThread(int second, int num) {
            this.isRun = true;
            this.second = second;
            this.num = num;
        }

        @Override
        public void run() {
            while (isRun && num > 0) {
                num--;
                try {
                    Thread.sleep(second * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num);
            }
            isRun = false;
        }

        public void setRun(boolean run) {
            isRun = run;
        }
    }
}
