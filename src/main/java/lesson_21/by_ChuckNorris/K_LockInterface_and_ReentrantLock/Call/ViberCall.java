package lesson_21.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Call;

import lesson_21.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Call.SharedLock;

public class ViberCall {

    static void viberCall(){
        SharedLock.lock.lock();
        try {
            System.out.println("Viber call start");
            Thread.sleep(7000);
            System.out.println("Viber call and");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            SharedLock.lock.unlock();
        }
    }
}
