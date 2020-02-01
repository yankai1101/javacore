package vip.abatt.unit05;

/**
 * Author:yankai1101
 * Desc:
 * Manager 和Employee 窜在 is-a 关系：
 * 每个经理都是员工
 **/
public class App01 {
    public static void main(String[] args) { // 测试继承
        Manager manager = new Manager("z1", 3000L, 1000L);
        Employee employee = new Employee("e1", 3000);

        System.out.println("经理的工资：" + manager.getSalary()); // 4000.0
        System.out.println("普通员工的工资：" + employee.getSalary()); // 3000.0

        Employee e2 = (Employee) manager;

        if (employee instanceof Manager) { // false
            Manager m2 = (Manager) employee;
        }
    }
}

class Manager extends Employee {
    /* 奖金 */
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() { // 覆盖 getSalary方法
        // 经理的工资是：基础工资+奖金
        return super.getSalary() + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class Employee {
    private String name;
    /* 工资 */
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
