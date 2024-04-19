package lesson_21.My_multithreading.A_withOut_multithreadind;

// без многопоточности программа выполняется последовательно как мы вызываем методы
// что если подсчет факториала и суммы выполнять одновременно в двух потоках

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.readData();
        service.showGreetingMessage();
        service.calculateFactorial(5);
        service.calculateSum(100);
        service.finishProgram();
    }
}
