package Lesson_4.Classes.pojo_class;

//“Plain Old Java Object” - это аббревиатура от “Plain Old Java Object”.
// Класс POJO содержит только приватные переменные с методами setter и getter для доступа к ним.
// Это чистая структура данных с полями, которые могут переопределить некоторые методы объекта
// (например, equals) или другие интерфейсы (например, serializable),
// но сам по себе не имеет поведения.
//
//Свойства класса POJO:
//
//При написании класса POJO требуются публичные методы setter и getter123.
//Для всех переменных экземпляра должны использоваться приватные переменные.
//Он не должен расширять уже определенные классы.
//Он не должен реализовывать предопределенные интерфейсы.
//Не должно быть предопределенных аннотаций.
//Он может не иметь функции Object() { [native code] }, которая не принимает аргументов.


public class PojoClass {
    public static void main(String args[])
    {
        POJO p = new POJO();
        System.out.println(p.getValue());
        p.setValue(465465);
        System.out.println(p.getValue());
    }
}

class POJO {

    private int value = 365;

    public int getValue() {
        return value; }

    public void setValue(int value){
        this.value = value; }
}
