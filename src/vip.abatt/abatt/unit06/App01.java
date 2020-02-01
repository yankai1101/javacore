package vip.abatt.abatt.unit06;

/**
 * Author:yankai1101
 * Desc: 接口默认实现
 **/
public class App01 {
    public static void main(String[] args) {
        P e = new E();
        System.out.println(e.getName()); // vip.abatt.abatt.unit06.E_356573597
    }
}

class E implements P {

}

interface P {
    /**
     * default 关键字提供接口默认实现
     *
     * @return
     */
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}
