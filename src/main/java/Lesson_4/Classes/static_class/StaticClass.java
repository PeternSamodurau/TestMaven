package Lesson_4.Classes.static_class;

import java.util.Scanner;

//Static - это слово в Java, которое объясняет, как объекты хранятся в памяти.
// Статический объект принадлежит самому классу, а не экземплярам этого класса.
// Основная функция класса - предоставление чертежей для наследуемых классов.
// Статический класс имеет только статические члены.
// Объект для статического класса не может быть создан

public class StaticClass {
    public static void main(String args[])
    {
        SomeStaticClasses.MyNestedClass nestedclass
                = new SomeStaticClasses.MyNestedClass();
        nestedclass.disp();

    }
}

class SomeStaticClasses {
    static int s;
    static void met(int x, int y)
    {
        System.out.println(
                "static method to calculate sum");
        s = x + y;
        System.out.println(x + "+" + y);
    }
    static class MyNestedClass {
        static
        {
            System.out.println(
                    "static block inside a static class");
        }
        public void disp()
        {
            int x1;
            int y1;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter two numbers");
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            met(x1, y1);
            System.out.println("Sum of the 2 numbers-" + s);
        }
    }
}