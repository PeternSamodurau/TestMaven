package Lesson_4.Classes.inner_class;

//Inner Class - Внутренний класс
//В Java мы можем определить класс внутри другого класса, и эти классы называются вложенными классами.
// Они используются для логической группировки классов и достижения инкапсуляции

//Nested Inner Class -Вложенный внутренний класс
//Он имеет доступ к приватным переменным экземпляра класса.
// Модификаторы доступа private, protected, public и default могут быть применены к любой переменной экземпляра

class Outer {
    class NestedInner {
        public void show()
        {
            System.out.println("Inside a nestedInner class");
        }
    }
}

class GFG {
    public static void main(String[] args)
    {
        Outer.NestedInner in = new Outer().new NestedInner();
        in.show();
    }
}
