package lesson_21.by_ChuckNorris.P_Callable_and_Future_iterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainSum_10Threads {
    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<Long>> futureList = new ArrayList<>();

        long valueDividedBy10 = value / 10;

        for (int i = 0; i <= 10; i++) {

            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);

            Sum_10Threads sum10Threads = new Sum_10Threads(from, to);

            Future<Long> futurePartSum = executorService.submit(sum10Threads);

            futureList.add(futurePartSum);
        }

        sum = futureList.stream().mapToLong(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum();
        executorService.shutdown();
        System.out.println("______________________________________");

        System.out.println(String.format("%,d", sum).replace(',', '_'));
    }
}
//Метод mapToLong в Java используется для преобразования объектов в потоке в long значения.
// Это делается с помощью функции, которая применяется к каждому элементу в потоке и возвращает long значение.
//
//В контексте вашего кода, mapToLong применяется к каждому Future<Long> в futureList, вызывая метод get() для каждого Future, чтобы получить его результат.
// Этот результат затем преобразуется в long значение.
// В конечном итоге, вы получаете поток long значений, которые затем суммируются с помощью метода sum().
//
//Обратите внимание, что mapToLong не изменяет исходный поток. Вместо этого он создает новый поток, содержащий преобразованные значения.