package lesson_21_Multithreading.by_ChuckNorris.L_Daemon_threads;

public class SomeClassDaemon extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon - " + isDaemon());
        for (int i = 1; i <= 1000; i++){
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
