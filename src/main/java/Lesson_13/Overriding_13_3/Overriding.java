package Lesson_13.Overriding_13_3;
//Overriding переопределение

public class Overriding {
    public static void main(String[] args) {
      ParentClass parentClass = new ParentClass();
      parentClass.method();

      ChildClass childClass = new ChildClass();
      childClass.method();
    }
}
