package lesson_19_IO_and_NIO.Skillbox.Parsing_XML_DOM_19_9_1;

import java.util.List;

public class Root {
    private String name;
    private List<People> peopleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", peopleList=" + peopleList +
                '}';
    }
}
