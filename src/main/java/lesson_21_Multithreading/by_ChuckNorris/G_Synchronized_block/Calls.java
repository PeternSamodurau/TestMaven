package lesson_21_Multithreading.by_ChuckNorris.G_Synchronized_block;

public class Calls {

    final static Object lock = new Object();             // чтобы синхронизация работала здесь нужно использовать обьект который используется как монитор


     void mobileCall() {                                                  // синхронизируем что бы звонки шли по очереди и опять не работает,
        System.out.println(this + "  Разные обьекты на которых вызывается метод поэтому this не используем");
        System.out.println(lock + "  Используем синхронизацию на одном обьекте");                                                     //теперь ссылка указывает на один обьет по которому синхронизируемся
        synchronized (lock) {
            System.out.println("Mobile call start");                                     // потому что не обьекте this а они все разные см принт ссылки
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call end");
        }
    }

     void skypeCall() {                                                     // синхронизируем что бы звонки шли по очереди и опять не работает
         System.out.println(this + "  Разные обьекты на которых вызывается метод поэтому this не используем");
         System.out.println(lock + "  Используем синхронизацию на одном обьекте");
        synchronized (lock) {
            System.out.println("Skype call start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Skype call end");
        }
    }

    void viberCall() {                                                      // синхронизируем что бы звонки шли по очереди и опять не работает
        System.out.println(this + "  Разные обьекты на которых вызывается метод поэтому this не используем");
        System.out.println(lock + "  Используем синхронизацию на одном обьекте");
        synchronized (lock) {
            System.out.println("Vibe call start");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Vibe call end");
        }
    }

}
