package lesson_19_IO_and_NIO.Skillbox.Parsing_from_Object_to_JSONfile_Jackson.Parsers;


import lesson_19_IO_and_NIO.Skillbox.Parsing_from_Object_to_JSONfile_Jackson.Objects.Line;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParseLine implements Get_document {

    private List<Line> lineList;

    public Elements nameLine() {
        Elements nameLine = getPage().select("span.js-metro-line");
        return nameLine;
    }

    public List<Line> getLineList(Elements nameLine) {
        lineList = new ArrayList<>();

        for (Element l : nameLine) {
            lineList.add(new Line(l.attr("data-line"), l.text()));
        }
        return lineList;
    }
}
