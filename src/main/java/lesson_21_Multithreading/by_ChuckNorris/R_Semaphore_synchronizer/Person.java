package lesson_21_Multithreading.by_ChuckNorris.R_Semaphore_synchronizer;

import java.util.concurrent.Semaphore;

public class Person extends Thread {
    private String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();           // при создании Person  поток запускается
    }
    @Override
    public void run(){
        try {
            System.out.println(name + " - ждет .....");
           // sleep(3000);      // можно дать подойти всем 5 людям
            callBox.acquire(); //пытается получить разрешение от семафора, он заблокирует поток пока ресурс не будет доступен, counter семафора уменьшается на 1
            System.out.println(name + " - пользуется телефоном");
            sleep(2000);            // пользуется 2 сек
            System.out.println(name + " - завершил звонок");
        } catch (InterruptedException e) {
           e.printStackTrace();
        }finally {
            callBox.release(); // освобождается разрешение семафора, counter семафора увеличивается на 1
        }
    }
}
