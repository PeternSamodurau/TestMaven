package lesson_21_Multithreading.by_ChuckNorris.L_Daemon_threads;

// DAEMON потоки предназначены для выполнения фоновых задач и оказания различных сервисов User потокам
//при завершении работы последнего User потока программа завершает свое выполнение, не дожидаясь окончания работы Daemon потоков
// пример garbrage collector

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread starts");

        SomeClass thread = new SomeClass();
        thread.setName("user_thread");
        SomeClassDaemon thread1 = new SomeClassDaemon();
        thread1.setName("daemon_thread");

        thread1.setDaemon(true);              // перед запуском делаем поток daemon

        thread.start();
        thread1.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread ands");

        // демон поток будет прерван после завершения цикла от A до Z
    }
}
