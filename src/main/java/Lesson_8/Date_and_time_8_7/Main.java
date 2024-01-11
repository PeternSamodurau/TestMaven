package Lesson_8.Date_and_time_8_7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        // раньше так
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(simpleDateFormat.format(date));

        Date date1 = simpleDateFormat.parse("21.02.2017");
        System.out.println(date1);
        // с java 8
        System.out.println(" с JAVA 8 _______________________________________________________");

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate + " - создали текущую дату");
        localDate.plusYears(1);  // не меняет год
        System.out.println(localDate + " -  дата не изменилась");
        System.out.println(localDate.plusYears(1) + " - только выводим год + 1");// только получаем год +1

        LocalDate birthday = LocalDate.of(1970,12,11); // создать дату
        System.out.println(birthday.plusYears(53) + " - получаем дату 53 дня рождения");

        // строку в обьект
        String date2 = "11.12.2017";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate2 = LocalDate.parse(date2,dateTimeFormatter);
        System.out.println("Парсим строку в дату - " + localDate2);
        System.out.println("или так строку в дату - " + String.format(date2, dateTimeFormatter));

        // обьект в строку
        LocalDate localDate1 = LocalDate.of(2017,12,11);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String srt = dateTimeFormatter1.format(localDate1);
        System.out.println(srt + " обьект в строку -  это уже строка");
    }
}
