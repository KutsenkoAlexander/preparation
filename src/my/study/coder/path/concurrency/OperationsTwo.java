package my.study.coder.path.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OperationsTwo {
    public static void main(String[] args) {
        Account acc1 = new Account(2000);
        Account acc2 = new Account(3000);

        Random random = new Random();

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        for (int i = 0; i < 50; i++) {
            executorService.submit(new Transfer(acc1, acc2, random.nextInt(400), i));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
