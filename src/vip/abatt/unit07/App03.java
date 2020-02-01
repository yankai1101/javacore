package vip.abatt.unit07;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author:YANKAI_1101
 * Date:2020/2/1
 * Time:13:03
 * 功能：日志
 **/
public class App03 {
    private static final Logger logger = Logger.getLogger(App03.class.getName());

    public static void main(String[] args) {
        // 设置日志等级
        logger.setLevel(Level.ALL);

        // 以下日志会输出在控制台
        logger.severe("some severe message 严重");
        logger.warning("some warning message 警告");
        logger.info("some info message 信息");

        // 以下日志不会输出在控制台
        logger.config("some config message");
        logger.fine("some fine message");
        logger.finer("some finer message");
        logger.finest("some finest message");

    }
}
