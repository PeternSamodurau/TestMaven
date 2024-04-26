package lesson_21_Multithreading.by_ChuckNorris.B_Thread_methods;

public class Employee implements Runnable{
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();                           // создаем для получения текуего состояния потока

        System.out.println("Current thread state: " + currentThread.getState());
        System.out.println("Work begins +1.5 sec");
        System.out.println("Current thread state: " + currentThread.getState());
        try {
            System.out.println("Current thread state: " + currentThread.getState());
            Thread.sleep(2500);
            System.out.println("Current thread state: " + currentThread.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Current thread state: " + currentThread.getState());
        System.out.println("Work ends + 1.5 sec");
        System.out.println("Current thread state: " + currentThread.getState());
    }
}
