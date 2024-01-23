package lesson_16.jenerics_16_2.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//public class Team{                          //БЫЛО
//public class Team<T> {                      //СТАЛО
public class Team<T extends Participant> {    //СТАЛО 1
    private final String teamName;
    //private List<Participant> participants = new ArrayList<>();             //БЫЛО
    private final List<T> participants = new ArrayList<>();                         //СТАЛО

    public Team(String teamName) {
        this.teamName = teamName;
    }

    //public void addNewPlayerParticipant(Participant participant) {           //БЫЛО
    public void addNewPlayerParticipant(T participant) {                    //СТАЛО
        participants.add(participant);
        System.out.println("Add new player to command - " + teamName + "  by name - " + ((Participant) participant).getName());
    }

    //public void playWith(Team team) {         //БЫЛО
    public void playWith(Team<T> team) {        //СТАЛО
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);

        if (i == 0) {
            winnerName = this.teamName;
        } else {
            winnerName = team.teamName;
        }
        System.out.println("Winner is team -" + winnerName);
    }
}
