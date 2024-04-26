package lesson_21_Multithreading.by_ChuckNorris.L_Daemon_threads;

public class SomeClass extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon - " + isDaemon());
        for (char i = 'A'; i <= 'Z'; i++){
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
