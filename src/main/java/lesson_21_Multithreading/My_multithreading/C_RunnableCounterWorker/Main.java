package lesson_21_Multithreading.My_multithreading.C_RunnableCounterWorker;

public class Main {
    public static void main(String[] args) {
        RunnableCounterWorker scw1 = new RunnableCounterWorker("A", 15);
        RunnableCounterWorker scw2 = new RunnableCounterWorker("B", 15);


        // МНОГОПОТОЧНАЯ ОБРАБОТКА
        Thread t1 = new Thread(scw1);
        Thread t2 = new Thread(scw2);
        t1.start();
        t2.start();
    }
}
