package lesson_21_Multithreading.by_ChuckNorris.S_CountDownLatch_sinchronizer;

import java.util.concurrent.CountDownLatch;

public class People extends Thread{
    private String name;
    private CountDownLatch countDownLatch;

    public People(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run(){
        try {
            countDownLatch.await(); // если счетчик CountDownLatch больше 0, поток будет заблокирован пока он не станет 0
            Thread.sleep(2000); // людиподождали и приступили к покупкам
            System.out.println(name + " - человек приступил к покупкам одновременно со всеми" );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
