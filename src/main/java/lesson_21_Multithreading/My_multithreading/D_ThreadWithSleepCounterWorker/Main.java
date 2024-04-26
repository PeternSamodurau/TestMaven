package lesson_21_Multithreading.My_multithreading.D_ThreadWithSleepCounterWorker;

//

public class Main {
    public static void main(String[] args) {
        ThreadWithSleepCounterWorker tcw1 = new ThreadWithSleepCounterWorker("A", 15);
        ThreadWithSleepCounterWorker tcw2 = new ThreadWithSleepCounterWorker("B", 15);


        // МНОГОПОТОЧНАЯ ОБРАБОТКА
        tcw1.start();
        tcw2.start();
    }
}
