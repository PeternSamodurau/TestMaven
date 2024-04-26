package lesson_21_Multithreading.by_ChuckNorris.S_CountDownLatch_sinchronizer;

// CountDownLatch - защелка(замок) с обратным отсчетом
// данный синхронизатор позволяет нескольким потокам ждать пока не закончится обратный отсчет каких либо операций
// в конструктор передается количество операций которое должно быть выполнено, потом замок будет отпущен и потоки продолжат работу

// пример -люди стоят в очереди на открытие магазина но не могут приступить к покупкам,
// пока не выполнятся некие операции(работники прийти, свет включен, магазин должен открыться)

public class Main {
    public static void main(String[] args) {

        new People("Peter1", Store.countDownLatch);
        new People("Peter2", Store.countDownLatch);
        new People("Peter3", Store.countDownLatch);
        new People("Peter4", Store.countDownLatch);
        new People("Peter5", Store.countDownLatch);

        Store.marketStaffOnPlace();
        Store.lightIsOn();
        Store.marketOpening();

    }
}
