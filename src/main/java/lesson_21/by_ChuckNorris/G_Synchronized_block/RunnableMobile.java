package lesson_21.by_ChuckNorris.G_Synchronized_block;

public class RunnableMobile implements Runnable{

    @Override
    public void run() {
        new Calls().mobileCall();
    }
}
