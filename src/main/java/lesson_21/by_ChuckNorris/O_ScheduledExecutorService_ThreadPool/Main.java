package lesson_21.by_ChuckNorris.O_ScheduledExecutorService_ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//ScheduledExecutorService используем, когда хотим установить расписание потоков
// ThreadPool удобно создавать используя factory методы класса Executors

public class Main {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        System.out.println("Main starts");

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

//        for (int i = 0; i < 10; i++) {
//            scheduledExecutorService.execute(myClass);   // метод execute() передает задание task в threadPool где оно выполняется одним из потоков
//        }

//        scheduledExecutorService.schedule(myClass, 3,TimeUnit.SECONDS); // выполнить задачу через 3 секунды

//        scheduledExecutorService.scheduleAtFixedRate(myClass, 3,1,TimeUnit.SECONDS); // выполнит задачу через 3 сек, с 1 сек на выполнение задания!!!!!

          scheduledExecutorService.scheduleWithFixedDelay(myClass,3,1,TimeUnit.SECONDS); //выполнит задачу через 3 сек, с 1 сек между заданиями!!!!
        try {
            Thread.sleep(10000);                  // MAIN спит scheduledExecutorService.scheduleAtFixedRate - работает, птом  scheduledExecutorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scheduledExecutorService.shutdown();              // заканчиваем работу ScheduledExecutorService иначе программа продолжает работу

        try {
            scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS); // РАБОТАЕТ КАК JOIN() поток main будет спать 5 сек или пока ExecutorService не закончит работу
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main ands");                 // теперь печать в конце
    }
}

