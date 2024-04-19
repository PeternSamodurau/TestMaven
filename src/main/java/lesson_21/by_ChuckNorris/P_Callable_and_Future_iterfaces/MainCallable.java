package lesson_21.by_ChuckNorris.P_Callable_and_Future_iterfaces;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainCallable {

    public static int factorialResult;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        FactorialCallable factorialCallable = new FactorialCallable(5);     // если 0 будет исключение

        Future<Integer> future = executorService.submit(factorialCallable);  // метод передает task в threadPool -результат хранится в обьекте класса Future

        //Thread.currentThread().interrupt();           // если раскоментить вылезет сключение -throw new RuntimeException("Поток был прерван" + e);

        try {
            System.out.println("Можно прверить завершился ли future - " + future.isDone());
            factorialResult = future.get();
            System.out.println(factorialResult);
            System.out.println("Можно прверить завершился ли future - " + future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException("Поток был прерван" + e);

            //InterruptedException - это исключение, которое выбрасывается, когда поток прерывается (например, другим потоком).
            // Обычно это исключение обрабатывается одним из следующих способов:
            //
            //Пробросить исключение выше: Это то, что вы делаете в своем коде сейчас.
            // Вы оборачиваете InterruptedException в RuntimeException и выбрасываете его.
            // Это приводит к тому, что исключение поднимается вверх по стеку вызовов, и его должен обработать вызывающий код или JVM.
            // Это может быть подходящим решением, если вы не знаете, как правильно обработать InterruptedException в данном контексте.
            //Восстановить прерванное состояние: Другой подход - это восстановить прерванное состояние потока, вызвав Thread.currentThread().interrupt();
            // в блоке catch. Это не остановит поток, но сохранит информацию о том, что поток был прерван,
            // так что вызывающий код или другие части программы могут проверить это состояние и реагировать соответствующим образом.
            //Просто игнорировать исключение: Это обычно не рекомендуется, так как может привести к тому, что ваша программа будет вести себя непредсказуемо.

        } catch (ExecutionException e) {
            if (e.getCause() instanceof IllegalArgumentException) {                // Обработка IllegalArgumentException
                System.out.println("Некорректный аргумент: " + e.getCause());    // спомощь данного метода можно найти причину почему исключение дыло выброшено
            } else {
                System.out.println(e.getCause());
            }                                                               // покажет "Number is not correct" из FactorialRunnable

        } finally {
            executorService.shutdown();                // закрывать executorService лучше в finally
        }
    }
}
