package lesson_21_Multithreading.by_ChuckNorris.M_Interruption_thread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread starts");

        SomeClass someClass = new SomeClass();
        someClass.start();

        try {
            Thread.sleep(2000);                       // main спит
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);               // вместо выбрасывания нового исключения лучше
            System.err.println("Main thread was interrupted during sleep");
            Thread.currentThread().interrupt();
        }

        someClass.interrupt();                             //пытаемся прервать поток

        try {
            someClass.join();
        } catch (InterruptedException e) {
           // throw new RuntimeException(e);
            System.err.println("Main thread was interrupted while waiting for someClass to finish");
            // Restore the interrupted status to respect other code that may check the interruption status
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread ands");
    }
}
