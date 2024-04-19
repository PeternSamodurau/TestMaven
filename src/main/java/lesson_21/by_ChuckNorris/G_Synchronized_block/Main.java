package lesson_21.by_ChuckNorris.G_Synchronized_block;

// Монитор - механизм при котором достигается корректная работа при синхронизации
// у каждого класса и обьекта есть привязка - монитор , у него два состояния свободен или занят
// монитор задействуется когда мы пишем ключевое слово synchronized, позволяет работать одному потоку
//БОЛОКИРОВКА ИДЕТ НА КЛАССЕ ИЛИ ОБЬЕКТЕ в блоке кода, а не на блоке кода

public class Main {
    public static void main(String[] args) {

      MyClass myClass = new MyClass();
        for (int i = 0; i< 10; i++){
            new Thread(myClass).start();
        }


    }
}
