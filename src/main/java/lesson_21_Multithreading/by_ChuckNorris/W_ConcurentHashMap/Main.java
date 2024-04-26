package lesson_21_Multithreading.by_ChuckNorris.W_ConcurentHashMap;

//ConcurrentHashMap имплементирует интерфейс ConcurrentMap, который имплементирует интерфейс Map
// Map делит множество элементов на баккеты - сегменты, каждый поток может работать со своим но не одновременно
// лок идет на сегменте
// не ключ не значение не могут быть null

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {

        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1,"Peter1");
        map.put(2,"Peter2");
        map.put(3,"Peter3");
        map.put(4,"Peter4");
        map.put(5,"Peter5");

        System.out.println(map);

        Runnable runnable1 = ()-> {
            Iterator<Integer> iterator = map.keySet().iterator();

            while (iterator.hasNext()){
                try {
                    Thread.sleep(1000);                // спит поток Thread thread1
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(i + ":" + map.get(i));
            }
        };

        Runnable runnable2 = ()-> {
            try {
                Thread.sleep(3000);                    // спит поток Thread thread2
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put(6,"Peter6");                             // вывелся в первом потоке, т к добавился в процессе итерации, но если сократить время сна до 100, то не выведется, не успеет
        };

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
        System.out.println(map);
    }
}
