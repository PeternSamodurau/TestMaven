package lesson_15.Instanse_15_14;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("Boing 777");
       // System.out.println(aircraft);

        Date currentTime = new Date();

        Flight flight = new Flight("133", Flight.Type.ARRIVAL, currentTime, aircraft);
       // System.out.println(flight);

        Terminal terminal = new Terminal("A");

        List<Aircraft> aircraftList = new ArrayList<>();
        aircraftList.add(new Aircraft("Boing 777"));
        aircraftList.add(new Aircraft("Airbus A380"));

        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight("133", Flight.Type.ARRIVAL, currentTime, aircraftList.get(0)));
        flightList.add(new Flight("136", Flight.Type.DEPARTURE, currentTime, aircraftList.get(1)));
        flightList.stream().forEach(System.out::println);
    }
}
