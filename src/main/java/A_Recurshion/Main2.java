package A_Recurshion;

public class Main2 {
    public static void main(String[] args) {
        counter(3);
    }
    //main -> counter(3) ждет пока выполнится -> counter(2) ждет пока выполнится -> counter(1) ждет пока выполнится -> counter(0)
    // исполняется counter(0) -> выход из counter(1)  -> выход из counter(2) -> выход из counter(3)
    // идем по цепи вниз, доходим до условия выхода и идем по цепи вверх
    private static void counter(int n){
        if (n == 0) return;

        System.out.println(n);

        counter(n - 1);
    }
}
