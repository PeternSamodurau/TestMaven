package lesson_19_IO_and_NIO.Skillbox.Parsing_JSON_GSON_19_10.Station_with_List;

import java.util.List;
import java.util.Map;

public class LinesToStations {
    private Map<String, List<String>> stations;

    public LinesToStations(Map<String, List<String>> stations) {
        this.stations = stations;
    }

    public Map<String, List<String>> getStations() {
        return stations;
    }

    public void setStations(Map<String, List<String>> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "LinesToStations{" +
                "stations=" + stations +
                '}';
    }
}
