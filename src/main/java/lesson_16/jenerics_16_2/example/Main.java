package lesson_16.jenerics_16_2.example;

public class Main {
    public static void main(String[] args) {
        Schoolchildren schoolchildren1 = new Schoolchildren("Ivan", 13);
        Schoolchildren schoolchildren2 = new Schoolchildren("Maria", 15);

        Students student1 = new Students("Peter", 20);
        Students student2 = new Students("Alla", 21);

        Employee employee1 = new Employee("Sveta", 35);
        Employee employee2 = new Employee("Misha", 47);

//        Team schoolTeam = new Team("Dragon");
//        Team studentTeam = new Team("Beer");
//        Team employeeTeam = new Team("Vodka");
//
//        schoolTeam.addNewPlayerParticipant(schoolchildren1);
//        schoolTeam.addNewPlayerParticipant(schoolchildren2);
//        schoolTeam.addNewPlayerParticipant(schoolchildren1);     // можно добавить 3 го игрока и одного и тогоже
//        schoolTeam.addNewPlayerParticipant(student1);            // можно даже добавить студента
//        schoolTeam.addNewPlayerParticipant(employee1);           // и работника
        // потому ,что метод addNewPlayerParticipant(Participant participant) принимает любого participant
        // что бы не писать классы Team отдельно для школьника, студента и работника, используем дженерики
        // помечаем Team <T>

        Team<Schoolchildren> schoolTeam = new Team<>("Dragon");
        Team<Students> studentTeam = new Team("I like Beer");
        Team<Employee> employeeTeam = new Team("Lets go!");

        schoolTeam.addNewPlayerParticipant(schoolchildren1);
        schoolTeam.addNewPlayerParticipant(schoolchildren1);

        studentTeam.addNewPlayerParticipant(student1);
        studentTeam.addNewPlayerParticipant(student2);

        employeeTeam.addNewPlayerParticipant(employee1);
        employeeTeam.addNewPlayerParticipant(employee2);

        // но можно создать любую команду ЧЕГО угодно
        // Team<String> schoolTeam1 = new Team<>("Dragon");
        // в Team <T extends Participant>

        //создаем еще одну команду школьников , что бы школьники играли со школьниками

        Team<Schoolchildren> schoolTeam1 = new Team<>("Avatar");

        Schoolchildren schoolchildren3 = new Schoolchildren("Sergey", 12);
        Schoolchildren schoolchildren4 = new Schoolchildren("Olia", 14);
        schoolTeam1.addNewPlayerParticipant(schoolchildren3);
        schoolTeam1.addNewPlayerParticipant(schoolchildren4);

        schoolTeam.playWith(schoolTeam1);  // будет рандомный выигрыш
        // но школьники могут играть и со студентами или работниками
        //schoolTeam.playWith(employeeTeam);       //а должны только школьники- школьники,,,,,,,
        // меняем метод playWith();

    }
}
