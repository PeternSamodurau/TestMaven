package Lesson_4.Classes.final_class;

//Когда переменная, функция или класс объявляются как final, их значение сохраняется на протяжении всей программы.
// Объявление метода с ключевым словом final указывает, что этот метод не может быть переопределен в подклассах.
// То есть класс, помеченный как final, не может быть подклассом.
// Это очень полезно при создании неизменяемых классов, таких как классы String.


class FinalClass {

    public static void main(String[] arg) {
        Extended d = new Extended();
        d.Display();
        Base base = new Base();
        base.Display();
    }
}

class Base {                      // если написать  -- final class Base {} нельзя будет -- class Extended extends Base{}
    void Display() {
        System.out.print("Method for Base class.");
    }
}

class Extended extends Base {

    void Display() {
        System.out.print("Method of Extended class.");
    }
}

