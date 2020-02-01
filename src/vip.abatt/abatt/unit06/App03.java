package vip.abatt.abatt.unit06;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author:YANKAI_1101
 * Date:2020/1/31
 * Time:17:06
 * 功能：接口回调
 **/
public class App03 {
    public static void main(String[] args) {
        Timer timer = new Timer(1000, new MyListener());
        timer.start();

        // keep program running
        JOptionPane.showMessageDialog(null, "退出系统？");
        System.exit(0);
    }
}

class MyListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("执行一次任务");
    }
}
