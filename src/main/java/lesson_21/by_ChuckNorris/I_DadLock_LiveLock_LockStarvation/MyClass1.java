package lesson_21.by_ChuckNorris.I_DadLock_LiveLock_LockStarvation;

public class MyClass1 implements Runnable {

    @Override
    public void run() {
        System.out.println("MyClass1: попытка захватить монитор бъекта lock1");
        synchronized (DeadLock.lock1) {
            System.out.println("MyClass1: монитор бъекта lock1 захвачен");

            System.out.println("MyClass1: попытка захватить монитор бъекта lock2");
            synchronized (DeadLock.lock2){
                System.out.println("MyClass1: монитор бъекта lock1 и lock2 захвачены");
            }
        }
    }
}
