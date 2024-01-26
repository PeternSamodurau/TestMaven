package Lesson_4.Classes.inner_class;

//Inner Class - Внутренний класс
//В Java мы можем определить класс внутри другого класса, и эти классы называются вложенными классами.
// Они используются для логической группировки классов и достижения инкапсуляции


// AnonymousInnerClass анонимный внутренний класс

//Он имеет доступ к приватным переменным экземпляра внешнего класса.
// Модификаторы доступа private, protected, public и default могут быть применены к любой переменной экземпляра
class Outer1 {
    void show()
    {
        System.out.println("Show method of super class");
    }
}

class AnonymousInnerClass {

    public static void main(String[] args) {
        o.show();
    }

    static Outer1 o = new Outer1() {
        void show() {
            super.show();
            System.out.println("Demo class");
        }
    };

}