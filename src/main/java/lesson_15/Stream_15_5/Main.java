package lesson_15.Stream_15_5;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Peter", 'm', 53, 4, 9.3);
        Student student2 = new Student("Alla", 'f', 50, 5, 8.3);
        Student student3 = new Student("Dron", 'm', 52, 3, 3.3);
        Student student4 = new Student("Sveta", 'f', 57, 1, 5.3);
        Student student5 = new Student("Natasha", 'f', 51, 2, 1.3);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        // меняем первоначальный объект
        List<Student> integerList =  studentList.stream().map(
                student -> new Student(student.getName().concat("100"),
                                       student.getSex(),
                                       student.getAge() +100,
                                       student.getCourse(),
                                        student.getGrade())).collect(Collectors.toList());
        System.out.println(integerList);
//        studentList.stream().sorted(Comparator.comparing(Student::getName))
//                .filter(student -> student.getSex() == 'f')
//                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------");
        // стрим из чисел
        Stream<Integer> integerStream = Stream.of(20, 5, 9, 10, 15);
        integerStream.sorted().forEach(System.out::print);
        // integerStream.filter(num -> num % 2 == 0).forEach(System.out::print);
        // стрим из строк
        Stream<String> stringStream = Stream.of("w", "e", " A");
        stringStream.sorted().forEach(System.out::print);
        // из мссива
        int[] integers = {8, 5, 1, 6, 3, 9, 7};
        IntStream stream = Arrays.stream(integers).sorted();
        stream.forEach(s -> System.out.print(s + " "));
        //System.out.println(Arrays.stream(integers).count());
        //Arrays.stream(integers).sorted().forEach(System.out::print);
        System.out.println("_______________________________________");
        //бесонечный стрим
        //Stream.iterate(1, n-> n + 1).forEach(System.out::print);
        //Stream.generate(()-> " AAA ").forEach(System.out::print);

        // стрим чар из строки
        "fg".chars().forEach(System.out::print);

        System.out.println("________________________________________________");
        //метод flatMap(), передав функцию которая принимает коллекцию а возвращает Stream

        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s->s.split("")) //Преобразование слова в массив букв
                .flatMap(Arrays::stream).distinct() //выравнивает каждый сгенерированный поток в один поток
                .collect(Collectors.toList()).forEach(System.out::println);

        Stream<String> stream5 = Stream.of("aaa","bb","ccccc");
        Stream<Integer> streamInt = stream5.map(str -> str.length())
                .map(i->i*4);
        streamInt.forEach(str-> System.out.println(str)); // 3 2 5
        // метод filter()
        Stream.of(1,2,3,4,5,6,7,8,9).filter(integer -> integer % 2 == 0).forEach(System.out::println);
        Stream.of("ski","","ll", "   ","box").filter(s -> !s.isBlank()).forEach(System.out::print);
        //или так
        System.out.println();
        Stream.of("ski","","ll", "   ","box").filter(Predicate.not(String::isBlank)).forEach(System.out::print);
        System.out.println();
        Stream.of("ski","","ll", "   ","box").filter(Predicate.isEqual("ski")).forEach(System.out::print);
        System.out.println();

        // метод distinct() пропускает уникальность
        Stream.of("zzz","zzz","ll","ll","box").distinct().forEach(System.out::print);
        System.out.println();

        Random random = new Random(2);                    // 2- начальная точка случ последовательности
        Stream.generate(()->random.nextInt(6))          // бесконечность от 0 до 5 включ
                .limit(10)                                    // ограничиваем 10
                .distinct()                                   // удаляем повторы
                .map(integer -> ++integer)                    // добавляем +1
                .forEach(integer -> System.out.print(" " + integer));
        System.out.println();

        new Random().ints(10, 1, 7)
                .distinct()
                .forEach(n -> System.out.print(" " +n));

        // метод sorted(); без компаратора и с компаратором
        System.out.println();
        Stream.of("SFAF","FWEGFG","ADAFQFW").sorted().forEach(s -> System.out.print(" " + s));
        System.out.println();
        Stream.of(List.of(1,6,3),List.of(8,4),List.of(1))
                .sorted(Comparator.comparing(List::size))
                .forEach(s -> System.out.print(" " + s));
        System.out.println();
        // метод peek(); используется для логирования (записи информации)
        "abcd".chars()                  // получаем IntStream из строки
                .peek(c-> System.out.print("char:" + (char) c))
                .forEach(i-> System.out.print(" " + i) );
        System.out.println();

        // ТЕРМИНАЛЬНЫЕ ОПЕРАТОРЫ
        // на них стрим вызывается и заканчиватся

        // forEach(); применяет функцию Consumer к каждому элементу стрима

        //count(); возвращает long количество элемнтов стрима
        long counts = Stream.of("skillbox","sendel","skillbox","sendel")
                .distinct()
                .count();
        System.out.println(counts); //2

        // .min(); .max();
        Optional<Integer> shortest = Stream.of(1,2,3,4)   // результат пакуется в объект Optional
                .filter(integer -> integer > 10)
                .max(Integer::compare);                   // max отсутствует
        if (shortest.isPresent()) {
            System.out.println(shortest.get());               // метод get(); для получения
        }else {
            System.out.println("Максимальное значение не найдено!");
        }
        // или сразу бросить исключение
        //int max = Stream.of(1,2,3,4)
         //       .filter(integer -> integer > 10)
        //        .max(Integer::compare)
        //        .orElseThrow(()-> new NotFoundMaxException());

        //.anyMatch(); возващает true если найден хотябы один элемент по условию
        boolean hasMoreThen10 = Stream.of(1,2,5,9)
                .anyMatch(i->i>10);    // false

        //.noneMatch(); возвращает true, если все НЕ соответствуют условию
        boolean allMoreThen10 = Stream.of(1,2,6,7)
                .noneMatch(i -> i > 10);   // true

        //.allMatch(); возвращает true, если все  соответствуют условию
        boolean allLessThen10 = Stream.of(1,2,6,7)
                .allMatch(i -> i > 10);   // false
        System.out.println(allLessThen10);

        //.findFirst(); возвращает первый элемент стрима соответствующий условию
        Optional<Integer> first = Stream.of(1,20,30)
                .filter(i-> i > 10)
                .findFirst();    // 20
        //.findAny();  возвращает любой элемент стрима соответствующий условию (не угадать какой!!!! во многопоточности)
        Optional<Integer> any = Stream.of(20,30,40)
                .parallel()
                .filter(i-> i > 10)
                .findFirst();    // 20 или 30 или 40
        System.out.println(any); //20

        //.collect(); собирает стрим в нужную структуру данных или объект с выбором конструктора коллекции .toCollection()
        Collection<Integer> collection = Stream.of(10,20,30,100)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(collection);  //[10, 20, 30, 100]

        Set<Integer> collection1 = Stream.of(10,20,20,100)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collection1); //[10, 20, 100]  уникальны
        // или короткая запись
        List<Integer> integerList1 = Stream.of(10,50,60,10,100)
                .collect(Collectors.toList());
        // или неизменяемая коллекция, если в будущем менять будет брошено исключение
        Set<Integer> integerSet = Stream.of(10,60,50,100)
                .collect(Collectors.toUnmodifiableSet());
        // integerSet.add(2);  если включить будет исключение

        //.toMap(); получаем map разными способами
        Map<String,Character> map = Stream.of(student1,student2,student3,student4,student5)
                .collect(Collectors.toMap(Student::getName,Student::getSex));
        System.out.println(map); //{Natasha=f, Sveta=f, Peter=m, Dron=m, Alla=f}

        Map<String,Integer> map1 = Stream.of("a","a","c","b","c","a")
                .collect(Collectors.toMap(Function.identity(),(s)-> 1,(existing,current)-> ++ existing));
        System.out.println(map1);
        // или так с помощью .groupBy() подсчет количества элементов через группировку данных
        Map<String,Long> map2 = Stream.of("a","a","c","b","c","a")
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map2);
        // или получить сумму всех оценок студентов
        Student student6 = new Student("Natasha", 'f', 51, 2, 1.3);
        Map<String,Double> map3 = Stream.of(student1,student2,student3,student4,student5,student6)
                .collect(Collectors.groupingBy(Student::getName,Collectors.summingDouble(Student::getGrade)));
        System.out.println(map3); // выводит ключ Natasha , а значение 2.6
    }
}
