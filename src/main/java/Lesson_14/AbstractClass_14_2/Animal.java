package Lesson_14.AbstractClass_14_2;

public abstract class Animal implements AbleToCanRun {
    //может иметь обычные методы
    public void eat(){
        System.out.println("I am eating");
    }
    // этот класс не является сущностью, поэтому для запрета создания обьекта класса помечают ключ словом abstract
    // мы знам, что все животные будут есть, поэтому не abstract метод, но мы не знаем как они будут спать-abstract метод canSleep()
    // может иметь абстрактные методы, которые переопределяются в наследниках
    public abstract void canSleep();
}
