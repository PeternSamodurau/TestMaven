package lesson_16.optional_class_16_5;

//ссылка обьекта должна указывать на обьект, но это не всегда так

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "один");
        stringMap.put(2, "два");
        stringMap.put(3, "три");

        //допустим ктото обратился к элементу с ключом 5, метод вернет null
        System.out.println(stringMap.get(5));

        //если мы добавим метод .toUpperCase() то вернется уже не null , a исключение NullPointerException
        //но на этапе написания компилятор не видет ошибку
        System.out.println(stringMap.get(5).toUpperCase());
        //создадим классы Computer, SoundClass, USB

        Computer computer = new Computer(new SoundCard(new USB("2.0.46546")));

        //Получим версию USB
       // String version = computer.getSoundCard().getUsb().getVersion();
        //если у компьютера не будет SoundCard - null, но есть USB то метод вернет исключение NullPointerException

        //добавляем проверки на null
 //       String version1 = "N/A"; //not acssable
//        if (computer !=null){
//            SoundCard soundCard = computer.getSoundCard();
//            if (soundCard != null){
//                USB usb = soundCard.getUsb();
//                if (usb != null){
//                    version1 = usb.getVersion();
//                }
//            }
//        }
        // пришлось написать кучу када для проверки, что мы не получим исключение NullPointerException

        //OPTIONAL CLASS позволяет более гибко обрабатывать нулевые ссылки, объект контейнер в котором 2 состояния пустое и не пустое
        //меняем getter на Optional

        //создадим объект
        Optional<Computer> optionalComputer = Optional.ofNullable(computer);
        optionalComputer.ifPresent(comp -> System.out.println("Computer exists"));        //если не пустой то будет сообщение

        //как из Optional получить объект
        Computer computer1 = optionalComputer.get();   //недостаток, если Optional - null, то исключение NoSuchException
        //тогда
        Computer computer2 = optionalComputer.orElse(new Computer(new SoundCard(new USB("default")))); //возвращаем каой-то комп по умолчанию

        //со строкой
        Optional<String> optional = Optional.empty();
        System.out.println(optional.orElseGet(()->getAnothrString()));
        //или
        System.out.println(optional.orElseThrow(() -> new RuntimeException("no value present")));

        //переписываем длинный пример с if строка 31

        String version1 = Optional.ofNullable(computer.getSoundCard())          //если не null то идет дальше
                .map(soundCard -> soundCard.getUsb())
                .map(usb -> usb.getVersion())
                .filter(ver -> ver.equals("1.003"))
                .orElse("N/A");

        // в Java 14 новая фитча проверки на null
        assert computer != null : "computer is not null";
    }
    private static String getAnothrString(){
        return "Default";
    }
}
