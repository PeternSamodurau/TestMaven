package A1_Mamory;

public class Main {
    public static void main(String[] args) {
        int id = 23;
        String name = "John";

        Person person = buildPerson(id, name);

        System.out.println("ID человека: " + person.id);
        System.out.println("Имя человека: " + person.name);
    }
    static Person buildPerson(int id, String name) {
        return new Person(id, name);
    }
}
//Сначала вызывается метод main.
//Внутри метода main вызывается метод buildPerson(int id, String name).
//Внутри метода buildPerson(int id, String name) вызывается конструктор new Person(id, name) для создания нового объекта Person.
//Таким образом, стек вызовов будет выглядеть следующим образом:
//
//3. new Person(id, name)
//2. buildPerson(int id, String name)
//1. main

//Сначала вызывается метод main. В этот момент стек памяти выглядит так:
//main:
//    id = 23
//    name = "John"
//    person = null
//
//Затем внутри метода main вызывается метод buildPerson(int id, String name). В этот момент стек памяти выглядит так:
//buildPerson:
//    id = 23
//    name = "John"
//main:
//    id = 23
//    name = "John"
//    person = null
//Внутри метода buildPerson(int id, String name) создается новый объект Person. В этот момент стек памяти выглядит так:
//buildPerson:
//    id = 23
//    name = "John"
//    new Person:
//        id = 23
//        name = "John"
//main:
//    id = 23
//    name = "John"
//    person = null
//После завершения метода buildPerson(int id, String name), его блок в стеке памяти освобождается, и ссылка на новый объект Person возвращается в метод main. В этот момент стек памяти выглядит так:
//main:
//    id = 23
//    name = "John"
//    person -> Person:
//        id = 23
//        name = "John"
//После завершения метода main, его блок в стеке памяти освобождается, и стек памяти становится пустым. В этот момент стек памяти выглядит так:
//(пусто)
//
//Обратите внимание, что объект Person, созданный в методе buildPerson, продолжает существовать в куче,
// даже после того как метод buildPerson и main завершили выполнение и их блоки в стеке памяти были освобождены.
// Этот объект будет уничтожен сборщиком мусора Java, когда на него больше не будет ссылок.