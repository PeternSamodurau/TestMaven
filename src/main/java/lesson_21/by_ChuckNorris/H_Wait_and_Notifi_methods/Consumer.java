package lesson_21.by_ChuckNorris.H_Wait_and_Notifi_methods;

public class Consumer implements Runnable{

    private Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {                 // потребитель может купить 10 хлебов которые произвоит Producer
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}
