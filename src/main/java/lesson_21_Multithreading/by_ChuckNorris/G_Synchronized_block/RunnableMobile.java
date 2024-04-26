package lesson_21_Multithreading.by_ChuckNorris.G_Synchronized_block;

public class RunnableMobile implements Runnable{

    @Override
    public void run() {
        new Calls().mobileCall();
    }
}
