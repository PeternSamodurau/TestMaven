package lesson_19_IO_and_NIO.Skillbox.Parsing_HTML_19_9;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {

    getElements(getPage());

    }
    public static String getDateFromString(String stringDate) throws Exception {
        Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()){
            return matcher.group();
        }
       throw new Exception("Can't extract date from string");
    }

    public static Elements getElements(Document doc) throws Exception {
        Elements tableWhe = getPage().select("table[class=wt]");
        // метод select возращает список тегов, в метод передается css селетор, по которому ищутся теги
        System.out.println(tableWhe.text());
        Elements names = tableWhe.select("tr[class=wth]");
        System.out.println(names.text());
        Elements values = tableWhe.select("tr[valign=top]");
        System.out.println(values.text());

        int index = 0;
        for (Element name : names) {
            String dateString = name.select("th[id=dt]").text();
            String date = getDateFromString(dateString);
            System.out.println(date);
        }
        return null;
    }

    public static Document getPage() {
        String url = "http://www.pogoda.spb.ru/";
        Document page = null;

        try {
            page = Jsoup.connect(url).get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }
}
