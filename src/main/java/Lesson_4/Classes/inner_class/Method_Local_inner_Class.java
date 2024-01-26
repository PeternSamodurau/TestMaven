package Lesson_4.Classes.inner_class;

//Inner Class - Внутренний класс
//В Java мы можем определить класс внутри другого класса, и эти классы называются вложенными классами.
// Они используются для логической группировки классов и достижения инкапсуляции

// Внутренний класс может быть объявлен внутри метода внешнего класса

class Method_Local_inner_Class {
    public static void main(String[] args)
    {
        SomeClass x = new SomeClass();
        x.outerMethod();
    }
}

class SomeClass {
    void outerMethod()
    {
        System.out.println("Outer Method");
        class Inner {
            void innerMethod()
            {
                System.out.println("Inner Method");
            }
        }

        Inner y = new Inner();
        y.innerMethod();
    }
}

