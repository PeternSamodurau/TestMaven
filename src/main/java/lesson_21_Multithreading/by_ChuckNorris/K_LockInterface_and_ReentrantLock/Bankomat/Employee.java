package lesson_21_Multithreading.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Bankomat;

import java.util.concurrent.locks.Lock;

public class Employee extends Thread {
    private String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();                // или можно так на каждом работнике будет запускаться поток
    }

//    public void startThread() {
//        this.start(); // Запуск потока  в отдельном методе
//    }

    public void run() {
         try {

                System.out.println(name + "ждет ...");

                lock.lock();

                System.out.println(name + "пользуется банкоматом");

                Thread.sleep(2000);

                System.out.println(name + "завершил пользуется банкоматом");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
    }
}
