package lesson_19_IO_and_NIO.Skillbox.Parsing_from_Object_to_JSONfile_Jackson.Parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public interface Get_document {
    String URL = "https://skillbox-java.github.io/";
      default Document getPage(){
          Document document = null;
          try {
              document = Jsoup.connect(URL).get();
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          return document;
    }
}
