package lesson_21_Multithreading.by_ChuckNorris.O_ScheduledExecutorService_ThreadPool;

public class MyClass implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(1);             // если убрать может быть ситуация, когда некоторые потоки будут быстро исполнять и 5 потоков на успеют сработать
        } catch (InterruptedException e) {
            System.err.println("thread was interrupted during sleep");
            // Restore the interrupted status to respect other code that may check the interruption status
            Thread.currentThread().interrupt();
        }

        System.out.println(Thread.currentThread().getName());
    }
}
