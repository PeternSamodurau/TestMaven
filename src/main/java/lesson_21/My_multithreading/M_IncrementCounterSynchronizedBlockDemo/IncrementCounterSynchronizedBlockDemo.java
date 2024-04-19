package lesson_21.My_multithreading.M_IncrementCounterSynchronizedBlockDemo;

public class IncrementCounterSynchronizedBlockDemo {
    static Integer counter = 0;
    static Integer anotherCounter = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                incrementCounter();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                incrementAnotherCounter();
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
        System.out.println("Another counter: " + anotherCounter);
        System.out.println("Time elapsed: " + duration);    }

    private static void incrementCounter() {
        synchronized (IncrementCounterSynchronizedBlockDemo.class) {             // ЗАХВАТЫВАЕМ МОНИТОР ВСЕГО КЛАССА
            counter++;
        }
    }

    private static void incrementAnotherCounter() {
        synchronized (IncrementCounterSynchronizedBlockDemo.class) {
            anotherCounter++;
        }
    }
}
