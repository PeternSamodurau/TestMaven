package lesson_21_Multithreading.by_ChuckNorris.U_AtomicInteger_class;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    //static int counter = 0;

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyClass());
        Thread thread2 = new Thread(new MyClass());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);
    }


    public static void increment(){           // раньше делали synchronized метод чтобы получить 2000
       // counter++;
       // counter.incrementAndGet();          //2000
        counter.addAndGet(5);           //будет + 5 = 10000, можно -5
    }
}
