package Lesson_14.AbstractClass_14_2;

public class Dog extends Animal implements AbleToCanRun {
    public void makeSound() {
        System.out.println("I am dog, i say - bark");
    }

    @Override
    public void canSleep() {
        System.out.println("I am dog, i am sleeping");
    }

    @Override
    public void canRun() {
        System.out.println("I am dog, i am running ");
    }
}
