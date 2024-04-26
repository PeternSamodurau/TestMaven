package lesson_21_Multithreading.My_multithreading.K_IncrementCounterSynchronizedDemo;

//ключевое слово synchronized НЕ позволяет использовать ресурс более чем одному потоку в каждый момент времени

public class IncrementCounterSynchronizedDemo {
    static Integer counter = 0;

    public static  void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
               increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Counter: " + counter);
        System.out.println("Time elapsed: " + duration);
    }
    private static synchronized void increment() {
        counter++;
    }
}
