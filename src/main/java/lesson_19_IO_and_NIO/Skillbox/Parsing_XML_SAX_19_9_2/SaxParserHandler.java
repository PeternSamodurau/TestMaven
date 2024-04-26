package lesson_19_IO_and_NIO.Skillbox.Parsing_XML_SAX_19_9_2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
//

public class SaxParserHandler extends DefaultHandler {
    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_PEOPLE = "people";
    private static final String TAG_ELEMENT = "element";
    private static final String TAG_NAME = "name";
    private static final String TAG_AGE = "age";
    private String currantTagName;  // переменная в которой хранится имя текущуго тэга
    private boolean isPeople = false;
    private boolean isElement = false;
    private String name;
    private int age;

    private Root root = new Root();
    private List<People> peopleList = new ArrayList<>();

    public Root getRoot() {
        return root;
    }

    // переопределенные методы  класса  DefaultHandler вызывают тэги
    @Override
    public void startDocument() throws SAXException {
        // System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("End document");
       root.setPeopleList(peopleList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currantTagName = qName;
        //System.out.println("Start element " + qName);
        if (currantTagName.equals(TAG_PEOPLE)) {
            isPeople = true;
        } else if (currantTagName.equals(TAG_ELEMENT)) {
            isElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // System.out.println("End element " +qName);

        if (qName.equals(TAG_PEOPLE)) {
            isPeople = false;
        } else if (qName.equals(TAG_ELEMENT)) {
            isElement = false;
            People people = new People(name, age);
            peopleList.add(people);
        }

        currantTagName = null;                    // обнуляем
    }

    //с помощю этого метода получают содержимое тэга
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // System.out.println("characters " + new String(ch, start, length));
        if (currantTagName == null) {
            return;
        }
        if (!isPeople && currantTagName.equals(TAG_NAME_MAIN)) {
            root.setName(new String(ch, start, length));
        }
        if (isPeople && isElement) {
            if (currantTagName.equals(TAG_NAME)) {
                name = new String(ch, start, length);
            } else if (currantTagName.equals(TAG_AGE)) {
                age = Integer.valueOf(new String(ch, start, length));
            }
        }
    }
}
