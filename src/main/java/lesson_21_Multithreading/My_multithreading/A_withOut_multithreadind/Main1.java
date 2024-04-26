package lesson_21_Multithreading.My_multithreading.A_withOut_multithreadind;

import static java.lang.Thread.currentThread;
import static java.util.stream.IntStream.range;

// создадим потоки по схеме main -> Thread 0 -> Thread 1-10  см файл
public class Main1 {
    private static final int THREADS_AMOUNT = 10;       // хотим создать 10 потоков от одного потока не main

    public static void main(String[] args) {

        Runnable task = ()-> System.out.println(currentThread().getName());

        Runnable task1 = ()-> range(0,THREADS_AMOUNT).forEach(i -> startThread(task));

        startThread(task1);
    }
    private static void startThread(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
