package vip.abatt.unit12;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Author:yankai1101
 * Desc:阻塞队列测试:打开一个文件内全部文件，并记录检索的单词
 **/
public class BlockQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREAND = 100;
    private static final Path DUMMY = Path.of("");
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk-9-src)");
            // /Users/yixuePXh/IdeaProjects/javacore/src
            String directory = in.nextLine();

            System.out.println("Enter keyword (e.g. static)");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(Path.of(directory));
                    queue.put(DUMMY);
                } catch (Exception e) {
                }
            };

            new Thread(enumerator).start();
            for (int i = 1; i <= SEARCH_THREAND; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            Path file = queue.take();// 一处并返回队头，必要时阻塞
                            if (file == DUMMY) {
                                queue.put(file);// 添加元素，必要时阻塞
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (Exception e) {

                    }
                };
                new Thread(searcher).start();
            }
        }

    }

    private static void enumerate(Path directory) throws IOException, InterruptedException {
        try (Stream<Path> children = Files.list(directory);) {
            for (Path child : children.collect(Collectors.toList())) {
                if (Files.isDirectory(child))
                    enumerate(child);
                else
                    queue.put(child);
            }
        }

    }

    private static void search(Path file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s%n", file, lineNumber, line);
            }
        }

    }
}
