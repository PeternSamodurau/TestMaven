package lesson_21_Multithreading.by_ChuckNorris.R_Semaphore_synchronizer;

// Semaphore - синхронизатор, позволяющий ограничить доступ к какому-то ресурсу
// в конструктор Semaphore нужно передавать количество потоков, которым Semaphore будет разрешать одновременно использовать этот ресурс

// пример 2 тел будки, в очереди стоят 5 человек

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore callBox = new Semaphore(2);  // звонить могут только двое одновременно - 2 будки

        new Person("Peter1", callBox);
        new Person("Peter2", callBox);
        new Person("Peter3", callBox);
        new Person("Peter4", callBox);
        new Person("Peter5", callBox);

    }
}
