package Lesson_13.OverridingStaticMethod_13_4;
//Overriding переопределение статических методов НЕ существует

public class OverridingStaticMethod {

    public static void main(String[] args) {
      ParentClass parentClass = new ParentClass();
        System.out.println(parentClass.method());

      ParentClass childClass = new ChildClass();       // статический метод смотрит на ParentClass , а не на объект - new ChildClass()
        System.out.println(childClass.method());
    }
}
