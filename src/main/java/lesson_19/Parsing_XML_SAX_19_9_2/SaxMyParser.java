package lesson_19.Parsing_XML_SAX_19_9_2;

import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxMyParser {
    public Root parser() {
        File file = new File("lesson_19/Parsing_from_Object_to_JSONfile_Jackson/data/xml.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();

        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e.toString());
            return null;
        }
        try {
            parser.parse(file, handler);                                 // идет парсинг, результат  в handler
        } catch (SAXException e) {
            System.out.println("Sax parsing error " + e.toString() );
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error " + e.toString() );
            return null;
        }
        return handler.getRoot();
    }
}
