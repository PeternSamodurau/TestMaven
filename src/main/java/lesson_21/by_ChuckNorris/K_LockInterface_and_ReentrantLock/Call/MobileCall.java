package lesson_21.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Call;


public class MobileCall {

    static void mobileCall(){
        SharedLock.lock.lock();
        try {
            System.out.println("Mobile call start");
            Thread.sleep(3000);
            System.out.println("Mobile call and");
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        finally {
           SharedLock.lock.unlock();
        }
    }
}
