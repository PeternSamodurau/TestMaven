package lesson_21_Multithreading.by_ChuckNorris.H_Wait_and_Notifi_methods;

public class Producer implements Runnable {

    private Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {                 // производит в день 10 шт хлеба для магазина
        for (int i = 0; i < 10; i++) {
          market.putBread();
        }
    }
}
