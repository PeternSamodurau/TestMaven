package lesson_21_Multithreading.by_Skillbox.Volatile_21_7;

public class Task implements Runnable {

    private long counter;
    //private boolean isRunning;                 // было
    private volatile boolean isRunning;          // сделали volatile

    public Task() {
        this.counter = 0;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning){
            counter++;
        }
        System.out.println("Task: " + counter);
    }
    public void stop(){
        isRunning= false;
    }

    public long getCounter() {
        return counter;
    }
}
