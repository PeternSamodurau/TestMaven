package Lesson_14.InterfaceWithDefoltMethod_14_5;

public class SimplePrinter implements Printer{
    @Override
    public void printBlackAndWhite() {
        System.out.println("Print black and white");
    }
    // метод  printColor() не переопределен здесь, т к помечен как default

    //но можно и переопределить
//    @Override
//    public void printColor() {
//        System.out.println("Print more color");
//    }
}
