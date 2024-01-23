package lesson_19.Parsing_XML_DOM_19_9_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomParser {

    public Root parse ()throws Exception{
        Root root = new Root();              // хотим получить обект

        Document doc = buildDocument();

        // node - каждый элемент включая пробелы
        Node rootNode = doc.getFirstChild();                      // получаем первый тэг
        System.out.println("firstelement" + " -> " + rootNode.getNodeName());
        NodeList rootChild = rootNode.getChildNodes();              // получаем дочерние тэги

        String mainName = null;
        Node peopleNode = null;

        for (int i = 0; i < rootChild.getLength(); i++) {
            if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {        //проверяем тип тэга - исключаем пробелы и текст, оставляем тэги
                continue;
            }
            // System.out.println(rootChild.item(i).getNodeName());
            switch (rootChild.item(i).getNodeName()) {
                case "name": {
                    mainName = rootChild.item(i).getTextContent();
                    System.out.println("mainName" + "->" + mainName);
                    break;
                }
                case "people": {
                    peopleNode = rootChild.item(i);
                    System.out.println("peopleNode" + "->" + peopleNode);
                    break;
                }
            }
        }

        if (peopleNode == null) {
            return null;
        }

        List<People> peopleList = parsPeople(peopleNode);

        root.setName(mainName);
        System.out.println(root);
        root.setPeopleList(peopleList);
        System.out.println(root.toString());

        root.getPeopleList().stream().filter(people -> {
            return people.getAge() == 20;
        }).forEach(people -> {
            System.out.println("is 20 years old " + " -> " + people.toString());
        });

        return root ;
    }

    private  Document buildDocument() throws Exception {
        File file = new File("lesson_19/Parsing_from_Object_to_JSONfile_Jackson/data/xml.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = dbf.newDocumentBuilder().parse(file);

        return document;                 // открыли документ для парсинга
    }

    private  List<People> parsPeople(Node peopleNode) {
        List<People> peopleList = new ArrayList<>();
        NodeList peopleChild = peopleNode.getChildNodes();
        for (int i = 0; i < peopleChild.getLength(); i++) {
            if (peopleChild.item(i).getNodeType() != Node.ELEMENT_NODE) {        //проверяем тип тэга - исключаем пробелы и текст, оставляем тэги
                continue;
            }
            //       System.out.println(peopleChild.item(i).getNodeName());
            if (!peopleChild.item(i).getNodeName().equals("element")) {
                continue;
            }

            NodeList elementChild = peopleChild.item(i).getChildNodes();

            People people = parseElement(peopleChild.item(i));
            peopleList.add(people);
            peopleList.forEach(System.out::println);
        }
        return peopleList;
    }
    private  People parseElement(Node elementNode){
        String name = "";
        int age = 0;
        NodeList elementChild = elementNode.getChildNodes();

        for (int j = 0; j < elementChild.getLength(); j++) {
            if (elementChild.item(j).getNodeType() != Node.ELEMENT_NODE) {        //проверяем тип тэга - исключаем пробелы и текст, оставляем тэги
                continue;
            }
            switch (elementChild.item(j).getNodeName()) {
                case "name": {
                    name = elementChild.item(j).getTextContent();
                    break;
                }
                case "age": {
                    age = Integer.valueOf(elementChild.item(j).getTextContent());
                    break;
                }

            }
        }
        People people = new People(name, age);

        return people;
    }
}
