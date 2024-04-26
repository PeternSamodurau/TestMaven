package lesson_21_Multithreading.by_ChuckNorris.V_Synchronized_Collections;

// Synchronized Collections получаются из традиционных коллекций благодаря их обертыванию
// достигается синхронизацией на методах, только один поток может работать за раз с методом, низкая производительность
// потоки в очереди

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>(Arrays.asList(1,2,3));  // Arrays.asList(1,2,3) Этот метод возвращает фиксированный список,
        // и вы не можете добавить или удалить элементы из него.
        // Вместо этого вы можете создать новый ArrayList из вашего исходного списка.
        // Затем вы можете добавить элементы в этот новый список.

        for (int i = 0; i < 5; i++){
            source.add(i);
        }
        System.out.println(source);
        System.out.println();

        //List<Integer> target = new ArrayList<>();
        List<Integer> target = Collections.synchronizedList(new ArrayList<>());

        Runnable runnable = ()->{target.addAll(source);};  // в новый лист добавили все обьекты

        Thread thread1 = new Thread(runnable);  // хотим 2 мя потоками в новый лист добавить все обьекты из source
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(target);
        // выводится либо 1 либо 2 раза, надо синхронизировать
    }
}
