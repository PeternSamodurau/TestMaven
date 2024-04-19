package lesson_21.by_ChuckNorris.P_Callable_and_Future_iterfaces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainRunnable {
    public static int factorialResult;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        FactorialRunnable factorial = new FactorialRunnable(5);

        executorService.execute(factorial);

       executorService.shutdown(); // больше не принимает задач и заканчивает текущие

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS); // ждем исполнеия executorService.execute(factorial);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(factorialResult);
    }
}
