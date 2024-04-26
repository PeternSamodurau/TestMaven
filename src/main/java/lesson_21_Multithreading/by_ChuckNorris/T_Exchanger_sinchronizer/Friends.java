package lesson_21_Multithreading.by_ChuckNorris.T_Exchanger_sinchronizer;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Friends extends Thread{
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public Friends(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }
    private void whoWins (Action myAction, Action friendAction){

        if (myAction == Action.STONE && friendAction == Action.SCISSORS ||
                myAction == Action.SCISSORS && friendAction == Action.PAPER ||
                myAction == Action.PAPER && friendAction == Action.STONE ){

            System.out.println(name + " - I wing!!!!");

        }

    }

    @Override
    public void run(){
    Action reply;
    for (Action action : myActions){
        try {
            reply = exchanger.exchange(action); // поток заблокируется если друг не покажет что то
            whoWins(action, reply);
            sleep(2000); // спим после игры
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
}
