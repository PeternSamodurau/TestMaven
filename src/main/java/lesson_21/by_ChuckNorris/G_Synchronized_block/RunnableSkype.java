package lesson_21.by_ChuckNorris.G_Synchronized_block;

public class RunnableSkype implements Runnable{
    @Override
    public void run() {
        new Calls().skypeCall();
    }
}
