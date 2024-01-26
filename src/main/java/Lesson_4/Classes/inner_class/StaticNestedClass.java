package Lesson_4.Classes.inner_class;


class StaticNestedClass {
    static int data = 100;

    public static void main(String args[])
    {
        StaticNestedClass.Inner obj = new StaticNestedClass.Inner();
        obj.msg();
    }

    static class Inner {

        void msg(){
            System.out.println("data is " + data);
        }
    }
}