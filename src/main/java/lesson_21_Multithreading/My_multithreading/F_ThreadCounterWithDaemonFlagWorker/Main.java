package lesson_21_Multithreading.My_multithreading.F_ThreadCounterWithDaemonFlagWorker;

//при завершении работы программы все стандартные потоки завершают свою работу планово
// поток может иметь флаг isDaemon
//Daemon поток будет прерван JVM , как только основной поток исполнения завершит свою работу

public class Main {
    public static void main(String[] args) {
        ThreadCounterWithDaemonFlagWorker tcw1 = new ThreadCounterWithDaemonFlagWorker("A", 1000, true);
        ThreadCounterWithDaemonFlagWorker tcw2 = new ThreadCounterWithDaemonFlagWorker("B", 100, false);


        // МНОГОПОТОЧНАЯ ОБРАБОТКА
        tcw1.start();
        tcw2.start();                // поток В завершил работу, и поток А прерывается так как он isDaemon - true

        // НЕ ГАРАНТИРУЕТСЯ ПОРЯДОК
        System.out.println("Process is finished!!!");
    }
}
