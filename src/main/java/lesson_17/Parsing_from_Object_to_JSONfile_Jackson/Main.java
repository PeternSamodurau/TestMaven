package lesson_17.Parsing_from_Object_to_JSONfile_Jackson;

import lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Parsers.ParseLine;
import lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Parsers.ParseStation;
import lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Serialization_to_Json.LineToJson;
import lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Serialization_to_Json.StationToJson;


public class Main {
    public static void main(String[] args) {
        ParseStation parseStation = new ParseStation();
        System.out.println(parseStation.getStationList(parseStation.numberStation(), parseStation.nameStation()));

        ParseLine parseLine = new ParseLine();
        System.out.println(parseLine.getLineList(parseLine.nameLine()));

        StationToJson sTJ = new StationToJson();
        sTJ.stationToJson(parseStation);

        LineToJson lToJ = new LineToJson();
        lToJ.lineToJson(parseLine);

    }
}
