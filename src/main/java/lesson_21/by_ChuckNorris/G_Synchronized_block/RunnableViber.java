package lesson_21.by_ChuckNorris.G_Synchronized_block;

public class RunnableViber implements Runnable{
    @Override
    public void run() {
        new Calls().viberCall();
    }
}
