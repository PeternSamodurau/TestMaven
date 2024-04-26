package lesson_21_Multithreading.by_ChuckNorris.T_Exchanger_sinchronizer;

//Exchanger - синхронизатор позволяющий обмениваться данными между двумя потоками, обеспечивает что оба потока получают информацию друг от друга
// обмен информацией происходит в одно и то же время

// 2 человек играют в игру камень - ножницы - бумага
// если один показывает, то второй не увидит пока сам не покажет, обмен информацией в один момент
// будем играть 3 раза

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friendAction = new ArrayList<>();
        friendAction.add(Action.SCISSORS);
        friendAction.add(Action.PAPER);
        friendAction.add(Action.SCISSORS);
        List<Action> myActions = new ArrayList<>();
        myActions.add(Action.PAPER);
        myActions.add(Action.STONE);
        myActions.add(Action.STONE);

        new Friends("Dron", friendAction, exchanger);
        new Friends("Peter", myActions, exchanger);
    }
}
