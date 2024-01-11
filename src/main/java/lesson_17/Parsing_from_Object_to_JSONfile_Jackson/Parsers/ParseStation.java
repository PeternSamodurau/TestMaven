package lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Parsers;


import lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Objects.Station;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParseStation implements Get_document {
    private List<Station> stationList;

    public Elements numberStation() {

        Elements numberStation = getPage().select("p>span.num");
        return numberStation;
    }

    public Elements nameStation() {

        Elements nameStation = getPage().select("p>span.name");
        return nameStation;
    }

    public List<Station> getStationList(Elements numberStation, Elements nameStation) {
        stationList = new ArrayList<>();

        double number;
        String name;

        for (int i = 0; i < numberStation.size(); i++) {
            number = Double.parseDouble(numberStation.get(i).text());
            name = nameStation.get(i).text();

            stationList.add(new Station((int) number, name));
        }
        return stationList;
    }
}


