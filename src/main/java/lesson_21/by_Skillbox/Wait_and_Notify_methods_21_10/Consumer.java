package lesson_21.by_Skillbox.Wait_and_Notify_methods_21_10;

public class Consumer implements Runnable {

    private Parking parking;

    public Consumer(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            parking.out();
        }
    }
}
