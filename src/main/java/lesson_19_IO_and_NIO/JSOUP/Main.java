package lesson_19_IO_and_NIO.JSOUP;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Post> postList = new ArrayList<>();

        Document document;
        try {
            document = Jsoup.connect("https://4pda.to").get();
            System.out.println("ПОДКЛЮЧЕНИЕ К ГДАВНОЙ СТРАНИЦЕ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //   System.out.println(document.toString());

        Elements elements = document.getElementsByAttributeValue("itemprop", "url");
        // elements.forEach(element -> System.out.println(element.attr("title") + " | " + element.attr("href")));

        for (Element element : elements) {
            String detailLink = element.attr("href");
            Post post = new Post();
            post.setDetailsLink(detailLink);
            post.setTitle(element.attr("title"));
            Document postDetailDoc = Jsoup.connect(detailLink).get();
            System.out.println("ПОДКЛЮЧЕНИЕ К ДЕТАЛЯМ О ПОСТЕ: " + detailLink);
            try {
                Element authorElement = postDetailDoc.getElementsByClass("name").first().child(0);
                post.setAuthor(authorElement.text());
                post.setAuthorDetailsLink(authorElement.attr("href"));
                post.setDateOfCreate(postDetailDoc.getElementsByClass("date").first().text());
            } catch (NullPointerException e) {
                post.setAuthor("Автор не обнаружен");
                post.setAuthorDetailsLink("Ссылка не обнаружена");
                post.setDateOfCreate("Дата создания не обнаружена");
            }

            postList.add(post);
        }

        postList.forEach(System.out::println);
    }
}
