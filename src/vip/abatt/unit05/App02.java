package vip.abatt.unit05;

/**
 * Author:yankai1101
 * Desc:
 * equals
 * hashCode
 * toString
 **/
public class App02 {
    private String name;
    private int age;

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == this)
            return true;
        if (otherObject == null)
            return false;
        if (!(otherObject instanceof App02))
            return false;
        App02 app = (App02) otherObject;
        return name == app.getName() && age == app.getAge();
    }

    private int hashCode = 0;

    @Override
    public int hashCode() {
        if (hashCode != 0)
            return hashCode;
        hashCode = 31 * name.hashCode();
        hashCode = hashCode + Integer.hashCode(age);
        return hashCode;
    }

    @Override
    public String toString() {
        // {"name":"yk","age":23}
        return "{\"name\":\"" + name + "\",\"age\":" + age + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
