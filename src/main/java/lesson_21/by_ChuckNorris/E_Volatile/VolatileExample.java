package lesson_21.by_ChuckNorris.E_Volatile;

public class VolatileExample implements Runnable{

    //static boolean aBoolean = true;         // было
     static volatile boolean aBoolean = true;          // используем ключевое слово volatile b
    // и значение переменной будет хранится только в main mamory, а не в cach каждого cpu
    @Override
    public void run() {
        long counter = 0;
        while (aBoolean){
            counter++;
        }
        System.out.println("Loop is finished. counter = " + counter);
    }
}
