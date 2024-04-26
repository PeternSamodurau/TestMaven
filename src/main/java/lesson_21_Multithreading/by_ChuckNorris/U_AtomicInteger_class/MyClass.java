package lesson_21_Multithreading.by_ChuckNorris.U_AtomicInteger_class;

public class MyClass implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            Main.increment();
        }
    }
}
