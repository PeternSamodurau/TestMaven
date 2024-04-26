package lesson_21_Multithreading.by_ChuckNorris.V_Synchronized_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            integerList.add(i);
        }

        List<Integer> sinchronizedList = Collections.synchronizedList(integerList);

        Runnable runnable1 = () -> {

            synchronized (sinchronizedList) {                                    // все равно итератор надо синхронизировать
                Iterator<Integer> iterator = sinchronizedList.iterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
                }
            }
        };
        Runnable runnable2 = () -> sinchronizedList.remove(10);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println(sinchronizedList);

    }
}
// будет исключение, Ошибка в вашем коде связана с одновременным доступом к коллекции из разных потоков.
// Ваш код пытается итерировать по списку в одном потоке (thread1), в то время как другой поток (thread2) пытается изменить этот список- далить элемент.
// Это приводит к ошибке ConcurrentModificationException.
// надо синхронизировать
