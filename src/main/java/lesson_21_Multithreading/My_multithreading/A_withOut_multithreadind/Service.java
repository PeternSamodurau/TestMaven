package lesson_21_Multithreading.My_multithreading.A_withOut_multithreadind;

public class Service {
    public void readData() {
        System.out.println("Read data");
    }

    public void showGreetingMessage() {
        System.out.println("Hello!!!");
    }

    public void calculateFactorial(int number) {
        long result = 1;

        for (int factorial = 2; factorial <= number; factorial++) {
            result *= factorial;
        }
        System.out.println("Factorial result: " + result);
    }

    public void calculateSum(int number) {
        long sum = 0;
        for (int i = 1; i <= number; i++) {
            sum = sum + i;
            System.out.println("The current sum is " + sum);
        }
        System.out.println("The total sum is " + sum);
    }


    public void finishProgram() {
        System.out.println("Finish");
        System.exit(0);
    }
}
