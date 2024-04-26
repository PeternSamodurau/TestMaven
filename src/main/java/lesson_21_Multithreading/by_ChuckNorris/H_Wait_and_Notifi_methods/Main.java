package lesson_21_Multithreading.by_ChuckNorris.H_Wait_and_Notifi_methods;

//у класса Object для извещения потока о своих действиях других потоков
//wait() - освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор пока другой поток не вызовет метод notify();
//notify() - НЕ освобождает монитор и будит поток, у которого ранее был вызван метод wait()
//notifyALL() - НЕ освобождает монитор и будит все потоки, у которых ранее был вызван метод wait()

public class Main {

    public static void main(String[] args) {

        Market market = new Market();

        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();

    }
}
