package lesson_21_Multithreading.by_Skillbox.Wait_and_Notify_methods_21_10;

public class Producer implements Runnable {

    private Parking parking;

    public Producer(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
               parking.in();
        }
    }
}
