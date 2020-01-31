package vip.abatt.abatt.unit05;

import jdk.internal.util.xml.impl.ReaderUTF8;

import java.io.*;
import java.net.URI;
import java.net.URL;

/**
 * Author:yankai1101
 * Desc: 获得资源
 **/
public class App05 {
    public static void main(String[] args) throws IOException {
        Class clazz = App05.class;
        InputStream in = clazz.getResourceAsStream("/abc.txt"); // 通过类加载器获得resource目录下的文件流

        BufferedReader br = new BufferedReader(new ReaderUTF8(in));
        StringBuffer sb = new StringBuffer();

        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        String result = sb.toString();
        if (result.endsWith("\n"))
            result = result.substring(0, result.length() - 1); // 去除最后换行符

        br.close();
        in.close();

        System.out.println("---file start---");
        System.out.println(result);
        System.out.println("---file end---");
    }
}
