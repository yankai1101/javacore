package vip.abatt.unit12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author:yankai1101
 * Desc:执行器Demo
 **/
public class ExecutorDemo {
    public static long occurrences(String word, Path path) {
        try (Scanner in = new Scanner(path)) {
            int count = 0;
            while (in.hasNext())
                if (in.next().equals(word)) count++;
            return count;
        } catch (IOException e) {
            return 0;
        }
    }

    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.collect(Collectors.toSet());
        }
    }

    public static Callable<Path> searchForTask(String word, Path path) {
        return () -> {
            try (Scanner in = new Scanner(path)) {
                while (in.hasNext()) {
                    if (in.next().equals(word)) return path;
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("search in " + path + "canceled.");
                        return null;
                    }
                }
            }
            throw new NoSuchElementException();
        };
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk-9-src)");
            String start = in.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String word = in.next();

            Set<Path> files = descendants(Path.of(start));
            ArrayList<Callable<Long>> tasks = new ArrayList<>();
            for (Path file : files) {
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }

            ExecutorService executor = Executors.newCachedThreadPool(); // 创建缓存执行器
            Instant startTime = Instant.now();
            List<Future<Long>> futures = executor.invokeAll(tasks); // 执行所有任务，返回所有执行结果
            long total = 0;
            for (Future<Long> future : futures) {
                total += future.get();
            }
            Instant endTime = Instant.now();
            System.out.println("Occurrences of " + word + ":" + total);
            System.out.println("Time elapsed:" + Duration.between(startTime, endTime).toMillis() + "ms");

            ArrayList<Callable<Path>> searchTasks = new ArrayList<>();
            for (Path file : files) {
                searchTasks.add(searchForTask(word, file));
            }
            Path found = executor.invokeAny(searchTasks); // 执行给定任务，返回其中一个执行结果
            System.out.println(word + " occurs in:" + found);
            if (executor instanceof ThreadPoolExecutor)
                System.out.println("Largest pool size:" + ((ThreadPoolExecutor) executor).getLargestPoolSize());

            executor.shutdown(); // 完成已提交的任务，不再接受新任务。
        }
    }
}
