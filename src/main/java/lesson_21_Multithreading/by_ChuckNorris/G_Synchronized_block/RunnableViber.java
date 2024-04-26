package lesson_21_Multithreading.by_ChuckNorris.G_Synchronized_block;

public class RunnableViber implements Runnable{
    @Override
    public void run() {
        new Calls().viberCall();
    }
}
