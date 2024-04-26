package lesson_21_Multithreading.by_ChuckNorris.Y_ArrayBlockingQueue;

//ArrayBlockingQueue - потокобезопасная очередь с ограниченным размером
// обычноодин или несколько потоков добавляют элементы в конец очереди, а другой или другие забирают из начала

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(4);

        //Producer put()  в конец
        new Thread(()->{
            int i = 0;
            while (true){
                try {
                    queue1.put(i++);
                    System.out.println(" Продюсер добавил: " + i + " " + queue1);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
        //Consumer take() из начала
        new Thread(()->{
           while (true){
                try {
                   Integer j = queue1.take();
                    System.out.println(" Продюсер забрал: " + j + " " + queue1);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }
}
