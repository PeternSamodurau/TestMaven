package lesson_21_Multithreading.by_ChuckNorris.H_Wait_and_Notifi_methods;

// мы не можем предсказать какой поток первый начнет работать - захватит монитор, но Produser и Consumer синхронизированны по одному обьекту Market

public class Market {

    private int breadCount = 5;                 // количество хлеба на прилавке магазина, предположим не больше 5 шт

    public synchronized void getBread(){                  // синхронизация по market, по умолчанию - this
        while (breadCount < 1) {
            try {
                this.wait();                                    // ждем пока поставят хлеб
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount--;

        System.out.println("Потребитель купил один хлеб");

        System.out.println("Остаток хлеба в магазине: = " + breadCount);

        this.notify();                                                             // сообщаем что надо поставить хлеб в магазин, т к колочество уменьшилось на 1
                                                                              // и будит покок Producer
    }
    public synchronized void putBread(){                             // синхронизация по market, умолчанию - this
        while (breadCount >= 5){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount++;
        System.out.println("Поставили 1 хлеб в магазин");
        System.out.println("Остаток хлеба в магазине: = " + breadCount);

        notify();                                                      // можно покупать хлеб
    }
}
