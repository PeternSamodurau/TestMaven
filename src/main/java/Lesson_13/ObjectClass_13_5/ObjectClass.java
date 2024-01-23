package Lesson_13.ObjectClass_13_5;

import java.util.HashMap;
import java.util.Map;

public class ObjectClass {
    //методы копирующие и сравнивающие объекты
    // clone();                    создает и возвращает копию объекта

    public static void main(String[] args) {

        // toString();                 для получения представления объекта в виде строки
        Person person = new Person("Peotr", "Samadurau");
        System.out.println(person.getClass().getName()+ "@" + Integer.toHexString(person.hashCode()));   //то что возвращает toString() по умолчанию, имя + @ + хэш в 16 коде
        System.out.println(person.toString());           // после переопределения в классе - строковое представление
        System.out.println("_______________________________________________________");

        // hashCode((Object obj);      сравнивает объекты и возвращает целое число
        Map<Person, Double> map = new HashMap<>();
        map.put(new Person("Peotr","Samadurau"),10.3);
        map.put(new Person("Peotr1","Samadurau1"),5.3);
        map.put(new Person("Peotr2","Samadurau2"),8.3);
        System.out.println(map);

        boolean result = map.containsKey(new Person("Peotr","Samadurau"));
        System.out.println("result = " + result );              //если не переопределить мерод hashCode() будет false, хотя equals(Object object) корректен
        // коллекции Hash используют хэшитование при поиске и сравнении, надо переопределить метод hashCode()
        //сравнение сначала идет по hashCode, а потом по equals
        System.out.println(new Person("Peotr","Samadurau").hashCode());
        System.out.println(new Person("Peotr1","Samadurau1").hashCode());
        System.out.println("__________________________________________________________");

       // equals(Object obj);         сравнивает объеты и возвращает true / false
        Man man1 = new Man("Peter", 76);
        Man man2 = new Man("Peter", 76);
        System.out.println(man1.equals(man2)); // т к ссылки разные, то объекты разные и будет false, поэтому надо переопределить метод equals в классе Man

        //finalize();       вызывается перед удалением ненужногообьекта из памяти, признан deprecated - устаревшим

        //getClass();       возвращает класс текущего объекта
        System.out.println(person.getClass());

        //методы для синхронизации потоков в многопоточных приложениях

        // notify();
        // notifyAll();
        //wait();
        //wait(long timeoutMillis);
        //wait(long timeoutMillis, int nanos);

    }
}
