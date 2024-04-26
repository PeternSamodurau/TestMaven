package lesson_21_Multithreading.by_ChuckNorris.S_CountDownLatch_sinchronizer;

import java.util.concurrent.CountDownLatch;

public class Store {
    public static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void marketStaffOnPlace(){   //работники прийти
        try {

            Thread.sleep(2000);  // дали время прийти на работу
            System.out.println("Работники пришли на работу" );
            countDownLatch.countDown(); // уменьшили счетчик на 1
            System.out.println("countDownLatch = " + countDownLatch.getCount());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void lightIsOn(){   // включили свет
        try {
            Thread.sleep(3000);  // дали времявключить свет
            System.out.println("Работники включили свет все готово к открытию" );
            countDownLatch.countDown(); // уменьшили счетчик на 1
            System.out.println("countDownLatch = " + countDownLatch.getCount());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void marketOpening(){   //работники открыли магазин
        try {

            Thread.sleep(4000);  // дали время на то, что бы открыть магазин
            System.out.println("Работники открыли магазин" );
            countDownLatch.countDown(); // уменьшили счетчик на 1
            System.out.println("countDownLatch = " + countDownLatch.getCount());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
