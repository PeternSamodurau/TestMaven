package lesson_21.by_ChuckNorris.I_DadLock_LiveLock_LockStarvation;

public class MyClass2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyClass2: попытка захватить монитор бъекта lock2");
        synchronized (DeadLock.lock2) {                                             // нужно изменить на (DeadLock.lock1)
            System.out.println("MyClass2: монитор бъекта lock2 захвачен");

            System.out.println("MyClass2: попытка захватить монитор бъекта lock1");
            synchronized (DeadLock.lock1){                                             // нужно изменить на (DeadLock.lock2)
                System.out.println("MyClass2: монитор бъекта lock2 и lock1 захвачены");
            }
        }
    }
}
