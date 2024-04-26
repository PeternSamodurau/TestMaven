package lesson_21_Multithreading.by_ChuckNorris.X_CopyOnWriteArrayList;

//CopyOnWriteArrayList имплементирует интерфейс List
// следует использовать тогда, когда нужна потокобезопасность, НЕ большое количество операций по изменению элементов и большое по их чтению
// при каждом изменении создается клон - копия листа

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> stringList = new CopyOnWriteArrayList<>();

        stringList.add("Peter1");
        stringList.add("Peter2");
        stringList.add("Peter3");
        stringList.add("Peter4");
        stringList.add("Peter5");

        System.out.println(stringList);

        Runnable runnable1 = ()->{
            Iterator<String> stringIterator = stringList.iterator(); // сюда передается копия stringIterator

            while (stringIterator.hasNext()){
//                try {
// //                   Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(stringIterator.next());          // поэтому выводится не измененная коллекция
            }
        };
        Runnable runnable2 = ()->{
            try {
                Thread.sleep(100);                              // спим для завершения итерации, или даже может успеть вставить "Peter6" до завершения итерации
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stringList.remove(4);
            stringList.add("Peter6");
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
        System.out.println(stringList);

    }
}
