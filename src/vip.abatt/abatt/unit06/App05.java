package vip.abatt.abatt.unit06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author:YANKAI_1101
 * Date:2020/1/31
 * Time:17:58
 * 功能：内部类:静态内部类、局部内部类、匿名内部类
 **/
public class App05 {
    boolean beep = true;

    public void main(String[] args) {
        // 匿名内部类
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (App05.this.beep) Toolkit.getDefaultToolkit().beep();
            }
        };

    }

    // 静态内部类
    public static class Pair {
        private double min;
        private double max;

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        public Pair(double min, double max) {
            this.min = min;
            this.max = max;
        }
    }

    // 内部类
    class ArrayAlg {
        public Pair minmax(double array[]) {
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double d : array) {
                if (min > d) min = d;
                if (max < d) max = d;
            }
            return new Pair(min, max);
        }
    }

    public void start() {
        // 局部内部类
        class B implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        B b = new B();
        Timer timer = new Timer(1000, b);
        timer.start();
    }
}


