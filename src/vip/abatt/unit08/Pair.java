package vip.abatt.unit08;

/**
 * Author:YANKAI_1101
 * Date:2020/2/3
 * Time:12:52
 * 功能：定义简单的泛型类
 **/
public class Pair<T> {
    private T first;
    private T second;


    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
