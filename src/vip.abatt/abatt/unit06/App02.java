package vip.abatt.abatt.unit06;

import java.util.Date;

/**
 * Author:YANKAI_1101
 * Date:2020/1/31
 * Time:16:56
 * 功能：深度拷贝
 **/
public class App02 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee(new Date(), "张三");

        Employee clone = employee.clone();

        employee.setRegiest(new Date(System.currentTimeMillis() + 60 * 60 * 1000));

        System.out.println(employee.toString());
        System.out.println(clone.toString());
    }
}

class Employee implements Cloneable {
    private Date regiest;
    private String name;

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.regiest = (Date) regiest.clone(); // 深度拷贝
        return cloned;
    }

    public Employee(Date regiest, String name) {
        this.regiest = regiest;
        this.name = name;
    }

    public Date getRegiest() {
        return regiest;
    }

    public void setRegiest(Date regiest) {
        this.regiest = regiest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "regiest=" + regiest +
                ", name='" + name + '\'' +
                '}';
    }
}
