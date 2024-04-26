package lesson_21_Multithreading.by_Skillbox.Wait_and_Notify_methods_21_10;


public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();

        Thread thread1 = new Thread(new Producer(parking));
        Thread thread2 = new Thread(new Consumer(parking));

        thread1.start();
        thread2.start();
    }
}
