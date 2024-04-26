package lesson_21_Multithreading.by_ChuckNorris.K_LockInterface_and_ReentrantLock.Call;

public class SkypeCall {

    static void skypeCall(){
        SharedLock.lock.lock();
        try {
            System.out.println("Skype call start");
            Thread.sleep(5000);
            System.out.println("Skype call and");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            SharedLock.lock.unlock();
        }
    }
}
