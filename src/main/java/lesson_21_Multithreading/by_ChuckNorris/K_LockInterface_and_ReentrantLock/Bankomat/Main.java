package lesson_21_Multithreading.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Bankomat;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        // для кода потоков в конструкторе
        new Employee("Peter1", lock);
        new Employee("Peter2", lock);
        new Employee("Peter3", lock);
        new Employee("Peter4", lock);
        new Employee("Peter5", lock);
        new Employee("Peter6", lock);



//        new Employee("Peter1", lock).startThread();
//        new Employee("Peter2", lock).startThread();
//        new Employee("Peter3", lock).startThread();
//        new Employee("Peter4", lock).startThread();
//        new Employee("Peter5", lock).startThread();
//        new Employee("Peter6", lock).startThread();

    }
}
