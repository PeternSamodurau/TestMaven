package Lesson_14.NestedClasses_14_7;

public class Electrocar {
    private int id;

    public Electrocar(int id) {
        this.id = id;
    }
    public void start(){
        final int turn = 1;                         //должна быть константой для доступа в enterKey()

        class Key{                                  //Локальные классы (local classes)
            public void enterKey(){
                System.out.println("Enter key in to the car- " + id + " - turn key " + turn);
            }
        }
        Key key = new Key();
        key.enterKey();

        Motor motor = new Motor();
        motor.startMotor();                                       // можем вызвать метод из вложенного класса Motor
        System.out.println("Electrocar  " + id + "  is driving");

    }

    @Override
    public String toString() {
        return "Electrocar{" +
                "id=" + id +
                '}';
    }
    private class Motor{              //Внутренние классы (inner classes) - это классы, которые объявлены без модификатора static внутри другого класса.
        public void startMotor(){      //определяем логику электрокара, когда он сложный - мотор, батарея,  коробка передач ...
            System.out.println("Motor  " + id + "  is starting...");
        }
    }
    public static class Battery{         //Статические вложенные классы (static nested classes) - нет доступа к полям (id)
        public void charge(){             //их связывает только логика
            System.out.println("Battery is charging...");
        }
    }
}
