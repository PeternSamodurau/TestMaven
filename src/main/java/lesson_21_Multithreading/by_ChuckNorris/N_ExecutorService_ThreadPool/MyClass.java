package lesson_21_Multithreading.by_ChuckNorris.N_ExecutorService_ThreadPool;

public class MyClass implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(2000);             // если убрать может быть ситуация, когда некоторые потоки будут быстро исполнять и 5 потоков на успеют сработать
        } catch (InterruptedException e) {
            System.err.println("thread was interrupted during sleep");
            // Restore the interrupted status to respect other code that may check the interruption status
            Thread.currentThread().interrupt();
        }

        System.out.println(Thread.currentThread().getName());
    }
}
//если поток в пуле будет повторно выполнять задачу, он снова “уснет” на 1 секунду.
// Это происходит потому, что вызов Thread.sleep(1000); находится внутри метода run(),
// который выполняется при каждом запуске задачи потоком.
// Таким образом, каждый раз, когда поток начинает выполнение задачи, он “спит” на 1 секунду перед ее выполнением.