package Lesson_4.Classes.inner_class;

//Inner Class - Внутренний класс
//В Java мы можем определить класс внутри другого класса, и эти классы называются вложенными классами.
// Они используются для логической группировки классов и достижения инкапсуляции


class UsingInterface {

    static Hello h = new Hello() {
        public void show()
        {
            System.out.println(
                    "This is an anonymous class");
        }
    };

    public static void main(String[] args) { h.show(); }
}

interface Hello {
    void show();
}