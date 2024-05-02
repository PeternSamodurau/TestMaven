package A_Recurshion;

public class Main1 {
    public static void main(String[] args) {
        up_and_down(1);
    }
    static void up_and_down(int n){

        System.out.println("Уровень вниз " + n);

        if (n < 4) {
            up_and_down(n + 1);
        }
        // не исполняется пока не пройдет вся рекурсия
        System.out.println("Уровень вверх " + n);
    }
}
