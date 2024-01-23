package Lesson_14.AnanimusClass_14_4;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        animal1.eat();

        //если нужно создать один обьект с переопределенным методом eat();

        Animal animal2 = new Animal(){                         // создется анонимный класс внутри
            public void eat(){
                System.out.println("Other Animal is eating");
            }
        };
        animal2.eat();

        AbleToSleep ableToSleep = new AbleToSleep() {           // на интерфейсе
            @Override
            public void sleep() {
                System.out.println("I can sleep");
            }
        };
        ableToSleep.sleep();
    }
}
