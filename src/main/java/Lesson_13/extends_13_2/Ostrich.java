package Lesson_13.extends_13_2;

public class Ostrich extends Animal {
    public int weight;

    public Ostrich(String name, Wings wings, int weight) {
        super(name, wings);
        this.weight = weight;
    }

    public void eat(){                             // переопределили метод
        System.out.println("Ostrich is eating");
    }
    public void hideHeard(){
         System.out.println(super.getName() + "  " + super.getWings());       // через super есть доступ к методам суперкласса
         System.out.println("I am ostrich");
     }
}
