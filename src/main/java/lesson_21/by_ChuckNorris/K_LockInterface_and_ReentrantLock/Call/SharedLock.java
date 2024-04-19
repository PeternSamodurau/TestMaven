package lesson_21.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Call;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedLock {
    public static Lock lock = new ReentrantLock();   // повторный лок
}
