package lesson_21_Multithreading.by_ChuckNorris.N_ExecutorService_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// ThreadPool - это множество потоков, каждый из которых преднозначен для выполнения той или иной задачи
// ThreadPool удобно создавать используя factory методы класса Executors

//В предоставленном коде создается пул из 5 потоков, и каждый поток выполняет задачу, которая передается в executorService.execute(new MyClass());.
// Этот код вызывается 10 раз (от 0 до 9 включительно), поэтому будет запущено 10 задач.
//
//Поскольку в пуле есть только 5 потоков, они начнут выполнять задачи по мере их поступления.
// Как только один из потоков завершит свою задачу (включая время сна в 1 секунду), он будет готов взять следующую задачу из очереди.
// Таким образом, все 10 задач будут выполнены, но только 5 из них могут выполняться одновременно.


public class Main {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        System.out.println("Main starts");
        //ExecutorService executorService = Executors.newCachedThreadPool();        // будет создавать потоки по надобности
        // ExecutorService executorService = Executors.newSingleThreadExecutor();   // pool  1 поток
        ExecutorService executorService = Executors.newFixedThreadPool(5);   // pool  5 потоков


        for (int i = 0; i < 10; i++) {
            executorService.execute(myClass);   // метод execute() передает задание task в threadPool где оно выполняется одним из потоков
        }

        executorService.shutdown();              // Метод shutdown() не вызывает немедленного уничтожения ExecutorService.
                                                // Он заставляет ExecutorService прекратить принимать новые задачи и завершить работу после того,
                                                  //как все работающие потоки завершат свою текущую работу2.
                                                 //При вызове этого метода не будут приниматься новые задачи, и начинается процесс остановки,
                                                 // в котором ранее представленные задачи выполняются,
                                                 //  а служба ExecutorService останавливается только после того,
                                                  //  как все работающие потоки завершат выполнение своих задач
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS); // РАБОТАЕТ КАК JOIN() поток main будет спать 5 сек или пока ExecutorService не закончит работу
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main ands");                 // теперь печать в конце
    }
}
