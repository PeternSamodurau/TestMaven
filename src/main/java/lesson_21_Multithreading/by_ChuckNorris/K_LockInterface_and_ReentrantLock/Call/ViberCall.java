package lesson_21_Multithreading.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Call;

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
